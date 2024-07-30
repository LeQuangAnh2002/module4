package com.codegym.furama.model.account;

import com.codegym.furama.model.employee.Employee;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id

    @Column(columnDefinition = "varchar(50)")
    private String username;
    @Column(columnDefinition = "varchar(50)")
    private String password;

    @ManyToOne
    @JoinColumn(name = "employee_id",nullable = false,referencedColumnName = "employee_id")
    private Employee employee;

    @OneToMany(mappedBy = "user")
    private List<UserRole> userRoleList;

    public User() {
    }

    public User(String username, String password, Employee employee, List<UserRole> userRoleList) {
        this.username = username;
        this.password = password;
        this.employee = employee;
        this.userRoleList = userRoleList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }
}
