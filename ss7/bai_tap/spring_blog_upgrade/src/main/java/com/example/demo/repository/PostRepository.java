package com.example.demo.repository;

import com.example.demo.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer>
{
    @Query("From Post p where p.category.id = :id")
    public Page<Post> searchByCategory(@Param("id") int id, Pageable pageable);
    public  Page<Post> searchByTitleContaining(String title, Pageable pageable);
    @Query("From Post p where p.title like :title")
    public Page<Post> searchByTitle(@Param("title") String title, Pageable pageable);


}
