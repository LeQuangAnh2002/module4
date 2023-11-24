package com.codegym.service.province;

import com.codegym.entity.Province;
import com.codegym.repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProvinceService implements IProvinceService{
    @Autowired
    private IProvinceRepository provinceRepository;
    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Optional<Province> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(Province province) {

    }

    @Override
    public void remove(int id) {

    }
}
