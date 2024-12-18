public interface UserInterface {
    UserInterface createUserName(String userName);
    UserInterface createPassword(String password);
    UserInterface createEmail(String email);
    User create();
}
