package com.codegym.furama.dto;

import com.codegym.furama.model.employee.Division;
import com.codegym.furama.model.employee.EducationDegree;
import com.codegym.furama.model.employee.Position;

public class EmployeeDTO {
//    DTO (Data Transfer Object) là một mô hình thiết kế phần mềm được sử dụng để chuyển dữ liệu
//    giữa các thành phần khác nhau trong hệ thống phần mềm. Mô hình DTO giúp tách biệt dữ liệu trên giao diện người dùng
//     và dữ liệu trong hệ thống,đồng thời cung cấp một cách tiếp cận tiện lợi để truyền dữ liệu giữa các thành phần.

//    Một DTO thường bao gồm các trường dữ liệu (data fields) và các phương thức getter và setter để truy cập và thiêt lập
//    giá trị của trường dữ liệu này. DTO thường không chứa logic xử lý phức tạp và chỉ đơn giản là một cấu trúc dữ liệu dể chứa và truyền tải
//    thông tin giữa các thành phần của hệ thống.
    private int id;
    private String name;
    private String birthDay;
    private String idCard;
    private double salary;
    private String phone;
    private String email;
    private String address;
    private Position position;
    private EducationDegree educationDegree;
    private Division division;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int id, String name, String birthDay, String idCard, double salary, String phone, String email, String address, Position position, EducationDegree educationDegree, Division division) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}