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

//    @Override
//    public CV getCVById(Long id) {
//        return cvRepository.findOne(id);
//    }
//
//    @Transactional
//    @Override
//    public CV getCVByIdWithCategories(Long id) {
//        CV cv = cvRepository.findOne(id);
//        Hibernate.initialize(cv.getCategories());
//        return cv;
//    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User saveUser(User user) {return  userRepository.save(user);}

}
