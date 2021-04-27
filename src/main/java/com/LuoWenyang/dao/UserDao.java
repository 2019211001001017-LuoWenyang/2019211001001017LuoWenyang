package com.LuoWenyang.dao;

import com.LuoWenyang.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{

    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        //insert..into usertable
        String sql = "INSERT INTO usertable(username,password,email,gender,birthdate) VALUES(?,?,?,?,?)";
        PreparedStatement ps;
        ps = con.prepareStatement(sql);
        System.out.println(user.getPassword());
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getGender());
        ps.setDate(5, user.getBirthDate());
        int resultSet = ps.executeUpdate();
        if(resultSet>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql = "DELETE FROM usertable WHERE username=?";
        PreparedStatement ps;
        ps = con.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        return ps.executeUpdate();
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql = "UPDATE usertable SET username=?,password=?,email=?,gender=?,birthdate=? WHERE id=?";
        PreparedStatement ps;
        ps = con.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getGender());
        ps.setDate(5,user.getBirthDate());
        ps.setInt(6, user.getId());
        return  ps.executeUpdate();
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql = "SELECT * FROM usertable WHERE id = ? ";
        PreparedStatement ps;
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet resultSet = ps.executeQuery();
        User user = null;
        if(resultSet.next())
        {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        //user for login
        String sql = "SELECT * FROM  usertable WHERE username =? and password =?";
        PreparedStatement ps;
        ps = con.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet resultSet = ps.executeQuery();
        User user = null;
        if(resultSet.next())
        {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql = "SELECT * FROM  usertable WHERE username =? ";
        PreparedStatement ps;
        ps = con.prepareStatement(sql);
        ps.setString(1, username);
        ResultSet resultSet = ps.executeQuery();
        User user = null;
        List<User> userList = new ArrayList<User>();
        while(resultSet.next())
        {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql = "SELECT * FROM  usertable WHERE password =? ";
        PreparedStatement ps;
        ps = con.prepareStatement(sql);
        ps.setString(1, password);
        ResultSet resultSet = ps.executeQuery();
        User user = null;
        List<User> userList = new ArrayList<User>();
        while(resultSet.next())
        {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql = "SELECT * FROM  usertable WHERE email=? ";
        PreparedStatement ps;
        ps = con.prepareStatement(sql);
        ps.setString(1, email);
        ResultSet resultSet = ps.executeQuery();
        User user = null;
        List<User> userList = new ArrayList<User>();
        while(resultSet.next())
        {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql = "SELECT * FROM  usertable WHERE gender =? ";
        PreparedStatement ps;
        ps = con.prepareStatement(sql);
        ps.setString(1, gender);
        ResultSet resultSet = ps.executeQuery();
        User user = null;
        List<User> userList = new ArrayList<User>();
        while(resultSet.next())
        {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        String sql = "SELECT * FROM  usertable WHERE birthDate =? ";
        PreparedStatement ps;
        ps = con.prepareStatement(sql);
        ps.setDate(1, (java.sql.Date) birthDate);
        ResultSet resultSet = ps.executeQuery();
        User user = null;
        List<User> userList = new ArrayList<User>();
        while(resultSet.next())
        {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql = "SELECT * FROM  usertable ";
        PreparedStatement ps;
        ps = con.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        User user = null;
        List<User> userList = new ArrayList<User>();
        while(resultSet.next())
        {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
            userList.add(user);
        }
        return userList;
    }
}
