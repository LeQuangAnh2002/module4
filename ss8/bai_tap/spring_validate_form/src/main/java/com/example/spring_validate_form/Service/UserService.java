package com.example.spring_validate_form.Service;

import com.example.spring_validate_form.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<User> findAll();
    void save(User user);
}
