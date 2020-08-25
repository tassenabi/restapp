package com.tassenabi.restapp.DataAccess.JDBCDAOUserImpl;

import com.tassenabi.restapp.BusinessEntity.User;
import com.tassenabi.restapp.BusinessEntity.JDBCUser.UserForJDBC;
import com.tassenabi.restapp.DataAccess.DAOEntity;
import com.tassenabi.restapp.DataAccess.QueryGenerator.QueryGeneratorUser;
import com.tassenabi.restapp.DataAccess.dataAccessConfigurations.DBConnection.IDBConnection;
import com.tassenabi.restapp.DataAccess.dataAccessConfigurations.Util.ApplicationLogger;
import com.tassenabi.restapp.Exceptions.NotInDataBaseException;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.tassenabi.restapp.DataAccess.QueryGenerator.QueryGeneratorUser.COLUMN1;
import static com.tassenabi.restapp.DataAccess.QueryGenerator.QueryGeneratorUser.COLUMN2;
import static com.tassenabi.restapp.DataAccess.dataAccessConfigurations.Util.ConverterStringForDataBase.*;

public class DAOUserImpl implements DAOEntity {

    private ArrayList<User> allUsers;
    private UserForJDBC user;
    private Statement queryStatement;
    private ResultSet queryResult;
    private IDBConnection connection;
    private boolean isLoggerActivated;

    public DAOUserImpl(){

    }

    //This constructor is for test database
    //TestDBConnection is the implementation for IDBConnection
    public DAOUserImpl(IDBConnection connectToTestDatabase, boolean isLoggerActivated) {

        user = new UserForJDBC();
        allUsers = new ArrayList<>();
        this.connection = connectToTestDatabase;
        this.isLoggerActivated = isLoggerActivated;

    }
    @Override
    public List<User> getAllUser() {

        allUsers.clear();

        try {

            String queryCommand = QueryGeneratorUser.fetchQueryAllUser();
            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            while (queryResult.next()) {

                allUsers.add(new UserForJDBC(queryResult.getInt(COLUMN1), queryResult.getString(COLUMN2)));

            }

            if(allUsers.isEmpty()){

                throw new NotInDataBaseException();

            }


        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            queryStatement.close();
            queryResult.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return allUsers;
    }

    @Override
    public UserForJDBC getUser(String userName) {
        //Set firstLetter to upperCase and set last to lowerLetters
        userName = formatUserNameForDatabase(userName);

        try {
            String queryCommand = QueryGeneratorUser.fetchQueryOneUser(userName);
            queryStatement = createSQLStatement();
            queryResult = queryStatement.executeQuery(queryCommand);

            if (queryResult.next()) {


                int PK_id = queryResult.getInt(1);
                String userNameForObject = queryResult.getString(2);

                createUserObject(PK_id, userNameForObject);

            } else {

                throw new NotInDataBaseException();

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            queryStatement.close();
            queryResult.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return user;
    }

    @Override
    public void deleteUser(String userName) {

        //Set firstLetter to upperCase and set last to lowerLetters
        userName = formatUserNameForDatabase(userName);

        try {

            String queryCommand = QueryGeneratorUser.deleteQueryUser(userName);
            queryStatement = createSQLStatement();
            queryStatement.executeUpdate(queryCommand);

            //Log the query
            if (isLoggerActivated) {
                ApplicationLogger.loggingQueries(queryCommand);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            queryStatement.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(String oldUserName, String newUserName) {

        //Set firstLetter to upperCase and set last to lowerLetters
        oldUserName = formatUserNameForDatabase(oldUserName);

        try {

            String queryCommand = QueryGeneratorUser.updateUserQuery(oldUserName, newUserName);
            queryStatement = createSQLStatement();
            queryStatement.executeUpdate(queryCommand);

            //Log the query
            if (isLoggerActivated) {
                ApplicationLogger.loggingQueries(queryCommand);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            queryStatement.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void insertUser(String userName){
        //Set firstLetter to upperCase and set last to lowerLetters
        userName = formatUserNameForDatabase(userName);

        try {

            String queryCommand = QueryGeneratorUser.insertUserQuery(userName);
            queryStatement = createSQLStatement();
            queryStatement.executeUpdate(queryCommand);

            //Log the query
            if (isLoggerActivated) {
                ApplicationLogger.loggingQueries(queryCommand);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        try {

            queryStatement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    private Connection openConnection() throws SQLException {

        return connection.getConnection();

    }

    private Statement createSQLStatement() throws SQLException {

        return this.openConnection().createStatement();

    }

    private void createUserObject(int PK_id, String userName) {
        user.setPrimaryKey(PK_id);
        user.setUserName(userName);
    }
}