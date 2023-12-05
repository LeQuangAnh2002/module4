package com.codegym.service;

import com.codegym.entity.Book;

public interface BookService extends Service<Book>{
    void decreaseBookQuantity(int bookID,int quantity);

    int updateBookQuantity(int bookID, int quantity);
    boolean checkQuantityBook(int bookID);
}
