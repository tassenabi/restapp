package com.tassenabi.restapp.data.dao.hibernateimpl;

import com.tassenabi.restapp.entity.User;
import com.tassenabi.restapp.entity.hibernateuser.UserForHibernate;
import com.tassenabi.restapp.data.dao.IdaoEntity;
import com.tassenabi.restapp.data.querygenerator.hibernate.QueryHibernateGeneratorUser;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO for the Hibernate/JPA Database Fetch // CRUD-Methods
 */
public class IdaoUserHibernateImpl implements IdaoEntity {

    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("restfulApp");

    @Override
    public List<User> getAllUser() {
        return new ArrayList<User>();
    }

    @Override
    public User getUser(String userName) {

        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        Query nativeQuery
                = em.createNativeQuery(QueryHibernateGeneratorUser.fetchQueryOneUser(userName), UserForHibernate.class);
        nativeQuery.setParameter("userId",userName);

        return (UserForHibernate) nativeQuery.getSingleResult();
    }

    @Override
    public void deleteUser(String userName) {

    }

    @Override
    public void updateUser(String oldUserName, String newUserName) {

    }

    @Override
    public void insertUser(String userName) {

        UserForHibernate userForHibernate;
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction trans = null;
        try{
            trans.begin();

            userForHibernate = new UserForHibernate();
            userForHibernate.setUserName(userName);

            em.persist(userForHibernate);
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
