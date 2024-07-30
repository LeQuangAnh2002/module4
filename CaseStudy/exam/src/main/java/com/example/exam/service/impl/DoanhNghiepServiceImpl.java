package com.example.exam.service.impl;

import com.example.exam.model.DoanhNghiep;
import com.example.exam.repository.DoanhNghiepRepository;
import com.example.exam.service.DoanhNghiepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoanhNghiepServiceImpl implements DoanhNghiepService {
    @Autowired
    private DoanhNghiepRepository doanhNghiepRepository;

    @Override
    public boolean create(DoanhNghiep doanhNghiep) {
        doanhNghiepRepository.save(doanhNghiep);
        return true;
    }

    @Override
    public boolean update(DoanhNghiep doanhNghiep) {
        doanhNghiepRepository.save(doanhNghiep);
        return true;
    }

    @Override
    public DoanhNghiep findById(int id) {
        return doanhNghiepRepository.findById(id).orElse(null);
    }

    @Override
    public List<DoanhNghiep> findAll() {
        return doanhNghiepRepository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        doanhNghiepRepository.deleteById(id);
        return true;
    }
}
