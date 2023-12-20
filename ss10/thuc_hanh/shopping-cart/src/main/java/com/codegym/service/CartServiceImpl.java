package com.codegym.service;

import com.codegym.model.Cart;
import com.codegym.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cartRepository;
    @Override
    public boolean create(Cart cart) {
        cartRepository.save(cart);
        return true;
    }

    @Override
    public boolean update(Cart cart) {
        return false;
    }

    @Override
    public Cart findById(int id) {
        return null;
    }

    @Override
    public List<Cart> findAll() {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

//    @Override
//    public int updateCurrentQuantity(int cartID) {
//        return cartRepository.updateCurrentQuantity(cartID);
//    }
}
