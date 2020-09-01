package com.tassenabi.repositoryIntegrationtest;

<<<<<<< HEAD
import com.tassenabi.restapp.data.dao.jdbcimpl.DaoUserJDBCImpl;
=======
import com.tassenabi.restapp.data.dao.jpaimpl.DaoUserJpaImpl;
>>>>>>> beforeRefactoringDAOUser
import com.tassenabi.restapp.entity.User;
import com.tassenabi.restapp.data.dao.IdaoEntity;
import com.tassenabi.restapp.data.dao.jpaimpl.DaoUserJpaImpl;
import com.tassenabi.restapp.data.config.jdbcconfig.IDatabaseJdbcConnection;
import com.tassenabi.restapp.data.config.jdbcconfig.DatabaseJdbcConnectionForTesting;
<<<<<<< HEAD
import com.tassenabi.restapp.exceptions.UserNotInDataBaseException;
=======
>>>>>>> beforeRefactoringDAOUser
import com.tassenabi.restapp.model.IRepositoryUser;
import com.tassenabi.restapp.model.RepositoryUser;
import org.junit.*;

<<<<<<< HEAD
import java.util.List;
import java.util.Optional;

=======
>>>>>>> beforeRefactoringDAOUser
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserJpaRepositoryTest {

    IDatabaseJdbcConnection dbConnection = new DatabaseJdbcConnectionForTesting();
    IdaoEntity daoUser = new DaoUserJpaImpl();
    IRepositoryUser userRepo = new RepositoryUser(daoUser);

<<<<<<< HEAD
    private User userOne = new User("Monti");
    private User userTwo = new User("Monti2");
    private User userThree = new User("Monti3");
    private User userForUpdate = new User("Rap");
=======
    private String userOne = "Monti";
    private String userTwo = "Monti2";
    private String userThree = "Monti3";
    private String userForUpdate = "Rap";
>>>>>>> beforeRefactoringDAOUser


    private int numberOfUsersInDatabase = 3;

<<<<<<< HEAD
    @Before
    public void init(){
        userRepo.insertUser(userOne);
        userRepo.insertUser(userTwo);
        userRepo.insertUser(userThree);
=======
    /**
    @Before
    public void init(){
        userRepo.insertUser(userOne);
        //userRepo.insertUser(userTwo);
>>>>>>> beforeRefactoringDAOUser

    }

    @After
    public void tearDown(){
        userRepo.deleteUser(userOne);
        userRepo.deleteUser(userTwo);
        userRepo.deleteUser(userThree);

    }
<<<<<<< HEAD

    @Test
    public void fetchOneUser_ShouldReturnCorrectUserName() {

        //Arrange Act
        String expectedUserName = "Monti";
        Optional<User> actualUser = userRepo.getUser(userOne);
        //Nullpointer hier > getTestDataBaseLink
        //Arrange
        assertThat(expectedUserName, is(actualUser.get().getUserName()));

    }

}
=======
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
>>>>>>> beforeRefactoringDAOUser
