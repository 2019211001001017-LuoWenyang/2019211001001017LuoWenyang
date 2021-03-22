package com.LuoWenyang.Week3.Demo.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDB {
    public Connection getConn() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/userdb";
        Connection connection = DriverManager.getConnection(url, "root", "lwy5687605682");
        return connection;
    }
}
