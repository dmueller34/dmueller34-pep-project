package DAO;

import Model.Account;
import Util.ConnectionUtil;
import java.sql.*;
import java.util.*;

public class AccountDAO {
    
    public Account insertAccount(Account account) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "insert into acounnt (username, password) values (?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.executeUpdate();
            return account;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account getAccount(Account account) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "select * from account where username=? and password=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account acc = new Account(
                    rs.getString("username"),
                    rs.getString("password")
                );
                return acc;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account getAccountByID(int id) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "select * from account where account_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account acc = new Account(
                    rs.getString("username"),
                    rs.getString("password")
                );
                return acc;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
