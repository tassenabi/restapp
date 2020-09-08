package com.tassenabi.integrationtest.jdbc;

import com.tassenabi.restapp.entity.User;
import com.tassenabi.restapp.data.dao.jdbcimpl.DaoUserJDBCImpl;
import com.tassenabi.restapp.exceptions.UserNotInDataBaseException;
import com.tassenabi.restapp.model.IRepositoryUser;
import com.tassenabi.restapp.model.RepositoryUser;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserJDBCRepositoryTest {

    DaoUserJDBCImpl daoUser = new DaoUserJDBCImpl();
    IRepositoryUser userRepo = new RepositoryUser(daoUser);

    private User userOne = new User("Monti");
    private User userTwo = new User("Monti2");
    private User userThree = new User("Monti3");
    private User userForUpdate = new User("Rap");


    private int numberOfUsersInDatabase = 3;

    @BeforeEach
    public void init(){

        daoUser.activateTestDatabase();
        userRepo.insertUser(userOne);
        userRepo.insertUser(userTwo);
        userRepo.insertUser(userThree);

    }

    @AfterEach
    public void tearDown(){
        userRepo.deleteUser(userOne);
        userRepo.deleteUser(userTwo);
        userRepo.deleteUser(userThree);

    }

    @Test
    public void getUser_ShouldReturnCorrectUserName() {

        //Arrange Act
        String expectedUserName = "Monti";
        Optional<User> actualUser = userRepo.getUser(userOne);

        //Arrange
        assertEquals(expectedUserName, actualUser.get().getUserName());

    }

    @Test
    public void getUser_ShouldThrowNotInDataBaseExceptionIfUserNotExist() {

        //Arrange
        userRepo.deleteUser(userOne);

        //Act // Assert
        assertThrows(
                UserNotInDataBaseException.class,
                () -> { userRepo.getUser(userOne); }
        );
    }

    @Test
    public void getAllUser_ShouldReturnCorrectAmountOfUser() {

        //Arrange Act
        List<User> listUsers = daoUser.getAll();

        //Assert
        assertEquals(listUsers.size(), numberOfUsersInDatabase);

    }

    @Test
    public void updateUser_ShouldReturnUpdatedUser() {

        //Arrange
        Optional<User> userBeforeUpdate = userRepo.getUser(userOne);
        String userNameBefore = userBeforeUpdate.get().getUserName();

        assertEquals(userOne.getUserName(), userNameBefore);

        //Act
        daoUser.update(userOne, userForUpdate);
        Optional<User> userAfterUpdate = daoUser.get(userForUpdate);

        //Assert
        assertEquals(userForUpdate.getUserName(), userAfterUpdate.get().getUserName());

        daoUser.deleteUser(userForUpdate);

    }
}