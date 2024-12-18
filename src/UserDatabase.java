import java.util.ArrayList;

public class UserDatabase {

    private ArrayList<CreateUser> users;

    public UserDatabase() {
        users = new ArrayList<>();
    }

    public void addUser(CreateUser user) {
        users.add(user);
    }

    public ArrayList<CreateUser> getUsers() {
        return users;
    }
}
