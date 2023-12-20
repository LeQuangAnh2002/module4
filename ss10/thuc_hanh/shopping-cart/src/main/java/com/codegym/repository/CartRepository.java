package com.codegym.repository;

import com.codegym.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CartRepository extends JpaRepository<Cart,Integer> {
//    @Modifying
//    @Query(value = "update Cart set quantity = quantity+1 where product.id = :productID")
//    public int updateCurrentQuantity(@Param("productID") int productID);
}
