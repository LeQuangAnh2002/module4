package com.codegym.furama.service.employee;

import com.codegym.furama.model.employee.Division;
import com.codegym.furama.model.employee.EducationDegree;
import com.codegym.furama.model.employee.Employee;
import com.codegym.furama.model.employee.Position;
import com.codegym.furama.repository.employee.DivisionRepository;
import com.codegym.furama.repository.employee.EducationRepository;
import com.codegym.furama.repository.employee.EmployeeRepository;
import com.codegym.furama.repository.employee.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmpolyeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DivisionRepository divisionRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private EducationRepository educationRepository;

    @Override
    public boolean add(Employee employee) {
        employeeRepository.save(employee);
        return true;
    }

    @Override
    public boolean update(Employee employee) {
        employeeRepository.save(employee);
        return true;
    }

    @Override
    public boolean remove(int id) {
        employeeRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<EducationDegree> findEducation() {
        return educationRepository.findAll();
    }

    @Override
    public List<Position> findPosition() {
        return positionRepository.findAll();
    }

    @Override
    public List<Division> findDivision() {
        return divisionRepository.findAll();
    }

    @Override
    public Page<Employee> findAllAndPaging(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }
}
