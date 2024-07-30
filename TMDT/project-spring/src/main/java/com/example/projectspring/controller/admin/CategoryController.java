package com.example.projectspring.controller.admin;

import com.example.projectspring.model.Category;
import com.example.projectspring.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String categories(Model model, Principal principal){
//        Nếu principal có giá trị null, nghĩa là người dùng chưa được xác thực trong hệ thống, điều này thường xảy ra khi người dùng chưa đăng nhập.
        if(principal == null){
            return "redirect:/login";
        }
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categoryNew", new Category());
        model.addAttribute("categories",categories);
        model.addAttribute("size",categories.size());
        model.addAttribute("title","Category");

        return "categories";
    }
    @PostMapping("/add-category")
    public String addCategory(@ModelAttribute("categoryNew") Category category, RedirectAttributes attributes){
        try {
            categoryService.save(category);
            attributes.addFlashAttribute("success","Added successfully");
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed","Failed");
        }
    return "redirect:categories";
    }

    @RequestMapping(value = "/findById",method = {RequestMethod.PUT,RequestMethod.GET})
    @ResponseBody
    public Category findById(Long id){
        return categoryService.findById(id);
    }

    @GetMapping("/update-category")
    public String update(Category category,RedirectAttributes redirectAttributes){
    try {
        categoryService.update(category);
        redirectAttributes.addFlashAttribute("success","Update successfully");
    }catch (Exception e){
        e.printStackTrace();
        redirectAttributes.addFlashAttribute("failed","Failed to update because duplicate name");
    }
    return "redirect:/categories";
    }
    @RequestMapping(value = "/delete-category",method = {RequestMethod.PUT,RequestMethod.GET})
    public String delete(Long id,RedirectAttributes attributes){
        try {
            categoryService.deleteId(id);
            attributes.addFlashAttribute("success","Deleted successfully");
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed","Failed to deleted");
        }
        return "redirect:/categories";
    }

    @RequestMapping(value = "/enable-category",method = {RequestMethod.PUT,RequestMethod.GET})
    public String enable(Long id, RedirectAttributes redirectAttributes){
        try{
            categoryService.enableById(id);
            redirectAttributes.addFlashAttribute("success","Enabled successfully");
        }catch (Exception e){
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("failed","Failed to enabled");
        }
        return "redirect:/categories";
    }
}
