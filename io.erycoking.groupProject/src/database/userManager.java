package database;

import database.bean.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userManager {

    Connection conn;
    PreparedStatement st;
    ResultSet rs;

    private String sql;

    public boolean insert(user usr) throws SQLException, ClassNotFoundException {

        sql = "INSERT INTO `asset_management`.`users`(`staff_id`,`Name`, `username`,`password`,`faculty`,`department`,`telephone_no`, `email`)VALUES(?,?,?,?,?,?,?,?);";

        try {
            conn = connectionManager.getInstance().getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, usr.getStaff_id());
            st.setString(2, usr.getName());
            st.setString(3, usr.getUsername());
            st.setString(4, usr.getPassword());
            st.setString(5, usr.getFaculty());
            st.setString(6, usr.getDepartment());
            st.setInt(7, usr.getTel_no());
            st.setString(8, usr.getEmail());
//            st.setString(9, "member");

            int affected = st.executeUpdate();
            if (affected == 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }

    public user[] display() throws SQLException, ClassNotFoundException {
        sql = "select * from users";

        try {
            conn = connectionManager.getInstance().getConnection();
            st = conn.prepareStatement(sql, ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
            rs = st.executeQuery();
            rs.last();

            user usr[] = new user[rs.getRow()];
            rs.first();

            int i = 1;

            while (rs.next()) {
                usr[i].setStaff_id(rs.getString("staff_id"));
                usr[i].setName(rs.getString("Name"));
                usr[i].setUsername(rs.getString("username"));
                usr[i].setPassword(rs.getString("password"));
                usr[i].setFaculty(rs.getString("faculty"));
                usr[i].setDepartment(rs.getString("department"));
                usr[i].setTel_no(rs.getInt("telephone_no"));
                usr[i].setEmail(rs.getString("email"));
                usr[i].setRole(rs.getString("role"));
                i++;
            }

            return usr;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        } finally {
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
    }
    //should have passed the username and the password so that we get the object details from the Db and return that user

    public user getCurrentUser(String id, String pswd) throws SQLException, ClassNotFoundException {
        sql = "select * from users where staff_id=? and password=?";

        try {
            conn = connectionManager.getInstance().getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            st.setString(2, pswd);
            rs = st.executeQuery();
            user usr = new user();
            if (rs.next()) {
                usr.setStaff_id(rs.getString("staff_id"));
                usr.setName(rs.getString("Name"));
                usr.setUsername(rs.getString("username"));
                usr.setPassword(rs.getString("password"));
                usr.setFaculty(rs.getString("faculty"));
                usr.setDepartment(rs.getString("department"));
                usr.setTel_no(rs.getInt("telephone_no"));
                usr.setEmail(rs.getString("email"));
                usr.setRole(rs.getString("role"));
                return usr;
            }else{
                System.out.println("No row were found");
                return usr;
            }            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }
    //this is admins functionality

    public boolean update(user usr) throws SQLException, ClassNotFoundException {

        sql = "update users set name=?,username=?, password=?, faculty=?, department=?, telephone_no=?, email=?,role=? where staff_id=?";

        try {
            conn = connectionManager.getInstance().getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, usr.getName());
            st.setString(2, usr.getUsername());
            st.setString(3, usr.getPassword());
            st.setString(4, usr.getFaculty());
            st.setString(5, usr.getDepartment());
            st.setInt(6, usr.getTel_no());
            st.setString(7, usr.getEmail());
            st.setString(8, usr.getRole());
            st.setString(9, usr.getStaff_id());

            int affected = st.executeUpdate();
            if (affected == 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }

    public boolean deleteItem(user usr) throws SQLException, ClassNotFoundException {

        sql = "delete from users where staff_id = ?";

        try {
            conn = connectionManager.getInstance().getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, usr.getStaff_id());

            int affected = st.executeUpdate();
            if (affected == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }

}
