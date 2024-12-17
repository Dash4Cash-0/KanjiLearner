import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class GUI extends JFrame {
    private static GUI gui;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private String previousPanel;
    private final JLabel userNameLabel = new JLabel("User Name:");
    private final JTextField userNameField = new JTextField();
    private final JLabel passwordLabel = new JLabel("Password:");
    private final JPasswordField passwordField = new JPasswordField();
    private CardDatabase database;
    private Level currentLevel;
    private AtomicInteger kanjiCounter;


    private GUI(){
        init();
    }

    public void init(){

        JFrame frame = new JFrame();
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        cardPanel.add(loginPanel(), "Login");
        cardPanel.add(registerPanel(), "Register");
        cardPanel.add(welcomePanel(), "Welcome");
        cardPanel.add(beginnerPanel(), "Beginner");
        cardPanel.add(basicPanel(), "Basic");
        cardPanel.add(cardFront(),"Card Front");
        cardPanel.add(cardBack(),"Card Back");

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

    public JPanel welcomePanel(){
        JPanel welcome = new JPanel(new BorderLayout());
        JPanel header = new JPanel();
        JPanel logout = new JPanel();
        JPanel kanjiLevels = new JPanel();
        JButton studyBeginner = new JButton("Study");
        JButton studyBasic = new JButton("Study");
        JButton logoutButton = new JButton("Log out");
        ImageIcon n5 = new ImageIcon("src/n5.png");
        Image image = n5.getImage();
        Image scaleImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledImage = new ImageIcon(scaleImage);

        ImageIcon n4 = new ImageIcon("src/n4.png");
        Image image2 = n4.getImage();
        Image scaleImage2 = image2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledImage2 = new ImageIcon(scaleImage2);

        JLabel headerText = new JLabel("漢字 Learner");
        JLabel beginnerImg = new JLabel(scaledImage);
        JLabel beginner = new JLabel("          Beginner          ");
        JLabel basicImg = new JLabel(scaledImage2);
        JLabel basic = new JLabel("          Basic                ");



        headerText.setFont(new Font("Serif", Font.BOLD, 25));

        welcome.add(header, BorderLayout.NORTH);
        welcome.add(kanjiLevels, BorderLayout.CENTER);
        welcome.add(logout, BorderLayout.SOUTH);
        kanjiLevels.add(beginnerImg);
        kanjiLevels.add(beginner);
        kanjiLevels.add(studyBeginner);
        kanjiLevels.add(basicImg);
        kanjiLevels.add(basic);
        kanjiLevels.add(studyBasic);
        header.add(headerText);
        logout.add(logoutButton);


        studyBeginner.addActionListener((ActionEvent e) -> {
            switchPanel("Beginner");
        });
        studyBasic.addActionListener((ActionEvent e) -> {
            switchPanel("Basic");
        });
        logoutButton.addActionListener((ActionEvent e) -> {
            if(e.getSource() == logoutButton){
                int exit = JOptionPane.showConfirmDialog(null,"Do you want to log out?", "Logout", JOptionPane.YES_NO_OPTION);
                if(exit == JOptionPane.YES_OPTION){
                    switchPanel("Login");
                }
            }
        });


        return welcome;
    }

    public JPanel registerPanel(){
        JPanel panel = new JPanel(new BorderLayout());
        JPanel userInfo = new JPanel();
        JPanel buttons = new JPanel();
        JLabel userName = new JLabel("Username: ");
        JLabel password = new JLabel("Password: ");
        JLabel email = new JLabel("Email: ");
        JTextField user = new JTextField(30);
        JPasswordField pass = new JPasswordField(30);
        JTextField emailField = new JTextField(30);
        JButton signUp = new JButton("Sign up");
        panel.add(userInfo, BorderLayout.CENTER);
        panel.add(buttons, BorderLayout.SOUTH);
        userInfo.add(userName);
        userInfo.add(user);
        userInfo.add(password);
        userInfo.add(pass);
        userInfo.add(email);
        userInfo.add(emailField);
        buttons.add(signUp);
        buttons.add(backButton("Back"));
        setPreviousPanel("Login");

        signUp.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null,"You have successfully registered and " +
                                                                        "can now log into your account!");
            switchPanel("Login");
        });

        return panel;
    }

    public JPanel beginnerPanel(){
        database = new CardDatabase();
        setCurrentLevel(Level.BEGINNER);
        JPanel panel = new JPanel(new BorderLayout());
        JPanel center = new JPanel(new GridLayout(10,3));
        JPanel backButton = new JPanel();
        JButton goBack = new JButton("Back");
        int setNo = 1;
        int kanjiCountInSet = database.getList(Level.BEGINNER).size();
        for (int i = 0; i < 8; i++){
            JLabel set = new JLabel("Set: " + setNo);
            JLabel kanjisInSet = new JLabel("         " +kanjiCountInSet + " Kanji");

            JButton setButton = new JButton("Study set ");
            center.add(set);
            center.add(setButton);
            center.add(kanjisInSet);
            setNo++;
            int finalKanjiCountInSet = kanjiCountInSet;
            setButton.addActionListener((ActionEvent e) -> {
               if(e.getSource() == setButton){
                   if(finalKanjiCountInSet > 0){
                       switchPanel("Card Front");
                   }
               }
            });
            if(kanjiCountInSet < 10){
                kanjiCountInSet = 0;
            }
        }

        panel.add(center, BorderLayout.CENTER);
        panel.add(backButton, BorderLayout.SOUTH);
        backButton.add(goBack);
        goBack.addActionListener((ActionEvent e) -> {
            switchPanel("Welcome");
        });


        return panel;
    }

    public JPanel basicPanel(){
        database = new CardDatabase();
        setCurrentLevel(Level.BASIC);
        JPanel panel = new JPanel(new BorderLayout());
        JPanel center = new JPanel(new GridLayout(10,3));
        JPanel backButton = new JPanel();
        JButton goBack = new JButton("Back");
        int setNo = 1;
        int kanjiCountInSet = database.getList(Level.BASIC).size();
        for (int i = 0; i < 8; i++){
            JLabel set = new JLabel("Set: " + setNo);
            JLabel kanjisInSet = new JLabel("         " +kanjiCountInSet + " Kanji");

            JButton setButton = new JButton("Study set ");
            center.add(set);
            center.add(setButton);
            center.add(kanjisInSet);
            setNo++;
            int finalKanjiCountInSet = kanjiCountInSet;
            setButton.addActionListener((ActionEvent e) -> {
                if(e.getSource() == setButton){
                    if(finalKanjiCountInSet > 0){
                        switchPanel("Card Front");
                    }
                }
            });
            if(kanjiCountInSet < 10){
                kanjiCountInSet = 0;
            }
        }

        panel.add(center, BorderLayout.CENTER);
        panel.add(backButton, BorderLayout.SOUTH);
        backButton.add(goBack);
        goBack.addActionListener((ActionEvent e) -> {
            switchPanel("Welcome");
        });


        return panel;
    }


