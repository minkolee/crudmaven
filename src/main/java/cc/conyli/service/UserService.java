package cc.conyli.service;

import cc.conyli.entity.Customer;
import cc.conyli.sub.User;

import java.util.List;

public interface UserService {

    List<User> geUsers();

    User saveUser(User user);

    User getUser(Long userId);

    void deleteUser (long userId);
}
