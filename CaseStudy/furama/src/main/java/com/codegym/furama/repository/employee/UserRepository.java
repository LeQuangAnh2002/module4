package com.codegym.furama.repository.employee;

import com.codegym.furama.model.account.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
