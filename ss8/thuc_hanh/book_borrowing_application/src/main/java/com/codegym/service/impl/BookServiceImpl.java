package com.codegym.service.impl;

import com.codegym.entity.Book;
import com.codegym.repository.BookRepository;
import com.codegym.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public boolean create(Book book) {
        return false;
    }

    @Override
    public boolean update(Book book) {
        return false;
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public void decreaseBookQuantity(int bookID,int quantity) {
        int currentQuantity = bookRepository.currentQuantity(bookID);
        if (currentQuantity > 0 ){
            int newCurrentQuantity = currentQuantity - quantity;
            updateBookQuantity(bookID,newCurrentQuantity);
        }

    }


    @Override
    public int updateBookQuantity(int bookID, int quantity) {
      return   bookRepository.updateCurrentQuantity(bookID,quantity);
    }

    @Override
    public boolean checkQuantityBook(int bookID) {
        Book book = bookRepository.findBookByIdBook(bookID);
        return book != null && book.getQuantity() > 0;
    }
}
