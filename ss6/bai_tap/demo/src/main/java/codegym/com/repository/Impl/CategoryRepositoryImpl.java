package codegym.com.repository.Impl;

import codegym.com.model.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public boolean create(Category category) {
        return false;
    }

    @Override
    public boolean update(Category category) {
        return false;
    }

    @Override
    public Category findById(int id) {
        return entityManager.find(Category.class,id);
    }

    @Override
    public List<Category> findAll() {
        return entityManager.createQuery("From Category").getResultList();
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
