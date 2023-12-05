package com.codegym.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
@Entity
@Table(name = "library_card")
public class LibraryCard {
    @Id
    @Column(columnDefinition = "varchar(5)")
    private String idBook;
    @Column(name = "book_name",columnDefinition = "varchar(50)")
    private String bookName;
    @Column(name = "borrowed_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date borrowedDate;
    @Column(name = "pay_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date payDate;
    @Column(name = "borrowed_name")

    private String borrowedName;
    private int quantity;

    @OneToMany(mappedBy = "libraryCard")
    private List<Detail> details;

    public LibraryCard() {
    }

    public LibraryCard(String idBook, String bookName, Date borrowedDate, Date payDate, String borrowedName, int quantity, List<Detail> details) {
        this.idBook = idBook;
        this.bookName = bookName;
        this.borrowedDate = borrowedDate;
        this.payDate = payDate;
        this.borrowedName = borrowedName;
        this.quantity = quantity;
        this.details = details;
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getBorrowedName() {
        return borrowedName;
    }

    public void setBorrowedName(String borrowedName) {
        this.borrowedName = borrowedName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }
}
