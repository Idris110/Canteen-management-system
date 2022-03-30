import java.awt.Font;
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
import java.awt.Toolkit;

public class UserRegistration extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField email;
    private JTextField username;
    private JTextField mob;
    private JPasswordField passwordField;
    private JButton btnNewButton;

    public UserRegistration() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("img/bg.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 80, 1014, 597);
    	setTitle("Canteen-MS-Registration");
        setResizable(false);
        setVisible(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("New User Registration");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        lblNewUserRegister.setBounds(330, 52, 325+100, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("First name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(58, 152, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Last name");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(58, 243, 110, 29);
        contentPane.add(lblNewLabel);

        JLabel lblEmailAddress = new JLabel("Email\r\n address");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEmailAddress.setBounds(58, 324, 124, 36);
        contentPane.add(lblEmailAddress);

        firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 22));
        firstname.setBounds(214, 156, 228, 40);
        contentPane.add(firstname);
        firstname.setColumns(10);

        lastname = new JTextField();
        lastname.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lastname.setBounds(214, 240, 228, 40);
        contentPane.add(lastname);
        lastname.setColumns(10);

        email = new JTextField();
        email.setFont(new Font("Tahoma", Font.PLAIN, 22));
        email.setBounds(214, 320+5, 228, 40);
        contentPane.add(email);
        email.setColumns(10);

        username = new JTextField();
        username.setFont(new Font("Tahoma", Font.PLAIN, 22));
        username.setBounds(707, 151+5, 228, 40);
        contentPane.add(username);
        username.setColumns(10);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername.setBounds(542, 159, 99, 29);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(542, 245, 99, 24);
        contentPane.add(lblPassword);

        JLabel lblMobileNumber = new JLabel("Mobile number");
        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMobileNumber.setBounds(542, 329, 139, 26);
        contentPane.add(lblMobileNumber);

        mob = new JTextField();
        mob.setFont(new Font("Tahoma", Font.PLAIN, 22));
        mob.setBounds(707, 320+5, 228, 40);
        contentPane.add(mob);
        mob.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 22));
        passwordField.setBounds(707, 235+5, 228, 40);
        contentPane.add(passwordField);

        btnNewButton = new JButton("Register");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = firstname.getText();
                String lastName = lastname.getText();
                String emailId = email.getText();
                String userName = username.getText();
                String mobileNumber = mob.getText();
                int len = mobileNumber.length();
                String password = String.valueOf(passwordField.getPassword());

                String msg = "" + firstName;
                msg += " \n";
                
                if(firstName.length()>0 && lastName.length()>0 && emailId.length()>0 && userName.length()>0 && len>0) {
                	if (len == 10) {
                		try {
                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/canteen_db", "root", "1234");

                            String query = "INSERT INTO account values('" + firstName + "','" + lastName + "','" + userName + "','" +
                                password + "','" + emailId + "','" + mobileNumber + "','" + 0 + "')";

                            Statement sta = connection.createStatement();
                            sta.executeUpdate(query);
                            
                            JOptionPane.showMessageDialog(btnNewButton,"Welcome, " + msg + "Your account is sucessfully created");
                                
                            connection.close();
                            dispose();
                            Order o = new Order(userName);
                            o.setVisible();
                            
                        } catch (SQLIntegrityConstraintViolationException exception) {
                            //exception.printStackTrace();
                        	System.out.println(exception);
                        	JOptionPane.showMessageDialog(btnNewButton, "This username already exists");
                        } catch (Exception exception) {
                        	exception.printStackTrace();
                        } 
                    }
                	else {                		
                		JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
                	}
                }
                else {
                	JOptionPane.showMessageDialog(btnNewButton, "Enter all the fields");
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(399, 447, 259, 74);
        btnNewButton.setFocusPainted(isEnabled());
        contentPane.add(btnNewButton);
    }
}
