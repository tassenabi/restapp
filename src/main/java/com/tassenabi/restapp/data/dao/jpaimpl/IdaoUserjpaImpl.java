package com.tassenabi.restapp.data.dao.jpaimpl;

import com.tassenabi.restapp.entity.User;
import com.tassenabi.restapp.entity.jpauser.UserForJpa;
import com.tassenabi.restapp.data.dao.IdaoEntity;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO for the Hibernate/JPA Database Fetch // CRUD-Methods
 */
public class IdaoUserjpaImpl implements IdaoEntity {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("restfulApp");

    @Override
    public List<User> getAllUser() {
        return new ArrayList<User>();
    }

    @Override
    public User getUser(String userName) {
        return null;
    }

    @Override
    public void deleteUser(String userName) {

    }

    @Override
    public void updateUser(String oldUserName, String newUserName) {

    }

    @Override
    public void insertUser(String userName) {

        UserForJpa userForJpa;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        try{
            transaction = entityManager.getTransaction();
            transaction.begin();

            userForJpa = new UserForJpa();
            userForJpa.setUserName(userName);

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
    public static void main(String[] args) {

        IdaoUserjpaImpl n = new IdaoUserjpaImpl();
        n.insertUser("Alanah4");
    }
}
