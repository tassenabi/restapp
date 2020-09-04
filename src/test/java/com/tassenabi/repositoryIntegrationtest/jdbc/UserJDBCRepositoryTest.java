package com.tassenabi.repositoryIntegrationtest.jdbc;

import com.tassenabi.restapp.entity.User;
import com.tassenabi.restapp.data.dao.IdaoEntity;
import com.tassenabi.restapp.data.dao.jdbcimpl.DaoUserJDBCImpl;
import com.tassenabi.restapp.data.config.jdbcconfig.IDatabaseJdbcConnection;
import com.tassenabi.restapp.data.config.jdbcconfig.DatabaseJdbcConnectionForTesting;
import com.tassenabi.restapp.exceptions.UserNotInDataBaseException;
import com.tassenabi.restapp.model.IRepositoryUser;
import com.tassenabi.restapp.model.RepositoryUser;
import org.junit.*;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserJDBCRepositoryTest {

    IDatabaseJdbcConnection dbConnection = new DatabaseJdbcConnectionForTesting();
    IdaoEntity daoUser = new DaoUserJDBCImpl(dbConnection, false);
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

    }

    @After
    public void tearDown(){
        userRepo.deleteUser(userOne);
        userRepo.deleteUser(userTwo);
        userRepo.deleteUser(userThree);

    }

    @Test
    public void fetchOneUser_ShouldReturnCorrectUserName() {

        //Arrange Act
        userRepo.insertUser(userOne);
        String expectedUserName = "Monti";
        Optional<User> actualUser = userRepo.getUser(userOne);

        //Arrange
        assertThat(expectedUserName, is(actualUser.get().getUserName()));

    }

    @Test(expected = UserNotInDataBaseException.class)
    public void fetchOneUser_ShouldThrowNotInDataBaseExceptionIfUserNotExist() {

        //Arrange
        userRepo.deleteUser(userOne);

        //Act
        userRepo.getUser(userOne);

    }

    @Test
    public void fetchAllUser_ShouldReturnCorrectAmountOfUser() {

        //Arrange Act
        List<User> listUsers = daoUser.getAll();

        //Assert
        assertThat(listUsers.size(), is(numberOfUsersInDatabase));

    }

    @Test
    public void updateUser_ShouldReturnUpdatedUser() {

        //Arrange
        String userNameBefore = userRepo.getUser(userOne).get().getUserName();

        Optional<User> userBeforeUpdate = userRepo.getUser(userOne);

        Assert.assertEquals(userOne.getUserName(), userBeforeUpdate.get().getUserName());

        //Act
        daoUser.update(userOne, userForUpdate);
        Optional<User> userAfterUpdate = daoUser.get(userForUpdate);

        //Assert
        Assert.assertEquals(userForUpdate.getUserName(), userAfterUpdate.get().getUserName());

        daoUser.deleteUser(userForUpdate);

    }

    @Test(expected = UserNotInDataBaseException.class)
    public void deleteUser_ShouldThrowExceptionIfFetchingAlreadyDeletedPrepaidObject() {

        //Arrange
        daoUser.deleteUser(userOne);

        //Act
        daoUser.get(userOne);

    }

    //TODO SQLite Exception not in maven package ... need to find
    @Ignore
    @Test
    //@Test(expected = org.sqlite.SQLiteErrorCode.SQLiteConstraintException.class)
    public void insertUser_IfUserAlreadyExistInDB_ShouldThrowException() {

        //Arrange Act
        daoUser.insert("Monti3333");
    }
}