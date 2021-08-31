package org.ada.school.service.impl;

import org.ada.school.dto.UserDto;
import org.ada.school.model.User;
import org.ada.school.repository.UserDocument;
import org.ada.school.repository.UserRepository;
import org.ada.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceMongoDB implements UserService {
    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User findById(String id) {
        User user = new User();
        user.updateFromDocument(userRepository.findById(id).get());
        return user;
    }

    @Override
    public List<User> all() {
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public User update(UserDto userDto, String id) {
        User user=null;
        if(userRepository.existsById(id)){
            UserDocument userDoc = userRepository.findById(id).get();
            user = userDoc.update(userDto);
            userRepository.save(userDoc);
        }
        return user;
    }
}
