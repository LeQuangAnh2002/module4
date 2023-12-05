package com.codegym.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice là một annotation được sử dụng để đánh dấu một lớp là global exception handler(xử lý ngoại lệ toàn cục)
// lớp này sẽ chứa các phương thức xử lý exception chung cho toàn bộ ứng dụng.
@ControllerAdvice
public class ErrorController {
//    Phương thức error() trong ErrorController được đánh dấu bằng @ExceptionHandler(Exception.class),
//    nghĩa là nó sẽ xử lý exception của kiểu Exception hoặc các exception con của nó.
//    Khi một exception xảy ra trong ứng dụng, Spring sẽ tự động gọi phương thức error() và truyền exception đó vào đối số e.
    @ExceptionHandler(Exception.class)
    public String error(Exception e, Model model){
        model.addAttribute("errorMessage",  e.getMessage());
        return "error";
    }
}
