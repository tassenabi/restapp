package com.tassenabi.unittest;

import com.tassenabi.restapp.data.querygenerator.jdbc.QueryJdbcGeneratorUser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueryJdbcGeneratorUserTest {

    @Test
    public void fetchQueryUser_ShouldReturnCorrectQueryString() {

        //Arrange
        String fetchQueryOneUser = "SELECT PK_id, TXT_userName from TBL_USER WHERE TXT_userName = 'Robert'";

        //Act
        String result = QueryJdbcGeneratorUser.fetchQueryOneUser("Robert");

        //Assert
        assertEquals(result, fetchQueryOneUser);
    }

    @Test
    public void insertQueryUser_ShouldReturnCorrectQueryString() {

        //Arrange
        String insertQueryOneUser = "INSERT INTO TBL_USER(PK_id,TXT_userName) VALUES (? ,'Robert')";

        //Act
        String result = QueryJdbcGeneratorUser.insertUserQuery("Robert");

        //Assert
        assertEquals(result, insertQueryOneUser);
    }

    @Test
    public void deleteQueryUser_ShouldReturnCorrectQueryString() {

        //Arrange
        String deleteQueryOneUser = "DELETE FROM TBL_USER WHERE TXT_userName='Robert'";

        //Act
        String result = QueryJdbcGeneratorUser.deleteQueryUser("Robert");

        //Assert
        assertEquals(result, deleteQueryOneUser);
    }

    @Test
    public void updateUser_ShouldReturnCorrectQueryString() {

        //Arrange
        String updateQueryOneUser = "UPDATE TBL_USER SET TXT_userName = 'Robert2' WHERE TXT_userName = 'Robert'";

        //Act
        String result = QueryJdbcGeneratorUser.updateUserQuery("Robert", "Robert2");

        //Assert
        assertEquals(result, updateQueryOneUser);
    }

    @Test
    public void fetchQueryAllUser_ShouldReturnCorrectQueryString() {

        //Arrange
        String fetchAllUser = "SELECT * FROM TBL_USER";

        //Act
        String result = QueryJdbcGeneratorUser.fetchQueryAllUser();

        //Assert
        assertEquals(result, fetchAllUser);
    }
}