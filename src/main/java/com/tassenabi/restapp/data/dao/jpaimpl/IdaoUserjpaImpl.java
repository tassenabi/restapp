package com.tassenabi.restapp.data.dao.jpaimpl;

import com.tassenabi.restapp.entity.User;
import com.tassenabi.restapp.entity.jpauser.UserForJpa;
import com.tassenabi.restapp.data.dao.IdaoEntity;
import com.tassenabi.restapp.data.querygenerator.jpa.QueryJpaGeneratorUser;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO for the Hibernate/JPA Database Fetch // CRUD-Methods
 */
public class IdaoUserjpaImpl implements IdaoEntity {

    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("restfulApp");

    @Override
    public List<User> getAllUser() {
        return new ArrayList<User>();
    }

    @Override
    public User getUser(String userName) {

        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        Query nativeQuery
                = em.createNativeQuery(QueryJpaGeneratorUser.fetchQueryOneUser(userName), UserForJpa.class);
        nativeQuery.setParameter("userId",userName);

        return (UserForJpa) nativeQuery.getSingleResult();
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
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction trans = null;
        try{
            trans.begin();

            userForJpa = new UserForJpa();
            userForJpa.setUserName(userName);

            em.persist(userForJpa);
            trans.commit();
        }catch (Exception ex){

            if(trans != null){
                trans.rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }

    }
}
