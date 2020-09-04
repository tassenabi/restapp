package com.tassenabi.repositoryIntegrationtest;

import com.tassenabi.restapp.data.dao.jpaimpl.DaoUserJpaImpl;
import com.tassenabi.restapp.entity.User;
import com.tassenabi.restapp.data.dao.IdaoEntity;
import com.tassenabi.restapp.data.config.jdbcconfig.IDatabaseJdbcConnection;
import com.tassenabi.restapp.data.config.jdbcconfig.DatabaseJdbcConnectionForTesting;
import com.tassenabi.restapp.model.IRepositoryUser;
import com.tassenabi.restapp.model.RepositoryUser;
import org.junit.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class UserJpaRepositoryTest {

    IDatabaseJdbcConnection dbConnection = new DatabaseJdbcConnectionForTesting();
    IdaoEntity daoUser = new DaoUserJpaImpl();
    IRepositoryUser userRepo = new RepositoryUser(daoUser);

    private User userOne = new User("Monti");
    private User userTwo = new User("Monti2");
    private User userThree = new User("Monti3");
    private User userForUpdate = new User("Rap");

    private int numberOfUsersInDatabase = 3;

    @Before
    public void init(){
        userRepo.insertUser(userOne);
        userRepo.insertUser(userTwo);
        userRepo.insertUser(userThree);

        //useTestDataBase();

    }

    @After
    public void tearDown(){
        userRepo.deleteUser(userOne);
        userRepo.deleteUser(userTwo);
        userRepo.deleteUser(userThree);

    }

    @Ignore
    @Test
    public void fetchOneUser_ShouldReturnCorrectUserName() {

        userRepo.insertUser(new User("roolazasdasdjtztund"));
        //userRepo.insertUser();
        //Arrange Act
        //String expectedUserName = "Monti";
        //User actualUser = userRepo.getUser(userOne);
        //Nullpointer hier > getTestDataBaseLink
        //Arrange
        //assertThat(expectedUserName, is(actualUser.getUserName()));

    }


    private void useTestDataBase(){
        EntityManagerFactory managerFactory = null;
        Map<String, String> persistenceMap = new HashMap<String, String>();

        String url = "jdbc:sqlite:/Users/tassenabi/IdeaProjects/restfulApp/restapp/src/main/java/com/tassenabi/sources/database/userTestdatabase.db";
        persistenceMap.put("javax.persistence.jdbc.url", url);

        managerFactory = Persistence.createEntityManagerFactory("restfulApp", persistenceMap);
        //manager = managerFactory.createEntityManager();
    }

}
