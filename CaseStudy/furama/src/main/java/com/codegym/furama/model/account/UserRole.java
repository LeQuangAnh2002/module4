package com.codegym.furama.model.account;

import jakarta.persistence.*;

@Entity
public class UserRole {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "userRole_Id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "username",nullable = false)

    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id",nullable = false)

    private Role role;

    public UserRole() {
    }

    public UserRole(int id, User user, Role role) {
        this.id = id;
        this.user = user;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
