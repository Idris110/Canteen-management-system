import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Signin extends JFrame {
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField username;
    private JPasswordField passwordField;
    private JButton loginButton,newUserButton;
    
    public Signin() {
    	
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setIconImage(Toolkit.getDefaultToolkit().getImage("img/bg.png"));
    	setTitle("PIL CANTEEN");
        setBounds(200, 100, 400, 500);
        setResizable(false);
        setVisible(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        getContentPane().setBackground(new Color(150, 255, 225));
        

        JLabel welcome = new JLabel("Welcome to");
        welcome.setFont(new Font("Times New Roman", Font.PLAIN, 23));
        welcome.setBounds(129, 10, 300, 60);
        contentPane.add(welcome);
        
        JLabel welcome1 = new JLabel(" PIL CANTEEN");
        welcome1.setFont(new Font("Felix Titling", Font.PLAIN, 27));
        welcome1.setBounds(92, 42, 300, 60);
        contentPane.add(welcome1);
        
        JLabel lblsignin = new JLabel("Login");
        lblsignin.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
        lblsignin.setBounds(154, 102, 200, 50);
        contentPane.add(lblsignin);
        

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblUsername.setBounds(20, 180, 90, 18);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPassword.setBounds(20, 240, 90, 18);
        contentPane.add(lblPassword);
        
        username = new JTextField();
        username.setFont(new Font("Tahoma", Font.PLAIN, 18));
        username.setBounds(110, 175, 228, 30);
        username.setBorder(new EmptyBorder(0, 5, 0, 0));
        contentPane.add(username);
        username.setColumns(10);
        
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        passwordField.setBounds(110, 235, 228, 30);
        passwordField.setBorder(new EmptyBorder(0, 5, 0, 0));
        contentPane.add(passwordField);
        
        loginButton = new JButton("Sign in");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userName = username.getText();
        		String password = String.valueOf(passwordField.getPassword());
        		String query = "select password_,first_name from account where user_name = \""+userName+"\"";
                try {
                	Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/canteen_db", "root", "1234");
                    Statement sta = connection.createStatement();
                    
                    ResultSet rs = sta.executeQuery(query);
                    rs.next();
            		String db_password = rs.getString("password_");
            		//System.out.println(db_password+" entered :"+password);
            		
                    if (db_password.equals(password)) {
                    	JOptionPane.showMessageDialog(loginButton,"Welcome, "+ rs.getString("first_name"));
                    	dispose();
                    	Order o =new Order(userName); //-------------------------------------------------
                    	o.setVisible();
                    } else {
                        JOptionPane.showMessageDialog(loginButton, "Invalid Password");
                    }
                    connection.close();
                } catch (Exception exception) {
                    //exception.printStackTrace();
                	JOptionPane.showMessageDialog(loginButton, "Invalid User");
                	System.out.println(exception);
                }
            }
        });
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        loginButton.setBounds(56, 310, 270, 38);
        loginButton.setFocusPainted(false);
        contentPane.add(loginButton);
        
        newUserButton = new JButton("New user");
        newUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
                new UserRegistration();
            }
        });
        newUserButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        newUserButton.setBounds(56, 370, 270, 38);
        newUserButton.setFocusPainted(false);
        contentPane.add(newUserButton);
    }
}
