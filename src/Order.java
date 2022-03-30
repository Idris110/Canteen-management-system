import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Order extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    JTextArea bill1,bill2;
    JButton cart;
    
	Cart c ;
    
    public Order(String username) {
    	c = new Cart(username);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setTitle("Canteen-MS-Place Order");
        setBounds(60, 10, 1200, 700);
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage("img/bg.png"));
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        getContentPane().setBackground(new Color(52, 46, 45)); //black
        
        JLabel lblorder = new JLabel("Place your Order");
        lblorder.setFont(new Font("Times New Roman", Font.PLAIN, 35));
        lblorder.setBounds(110, 19, 500, 50);
        lblorder.setForeground(Color.white);  //red
        contentPane.add(lblorder);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(115, 1000));
        
        //System.out.println(new File("img/item1.jpg").getCanonicalPath());

        JLabel lrow1 = new JLabel("Snacks");
        lrow1.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        lrow1.setBounds(525,11,100,32);
        lrow1.setForeground(Color.white);
        panel.add(lrow1);
        
        JLabel lrow2 = new JLabel("Meals");
        lrow2.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        lrow2.setBounds(525,350,100,32);
        lrow2.setForeground(Color.white);
        panel.add(lrow2);
        
//        int yrow1=52 ,yrow2=360,  pheight=246,pwidth=262;
//        int xcol1=16 ,xcol2=295 ,xcol3=574 ,xcol4=853;
//        int lx=100,ly=218,lwid=250,lhei=20,by=4,bxy=4,bwid=254,bhei=210;
        
        int yrow1=52 ,yrow2=390,  pheight=270,pwidth=262;
        int xcol1=16 ,xcol2=295 ,xcol3=574 ,xcol4=853;
        int lx=100,ly=243,lwid=250,lhei=20,by=30,bxy=5,bwid=252,bhei=210;
        
        JButton bitem1,bitem2,bitem3,bitem4,bitem5,bitem6,bitem7,bitem8;
        JLabel litem1,litem2,litem3,litem4,litem5,litem6,litem7,litem8;
        JLabel lname1,lname2,lname3,lname4,lname5,lname6,lname7,lname8;
        JPanel pitem1,pitem2,pitem3,pitem4,pitem5,pitem6,pitem7,pitem8;
        
        Color blue =new Color(138, 241, 255); //greenish
        Font menuFont= new Font("Tahoma", Font.PLAIN, 20);
        
        Border blackline = BorderFactory.createLineBorder(Color.black,2);
        Font lblname = new Font("Times New Roman", Font.PLAIN, 22);
        
        pitem1 = new JPanel();
        pitem1.setBounds(xcol1,yrow1,pwidth,pheight);
        pitem1.setBackground(blue);
        litem1 = new JLabel("Rs.25");
        litem1.setFont(menuFont);
        litem1.setBounds(lx,ly,lwid,lhei);
        lname1 = new JLabel("Samosa");
        lname1.setFont(lblname);
        lname1.setBounds(90,6,lwid,lhei);
    	bitem1 = new JButton(new ImageIcon("img/samosa.jpg"));
        bitem1.setBounds(bxy,by,bwid,bhei);
        
        pitem2 = new JPanel();
        pitem2.setBounds(xcol2,yrow1,pwidth,pheight);
        pitem2.setBackground(blue);
        litem2 = new JLabel("Rs.20");
        litem2.setFont(menuFont);
        litem2.setBounds(lx,ly,lwid,lhei);
        lname2 = new JLabel("Vada Pav");
        lname2.setFont(lblname);
        lname2.setBounds(90,6,lwid,lhei);
    	bitem2 = new JButton(new ImageIcon("img/vadapav.jpg"));
        bitem2.setBounds(bxy,by,bwid,bhei);
        
        pitem3 = new JPanel();
        pitem3.setBounds(xcol3,yrow1,pwidth,pheight);
        pitem3.setBackground(blue);
        litem3 = new JLabel("Rs.30");
        litem3.setFont(menuFont);
        litem3.setBounds(lx,ly,lwid,lhei);
        lname3 = new JLabel("Misal Pav");
        lname3.setFont(lblname);
        lname3.setBounds(90,6,lwid,lhei);
    	bitem3 = new JButton(new ImageIcon("img/misal.jpg"));
        bitem3.setBounds(bxy,by,bwid,bhei);
        
        pitem4 = new JPanel();
        pitem4.setBounds(xcol4,yrow1,pwidth,pheight);
        pitem4.setBackground(blue);
        litem4 = new JLabel("Rs.30");
        litem4.setFont(menuFont);
        litem4.setBounds(lx,ly,lwid,lhei);
        lname4 = new JLabel("Pav Bhaji");
        lname4.setFont(lblname);
        lname4.setBounds(90,6,lwid,lhei);
    	bitem4 = new JButton(new ImageIcon("img/pavbhaji.jpg"));
        bitem4.setBounds(bxy,by,bwid,bhei);
        
        pitem5 = new JPanel();
        pitem5.setBounds(xcol1,yrow2,pwidth,pheight);
        pitem5.setBackground(blue);
        litem5 = new JLabel("Rs.120");
        litem5.setFont(menuFont);
        litem5.setBounds(lx,ly,lwid,lhei);
        lname5 = new JLabel("Chicken Biryani");
        lname5.setFont(lblname);
        lname5.setBounds(66,6,lwid,lhei);
    	bitem5 = new JButton(new ImageIcon("img/chikenbiryani.jpg"));
        bitem5.setBounds(bxy,by,bwid,bhei);
        
        pitem6 = new JPanel();
        pitem6.setBounds(xcol2,yrow2,pwidth,pheight);
        pitem6.setBackground(blue);
        litem6 = new JLabel("Rs.160");
        litem6.setFont(menuFont);
        litem6.setBounds(lx,ly,lwid,lhei);
        lname6 = new JLabel("Idli Sambar");
        lname6.setFont(lblname);
        lname6.setBounds(90,6,lwid,lhei);
    	bitem6 = new JButton(new ImageIcon("img/idli.jpg"));
        bitem6.setBounds(bxy,by,bwid,bhei);
        
        pitem7 = new JPanel();
        pitem7.setBounds(xcol3,yrow2,pwidth,pheight);
        pitem7.setBackground(blue);
        litem7 = new JLabel("Rs.130");
        litem7.setFont(menuFont);
        litem7.setBounds(lx,ly,lwid,lhei);
        lname7 = new JLabel("Chole Bature");
        lname7.setFont(lblname);
        lname7.setBounds(80,6,lwid,lhei);
    	bitem7 = new JButton(new ImageIcon("img/cholebhature.jpg"));
        bitem7.setBounds(bxy,by,bwid,bhei);
        
        pitem8 = new JPanel();
        pitem8.setBounds(xcol4,yrow2,pwidth,pheight);
        pitem8.setBackground(blue);
        litem8 = new JLabel("Rs.140");
        litem8.setFont(menuFont);
        litem8.setBounds(lx,ly,lwid,lhei);
        lname8 = new JLabel("Veg Biryani");
        lname8.setFont(lblname);
        lname8.setBounds(82,6,lwid,lhei);
    	bitem8 = new JButton(new ImageIcon("img/vegbiryani.jpg"));
        bitem8.setBounds(bxy,by,bwid,bhei);
        
        pitem1.setLayout(null);
        pitem2.setLayout(null);
        pitem3.setLayout(null);
        pitem4.setLayout(null);
        pitem5.setLayout(null);
        pitem6.setLayout(null);
        pitem7.setLayout(null);
        pitem8.setLayout(null);
        
        pitem1.add(litem1);
        pitem2.add(litem2);
        pitem3.add(litem3);
        pitem4.add(litem4);
        pitem5.add(litem5);
        pitem6.add(litem6);
        pitem7.add(litem7);
        pitem8.add(litem8);
        
        pitem1.add(lname1);
        pitem2.add(lname2);
        pitem3.add(lname3);
        pitem4.add(lname4);
        pitem5.add(lname5);
        pitem6.add(lname6);
        pitem7.add(lname7);
        pitem8.add(lname8);
        
        pitem1.add(bitem1);
        pitem2.add(bitem2);
        pitem3.add(bitem3);
        pitem4.add(bitem4);
        pitem5.add(bitem5);
        pitem6.add(bitem6);
        pitem7.add(bitem7);
        pitem8.add(bitem8);
        
        pitem1.setBorder(blackline);
        pitem2.setBorder(blackline);
        pitem3.setBorder(blackline);
        pitem4.setBorder(blackline);
        pitem5.setBorder(blackline);
        pitem6.setBorder(blackline);
        pitem7.setBorder(blackline);
        pitem8.setBorder(blackline);
        
        bitem1.addActionListener(this);
        bitem2.addActionListener(this);
        bitem3.addActionListener(this);
        bitem4.addActionListener(this);
        bitem5.addActionListener(this);
        bitem6.addActionListener(this);
        bitem7.addActionListener(this);
        bitem8.addActionListener(this);
        
        bitem1.setActionCommand("1");
        bitem2.setActionCommand("2");
        bitem3.setActionCommand("3");
        bitem4.setActionCommand("4");
        bitem5.setActionCommand("5");
        bitem6.setActionCommand("6");
        bitem7.setActionCommand("7");
        bitem8.setActionCommand("8");

        panel.add(pitem1);
        panel.add(pitem2);
        panel.add(pitem3);
        panel.add(pitem4);
        panel.add(pitem5);
        panel.add(pitem6);
        panel.add(pitem7);
        panel.add(pitem8);
        
        cart= new JButton("Cart");
        cart.setBounds(1000,25,100,40);
        cart.setFont(menuFont);
        cart.setBackground(new Color(92, 85, 84));
        cart.addActionListener(this);
        cart.setFocusPainted(false);
        cart.setForeground(Color.white); 
        cart.setBorder(BorderFactory.createLineBorder(Color.white,2));
        contentPane.add(cart);
        
        panel.setBackground(new Color(92, 85, 84));
        JScrollPane scrollPane = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(20,90,1150,500);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane);
    }
    
    public void actionPerformed(ActionEvent e){  
        switch(e.getActionCommand()) {
        case "1": 
        	c.addToCart("1");
        	break;
        case "2": 
        	c.addToCart("2");
        	break;
        case "3": 
        	c.addToCart("3");
        	break;
        case "4": 
        	c.addToCart("4");
        	break;
        case "5": 
        	c.addToCart("5");
        	break;
        case "6": 
        	c.addToCart("6");
        	break;
        case "7": 
        	c.addToCart("7");
        	break;
        case "8": 
        	c.addToCart("8");
        	break;
        }
    	
    	if(e.getSource()==cart) {
    		c.setVisible(true);
    	}
    }
    
    public void setVisible() {
        setVisible(true);
	}

}
