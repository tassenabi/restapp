package com.tassenabi.restapp.dataAccess.dao.hibernateDAOUserImpl;

import com.tassenabi.restapp.businessEntity.User;
import com.tassenabi.restapp.businessEntity.hibernateUser.UserForHibernate;
import com.tassenabi.restapp.dataAccess.dao.DAOEntity;
import com.tassenabi.restapp.dataAccess.queryGenerator.QueryJdbcGenerator.QueryHibernateGeneratorUser;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

public class DAOUserHibernateImpl implements DAOEntity  {

    private UserForHibernate userForHibernate;

    private EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("restfulApp");

    @Override
    public List<User> getAllUser() {
        return null;
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
