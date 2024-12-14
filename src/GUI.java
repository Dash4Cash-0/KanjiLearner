import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private String previousPanel;



    public GUI(){
        init();
    }

    public void init(){

        JFrame frame = new JFrame();
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        cardPanel.add(loginPanel(), "Login");
        cardPanel.add(registerPanel(), "Register");

        frame.add(cardPanel);
        frame.setSize(300,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        cardLayout.show(cardPanel, "Login");
    }

    public void switchPanel(String panel){
        cardLayout.show(cardPanel, panel);
    }


    public JPanel loginPanel(){
        JPanel login = new JPanel(new BorderLayout());
        JPanel userPassPanel = new JPanel();
        JPanel loginRegisterPanel = new JPanel();
        JPanel logo = new JPanel();
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        login.add(logo, BorderLayout.NORTH);
        login.add(userPassPanel, BorderLayout.CENTER);
        login.add(loginRegisterPanel, BorderLayout.SOUTH);
        loginRegisterPanel.add(loginButton);
        loginRegisterPanel.add(registerButton);


        loginButton.addActionListener((ActionEvent e) -> {
            switchPanel("Welcome");
        });
        registerButton.addActionListener((ActionEvent e) -> {
            switchPanel("Register");
        });

        return login;
    }

    public JPanel registerPanel(){
        JPanel panel = new JPanel(new BorderLayout());
        JPanel userInfo = new JPanel();
        JPanel buttons = new JPanel();
        JLabel userName = new JLabel("Username: ");
        JLabel password = new JLabel("Password: ");
        JTextField user = new JTextField(30);
        JTextField pass = new JTextField(30);
        JButton signUp = new JButton("Sign up");
        panel.add(userInfo, BorderLayout.CENTER);
        panel.add(buttons, BorderLayout.SOUTH);
        userInfo.add(userName);
        userInfo.add(user);
        userInfo.add(password);
        userInfo.add(pass);
        buttons.add(signUp);
        buttons.add(backButton());
        setPreviousPanel("Login");

        return panel;
    }


    public JButton backButton(){
        JButton backButton = new JButton("Back");
        backButton.addActionListener((ActionEvent e) -> {
            cardLayout.show(cardPanel, getPreviousPanel());
        });
        return backButton;
    }

    public void setPreviousPanel(String panel){
        previousPanel = panel;
    }
    public String getPreviousPanel(){
        return previousPanel;
    }
}