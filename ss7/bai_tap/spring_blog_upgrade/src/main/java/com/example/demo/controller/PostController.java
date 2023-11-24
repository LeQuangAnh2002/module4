package com.example.demo.controller;

import com.example.demo.entity.Post;
import com.example.demo.service.AuthorService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.PostService;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AuthorService authorService;
    @GetMapping("/list")
    public String display(Model model, @RequestParam(name = "page",defaultValue = "1",required = false) int pageNumber,
                          @RequestParam(value = "pageSize",defaultValue = "5",required = false) int pageSize){

        Pageable pageable = PageRequest.of(pageNumber-1,pageSize);
        Page<Post> posts = postService.findAllAndPaging(pageable);
        int totalPage = posts.getTotalPages();
        List<Integer> pageNumbers = new ArrayList<>();
        for (int i = 0; i < totalPage; i++) {
            pageNumbers.add(i + 1);
        }
        model.addAttribute("posts",posts);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("categories",categoryService.findAll());
        return "view/list";
    }
    @GetMapping("/search")
    public String searchPost(Model model, @RequestParam(name = "page",defaultValue = "1",required = false) int pageNumber,
                             @RequestParam(value = "pageSize",defaultValue = "5",required = false) int pageSize, @RequestParam("post_title") String postTitle){
        Pageable pageable = PageRequest.of(pageNumber-1,pageSize);
        Page<Post> posts = postService.findAllAndPagingAndSearch(pageable,postTitle);
        int totalPage = posts.getTotalPages();
        List<Integer> pageNumbers = new ArrayList<>();
        for (int i = 0; i < totalPage; i++) {
            pageNumbers.add(i + 1);
        }
        model.addAttribute("posts",posts);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("categories",categoryService.findAll());
        return "view/list";
    }
    @GetMapping("/create")
    public String showCreataPost(Model model){
        model.addAttribute("post",new Post());
        model.addAttribute("authors",authorService.findAll());
        model.addAttribute("categories",categoryService.findAll());
        return "view/create";

    }
    @PostMapping("/create")
    public String savePost(@ModelAttribute("post") Post post){

        postService.create(post);
        return "redirect:/post";

    }
    @GetMapping("/findAllCategories")
    public String findAllCategories(Model model,@RequestParam("idCategory") int IdCategory,@RequestParam(name = "page",defaultValue = "1",required = false) int pageNumber,
                                    @RequestParam(value = "pageSize",defaultValue = "5",required = false) int pageSize ){

                Pageable pageable = PageRequest.of(pageNumber-1,pageSize);
        Page<Post> posts = postService.findAllByCategories(pageable,IdCategory);
        int totalPage = posts.getTotalPages();
        List<Integer> pageNumbers = new ArrayList<>();
        for (int i = 0; i < totalPage; i++) {
            pageNumbers.add(i + 1);
        }
        model.addAttribute("posts",posts);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("categories",categoryService.findAll());
        return "view/list";
    }
    @GetMapping("/detail/{id}")
    public String showDetail(Model model, @PathVariable("id") int id){
        Post post = postService.findById(id);
        model.addAttribute("post",post);
        model.addAttribute("authors",authorService.findAll());
        model.addAttribute("categories",categoryService.findAll());
        return "view/detail";
    }
    @GetMapping("/delete/{id}")
    public String doDelete(@PathVariable("id") int id){

        postService.deleteById(id);
        return "redirect:/post/list";

    }
    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable("id") int id, Model model) {
        Post post = postService.findById(id);
        model.addAttribute("post", post);
        model.addAttribute("authors",authorService.findAll());
        model.addAttribute("categories",categoryService.findAll());
        return "view/update";
    }
    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("post") Post post) {

        postService.update(post);
        return "redirect:/post/list";
    }
}
