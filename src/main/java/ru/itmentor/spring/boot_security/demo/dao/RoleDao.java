package ru.itmentor.spring.boot_security.demo.dao;


import org.springframework.stereotype.Repository;
import ru.itmentor.spring.boot_security.demo.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDao {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Role> getRolesList() {

        return entityManager.createQuery("from Role", Role.class).getResultList();
    }

    public Role getRoleByName(String roleName) {

        return entityManager.find(Role.class, roleName);
    }

    //написать тут меоды по доставанию из таблицы Роли и СетаРолей?

}
