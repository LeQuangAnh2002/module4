package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String display(Model model){
        model.addAttribute("products",productService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("/save")
    public String saveProduct(Product product, RedirectAttributes redirectAttributes){
       productService.add(product);
       redirectAttributes.addFlashAttribute("message","Thêm mới thành công");
       return "redirect:/product";
    }

    @GetMapping ("/{id}/edit")
    public String edit(@PathVariable String id, Model model){
        model.addAttribute("product",productService.findByID(id));
        return "update";
    }
    @PostMapping("/update")
    public String update(Product product,RedirectAttributes redirectAttributes){
        productService.update(product.getId(),product);
        redirectAttributes.addFlashAttribute("message","Cập nhật thành công");
        return "redirect:/product";
    }
    @GetMapping("/{id}/delete")
        public String delete(@PathVariable String id ,RedirectAttributes redirectAttributes){
        productService.delete(id);
        redirectAttributes.addFlashAttribute("message","Xóa thành công");
        return "redirect:/product";
        }
    @GetMapping("/{id}/detail")
    public String view(@PathVariable String id, Model model) {
        model.addAttribute("product", productService.findByID(id));
        return "view";
    }
}
