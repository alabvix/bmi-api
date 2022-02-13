package com.bmiapi.framework.spring.integration.helper;

import com.bmiapi.framework.spring.user.repository.UserEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.UUID;

public class DbHelper {

    private static Connection conn = null;

    private static void openConnection() throws Exception {
        Class.forName ("org.h2.Driver");
        conn = DriverManager.getConnection ("jdbc:h2:mem:mydb", "sa","password");
    }

    private static void closeConnection() throws Exception {
        conn.close();
    }

    public static void createUser(UserEntity user) throws Exception {
        final String INSERT = "insert into user (id, name, email, height, weight, age) VALUES ("
                + "'" + user.getId() + "',"
                + "'" + user.getName() + "',"
                + "'" + user.getEmail() + "',"
                + user.getHeight() + ","
                + user.getWeight() + ","
                + user.getAge() + ")";

        openConnection();

        Statement st = conn.createStatement();
        st.executeUpdate(INSERT);

        closeConnection();

    }

    public static void deleteUser(UUID uuid) throws Exception {
        final String INSERT = "delete from user where id = '" + uuid + "'";

        openConnection();

        Statement st = conn.createStatement();
        st.executeUpdate(INSERT);

        closeConnection();

    }

}
