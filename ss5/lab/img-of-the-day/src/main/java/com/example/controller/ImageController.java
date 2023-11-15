package com.example.controller;

import com.example.model.Image;
import com.example.repository.ImageRepository;
import com.example.repository.StarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private StarRepository strRepository;

    @Autowired
    private ImageRepository imageRepository;

    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("images",imageRepository.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("image",new Image());
        model.addAttribute("stars", strRepository.findAll());
        return "create";
    }
    @PostMapping("/create")
    public String doCreate(@ModelAttribute("image") Image image) {
        image.setStar(strRepository.findById(image.getStar().getId()));
        imageRepository.create(image);
        return "redirect:list";
    }
    @GetMapping("/doLike")
    public String doLike(@RequestParam("id") int id) {
        imageRepository.updateLike(id);
        return "redirect:/image/list";
    }
}
