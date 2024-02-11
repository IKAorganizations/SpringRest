package ru.itmentor.spring.boot_security.demo.service;

import ru.itmentor.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {

    List<User> allUsers ();
    User findUserById (Long id);

    void saveUser(User user);

    void deleteUser (Long id);

    void update (Long id, User updateuser);


}
