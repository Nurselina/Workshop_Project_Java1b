// UserImpl.java
package com.tobeto.spring.b.dataAccess;

import com.tobeto.spring.b.entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserImpl implements UserDao {

    private final List<User> users = new ArrayList<>();

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void deleteUser(int id) {
        users.removeIf(user -> user.getId()==id);

    }
}
