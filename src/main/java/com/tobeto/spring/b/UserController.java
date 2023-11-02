// UserController.java
package com.tobeto.spring.b;

import com.tobeto.spring.b.business.UserBuss;
import com.tobeto.spring.b.entities.User;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {

    private final UserBuss userBuss;

    public UserController(UserBuss userBuss) {
        this.userBuss = userBuss;
        List<User> allUsers = userBuss.getUsers();

    }
    @PostConstruct
    public void addUser () {
       userBuss.addUser(new User(1,"kadir", "kadir@tobeto", 32));
       userBuss.addUser(new User(2,"yasin", "yasin@tobeto", 23));
       userBuss.addUser(new User(3,"nursel", "nursel@tobeto", 29));
    }
    @GetMapping()
    public List<User> getAllUsers() {


        return this.userBuss.getUsers();
    }
    @PostMapping()
    public String createUser(@RequestBody User user) {
        userBuss.addUser(user);
        return "Kullanıcı oluşturuldu: " + user.getName() + " (ID: " + user.getId() + ")";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user) {
        User existingUser = userBuss.getUserById(id);

        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setAge(user.getAge());

            userBuss.updateUser(existingUser);

            return "Kullanıcı güncellendi: ID: " + id + ", Yeni Bilgiler: \nİsim: " + existingUser.getName() +
                    ", \nE-mail: " + existingUser.getEmail() + ", \nYaş: " + existingUser.getAge();
        } else {
            return "Kullanıcı bulunamadı. Güncelleme başarısız.";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        userBuss.deleteUser(id);
        return "Kullanıcı silindi: " + id;
    }
}
