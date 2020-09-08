package com.tassenabi.unittest;

import org.junit.jupiter.api.Test;

import static com.tassenabi.restapp.data.config.util.ConverterStringForDataBase.formatUserNameForDatabase;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverterStringForDataBaseTest {

    @Test
    public void formatUserNameForDatabase_ShouldInputUpperCaseFirstLetter(){

        //Arrange
        String expectedValue = "Robert";

        //Act
        String actualValue = formatUserNameForDatabase("robert");

        //Assert
        assertEquals(actualValue, (expectedValue));

    }

    @Test
    public void formatUserNameForDatabase_ShouldHandleInputWithWhiteSpaceAtTheBegingingAndEndCorrect(){

        //Arrange
        String expectedValue = "Robert";

        //Act
        String actualValue = formatUserNameForDatabase(" robert ");

        //Assert
        assertEquals(actualValue, (expectedValue));

    }

    @Test
    public void formatUserNameForDatabase_ShouldHandleInputWithUpperLetterSomewhereButNotatTheBeginning_Correct(){

        //Arrange
        String expectedValue = "Robert";

        //Act
        String actualValue = formatUserNameForDatabase("rObert");

        //Assert
        assertEquals(actualValue, (expectedValue));

    }

    @Test
    public void formatUserNameForDatabase_ShouldHandleInputWithSpecialCharCorrect(){

        //Arrange
        String expectedValue = "?robert";

        //Act
        String actualValue = formatUserNameForDatabase("?robert ");

        //Assert
        assertEquals(actualValue, (expectedValue));
    }
}
