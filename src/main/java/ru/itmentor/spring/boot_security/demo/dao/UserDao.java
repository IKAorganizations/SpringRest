package ru.itmentor.spring.boot_security.demo.dao;




import ru.itmentor.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User findOne(Integer id);

    void save(User user);

    User update(User updatedUser);

    void delete(Integer id);

    User findByUsername(String username);

}
