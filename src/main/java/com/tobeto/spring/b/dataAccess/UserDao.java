// UserDao.java
package com.tobeto.spring.b.dataAccess;

import com.tobeto.spring.b.entities.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    void addUser(User user);
    void deleteUser(int id);
}
