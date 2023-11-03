package codegym.vn.thuvien.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LibraryController {
    @GetMapping("/library")
    public String display(){
        return "index";
    }
    @PostMapping("/translate")
    public String translate(@RequestParam("txtSearch") String search, Model model){
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");

        String resultSet = dictionary.get(search);

            model.addAttribute("search",search);
            model.addAttribute("resultSet",resultSet);

            model.addAttribute("message","Not Found");
        


        return "result";
    }
}
