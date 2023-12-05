package com.codegym.service.impl;

import com.codegym.entity.Book;
import com.codegym.entity.Detail;
import com.codegym.entity.LibraryCard;
import com.codegym.repository.BookRepository;
import com.codegym.repository.DetailRepository;
import com.codegym.repository.LibraryCardRepository;
import com.codegym.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailServiceImpl implements DetailService {
    @Autowired
    private DetailRepository detailRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private LibraryCardRepository libraryCardRepository;
    @Override
    public boolean create(Detail detail) {
        detailRepository.save(detail);
        return true;
    }

    @Override
    public boolean update(Detail detail) {
        return false;
    }

    @Override
    public Detail findById(int id) {
        return null;
    }

    @Override
    public List<Detail> findAll() {
        return detailRepository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        detailRepository.deleteById(id);
        return true;
    }

    @Override
    public void payBookQuantity( String idCard, int quantity) {


        Detail detail = detailRepository.searchDetailByLibraryCard(idCard).orElse(null);


        if(detail != null){
            int currentQuantity = bookRepository.currentQuantity(detail.getBook().getIdBook());
            int newCurrentQuantity = currentQuantity + quantity;
            bookRepository.updateCurrentQuantity(detail.getBook().getIdBook(),newCurrentQuantity);
        }


    }

    @Override
    public Optional<Integer> findIdByCardId(String idCard) {
        return detailRepository.findIdByCardId(idCard);
    }
}
