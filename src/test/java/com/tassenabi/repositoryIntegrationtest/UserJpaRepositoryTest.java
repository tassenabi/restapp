package com.tassenabi.repositoryIntegrationtest;

import com.tassenabi.restapp.data.dao.jpaimpl.DaoUserJpaImpl;
import com.tassenabi.restapp.entity.User;
import com.tassenabi.restapp.data.dao.IdaoEntity;
import com.tassenabi.restapp.data.dao.jpaimpl.DaoUserJpaImpl;
import com.tassenabi.restapp.data.config.jdbcconfig.IDatabaseJdbcConnection;
import com.tassenabi.restapp.data.config.jdbcconfig.DatabaseJdbcConnectionForTesting;
import com.tassenabi.restapp.model.IRepositoryUser;
import com.tassenabi.restapp.model.RepositoryUser;
import org.junit.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserJpaRepositoryTest {

    IDatabaseJdbcConnection dbConnection = new DatabaseJdbcConnectionForTesting();
    IdaoEntity daoUser = new DaoUserJpaImpl();
    IRepositoryUser userRepo = new RepositoryUser(daoUser);

    private String userOne = "Monti";
    private String userTwo = "Monti2";
    private String userThree = "Monti3";
    private String userForUpdate = "Rap";


    private int numberOfUsersInDatabase = 3;

    /**
    @Before
    public void init(){
        userRepo.insertUser(userOne);
        //userRepo.insertUser(userTwo);

    }

    @After
    public void tearDown(){
        userRepo.deleteUser(userOne);
        userRepo.deleteUser(userTwo);
        userRepo.deleteUser(userThree);

    }
**/
    @Ignore
    @Test
    public void fetchOneUser_ShouldReturnCorrectUserName() {

        //userRepo.insertUser();
        //Arrange Act
        //String expectedUserName = "Monti";
        //User actualUser = userRepo.getUser(userOne);
        //Nullpointer hier > getTestDataBaseLink
        //Arrange
        //assertThat(expectedUserName, is(actualUser.getUserName()));

    }

}