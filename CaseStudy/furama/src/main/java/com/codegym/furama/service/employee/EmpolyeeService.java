package com.codegym.furama.service.employee;

import com.codegym.furama.model.employee.Division;
import com.codegym.furama.model.employee.EducationDegree;
import com.codegym.furama.model.employee.Employee;
import com.codegym.furama.model.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmpolyeeService {
    boolean add(Employee employee);
    boolean update(Employee employee);
    boolean remove(int id);
    List<Employee> findAll();
    Employee findById (int id);

    List<EducationDegree> findEducation();
    List<Position> findPosition();
    List<Division> findDivision();
    Page<Employee> findAllAndPaging(Pageable pageable);
}
