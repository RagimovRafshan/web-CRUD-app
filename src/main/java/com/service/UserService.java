package com.service;

import com.repository.UserDao;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public void addUser(String firstName, String lastName, String email) {
        userDao.addUser(firstName, lastName, email);
    }

    public void updateUser(long id, String firstName, String lastName, String email) {
        userDao.updateUser(new User(id, firstName, lastName, email));
    }

    public List<User> readUsers() {
        return userDao.readUsers();
    }

    public void deleteUsersById(long id) {
        userDao.deleteUsersById(id);
    }
}
