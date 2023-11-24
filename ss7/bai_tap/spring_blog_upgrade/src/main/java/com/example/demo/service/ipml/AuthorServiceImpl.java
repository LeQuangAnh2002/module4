package com.example.demo.service.ipml;

import com.example.demo.entity.Author;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public boolean create(Author author) {
        return false;
    }

    @Override
    public boolean update(Author author) {
        return false;
    }

    @Override
    public Author findById(int id) {
        return null;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
