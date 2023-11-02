// UserBuss.java
package com.tobeto.spring.b.business;

import com.tobeto.spring.b.entities.User;

import java.util.List;

public interface UserBuss {
    List<User> getUsers();
    void addUser(User user);
    void deleteUser(int id);
    User getUserById(int id);
    void updateUser(User user);
}
