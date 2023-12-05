package com.codegym.repository;

import com.codegym.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book,Integer> {
    @Query("select b.quantity from Book b where b.idBook = :bookID")
    public int currentQuantity(@Param("bookID") int bookID);

    @Modifying
    @Query(value = "update Book set quantity = :quantity where idBook = :bookID")
    public int updateCurrentQuantity(@Param("bookID") int bookID,@Param("quantity") int quantity);


    public Book findBookByIdBook(int id);


}
