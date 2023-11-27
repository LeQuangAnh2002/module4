package com.example.spring_validate_form.Controller;

import com.example.spring_validate_form.Model.User;
import com.example.spring_validate_form.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/register")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/home")
        public String showHome(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "/list";
        }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/create";
        } else {
            userService.save(user);
            return "redirect:/register/home";
        }
    }
}
