package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="star")
public class Star {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="star_id")
    private int id;
    @Column(name="number_star")
    private int numberStar;
    @OneToMany(mappedBy = "star")
    private List<Image> images;

    public Star() {
    }

    public Star(int id, int numberStar) {
        this.id = id;
        this.numberStar = numberStar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberStar() {
        return numberStar;
    }

    public void setNumberStar(int numberStar) {
        this.numberStar = numberStar;
    }
}
