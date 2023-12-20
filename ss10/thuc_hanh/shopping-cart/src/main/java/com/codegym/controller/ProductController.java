package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.service.CartService;
import com.codegym.service.ProductService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@SessionAttributes("cart")
@RequestMapping("/shop")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;
    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }
    @GetMapping("")
        public String showShop(Model model){
        model.addAttribute("products",productService.findAll());
        return "/shop";
        }

        @GetMapping("/add/{id}")
    public String addToCart(@CookieValue(value ="cookieID", defaultValue = "") String cookieID, @PathVariable("id") int id, @ModelAttribute("cart") Cart cart, @RequestParam(name = "action") String action, HttpServletResponse response, HttpServletRequest request,Model model){


        Cookie[] cookies = request.getCookies(); // cập nhật danh sách các cookie được gửi từ máy khách tới server bằng cách sử dụng getCookies() của đối tượng HttpServletRequest

        for (Cookie cookie : cookies){
            if (cookie.getName().equals(cookieID)) {
                // Tăng số lượng sản phẩm trong giỏ hàng lên 1
//                cartService.updateCurrentQuantity(id);
                break;
            }
            // Kiểm tra nếu cookie chưa  tồn tại
            else {
                // Thêm sản phẩm vào giỏ hàng
                Product product = productService.findById(id);


                if (product == null) {
                    return "/error";
                }
                cart.set

                cart.setTotal(product.getPrice());
                cartService.create(cart);

                // Tạo cookie mới
                Cookie cookieName = new Cookie("cookieID", String.valueOf(id));
                cookie.setMaxAge(24 * 60 * 60);
                response.addCookie(cookieName);
            }
        }
            if (action.equals("show")) {
                return "redirect:/shopping-cart";
            }
            model.addAttribute("products",productService.findAll());
            return "/shop";
        }
}
