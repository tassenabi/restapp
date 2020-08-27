package com.tassenabi.restapp.data.dao.jpaimpl;

import com.tassenabi.restapp.entity.User;
import com.tassenabi.restapp.entity.jpauser.UserForJpa;
import com.tassenabi.restapp.data.dao.IdaoEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

/**
 * DAO for the Hibernate/JPA Database Fetch // CRUD-Methods
 */
public class DaoUserJpaImpl implements IdaoEntity<User> {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("restfulApp");


    @Override
    public void insert(User userName) {

        UserForJpa userForJpa;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        try{
            transaction = entityManager.getTransaction();
            transaction.begin();

            userForJpa = new UserForJpa();
            userForJpa.setUserName(userName.getUserName());

            entityManager.persist(userForJpa);
            transaction.commit();
        }catch (Exception ex){

            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void update(User user, User r) {

    }

    @Override
    public Optional<User> get(User user) {
        return (Optional<User>) Optional.ofNullable(user);
    }
}
