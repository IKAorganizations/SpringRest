package ru.itmentor.spring.boot_security.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmentor.spring.boot_security.demo.dao.RoleRepository;
import ru.itmentor.spring.boot_security.demo.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Transactional(readOnly = true)
public class RoleService {

    private final RoleRepository roleRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Set<Role> getAllRoles () {
       List<Role> list = roleRepository.findAll();

       Set<Role> set = new HashSet<>();

       for (Role role : list)
           set.add(role);
       return set;

    }

}
