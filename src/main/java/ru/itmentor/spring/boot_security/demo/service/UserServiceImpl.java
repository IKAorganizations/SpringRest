package ru.itmentor.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.itmentor.spring.boot_security.demo.dao.UserRepository;
import ru.itmentor.spring.boot_security.demo.model.User;

import java.util.*;


@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user==null)
            throw new UsernameNotFoundException("User not found");

        return user;
    }

    public List<User> allUsers () {
        return userRepository.findAll();
    }


    public User findUserById (Long id) {
       Optional<User> user = userRepository.findById(id);

       return user.orElse(new User());
    }


    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);

        user.setPassword(NoOpPasswordEncoder.getInstance().encode(user.getPassword()));
    }

    @Transactional
    public void deleteUser (Long id) {
       userRepository.deleteById(id);

    }

    @Transactional
    public void update (Long id, User updateuser) {
        updateuser.setId(id);
        userRepository.save(updateuser);
    }


}




