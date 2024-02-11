package ru.itmentor.spring.boot_security.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring.boot_security.demo.model.Role;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.service.RoleService;
import ru.itmentor.spring.boot_security.demo.service.RoleServiceImpl;
import ru.itmentor.spring.boot_security.demo.service.UserService;
import ru.itmentor.spring.boot_security.demo.service.UserServiceImpl;

import javax.validation.Valid;
import java.util.Set;


@Controller
@RequestMapping ("/admin")
public class AdminController {

    private final UserService userServiceImpl;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserServiceImpl userServiceImpl, RoleServiceImpl roleService) {
        this.userServiceImpl = userServiceImpl;
        this.roleService = roleService;
    }

    @GetMapping
    public String allUsers (Model model) {
        model.addAttribute("users", userServiceImpl.allUsers());
        return "allUsers";
    }

    @DeleteMapping("allUsers/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userServiceImpl.deleteUser(id);

        return "redirect:/admin";
    }

    @GetMapping("/{id}" )
    public String show (@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userServiceImpl.findUserById(id));
        return "show";
    }


    @GetMapping("/new")
    public String newUser(Model model) {

        Set<Role> setRoles = roleService.getAllRoles();
        model.addAttribute("setRoles", setRoles);
        model.addAttribute("user", new User());

        return "new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new";

        userServiceImpl.saveUser(user);
        return "redirect:/admin";
    }


    @GetMapping("allUsers/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id){
        Set<Role> setRoles = roleService.getAllRoles();
        model.addAttribute("setRoles", setRoles);
        model.addAttribute("user", userServiceImpl.findUserById(id));

        return "edit";
    }

    @PatchMapping("allUsers/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                         @PathVariable("id") Long id) {
        if (bindingResult.hasErrors())
            return "edit";

        userServiceImpl.update(id, user);
        return "redirect:/admin";
    }


}
