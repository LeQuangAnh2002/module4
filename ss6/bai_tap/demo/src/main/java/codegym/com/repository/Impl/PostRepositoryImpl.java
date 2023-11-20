package codegym.com.repository.Impl;

import codegym.com.model.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class PostRepositoryImpl implements PostRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public boolean create(Post post) {
        entityManager.persist(post);
        return true;
    }

    @Override
    public boolean update(Post post) {
        entityManager.merge(post);
        return true;
    }

    @Override
    public Post findById(int id) {
        return entityManager.find(Post.class,id);
    }

    @Override
    public List<Post> findAll() {
        return entityManager.createQuery("From Post").getResultList();
    }

    @Override
    public boolean deleteById(int id) {
        entityManager.remove(findById(id));
        return true;
    }
}
