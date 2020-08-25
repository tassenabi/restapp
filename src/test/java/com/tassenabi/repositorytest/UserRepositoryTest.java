package com.tassenabi.repositorytest;

import com.tassenabi.restapp.BusinessEntity.User;
import com.tassenabi.restapp.DataAccess.DAOEntity;
import com.tassenabi.restapp.DataAccess.JDBCDAOUserImpl.DAOUserImpl;
import com.tassenabi.restapp.DataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.tassenabi.restapp.DataAccess.dataAccessConfigurations.DBConnection.TestDBConnection;
import com.tassenabi.restapp.Exceptions.NotInDataBaseException;
import com.tassenabi.restapp.Model.IRepository;
import com.tassenabi.restapp.Model.RepositoryUser;
import org.ibex.nestedvm.Runtime;
import org.junit.*;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserRepositoryTest {

    IDBConnection dbConnection = new TestDBConnection();
    DAOEntity daoUser = new DAOUserImpl(dbConnection, false);
    IRepository userRepo = new RepositoryUser(daoUser);

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

    @Test(expected = NotInDataBaseException.class)
    public void fetchOneUser_ShouldThrowNotInDataBaseExceptionIfGuestNotExist() {

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

    @Test(expected = NotInDataBaseException.class)
    public void deleteUser_ShouldThrowExceptionIfFetchingAlreadyDeletedPrepaidObject() {

        //Arrange
        daoUser.deleteUser(userNameOne);

        //Act
        daoUser.getUser(userNameOne);

    }

    //TODO
    @Ignore
    @Test(expected = Runtime.CallException.class)
    //@Test(expected = org.sqlite.SQLiteErrorCode.SQLiteConstraintException.class)
    public void insertUser_IfUserAlreadyExistInDB_ShouldThrowException() {

        //Arrange Act
        daoUser.insertUser("Monti");
    }
}