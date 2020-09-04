package com.tassenabi.restapp.data.dao.jpaimpl;

import com.tassenabi.restapp.data.config.entitymanagementjpa.EntityManagement;
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
//TODO -> Logging Process should be implemented
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

        } catch (PersistenceException per){

            per.printStackTrace();

            throw new PersistenceException("Error: " + per.getMessage(), per);


        } catch (Exception ex){

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

        EntityManager entityManager = entityManagement.getEntityManager();
        EntityTransaction transaction = null;

        try{

            transaction = entityManager.getTransaction();
            transaction.begin();

            Query query = entityManager.createQuery("Select u FROM UserForJpa u");
            List<User> result = query.getResultList();

            return result;

        }catch (NoResultException ex){
            ex.printStackTrace();

            throw new NoResultException("Error: " + ex.getMessage());

        } finally {
            entityManager.close();
        }
    }

    @Override
    public void deleteUser(User user) {

        EntityManager entityManager = entityManagement.getEntityManager();

        EntityTransaction transaction = null;

        try{

            transaction = entityManager.getTransaction();
            transaction.begin();

            Query query = entityManager.createQuery("DELETE FROM UserForJpa u WHERE u.userName = :user");
            query.setParameter("user", user.getUserName()).executeUpdate();

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
    public void update(User userBeforeUpdateUser, User userAfterUpdate) {

        EntityManager entityManager = entityManagement.getEntityManager();
        EntityTransaction transaction = null;

        try{

            transaction = entityManager.getTransaction();
            transaction.begin();

            Query query = entityManager.createQuery("UPDATE UserForJpa u SET u.userName = :newUserName WHERE u.userName= :oldUserName");
            query.setParameter("oldUserName", userBeforeUpdateUser.getUserName());
            query.setParameter("newUserName", userAfterUpdate.getUserName());

            query.executeUpdate();

            transaction.commit();

        } catch (NoResultException ex) {

            ex.printStackTrace();
            throw new NoResultException("Username: " + userBeforeUpdateUser.getUserName() + " is not in database");

        }catch (Exception ex){

            if(transaction != null){
                transaction.rollback();
            }

        } finally {
            entityManager.close();
        }
    }

    @Override
    public Optional<User> get(User user) {

        EntityManager entityManager = entityManagement.getEntityManager();

        try{

            Query query = entityManager.createQuery("Select u FROM UserForJpa u WHERE u.userName = :user");
            query.setParameter("user", user.getUserName());
            UserForJpa result = (UserForJpa)query.getSingleResult();

            return Optional.ofNullable(result);

        } catch (NoResultException ex){

            ex.printStackTrace();
            throw new NoResultException("Username: " + user.getUserName() + " is not in database");

        } finally {
            entityManager.close();
        }

    }

    private void setDefaultEntityManagement(){
        this.entityManagement = new EntityManagement();
    }

    public void setEntityManagement(EntityManagement entityManagement) {
        this.entityManagement = entityManagement;
    }
}