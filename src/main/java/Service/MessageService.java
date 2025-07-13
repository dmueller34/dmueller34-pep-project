package Service;
import DAO.AccountDAO;
import DAO.MessageDAO;
import Model.Message;
import Model.Account;
import java.util.*;

public class MessageService {
    
    MessageDAO messageDAO;
    AccountDAO accountDAO;

    public MessageService() {
        messageDAO = new MessageDAO();
        accountDAO = new AccountDAO();
    }

    public MessageService(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    public Message createMessage(Message message) {
        if (message.getMessage_text().length() > 0 && 
        message.getMessage_text().length() < 255 &&
        accountDAO.getAccountByID(message.getPosted_by()) != null) {
            return messageDAO.insertMessage(message);
        }
        return null;
    }

    public List<Message> getAllMessages() {
        return messageDAO.getAllMessages();
    }

    public Message getMessageByID(int id) {
        return messageDAO.getMessageByID(id);
    }

    public void deleteMessage(int id) {
        if (getMessageByID(id) != null) {
            messageDAO.deleteMessage(id);
        }
    }

    public void updateMessage(int id, Message message) {
        if (getMessageByID(id) != null && 
        message.getMessage_text().length() > 0 && 
        message.getMessage_text().length() < 255) {
            messageDAO.updateMessage(id, message);
        }
    }

    public List<Message> getAllMessagesFromUser(int id) {
        return messageDAO.getAllMessagesFromUser(id);
    }
}
