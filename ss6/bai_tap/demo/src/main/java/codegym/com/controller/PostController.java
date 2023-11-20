package codegym.com.controller;

import codegym.com.model.Post;
import codegym.com.repository.Impl.AuthorRepository;
import codegym.com.repository.Impl.CategoryRepository;
import codegym.com.repository.Impl.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping("")
    public String display(Model model){
        model.addAttribute("post",postRepository.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("post",new Post());
        model.addAttribute("authors",authorRepository.findAll());
        model.addAttribute("categories",categoryRepository.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("post") Post post){
        post.setCategory(categoryRepository.findById(post.getCategory().getId()));
        post.setAuthor(authorRepository.findById(post.getAuthor().getId()));
        postRepository.create(post);
        return "redirect:/post";
    }
    @GetMapping("/detail/{id}")
    public String showDetail(Model model, @PathVariable("id") int id){
        Post post = postRepository.findById(id);
        model.addAttribute("post",post);
        model.addAttribute("authors",authorRepository.findAll());
        model.addAttribute("categories",categoryRepository.findAll());
        return "detail";
    }
    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable("id") int id, Model model) {
        model.addAttribute("post", postRepository.findById(id));
        model.addAttribute("authors",authorRepository.findAll());
        model.addAttribute("categories",categoryRepository.findAll());
        return "update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("post") Post post) {
        post.setCategory(categoryRepository.findById(post.getCategory().getId()));
        post.setAuthor(authorRepository.findById(post.getAuthor().getId()));
        postRepository.update(post);
        return "redirect:/post";
    }
    @GetMapping("/delete/{id}")
    public String doDelete(@PathVariable("id") int id){

        postRepository.deleteById(id);
        return "redirect:/post";

    }
}
