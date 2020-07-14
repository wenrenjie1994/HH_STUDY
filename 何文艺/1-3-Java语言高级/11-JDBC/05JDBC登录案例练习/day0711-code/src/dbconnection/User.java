package dbconnection;

/**
 * @program: TODO
 * @className: User
 * @description: TODO
 * @author: 何文艺
 * @creat: 2020/7/13 18:23
 **/
public class User {
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
