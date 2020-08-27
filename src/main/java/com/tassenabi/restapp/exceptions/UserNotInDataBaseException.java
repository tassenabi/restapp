package com.tassenabi.restapp.exceptions;

import javax.swing.*;

public class UserNotInDataBaseException extends RuntimeException {

    public UserNotInDataBaseException(){

        super("UserNotInDataBaseException");

    }

    public UserNotInDataBaseException(String errorMessage){

        super(errorMessage);
        JOptionPane.showMessageDialog(null, "This user is not in database");

    }
}