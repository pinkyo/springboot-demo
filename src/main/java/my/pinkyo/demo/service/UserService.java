package my.pinkyo.demo.service;

import my.pinkyo.demo.model.User;

public interface UserService {
    User createUser(User user);
    void updateUser(User user);
    User getUserByName(String name);
    void deleteUserByName(String name);
}
