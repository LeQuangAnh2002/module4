package com.codegym.service;

import com.codegym.entity.Detail;

import java.util.Optional;

public interface DetailService extends Service<Detail>{
        void payBookQuantity(String idCard,int quantity);
        Optional<Integer> findIdByCardId(String idCard);
}
