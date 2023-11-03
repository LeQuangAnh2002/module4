package codegym.vn.service;

import codegym.vn.entity.Student;

import java.util.List;

public interface StudentService {
    void create(Student student);
    void delete(Student student);
    void update(Student student);
    Student findById(String id);
    List<Student> findAll();
}
