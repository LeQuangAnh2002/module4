package com.example.demo.service.ipml;

import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Override
    public boolean create(Post post) {
        postRepository.save(post);
        return true;
    }

    @Override
    public boolean update(Post post) {
        postRepository.save(post);
        return true;
    }

    @Override
    public Post findById(int id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        postRepository.deleteById(id);
        return true;
    }

    @Override
    public Page<Post> findAllAndPaging(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Page<Post> findAllAndPagingAndSearch(Pageable pageable, String title) {
        return  postRepository.searchByTitle(title,pageable);
    }

    @Override
    public Page<Post> findAllByCategories(Pageable pageable, int id) {
        return postRepository.searchByCategory(id,pageable);
    }

    @Override
    public List<Post> getCategoryPost(int id) {
        return postRepository.getCategoryPost(id);
    }
}
