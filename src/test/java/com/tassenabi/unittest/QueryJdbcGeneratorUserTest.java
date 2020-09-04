package com.tassenabi.unittest;

import com.tassenabi.restapp.data.querygenerator.jdbc.QueryJdbcGeneratorUser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueryJdbcGeneratorUserTest {

    @Test
    public void fetchQueryUser_ShouldReturnCorrectQueryString() {

        //Arrange
        String fetchQueryOneUser = "SELECT PK_id, TXT_userName from TBL_USER WHERE TXT_userName =  ? ";

        //Act
        String result = QueryJdbcGeneratorUser.fetchQueryOneUser();

        //Assert
        assertEquals(result, fetchQueryOneUser);
    }

    @Test
    public void insertQueryUser_ShouldReturnCorrectQueryString() {

        //Arrange
        String insertQueryOneUser = "INSERT INTO TBL_USER(PK_id,TXT_userName) VALUES (? , ? )";

        //Act
        String result = QueryJdbcGeneratorUser.insertUserQuery();

        //Assert
        assertEquals(result, insertQueryOneUser);
    }

    @Test
    public void deleteQueryUser_ShouldReturnCorrectQueryString() {

        //Arrange
        String deleteQueryOneUser = "DELETE FROM TBL_USER WHERE TXT_userName= ? ";

        //Act
        String result = QueryJdbcGeneratorUser.deleteQueryUser();

        //Assert
        assertEquals(result, deleteQueryOneUser);
    }

    @Test
    public void updateUser_ShouldReturnCorrectQueryString() {

        //Arrange
        String updateQueryOneUser = "UPDATE TBL_USER SET TXT_userName =  ?  WHERE TXT_userName =  ? ";

        //Act
        String result = QueryJdbcGeneratorUser.updateUserQuery();

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