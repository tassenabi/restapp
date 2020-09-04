package com.tassenabi.restapp.data.dao.jpaimpl;

import com.tassenabi.restapp.data.config.entitymanagementjpa.EntityManagement;
import com.tassenabi.restapp.entity.User;
import com.tassenabi.restapp.entity.jpauser.UserForJpa;
import com.tassenabi.restapp.data.dao.IdaoEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * DAO for the Hibernate/JPA Database Fetch // CRUD-Methods
 */
public class DaoUserJpaImpl implements IdaoEntity<User> {

    private EntityManagement entityManagement;

    public DaoUserJpaImpl(){
        setDefaultEntityManagement();
    }

    @Override
    public void insert(User userName) {

        UserForJpa userForJpa = new UserForJpa();
        EntityManager entityManager = entityManagement.getEntityManager();
        EntityTransaction transaction = null;
        try{
            transaction = entityManager.getTransaction();
            transaction.begin();

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
        return new ArrayList<>();
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void update(User user, User r) {

    }

    @Override
    public Optional<User> get(User user) {

        UserForJpa userForJpa = new UserForJpa();
        EntityManager entityManager = entityManagement.getEntityManager();




        return Optional.ofNullable(user);
    }

    private void setDefaultEntityManagement(){
        this.entityManagement = new EntityManagement();
    }

    public void setEntityManagement(EntityManagement entityManagement) {
        this.entityManagement = entityManagement;
    }
}