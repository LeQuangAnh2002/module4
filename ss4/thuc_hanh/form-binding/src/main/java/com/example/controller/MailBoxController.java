package com.example.controller;

import com.example.model.MailBox;
import com.example.service.MailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/home")
public class MailBoxController {
    @Autowired
    private MailBoxService mailBoxService;
    @GetMapping("")
    public String displayList(Model model){
        model.addAttribute("list",mailBoxService.listMailBox());
        return "list";
    }
    @GetMapping("/detail")
    public String detail(Model model,@RequestParam("id") String id){
        model.addAttribute("mail",mailBoxService.findByID(id));
        model.addAttribute("languages",getLanguage());
        model.addAttribute("page",getPageSize());
        return "update";


    }
    @PostMapping("/update")
    public String update(@ModelAttribute("mail")MailBox mailBox){
        mailBoxService.update(mailBox);
        return "redirect:/home";
    }

    public List<String> getLanguage(){
        List<String> languages = new ArrayList<>();
        languages.add("Vietnamese");
        languages.add("English");
        languages.add("Japanese");
        languages.add("Chinese");
        return languages;
    }
    public List<String> getPageSize(){
        List<String> pageSizes = new ArrayList<>();
        pageSizes.add("5");
        pageSizes.add("10");
        pageSizes.add("15");
        pageSizes.add("25");
        pageSizes.add("50");
        pageSizes.add("100");
        return pageSizes;
    }
}
