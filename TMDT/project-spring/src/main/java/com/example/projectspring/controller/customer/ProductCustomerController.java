package com.example.projectspring.controller.customer;

import com.example.projectspring.model.Product;
import com.example.projectspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/products")
public String products(Model model){
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products",products);
    return "customer/shop";
}

}
