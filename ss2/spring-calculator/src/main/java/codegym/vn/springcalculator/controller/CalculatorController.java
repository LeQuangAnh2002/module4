package codegym.vn.springcalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/calculator")
    public String display(){
        return "index";
    }
    @PostMapping("/calculate")
    public String resultSet (@RequestParam("first-operand") double firstOperand, @RequestParam("second-operand") double secondOperand, @RequestParam("operator") char operator, Model model){
            double result = calculate(firstOperand,secondOperand,operator);
            model.addAttribute("result",result);
            return "result";
    }




    private  double calculate(double firstOperand, double secondOperand, char operator ){
        switch (operator){
            case '+':
                return firstOperand + secondOperand;
            case '-':
                return firstOperand - secondOperand;
            case '*':
                return firstOperand * secondOperand;
            case '/':
                if(secondOperand != 0)
                    return firstOperand / secondOperand;
                else
                    throw new RuntimeException("Can't divide by zero");
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
