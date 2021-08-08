package org.academiadecodigo.bootcamp.service;


import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.persistence.ConnectionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
    public void add(Integer id, String username, String email, String password, String firstName, String lastName, String phone) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("prompt");
        EntityManager em = emf.createEntityManager();

        User user = new User();

        user.setId(id);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhone(phone);

        em.getTransaction().begin();

        em.persist(user);

        em.getTransaction().commit();


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


                return new User();
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


                // userList.add();

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


    public User findById(Integer id) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("prompt");
        EntityManager em = emf.createEntityManager();
        User user = null;
        try {
            em.getTransaction().begin();

            user = em.find(User.class, id);

            em.getTransaction().commit();
        } finally {

            em.close();
        }
        return user;
    }

}
