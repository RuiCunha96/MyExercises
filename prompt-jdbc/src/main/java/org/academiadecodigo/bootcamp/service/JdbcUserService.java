package org.academiadecodigo.bootcamp.service;


import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.persistence.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class JdbcUserService implements UserService {

    private ConnectionManager connectionManager;
    private Connection dbConnection;

    public JdbcUserService() {
        this.connectionManager = new ConnectionManager();
    }


    @Override
    public boolean authenticate(String username, String password) {
        dbConnection = connectionManager.getConnection();
        try {
            String query = "SELECT username, password " +
                    "FROM user" +
                    " WHERE (username=? AND password=?);";
            ;

            PreparedStatement statement = dbConnection.prepareStatement(query);//para nao dar merda

            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
//get result
            if (resultSet.next()) {
                return true;
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public void add(User user) {
        dbConnection = connectionManager.getConnection();
        Statement statement = null;

        try {
            statement = dbConnection.createStatement();

            String query = "INSERT INTO user( username, password, email ,firstName, lastName, phone) " +
                    "VALUES('" + user.getUsername() + "', '" + user.getPassword() + "', '" +
                    user.getEmail() + "', '" + user.getFirstName() + "', '" +
                    user.getLastName() + "', '" + user.getPhone() + "' )";

            // execute query
            statement.executeUpdate(query);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("deu merda");
        }


    }

    @Override
    public User findByName(String username) {

        dbConnection = connectionManager.getConnection();
        Statement statement = null;

        try {

            statement = dbConnection.createStatement();

            // create a query
            String query = "SELECT * " +
                    "FROM user AS u" +
                    " WHERE u.username = '" + username + "'";

            // execute query
            ResultSet resultSet = statement.executeQuery(query);

            // get results
            if (resultSet.next()) {

                String usernameValue = resultSet.getString("username");
                String passwordValue = resultSet.getString("password");
                String emailValue = resultSet.getString("email");
                String fsName = resultSet.getString("firstname");
                String ltName = resultSet.getString("lastname");
                String phone = resultSet.getString("phone");


                return new User(usernameValue, emailValue, passwordValue, fsName, ltName, phone);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public List<User> findAll() {

        List<User> userList = new LinkedList<>();

        dbConnection = connectionManager.getConnection();
        Statement statement = null;

        String query = "SELECT *" +
                " FROM user;";

        try {
            statement = dbConnection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            // get results
            while (resultSet.next()) {

                String usernameValue = resultSet.getString("username");
                String passwordValue = resultSet.getString("password");
                String emailValue = resultSet.getString("email");
                String fsName = resultSet.getString("firstname");
                String ltName = resultSet.getString("lastname");
                String phone = resultSet.getString("phone");


                userList.add(new User(usernameValue, emailValue, passwordValue, fsName, ltName, phone));

            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return userList;
    }

    @Override
    public int count() {

        dbConnection = connectionManager.getConnection();

        Statement statement = null;
        try {
            statement = dbConnection.createStatement();
            // create a query
            String query = "SELECT COUNT(*) FROM user";

            // execute the query
            ResultSet resultSet = statement.executeQuery(query);

            // get the results
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }
}
