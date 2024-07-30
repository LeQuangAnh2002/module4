package com.codegym.furama.service.employee;

import com.codegym.furama.model.account.User;
import com.codegym.furama.repository.employee.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public User getUserByUserName(String username) {
        return userRepository.findById(username).orElse(null);
    }
}
