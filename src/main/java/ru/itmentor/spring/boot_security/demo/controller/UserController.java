package ru.itmentor.spring.boot_security.demo.controller;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itmentor.spring.boot_security.demo.model.User;


@Controller
@RequestMapping("/user")
public class UserController {


    public ModelAndView showUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
