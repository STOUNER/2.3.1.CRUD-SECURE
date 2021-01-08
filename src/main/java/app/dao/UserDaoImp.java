package app.dao;

import app.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getAllUser() {
        Query query = entityManager.createQuery("FROM User ", User.class);
        return query.getResultList();
    }

    @Override
    public void deleteUserById(Long userId) {
        User user = entityManager.find(User.class, userId);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(User user) {
        User oldUser = entityManager.find(User.class, user.getId());
        oldUser.setAge(user.getAge());
        oldUser.setName(user.getName());
        entityManager.persist(oldUser);
    }

    @Override
    public User getUser(Long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }
}
