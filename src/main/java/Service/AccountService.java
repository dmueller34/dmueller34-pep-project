package Service;
import DAO.AccountDAO;
import Model.Account;


public class AccountService {
    
    AccountDAO accountDAO;

    public AccountService() {
        accountDAO = new AccountDAO();
    }

    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public Account createAccount(Account account) {
        if (accountDAO.getAccount(account) == null && 
        account.getPassword().length() >= 4 && 
        !account.getUsername().isBlank()) {
            return accountDAO.insertAccount(account);
        }
        return null;
    }

    public Account login(Account account) {
        if (accountDAO.getAccount(account) == null) {
            return null;
        }
        return accountDAO.getAccount(account);
    }
}
