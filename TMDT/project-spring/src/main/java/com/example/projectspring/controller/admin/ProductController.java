package com.example.projectspring.controller.admin;

import com.example.projectspring.dto.CategoryDto;
import com.example.projectspring.dto.ProductDto;
import com.example.projectspring.model.Category;
import com.example.projectspring.model.Product;
import com.example.projectspring.service.CategoryService;
import com.example.projectspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/products")
    public String products(Model model, Principal principal){
        //        Nếu principal có giá trị null, nghĩa là người dùng chưa được xác thực trong hệ thống, điều này thường xảy ra khi người dùng chưa đăng nhập.
        if(principal == null){
            return "redirect:/login";
        }
        List<ProductDto> productDtoList = productService.findAll();
        model.addAttribute("title","Manage Product");
        model.addAttribute("products",productDtoList);
        model.addAttribute("size",productDtoList.size());
        return "products";
    }

    @GetMapping("/add-product")
    public String addProductForm(Model model, Principal principal){
        //        Nếu principal có giá trị null, nghĩa là người dùng chưa được xác thực trong hệ thống, điều này thường xảy ra khi người dùng chưa đăng nhập.
        if(principal == null){
            return "redirect:/login";
        }
        List<Category> categories = categoryService.findAllByActivated();
        model.addAttribute("categories",categories);
        model.addAttribute("product",new ProductDto());
        return "add-product";
    }
    @PostMapping("/save-product")
    public String saveProduct(@ModelAttribute("product")ProductDto productDto, @RequestParam("imageProduct")MultipartFile imageProduct,
                              RedirectAttributes attributes){
        try{
            productService.save(imageProduct,productDto);
            attributes.addFlashAttribute("success","Add successfully");

        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed","Failed to add");
        }

        return "redirect:/products";
    }

    @GetMapping("/update-product/{id}")
    public String updateProduct(@PathVariable("id") Long id, Model model,Principal principal){
        if (principal == null){
            return "redirect:/login";
        }
       model.addAttribute("title","Update Products");
       List<Category> categories = categoryService.findAllByActivated();
        ProductDto productDto = productService.getById(id);
        model.addAttribute("product",productDto);
        model.addAttribute("categories",categories);
        return "update-product";
    }

    @PostMapping("/update-product/{id}")
    public String processUpdate(@PathVariable("id") Long id,@ModelAttribute("product") ProductDto productDto,
                                @RequestParam("imageProduct") MultipartFile imageProduct
                                ,Model model,RedirectAttributes attributes){
    try {
            productService.update(imageProduct,productDto);
        attributes.addFlashAttribute("success","Update successfully");
    }catch (Exception e){
        e.printStackTrace();
        attributes.addFlashAttribute("failed","Failed to update");
    }
        return "redirect:/products";
    }

    @RequestMapping(value = "/enable-product/{id}",method = {RequestMethod.PUT,RequestMethod.GET})
    public String enableProduct(@PathVariable("id") Long id, RedirectAttributes attributes){
        try {
            productService.enableById(id);
            attributes.addFlashAttribute("success","Enable successfully");
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed","Failed to enable");
        }
        return "redirect:/products";
    }
    @RequestMapping(value = "/delete-product/{id}",method = {RequestMethod.PUT,RequestMethod.GET})
    public String deleteProduct(@PathVariable("id") Long id, RedirectAttributes attributes){
        try {
            productService.deleteById(id);
            attributes.addFlashAttribute("success","Delete successfully");
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed","Failed to delete");
        }
        return "redirect:/products/0";
    }
    @GetMapping("/products/{pageNo}")
    public String productsPage(@PathVariable("pageNo") int pageNo,Model model,Principal principal){
        if (principal == null){
            return "redirect:/login";
        }
        Page<ProductDto> products = productService.pageProducts(pageNo);
        model.addAttribute("title","Manage Product");
        model.addAttribute("size",products.getSize());
        model.addAttribute("totalPages",products.getTotalPages());
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("products",products);
        return "products";
    }

    @GetMapping("/search-result/{pageNo}")
    public String searchProducts(@PathVariable("pageNo") int pageNo,@RequestParam("keyword") String keyword,Model model,Principal principal){
        if (principal == null){
            return "redirect:/login";
        }
        Page<ProductDto> products = productService.searchProducts(pageNo,keyword);
        model.addAttribute("products",products);
        model.addAttribute("size",products.getSize());
        model.addAttribute("totalPages",products.getTotalPages());
        model.addAttribute("currentPage",pageNo);
        return "products";
    }

    @GetMapping("/high-price")
    public String filterHighPrice(Model model){
        List<Category> categories = categoryService.findAllByActivated();
        List<CategoryDto> categoryDtoList = categoryService.getCategoryAndProduct();
        List<Product> products = productService.filterHighPrice();
        model.addAttribute("products",products);
        model.addAttribute("categories",categories);
        model.addAttribute("categoryDtoList",categoryDtoList);
        return "customer/filter-high-price";
    }

    @GetMapping("/low-price")
    public String filterLowPrice(Model model){
        List<Category> categories = categoryService.findAllByActivated();
        List<CategoryDto> categoryDtoList = categoryService.getCategoryAndProduct();
        List<Product> products = productService.filterLowPrice();
        model.addAttribute("products",products);
        model.addAttribute("categories",categories);
        model.addAttribute("categoryDtoList",categoryDtoList);
        return "customer/low-high-price";
    }
}
