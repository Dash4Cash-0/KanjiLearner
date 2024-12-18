import java.util.ArrayList;

public class UserDatabase {

    private ArrayList<User> users;

    public UserDatabase() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }
    public boolean checkUser(User user) {
        return users.contains(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
