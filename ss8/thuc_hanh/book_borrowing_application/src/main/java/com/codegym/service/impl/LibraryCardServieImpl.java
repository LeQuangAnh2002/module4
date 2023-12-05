package com.codegym.service.impl;

import com.codegym.entity.LibraryCard;
import com.codegym.repository.LibraryCardRepository;
import com.codegym.service.LibraryCardServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LibraryCardServieImpl implements LibraryCardServie {
    @Autowired
    private LibraryCardRepository libraryCardRepository;
    @Override
    public boolean create(LibraryCard libraryCard) {
        libraryCardRepository.save(libraryCard);
        return true;
    }

    @Override
    public boolean update(LibraryCard libraryCard) {
        return false;
    }

    @Override
    public LibraryCard findById(int id) {
        return null;
    }

    @Override
    public List<LibraryCard> findAll() {
        return libraryCardRepository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public String generateBorrowCode() {
        StringBuilder codeBuilder = new StringBuilder();
        for (int i = 0 ; i < 5; i++){
            int random =(int) (Math.random() * 10);
            codeBuilder.append(random);
        }
        return codeBuilder.toString();
    }

    @Override
    public LibraryCard findByIDCard(String id) {
        return libraryCardRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCard(String id) {
        libraryCardRepository.deleteById(id);
    }
}
