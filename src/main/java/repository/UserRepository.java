package repository;

import config.ConnectionProvider;
import entity.Role;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public static List<User> findAll() {
        String sql = "select id, fullname, email, password, role, exp_in_year, pro_skill\n" +
                "from user";
        ArrayList<User> users = new ArrayList<>();
        try {

            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String fullName = resultSet.getString("fullname");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                int exInYear = resultSet.getInt("exp_in_year");
                String proSkill = resultSet.getString("pro_skill");
                User user = new User(userId, fullName, email, password, Role.valueOf(role), exInYear, proSkill);
                users.add(user);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return users;
    }

    public static User findById(int userId) {
        String sql = "select *  from user where id= ?";

        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                String fullName = resultSet.getString("fullname");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                int exInYear = resultSet.getInt("exp_in_year");
                String proSkill = resultSet.getString("pro_skill");
                User user = new User(userId, fullName, email, password, Role.valueOf(role), exInYear, proSkill);
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static boolean deletedId(int userId) {
        String sql = "delete from  user where id= ?";
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            int deletedRow=statement.executeUpdate();
            if(deletedRow>0){
                return true;
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public static boolean createUser(User user) {
        String sql = "insert into user(id,fullname,email,password, role, exp_in_year, pro_skill) values(?,?,?,?,?,?,?)";
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,user.getUserId());
            statement.setString(2, user.getFullName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, String.valueOf(user.getRole()));
            if (user.getRole()== Role.ADMIN){
                statement.setInt(6,user.getExpInYear());
                statement.setObject(7,null);
            }else {
                statement.setObject(6,user.getExpInYear());
                statement.setString(7,null);
            }

            statement.setString(7, user.getProSkill());
            int i = statement.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    }


