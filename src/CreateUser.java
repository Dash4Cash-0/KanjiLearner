public class CreateUser implements  UserInterface{
    private User user;

    public CreateUser(){
        this.user = new User();
    }


    @Override
    public UserInterface createUserName(String userName) {
        user.setUserName(userName);
        return this;
    }

    @Override
    public UserInterface createPassword(String password) {
        user.setPassword(password);
        return this;
    }

    @Override
    public UserInterface createEmail(String email) {
        user.setEmail(email);
        return this;
    }

    @Override
    public User create() {
        return user;
    }
}
