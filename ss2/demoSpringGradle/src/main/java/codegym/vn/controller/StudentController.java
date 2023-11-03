package codegym.vn.controller;

import codegym.vn.entity.Student;
import codegym.vn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;
    // constructor injection
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//    @GetMapping("/list")
    @RequestMapping(value = "/list", method = RequestMethod.GET
//        , consumes = {"text/html"}
    )
    public String displayList(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "student/list";
    }

    @GetMapping("/detail/{id}")
    public String displayDetail(Model model, @PathVariable("id") String id) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "student/detail";
    }

    @GetMapping("/detail")
    public String displayDetail2(Model model, @RequestParam("id") String id) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "student/detail";
    }

    @GetMapping("/detail2")
    public String displayDetail3(Model model, @RequestParam("id") String id, RedirectAttributes attributes) {
        model.addAttribute("message", "From list page");
        attributes.addFlashAttribute("message1", "From list page");;
        return "redirect:/student/detail?id=" + id;
    }
    // setter injection
//    @Autowired
//    public void setStudentService(StudentService studentService) {
//        this.studentService = studentService;
//    }

//    @GetMapping("/create")
//    public String displayCreate(Model model) {
//        model.addAttribute("student", new Student());
//        model.addAttribute("action", "create");
//        model.addAttribute("hobbies", getHobbies());
//        return "student/create";
//    }
        @GetMapping("/create")
    public ModelAndView displayCreate() {
        ModelAndView model = new ModelAndView("student/create");
        model.addObject("student", new Student());
        model.addObject("action", "create");
        model.addObject("hobbies", getHobbies());
        return model;
    }


    @GetMapping("/edit")
    public String displayCreate(Model model, @RequestParam("id") String id) {
        model.addAttribute("student", studentService.findById(id));
        model.addAttribute("action", "edit");
        model.addAttribute("hobbies", getHobbies());
        return "student/create";
    }

    @PostMapping("/create")
    public String doCreateOrEdit(@ModelAttribute("student") Student student,
                                 @RequestParam("action") String action,
                                 RedirectAttributes attributes) {
        if ("create".equals(action)) {
            studentService.create(student);
            attributes.addFlashAttribute("message", "Thêm mới thành công");
        } else {
            studentService.update(student);
            attributes.addFlashAttribute("message", "Cập nhật thành công");
        }
        return "redirect:/student/list";
    }

    private List<String> getHobbies() {
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Thể thao");
        hobbies.add("Du lịch");
        hobbies.add("Âm nhạc");
        hobbies.add("Mua sắm");
        hobbies.add("Ăn uống");
        return hobbies;
    }
}
