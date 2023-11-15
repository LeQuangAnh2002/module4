package com.example.repository;

import com.example.model.Star;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class StarRepositoryImpl implements StarRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public boolean create(Star star) {
        entityManager.persist(star);
        return true;
    }

    @Override
    public boolean update(Star star) {
        entityManager.merge(star);
        return true;
    }

    @Override
    public Star findById(int id) {
        return entityManager.find(Star.class,id);
    }

    @Override
    public List<Star> findAll() {
        return entityManager.createQuery("From Star").getResultList();
    }

    @Override
    public boolean deleteById(int id) {
         entityManager.remove(findById(id));
        return true;
    }
}
