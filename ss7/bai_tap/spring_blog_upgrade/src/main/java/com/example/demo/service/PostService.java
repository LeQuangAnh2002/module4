package com.example.demo.service;

import com.example.demo.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService extends Service<Post>{
    Page<Post> findAllAndPaging(Pageable pageable);
    Page<Post> findAllAndPagingAndSearch(Pageable pageable,String title);
    Page<Post> findAllByCategories(Pageable pageable,int id);
    List<Post> getCategoryPost(int id);
}
