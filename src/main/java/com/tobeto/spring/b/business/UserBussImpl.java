// UserBussImpl.java
package com.tobeto.spring.b.business;

import com.tobeto.spring.b.dataAccess.UserDao;
import com.tobeto.spring.b.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
    @Service
    public class UserBussImpl implements UserBuss {
    private final UserDao userDao;
    @Autowired
    public UserBussImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public User getUserById(int id) {
        List<User> users = userDao.getUsers();
        for (User user : users) {
            if (user.getId()== id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void updateUser(User user) {
        List<User> users = userDao.getUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId()==user.getId()) {
                users.set(i, user);
                break;
            }
        }
    }
}
