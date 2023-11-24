package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "category")
public class Category
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name = "name_category", columnDefinition = "varchar(25)")
    private String name;
    @Column(columnDefinition = "varchar(50)")
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Post> posts;

    public Category() {
    }

    public Category(int id, String name, String description, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.posts = posts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
