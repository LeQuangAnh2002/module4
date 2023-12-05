package com.codegym.repository;

import com.codegym.entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DetailRepository extends JpaRepository<Detail,Integer> {
    @Query(" from Detail d where d.libraryCard.idBook = :idCard")
    public Optional<Detail> searchDetailByLibraryCard(@Param("idCard") String idCard);

    @Query("SELECT d.id FROM Detail d WHERE d.libraryCard.idBook = :idCard")
    public Optional<Integer> findIdByCardId(@Param("idCard") String idCard);
}
