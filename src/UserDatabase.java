import java.util.ArrayList;

public class UserDatabase {

    private ArrayList<User> users;

    public UserDatabase() {
        users = new ArrayList<>();
        CreateUser createUser = new CreateUser();
        createUser.createUserName("Test");
        createUser.createPassword("Test");
        createUser.createEmail("Test@test.com");
        addUser(createUser.create());
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