//    public JPanel basicPanel(){
//        JPanel panel = new JPanel(new BorderLayout());
//        JPanel center = new JPanel();
//        JPanel backButton = new JPanel();
//
//
//        panel.add(backButton, BorderLayout.SOUTH);
//        backButton.add(backButton("Back"));
//        setPreviousPanel("Welcome");
//
//        return panel;
//    }


    public JPanel cardFront(){
        ArrayList<FlashCard> current = database.getList(currentLevel);
        kanjiCounter = new AtomicInteger();
        JPanel frontOfCard = new JPanel(new BorderLayout());
        JPanel bottom = new JPanel();
        JPanel center = new JPanel();
        JLabel kanji = new JLabel(current.get(kanjiCounter.get()).getFront());
        JButton nextCard = new JButton("Next Card");
        JButton backCard = new JButton("Back of card");
        kanji.setFont(new Font("Serif", Font.BOLD, 40));
        frontOfCard.add(center, BorderLayout.CENTER);
        frontOfCard.add(bottom, BorderLayout.SOUTH);
        center.add(kanji);
        setPreviousPanel("Beginner");
        bottom.add(nextCard);
        bottom.add(backCard);
        bottom.add(backButton("Back"));

        backCard.addActionListener((ActionEvent e) -> {
            switchPanel("Card Back");

        });
        nextCard.addActionListener((ActionEvent e) -> {
            if(e.getSource() == nextCard){
                kanjiCounter.getAndIncrement();
                kanji.setText(current.get(kanjiCounter.get()).getFront());
                frontOfCard.updateUI();
            }
        });

        return frontOfCard;
    }

    public JPanel cardBack(){
        ArrayList<FlashCard> current = database.getList(currentLevel);
        database = new CardDatabase();
        JPanel backOfCard = new JPanel(new BorderLayout());
        JPanel center = new JPanel();
        JPanel bottom = new JPanel();
        JButton showFront = new JButton("Front of card");
        JButton showAnswer = new JButton("Show Answer");
        JLabel onyomi = new JLabel();
        JLabel kunyomi = new JLabel();
        JLabel meaning = new JLabel();
        backOfCard.add(center, BorderLayout.CENTER);
        center.add(onyomi);
        center.add(kunyomi);
        center.add(meaning);
        backOfCard.add(bottom, BorderLayout.SOUTH);
        bottom.add(showFront);
        bottom.add(showAnswer);

        showFront.addActionListener((ActionEvent e) -> {
            switchPanel("Card Front");
        });
        showAnswer.addActionListener((ActionEvent e) -> {
            if(e.getSource() == showAnswer){
                onyomi.setText(current.get(getKanjiCounter().get()).getBack()[0]);
                kunyomi.setText(current.get(getKanjiCounter().get()).getBack()[1]);
                meaning.setText(current.get(getKanjiCounter().get()).getBack()[2]);
                backOfCard.updateUI();
            }
        });

        return backOfCard;
    }


    public JButton backButton(String button){
        JButton backButton = new JButton(button);
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
    public Level getCurrentLevel(){
        return currentLevel;
    }
    public void setCurrentLevel(Level currentLevel){
        this.currentLevel = currentLevel;
    }
    public AtomicInteger getKanjiCounter(){
        return kanjiCounter;
    }
    public static GUI getInstance(){
        if(gui == null){
            gui = new GUI();
        }
        return gui;
    }
}