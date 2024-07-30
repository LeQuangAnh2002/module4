package com.example.authentication.config;

import com.example.authentication.model.Role;
import com.example.authentication.model.User;

import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {


    private String username;
    private String password;
    private List<GrantedAuthority> authorities;
    private boolean isEnable;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;

    public UserDetails(String username, String password, List<GrantedAuthority> authorities, boolean isEnable, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.isEnable = isEnable;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnable;
    }
}
