package com.tassenabi.unittest;

import com.tassenabi.restapp.DataAccess.QueryGenerator.QueryGeneratorUser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueryGeneratorGuestTest {

    @Test
    public void fetchQueryOneGuestOneProject_ShouldReturnCorrectQueryString() {

        //Arrange
        String fetchQueryOneGuest = "SELECT PK_id, TXT_userName from TBL_USER WHERE TXT_userName = 'Robert'";

        //Act
        String result = QueryGeneratorUser.fetchQueryOneUser("Robert");

        //Assert
        assertEquals(result, fetchQueryOneGuest);
    }

    @Test
    public void insertQueryGuestOneProject_ShouldReturnCorrectQueryString() {

        //Arrange
        String insertQueryOneGuest = "INSERT INTO TBL_USER(PK_id,TXT_userName) VALUES (? ,'Robert')";

        //Act
        String result = QueryGeneratorUser.insertUserQuery("Robert");

        //Assert
        assertEquals(result, insertQueryOneGuest);
    }

    @Test
    public void deleteQueryFoodOneGuest_ShouldReturnCorrectQueryString() {

        //Arrange
        String deleteQueryOneGuest = "DELETE FROM TBL_USER WHERE TXT_userName='Robert'";

        //Act
        String result = QueryGeneratorUser.deleteQueryUser("Robert");

        //Assert
        assertEquals(result, deleteQueryOneGuest);
    }

    @Test
    public void updateQueryGuestOneProject_ShouldReturnCorrectQueryString() {

        //Arrange
        String updateQueryOneGuest = "UPDATE TBL_USER SET TXT_userName = 'Robert2' WHERE TXT_userName = 'Robert'";

        //Act
        String result = QueryGeneratorUser.updateUserQuery("Robert", "Robert2");

        //Assert
        assertEquals(result, updateQueryOneGuest);
    }

    @Test
    public void fetchQueryAllGuestsOneProject_ShouldReturnCorrectQueryString() {

        //Arrange
        String fetchAllQueryOneProject = "SELECT * FROM TBL_USER";

        //Act
        String result = QueryGeneratorUser.fetchQueryAllUser();

        //Assert
        assertEquals(result, fetchAllQueryOneProject);
    }
}