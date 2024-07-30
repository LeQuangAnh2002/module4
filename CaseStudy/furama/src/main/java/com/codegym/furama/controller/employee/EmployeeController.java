package com.codegym.furama.controller.employee;

import com.codegym.furama.model.employee.Division;
import com.codegym.furama.model.employee.EducationDegree;
import com.codegym.furama.model.employee.Employee;
import com.codegym.furama.model.employee.Position;
import com.codegym.furama.service.employee.EmpolyeeService;
import com.codegym.furama.validator.EmployeeValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmpolyeeService empolyeeService;

    @Autowired
    private EmployeeValidate employeeValidate;
@GetMapping("/list")
    public String showList(Model model, @RequestParam(name = "page", defaultValue = "1", required = false) int pageNumber,
                           @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize){

    Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
    Page<Employee> employeePage = empolyeeService.findAllAndPaging(pageable);
    int totalPage = employeePage.getTotalPages();
    List<Integer> pageNumbers = new ArrayList<>();
    for (int i = 0; i < totalPage; i++) {
        pageNumbers.add(i + 1);
    }

    model.addAttribute("employees", employeePage);
    model.addAttribute("pageSize", pageSize);
    model.addAttribute("pageNumbers", pageNumbers);
    return "employee/list";
    }

    @GetMapping("/add")
    public String showAddEmployee(Model model){

    List<Position> positions = empolyeeService.findPosition();
    List<EducationDegree> educationDegrees = empolyeeService.findEducation();
    List<Division> divisions = empolyeeService.findDivision();
        model.addAttribute("employee",new Employee());
    model.addAttribute("positions",positions);
    model.addAttribute("educationDegrees",educationDegrees);
    model.addAttribute("divisions",divisions);

    return "/employee/create";
    }

    @PostMapping("/add")
    public String addEmployee(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult, Model model){
        employeeValidate.validate(employee,bindingResult);
    if(bindingResult.hasErrors()){


                List<Position> positions = empolyeeService.findPosition();
                List<EducationDegree> educationDegrees = empolyeeService.findEducation();
                List<Division> divisions = empolyeeService.findDivision();

                model.addAttribute("positions",positions);
                model.addAttribute("educationDegrees",educationDegrees);
                model.addAttribute("divisions",divisions);
                return "/employee/create";



    }

            empolyeeService.add(employee);
            return "redirect:/employee/list";
    }
    @GetMapping("/detail/{id}")
    public String showEdit(@PathVariable int id,Model model){
        Employee employee = empolyeeService.findById(id);
        List<Position> positions = empolyeeService.findPosition();
        List<EducationDegree> educationDegrees = empolyeeService.findEducation();
        List<Division> divisions = empolyeeService.findDivision();

        model.addAttribute("positions",positions);
        model.addAttribute("educationDegrees",educationDegrees);
        model.addAttribute("divisions",divisions);
        model.addAttribute("employee",employee);
        return "/employee/update";
    }
    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute("employee") Employee employee){
    empolyeeService.add(employee);
        return "redirect:/employee/list";
    }
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
    empolyeeService.remove(id);
        return "redirect:/employee/list";
    }
}
