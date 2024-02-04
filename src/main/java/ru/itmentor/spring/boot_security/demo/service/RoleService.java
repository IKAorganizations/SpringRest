package ru.itmentor.spring.boot_security.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmentor.spring.boot_security.demo.dao.RoleDao;
import ru.itmentor.spring.boot_security.demo.model.Role;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RoleService {

    private final RoleDao roleDao;

    @Autowired
    public RoleService(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<Role> getRolesList() {

        return roleDao.getRolesList();
    }

    public Role getRoleByName(String roleName) {
        return roleDao.getRoleByName(roleName);
    }


}
