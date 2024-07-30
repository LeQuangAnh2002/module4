package com.codegym.furama.service.employee;

import com.codegym.furama.model.account.User;
import org.springframework.stereotype.Service;


public interface UserService
{

    User getUserByUserName(String username);
}
