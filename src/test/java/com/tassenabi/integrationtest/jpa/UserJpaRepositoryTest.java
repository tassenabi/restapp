package com.tassenabi.integrationtest.jpa;

import com.tassenabi.databaseConfigurationTest.util.EntityManagementForTesting;
import com.tassenabi.restapp.data.dao.jpaimpl.DaoUserJpaImpl;
import com.tassenabi.restapp.entity.User;
import com.tassenabi.restapp.model.IRepositoryUser;
import com.tassenabi.restapp.model.RepositoryUser;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserJpaRepositoryTest {

    DaoUserJpaImpl daoUser = new DaoUserJpaImpl();
    IRepositoryUser userRepo = new RepositoryUser(daoUser);
    EntityManagementForTesting entityManagementForTesting = new EntityManagementForTesting();

    private User userOne = new User("Monti");
    private User userTwo = new User("Monti2");
    private User userThree = new User("Monti3");
    private User userForUpdate = new User("Rap");

    private int numberOfUsersInDatabase = 3;

    @BeforeEach
    public void init(){

        daoUser.setEntityManagement(entityManagementForTesting);
        userRepo.insertUser(userOne);
        userRepo.insertUser(userTwo);
        userRepo.insertUser(userThree);

    }

    @AfterEach
    public void tearDown() {

        userRepo.deleteUser(userOne);
        userRepo.deleteUser(userTwo);
        userRepo.deleteUser(userThree);

    }

    @Test
    public void getUser_ShouldReturnCorrectUserName() {

        //Arrange Act
        String expectedUserName = "Monti";

        //Act
        Optional<User> actualUser = userRepo.getUser(userOne);
        String actualUserName = actualUser.get().getUserName();

        //Assert
        assertEquals(expectedUserName, (actualUserName));
    }

    @Disabled
    @Test
    public void getUser_ShouldThrowNotInDataBaseExceptionIfUserNotExist() {

        //Arrange
        userRepo.deleteUser(userOne);

        //Act // Assert
        assertThrows(
                javax.persistence.NoResultException.class,
                () -> { userRepo.getUser(userOne); }
        );
    }

    @Test
    public void insertOneUserAlreadyExist_ShouldReturnException() {

        //Arrange // Act // Assert
        assertThrows(
                Exception.class,
                () -> { userRepo.insertUser(userOne); }
        );

    }

    @Test
    public void getAllUser_ShouldReturnCorrectAmountOfUser() {

        //Arrange Act
        List<User> listUsers = daoUser.getAll();

        //Assert
        assertEquals(listUsers.size(), (numberOfUsersInDatabase));

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