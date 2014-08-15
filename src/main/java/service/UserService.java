package service;

import model.User;

public interface UserService {

    User getUserById(Long id);
    User saveUser(User user);
    Iterable<User> findAllUsers();
}
