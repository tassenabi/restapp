package com.tassenabi.repositoryIntegrationtest;

import com.tassenabi.restapp.entity.User;
import com.tassenabi.restapp.data.dao.IdaoEntity;
import com.tassenabi.restapp.data.dao.jdbcimpl.IdaoUserJDBCImpl;
import com.tassenabi.restapp.data.config.jdbcconfig.IDatabaseJdbcConnection;
import com.tassenabi.restapp.data.config.jdbcconfig.DatabaseJdbcConnectionForTesting;
import com.tassenabi.restapp.exceptions.UserNotInDataBaseException;
import com.tassenabi.restapp.model.IRepositoryUser;
import com.tassenabi.restapp.model.RepositoryUser;
import org.junit.*;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserJDBCRepositoryTest {

    IDatabaseJdbcConnection dbConnection = new DatabaseJdbcConnectionForTesting();
    IdaoEntity daoUser = new IdaoUserJDBCImpl(dbConnection, false);
    IRepositoryUser userRepo = new RepositoryUser(daoUser);

    private String userNameOne = "Monti";
    private String userNameTwo = "Monti2";
    private String userNameThree = "Monti3";
    private String newUserForUpdate = "Rap";


    private int numberOfUsersInDatabase = 3;

    @Before
    public void init(){
        userRepo.insertUser(userNameOne);
        userRepo.insertUser(userNameTwo);
        userRepo.insertUser(userNameThree);

    }

    @After
    public void tearDown(){
        userRepo.deleteUser(userNameOne);
        userRepo.deleteUser(userNameTwo);
        userRepo.deleteUser(userNameThree);

    }
    @Test
    public void fetchOneUser_ShouldReturnCorrectUserName() {

        //Arrange Act
        userRepo.getUser("Monti");

        //Arrange
        assertThat(userRepo.getUser(userNameOne).getUserName(), is(userNameOne));

    }

    @Test(expected = UserNotInDataBaseException.class)
    public void fetchOneUser_ShouldThrowNotInDataBaseExceptionIfUserNotExist() {

        //Arrange
        userRepo.deleteUser(userNameOne);

        //Act
        userRepo.getUser(userNameOne);

    }

    @Test
    public void fetchAllUser_ShouldReturnCorrectAmountOfUser() {

        //Arrange Act
        List<User> listUsers = daoUser.getAllUser();

        //Assert
        assertThat(listUsers.size(), is(numberOfUsersInDatabase));

    }

    @Test
    public void updateUser_ShouldReturnUpdatedUser() {

        //Arrange
        String userNameBefore = daoUser.getUser(userNameOne).getUserName();
        Assert.assertEquals(userNameOne, userNameBefore);

        //Act
        daoUser.updateUser(userNameOne, newUserForUpdate);
        String userNameAfter = daoUser.getUser(newUserForUpdate).getUserName();

        //Assert
        Assert.assertEquals(newUserForUpdate, userNameAfter);

        daoUser.deleteUser(newUserForUpdate);

    }

    @Test(expected = UserNotInDataBaseException.class)
    public void deleteUser_ShouldThrowExceptionIfFetchingAlreadyDeletedPrepaidObject() {

        //Arrange
        daoUser.deleteUser(userNameOne);

        //Act
        daoUser.getUser(userNameOne);

    }

    //TODO SQLite Exception not in maven package ... need to find
    @Ignore
    @Test
    //@Test(expected = org.sqlite.SQLiteErrorCode.SQLiteConstraintException.class)
    public void insertUser_IfUserAlreadyExistInDB_ShouldThrowException() {

        //Arrange Act
        daoUser.insertUser("Monti");
    }
}