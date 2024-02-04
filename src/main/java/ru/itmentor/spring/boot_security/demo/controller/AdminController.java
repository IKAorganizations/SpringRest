package ru.itmentor.spring.boot_security.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.service.RoleService;
import ru.itmentor.spring.boot_security.demo.service.UserService;

import javax.validation.Valid;


@Controller
@RequestMapping ("/admin")
public class AdminController {

    private final UserService userServiceImpl; //заменил на файнал   ?? - расширил  класс, но здесь нет реализации метода loadByUsername

    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userServiceImpl, RoleService roleService) {
        this.userServiceImpl = userServiceImpl;
        this.roleService = roleService;
    }

    @GetMapping
    public String allUsers (Model model) {
        model.addAttribute("users", userServiceImpl.findAll());
        return "users/index";
    }

    @GetMapping("/{id}" )
    public String show (@PathVariable("id") int id, Model model){
        model.addAttribute("user", userServiceImpl.findOne(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "users/new";

        if(roleService.getRolesList().contains(user.getRoles())){  //!возможно стоит перенести в ДАО
            userServiceImpl.save(user);
        } else {
            System.out.println("Role not found");
        }

         return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("user", userServiceImpl.findOne(id));

        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "users/edit";

        userServiceImpl.update(user);
        return "redirect:/users";
    }


    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userServiceImpl.delete(id);
        return "redirect:/users";
    }
}
