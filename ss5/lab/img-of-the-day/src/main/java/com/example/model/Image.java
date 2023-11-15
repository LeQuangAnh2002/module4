package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "imgae")
public class Image {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String author;
    private String feelBack;
    private int enjoys;
    @ManyToOne
    @JoinColumn(name = "star_id")
    private Star star;

    public Image() {
    }

    public Image(int id, String author, String feelBack, int enjoys, Star star) {
        this.id = id;
        this.author = author;
        this.feelBack = feelBack;
        this.enjoys = enjoys;
        this.star = star;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeelBack() {
        return feelBack;
    }

    public void setFeelBack(String feelBack) {
        this.feelBack = feelBack;
    }

    public int getEnjoys() {
        return enjoys;
    }

    public void setEnjoys(int enjoys) {
        this.enjoys = enjoys;
    }

    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
    }
}
