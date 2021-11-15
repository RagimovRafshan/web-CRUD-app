package com.repository;


import com.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDao {

    @PersistenceContext
    EntityManager em;


    public UserDao() {}

    public void addUser(String name, String lastName, String email) {
        em.persist(new User(name, lastName, email));
    }

    public void updateUser(User user) {
        em.merge(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> readUsers() {
        return em.createQuery("from User").getResultList();
    }


    public void deleteUsersById(long id) {
        try {
            em.remove(em.find(User.class, id));
        } catch(Exception ignore) {}
    }
}
