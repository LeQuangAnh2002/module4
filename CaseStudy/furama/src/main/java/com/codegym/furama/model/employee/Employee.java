package com.codegym.furama.model.employee;

import com.codegym.furama.model.account.User;
import com.codegym.furama.model.contract.Contract;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Entity

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int id;
//    @NotBlank
//    @Size(min = 3,max = 50,message = "Name độ dài phải đủ từ 3 kí tự ")
    private String name;

    @Column(columnDefinition = "DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String birthDay;
//    @NotBlank(message = "Trường CCCD/CMND không được để trống")
//    @Size(min = 9,max = 11,message = "CCCD/CMND nằm trong khoảng từ 9 đến 11 kí tự")
    private String idCard;
    @DecimalMin(value = "0.0", inclusive = false,message = "Lương phải lớn hơn 0")
    private double salary;
//    @NotBlank(message = "SDT không được để trống")
//    @Pattern(regexp = "\\d{10}",message = "Số điện thoại không đúng dịnh dạng")
    private String phone;
//    @NotBlank(message = "Email không được để trống")
//    @Email(message = "Email không đúng định dạng")
    private String email;
    @NotBlank(message = " Địa chỉ không được để trống")
    private String address;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false, referencedColumnName = "position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id", nullable = false, referencedColumnName = "education_degree_id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false, referencedColumnName = "division_id")
    private Division division;

    @OneToMany(mappedBy = "employee")
    List<Contract> contracts;

    @OneToMany(mappedBy = "employee")
    List<User> users;

    public Employee() {
    }

    public Employee(int id, String name, String birthDay, String idCard, double salary, String phone, String email, String address, Position position, EducationDegree educationDegree, Division division, List<Contract> contracts, List<User> users) {
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
        this.contracts = contracts;
        this.users = users;
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

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
