package objects;

public class account {
    // Instance Variables
    int account_id;
    int user_id;
    String login;
    String email;
    String password;

    // Setter Classes
    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter Classes
    public int getAccountId() {
        return account_id;
    }

    public int getUserId() {
        return user_id;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // Constructor

    // For READ, UPDATE, DELETE existing account
    public account(int account_id, int user_id, String login, String email, String password) {
        this.account_id = account_id;
        this.user_id = user_id;
        this.login = login;
        this.email = email;
        this.password = password;
    }

    // For INSERT new account
    public account(String login, String email, String password) {
        this(0, 0, login, email, password);
    }

    // Default Constructor
    public account() {
        this(0, 0, "johnDoe@gmail.com", "johnDoe@gmail.com", "password");
    }
}
