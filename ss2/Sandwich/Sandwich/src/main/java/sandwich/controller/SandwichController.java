package sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sandwich.bean.Sandwich;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SandwichController {

    @GetMapping("/")
    public ModelAndView getIndex() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<String> sandwichSpice = new ArrayList<>();
        sandwichSpice.add("Lettuce");
        sandwichSpice.add("Tomato");
        sandwichSpice.add("Mustard");
        sandwichSpice.add("Sprouts");
        modelAndView.addObject("sandwichSpice",sandwichSpice);
        modelAndView.addObject("sandwich",new Sandwich());
        return  modelAndView;
    }

    @PostMapping("/")
        public ModelAndView getSandwich(@ModelAttribute Sandwich sandwich, RedirectAttributes redirectAttributes) {
    redirectAttributes.addAttribute("sandwich",sandwich.getSpice());
    return new ModelAndView("redirect:/")       ;
    }
}
