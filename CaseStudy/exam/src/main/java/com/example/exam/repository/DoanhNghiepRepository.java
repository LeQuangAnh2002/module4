package com.example.exam.repository;

import com.example.exam.model.DoanhNghiep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoanhNghiepRepository extends JpaRepository<DoanhNghiep,Integer> {
//    @Query("From Post p where p.category.id = :id")
//    public Page<Post> searchByCategory(@Param("id") int id, Pageable pageable);
//    public  Page<Post> searchByTitleContaining(String title, Pageable pageable);
//    @Query("From Post p where p.title like %:title% or p.author.name like %:title%")
//    public Page<Post> searchByTitle(@Param("title") String title, Pageable pageable);
//    @Query("From Post p where p.category.id = :categoryId")
//    public List<Post> getCategoryPost(@Param("categoryId") int categoryId);
}
