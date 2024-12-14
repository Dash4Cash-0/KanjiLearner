import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private String previousPanel;
    private final JLabel userNameLabel = new JLabel("User Name:");
    private final JTextField userNameField = new JTextField();
    private final JLabel passwordLabel = new JLabel("Password:");
    private final JPasswordField passwordField = new JPasswordField();


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
        frame.setBackground(new Color(68,84,76));
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
        login.setBackground(new Color(68,84,76));
        userPassPanel.setBackground(new Color(68,84,76));
        loginRegisterPanel.setBackground(new Color(68,84,76));
        userPassPanel.setLayout(new GridLayout(2,2));
        logo.add(getImageLabel());
        login.add(logo, BorderLayout.NORTH);
        login.add(userPassPanel, BorderLayout.CENTER);
        login.add(loginRegisterPanel, BorderLayout.SOUTH);
        getUserNameLabel().setForeground(Color.white);
        getPasswordLabel().setForeground(Color.white);
        userPassPanel.add(getUserNameLabel());
        userPassPanel.add(getUserNameField());
        userPassPanel.add(getPasswordLabel());
        userPassPanel.add(getPasswordField());
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
    public JLabel getImageLabel(){
        ImageIcon logoImage = new ImageIcon("src/kanjilearner.png");
        JLabel imageLabel = new JLabel();
        Image image = logoImage.getImage();
        Image scaleImage = image.getScaledInstance(300, 250, Image.SCALE_SMOOTH);
        ImageIcon scaledImage = new ImageIcon(scaleImage);
        imageLabel.setIcon(scaledImage);

        return imageLabel;
    }
    public JTextField getUserNameField(){
        return userNameField;
    }
    public JPasswordField getPasswordField(){
        return passwordField;
    }
    public JLabel getPasswordLabel(){
        return passwordLabel;
    }
    public JLabel getUserNameLabel(){
        return userNameLabel;
    }
}