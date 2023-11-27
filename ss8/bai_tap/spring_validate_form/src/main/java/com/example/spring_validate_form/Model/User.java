package com.example.spring_validate_form.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @Size(min = 3,max = 45)
    private String firstName;
    @NotBlank
    @Size(min = 3,max = 45)
    private String lastName;
    @Pattern(regexp= "^0[0-9]+$",message = "số điện thoại phải bắt đầu từ số 0")
    @Size(min = 10,max = 10, message = "chỉ có 10 số")
    private String Phone;
    @Min(18)

    private int age;
    @Email
    private String email;

    public User() {
    }

    public User(int id, String firstName, String lastName, String phone, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        Phone = phone;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
