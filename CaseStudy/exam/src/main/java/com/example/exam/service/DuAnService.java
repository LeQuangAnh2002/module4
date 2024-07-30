package com.example.exam.service;

import com.example.exam.model.DuAn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DuAnService extends Service<DuAn>{
    DuAn findByIdNameDuAn(String id);
    boolean deleteByIdNameDuAn(String id);
    Page<DuAn> pageAllDuAn(Pageable pageable);
}
