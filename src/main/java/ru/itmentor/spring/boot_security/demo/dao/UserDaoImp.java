package ru.itmentor.spring.boot_security.demo.dao;
 import org.springframework.stereotype.Repository;
 import ru.itmentor.spring.boot_security.demo.model.User;

 import javax.persistence.EntityManager;
 import javax.persistence.PersistenceContext;
 import java.util.List;



@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> findAll() {
        List<User> list = entityManager.createQuery("from User", User.class).getResultList();
        return list;
    }

    public User findOne(Integer id) {
        return entityManager.find(User.class, id);
    }


    public void save(User user) {
        entityManager.persist(user);
    }


    public User update(User updatedUser) {
        return entityManager.merge(updatedUser);
    }


    public void delete(Integer id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }


    public User findByUsername(String username) {
        return entityManager.find(User.class, username);
    }
}