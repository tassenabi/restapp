package com.tassenabi.restapp.data.config.entitymanagementjpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagement {

    private static final EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("restfulApp");
    }

    private EntityManager entityManager;

    public EntityManager getEntityManager(){
        return  entityManager = entityManagerFactory.createEntityManager();
    }
}
