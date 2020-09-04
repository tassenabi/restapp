package com.tassenabi.repositoryIntegrationtest.jpa;

import com.tassenabi.databaseConfigurationTest.util.EntityManagementForTesting;
import com.tassenabi.restapp.data.dao.jpaimpl.DaoUserJpaImpl;
import com.tassenabi.restapp.entity.User;
import com.tassenabi.restapp.data.config.jdbcconfig.IDatabaseJdbcConnection;
import com.tassenabi.restapp.data.config.jdbcconfig.DatabaseJdbcConnectionForTesting;
import com.tassenabi.restapp.model.IRepositoryUser;
import com.tassenabi.restapp.model.RepositoryUser;
import org.junit.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class UserJpaRepositoryTest {

    IDatabaseJdbcConnection dbConnection = new DatabaseJdbcConnectionForTesting();
    DaoUserJpaImpl daoUser = new DaoUserJpaImpl();
    IRepositoryUser userRepo = new RepositoryUser(daoUser);
    EntityManagementForTesting entityManagementForTesting = new EntityManagementForTesting();

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

        daoUser.setEntityManagement(entityManagementForTesting);

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

        userRepo.insertUser(new User("ralle"));
        //userRepo.insertUser();
        //Arrange Act
        //String expectedUserName = "Monti";
        //User actualUser = userRepo.getUser(userOne);
        //Nullpointer hier > getTestDataBaseLink
        //Arrange
        //assertThat(expectedUserName, is(actualUser.getUserName()));

    }

}
