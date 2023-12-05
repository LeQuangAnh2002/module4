package com.codegym.service;

import com.codegym.entity.LibraryCard;

public interface LibraryCardServie extends Service<LibraryCard>{
    public String generateBorrowCode();
    public LibraryCard findByIDCard(String id);
    public void deleteCard(String id);
}
