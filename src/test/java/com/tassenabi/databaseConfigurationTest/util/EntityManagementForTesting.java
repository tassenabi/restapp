package com.tassenabi.databaseConfigurationTest.util;

import com.tassenabi.restapp.data.config.entitymanagementjpa.EntityManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class EntityManagementForTesting extends EntityManagement {

    private static String testDatabaseURL = "jdbc:sqlite:/Users/tassenabi/IdeaProjects/restfulApp/restapp/src/main/java/com/tassenabi/sources/database/userTestdatabase.db";

    private static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("restfulApp", getDatabaseProperties());
    }

    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager(){
        return  entityManager = entityManagerFactory.createEntityManager();
    }

    private static Map<String, String> getDatabaseProperties(){
        Map<String, String> dataBaseProperties = new HashMap<>();
        dataBaseProperties.put("javax.persistence.jdbc.url", testDatabaseURL);

        return dataBaseProperties;
    }
}
