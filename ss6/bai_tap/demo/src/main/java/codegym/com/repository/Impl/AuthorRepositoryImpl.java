package codegym.com.repository.Impl;

import codegym.com.model.Author;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class AuthorRepositoryImpl implements AuthorRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public boolean create(Author author) {
        return false;
    }

    @Override
    public boolean update(Author author) {
        return false;
    }

    @Override
    public Author findById(int id) {
        return entityManager.find(Author.class,id);
    }

    @Override
    public List<Author> findAll() {
        return entityManager.createQuery("From Author ").getResultList();
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
