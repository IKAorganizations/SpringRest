package ru.itmentor.spring.boot_security.demo.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmentor.spring.boot_security.demo.model.User;


@RestController
@RequestMapping("/api/user")
public class UserRestController {


    @GetMapping
    public User showUserInfo() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
