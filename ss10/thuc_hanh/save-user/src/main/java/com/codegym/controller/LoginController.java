package com.codegym.controller;

import com.codegym.model.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
public class LoginController {
    /*add user in model attribute*/
    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @RequestMapping("/login")
    public String Index(@CookieValue(value = "setUser", defaultValue = "") String setUser, Model model) {
//    @CookieValue(value = "setUser", defaultValue = ""):   Annotation này được sử dụng để trích xuất giá trị của cookie có tên "setUser" và lưu vào biến setUser. Nếu cookie không tồn tại, giá trị mặc định của "" được sử dụng.
//    Cookie cookie = new Cookie("setUser", setUser) : tạo một đối tượng cookie mới có tên "setUser" và giá trị là setUser, giá trị này được trích xuất từ cookie đã nhận được. Đối tượng cookie này sẽ được sử dụng để tạo một cookie mới hoặc cập nhật cookie đã tồn tại.

        Cookie cookie = new Cookie("setUser", setUser);
        model.addAttribute("cookieValue", cookie.getValue());
//        model.addAttribute("user",new User());
        return "/login";
    }
    @PostMapping("/dologin")
    public String doLogin(@ModelAttribute("user") User user, Model model, @CookieValue(value = "setUser", defaultValue = "") String setUser,
                          HttpServletResponse response, HttpServletRequest request) {
        //implement business logic
        if (user.getEmail().equals("admin@gmail.com") && user.getPassword().equals("12345")) {
            if (user.getEmail() != null)
                setUser = user.getEmail();

            // create cookie and set it in response
            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(24 * 60 * 60); // thời gian sống là 24h
            response.addCookie(cookie); // Sau khi dc thêm vào phản hồi , cookie sẽ được gửi về máy khách và được lưu trên máy khách.

            //get all cookies
            Cookie[] cookies = request.getCookies(); // cập nhật danh sách các cookie được gửi từ máy khách tới server bằng cách sử dụng getCookies() của đối tượng HttpServletRequest
            //iterate each cookie
            for (Cookie ck : cookies) {
                //chỉ tìm kiếm cookie có tên 'setUser'
                if (ck.getName().equals("setUser")) {
                    model.addAttribute("cookieValue", ck.getValue());
                    break;
                } else {
                    ck.setValue("");
                    model.addAttribute("cookieValue", ck.getValue());
                    break;
                }
            }
            model.addAttribute("message", "Login success. Welcome ");
        } else {
            user.setEmail("");
            Cookie cookie = new Cookie("setUser", setUser);
            model.addAttribute("cookieValue", cookie);
            model.addAttribute("message", "Login failed. Try again.");
        }
        return "/login";
    }
}
