package com.codegym.furama.validator;

import com.codegym.furama.model.employee.Employee;
import com.codegym.furama.service.employee.EmpolyeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Date;

@Component
public class EmployeeValidate implements Validator
{
    @Autowired
    private EmpolyeeService empolyeeService;
    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof Employee)) {
            return;
        }

        Employee employee = (Employee) target;
        if(employee.getName() == null || employee.getName().isEmpty()){
            errors.rejectValue("name","","Name không được để trống ");
        } else if(employee.getName().length() >50 || employee.getName().length() <3){
            errors.rejectValue("name","","Name độ dài phải đủ từ 3 kí tự đến 50");
        }

        if(employee.getIdCard() == null || employee.getIdCard().isEmpty()){
            errors.rejectValue("idCard","","CCCD/CMND không được để trống ");
        } else if(employee.getIdCard().length() > 11 || employee.getIdCard().length() < 9){
            errors.rejectValue("idCard","","CCCD/CMND nằm trong khoảng từ 9 đến 11 kí tự");
        }

        if(employee.getPhone() == null || employee.getPhone().isEmpty()){
            errors.rejectValue("phone","","Số điện thoại không được để trống ");
        } else if(!employee.getPhone().matches("(^$|[0-9]*$)")){
            errors.rejectValue("phone","","Số điện thoại không đúng dịnh dạng");
        }

        if(employee.getBirthDay() == null || employee.getBirthDay().equals("")){
            errors.rejectValue("birthDay","","Ngày không hợp lệ");
          }
//        else if(employee.getBirthDay().before(new Date())){
//            errors.rejectValue("birthDay","","Ngày không hợp lệ");
//        }

        if(employee.getEmail() == null || employee.getEmail().isEmpty()){
            errors.rejectValue("email","","Email không được để trống ");
        }else if(!employee.getEmail().matches("^\\w+@\\w+[.]\\w+$")){
            errors.rejectValue("email","","Email không đúng định dạng ");
        }
     }

}
