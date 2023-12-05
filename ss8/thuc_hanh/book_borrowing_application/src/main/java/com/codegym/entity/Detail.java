package com.codegym.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "detail")
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "book_ID")
   private Book book;
    @ManyToOne
    @JoinColumn(name = "card_ID")
   private LibraryCard libraryCard;
    private int quantity;

    public Detail() {
    }

    public Detail(int id, Book book, LibraryCard libraryCard, int quantity) {
        this.id = id;
        this.book = book;
        this.libraryCard = libraryCard;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LibraryCard getLibraryCard() {
        return libraryCard;
    }

    public void setLibraryCard(LibraryCard libraryCard) {
        this.libraryCard = libraryCard;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
