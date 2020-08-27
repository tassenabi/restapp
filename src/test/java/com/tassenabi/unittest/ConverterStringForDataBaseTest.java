package com.tassenabi.unittest;

import org.junit.Test;

import static com.tassenabi.restapp.data.config.util.ConverterStringForDataBase.formatUserNameForDatabase;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConverterStringForDataBaseTest {

    @Test
    public void formatUserNameForDatabase_ShouldInputUpperCaseFirstLetter(){

        //Arrange
        String expectedValue = "Robert";

        //Act
        String actualValue = formatUserNameForDatabase("robert");

        //Assert
        assertThat(actualValue, is(expectedValue));

    }

    @Test
    public void formatUserNameForDatabase_ShouldHandleInputWithWhiteSpaceAtTheBegingingAndEndCorrect(){

        //Arrange
        String expectedValue = "Robert";

        //Act
        String actualValue = formatUserNameForDatabase(" robert ");

        //Assert
        assertThat(actualValue, is(expectedValue));

    }

    @Test
    public void formatUserNameForDatabase_ShouldHandleInputWithUpperLetterSomewhereButNotatTheBeginning_Correct(){

        //Arrange
        String expectedValue = "Robert";

        //Act
        String actualValue = formatUserNameForDatabase("rObert");

        //Assert
        assertThat(actualValue, is(expectedValue));

    }

    @Test
    public void formatUserNameForDatabase_ShouldHandleInputWithSpecialCharCorrect(){

        //Arrange
        String expectedValue = "?robert";

        //Act
        String actualValue = formatUserNameForDatabase("?robert ");

        //Assert
        assertThat(actualValue, is(expectedValue));

    }
}
