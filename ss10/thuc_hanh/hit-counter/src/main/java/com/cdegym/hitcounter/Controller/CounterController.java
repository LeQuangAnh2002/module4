package com.cdegym.hitcounter.Controller;

import com.cdegym.hitcounter.model.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
//Annotation này được sử dụng để chỉ định rằng giá trị của thuộc tính counter trong model cần
// được lưu trữ và duy trì trong sesion. Khi một phương thức trả về giá trị "counter" giá trị này sẽ đc tự
// động thêm vào session mỗi khi phương thức được gọi
@SessionAttributes("counter")

public class CounterController {
//    @ModelAttribute("counter"): Annotation này được sử dụng để đánh dấu phương thức setUpCounter()
//    khi một yêu cầu HTTP được xử lý, phương thức này sẽ được gọi để khởi tạo đối tượng và trả về một đối tượng Counter
//    Đối tượng Counter này sẽ được lưu trong session nhờ vào @SessionAttributes("counter").
    @ModelAttribute("counter")
    public Counter setUpCounter() {
        return new Counter();
    }
    @GetMapping("/")
    public String get(@ModelAttribute("counter") Counter counter) {
        counter.increment();
        return "/index";
    }
}
