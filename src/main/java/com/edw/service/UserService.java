package com.edw.service;

import com.edw.entity.User;
import com.edw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <pre>
 *     com.edw.service.UserService
 * </pre>
 *
 * @author Muhammad Edwin < emuhamma at redhat dot com >
 * 16 Des 2019 11:54
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User insert(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }

    public Boolean exist(String id) {
        return userRepository.existsById(id);
    }

    public List findAll() {
        return userRepository.findAll();
    }
}
