package com.codegym.furama.utils;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class UserUtils {
    public String generatePassword(String password){
        String bcryptHashString = BCrypt.withDefaults().hashToString(12,password.toCharArray());
        return bcryptHashString;
    }
}
