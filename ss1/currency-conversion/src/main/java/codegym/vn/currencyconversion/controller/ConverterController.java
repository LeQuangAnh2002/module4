package codegym.vn.currencyconversion.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/converter")
public class ConverterController {
    @GetMapping("/create")
//    public String displayCreate() {
//        return "create";
//    }
    public ModelAndView displayCreate(){
        ModelAndView model = new ModelAndView("create");
        return model;
    }

    @PostMapping("/convert")
    public String convertCurrency(@RequestParam("rate") double rate, @RequestParam("usd") double usd, Model model){
        double convertedAmount = rate * usd;
        model.addAttribute("convertedAmount",convertedAmount);
        return "result";
    }
}
