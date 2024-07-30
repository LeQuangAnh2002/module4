package com.example.exam.service.impl;

import com.example.exam.model.DuAn;
import com.example.exam.repository.DuAnRepository;
import com.example.exam.service.DuAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DuAnServiceImpl implements DuAnService {
    @Autowired
    private DuAnRepository duAnRepository;
    @Override
    public boolean create(DuAn duAn) {
        duAnRepository.save(duAn);
        return true;
    }

    @Override
    public boolean update(DuAn duAn) {
        duAnRepository.save(duAn);
        return true;
    }

    @Override
    public DuAn findById(int id) {
        return null;
    }

    @Override
    public List<DuAn> findAll() {
        return duAnRepository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public DuAn findByIdNameDuAn(String id) {
        return duAnRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteByIdNameDuAn(String id) {
        duAnRepository.deleteById(id);
        return true;
    }

    @Override
    public Page<DuAn> pageAllDuAn(Pageable pageable) {
        return duAnRepository.findAll(pageable);
    }
}
