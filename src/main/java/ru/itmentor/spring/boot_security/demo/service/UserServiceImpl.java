package ru.itmentor.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmentor.spring.boot_security.demo.dao.RoleDao;
import ru.itmentor.spring.boot_security.demo.dao.UserDao;
import ru.itmentor.spring.boot_security.demo.dao.UserDaoImp;

import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.model.UserDetailsImpl;

import java.util.List;



@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserDao userDaoImp;  //заменил на файнал

    @Autowired
    public UserServiceImpl(UserDaoImp userDaoImp) {
        this.userDaoImp = userDaoImp;
    }

    public List<User> findAll() {
        return userDaoImp.findAll();
    }

    public User findOne(int id) {
        return userDaoImp.findOne(id);
    }

    @Transactional
    public void save(User user) {
        userDaoImp.save(user);

    }

    @Transactional
    public User update(User updatedUser) {
        return userDaoImp.update(updatedUser);
    }

    @Transactional
    public void delete(int id) {
        userDaoImp.delete(id);
    }

    // имплементация второго интерфейса



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         User user = userDaoImp.findByUsername(username);

         if (user == null) {
            throw new UsernameNotFoundException("User not found");
         }

         return new UserDetailsImpl(user);
    }


}


