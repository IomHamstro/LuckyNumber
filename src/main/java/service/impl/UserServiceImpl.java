package service.impl;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User getUserById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User saveUser(User user) {return  userRepository.save(user);}

    @Override
    public Iterable<User> findAllUsers() { return userRepository.findAll(); }



}
