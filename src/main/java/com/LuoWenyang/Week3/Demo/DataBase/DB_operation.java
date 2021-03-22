package com.LuoWenyang.Week3.Demo.DataBase;

import com.LuoWenyang.Week3.Demo.Object.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB_operation {
    public void InsertUser(User user) throws SQLException, ClassNotFoundException {

        UserDB userDB = new UserDB();
        String sql = "INSERT INTO usertable(username,password,email,gender,birthdate) VALUES (?,?,?,?,?)";
        Connection connection = userDB.getConn();
        int resultSet;
        PreparedStatement ps;
        ps = connection.prepareStatement(sql);
        ps.setString(1,user.getUsername());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getEmail());
        ps.setString(4,user.getGender());
        ps.setString(5,user.getBirthDate());
        resultSet = ps.executeUpdate();
        ps.close();
        connection.close();

    }
}
