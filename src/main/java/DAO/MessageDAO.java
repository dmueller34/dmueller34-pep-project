package DAO;

import Model.Message;
import Util.ConnectionUtil;
import java.sql.*;
import java.util.*;


public class MessageDAO {

    public List<Message> getAllMessages() {
        Connection connection = ConnectionUtil.getConnection();
        String sql = "select * from message";
        List<Message> messages = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(); 
            while (rs.next()) {
                Message message = new Message(
                    rs.getInt("message_id"),
                    rs.getInt("posted_by"),
                    rs.getString("message_text"),
                    rs.getLong("time_posted_epoch")
                );
                messages.add(message);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return messages;
    }
    
    public Message getMessageByID(int id) {
        Connection connection = ConnectionUtil.getConnection();
        String sql = "select * from message where message_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Message message = new Message(
                    rs.getInt("message_id"),
                    rs.getInt("posted_by"),
                    rs.getString("message_text"),
                    rs.getLong("time_posted_epoch"));
                return message;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
