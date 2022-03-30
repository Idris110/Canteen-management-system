import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Cart extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea itemList, quantity, amt,rate;
    private JButton Customize, calculate, debit ,paynow, Finish;
    private JTextField tftotal;
    private String username;
    private int amtsum=0, paid=0;

    Cart(String Username) {
    	username=Username;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Canteen-MS-Cart");
        setBounds(60, 10, 1200, 700);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(52, 46, 45));

        Color blue = new Color(79, 170, 255);
        Font menuFont = new Font("Tahoma", Font.PLAIN, 20);
        
        JPanel pitemlist,prate,pquan,pamt;
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(200, 100, 390, 430);
        panel.setBackground(new Color(92, 85, 84));

        Border blackborder = BorderFactory.createLineBorder(Color.black,2);
        int py=36,pos=-19;
        
        itemList = new JTextArea();
        itemList.setBounds(5, 5, 170, 300);
        itemList.setLineWrap(true);
        itemList.setEditable(false);
        itemList.setBorder(new EmptyBorder(5, 5, 5, 5));
        itemList.setFont(new Font("Tahoma", Font.PLAIN, 17));
        pitemlist = new JPanel();
        pitemlist.setLayout(null);
        pitemlist.setBounds(40+pos, py, 180, 310);
        pitemlist.setBorder(blackborder);
        pitemlist.add(itemList);
        
        rate = new JTextArea();
        rate.setBounds(05,05, 50, 300);
        rate.setLineWrap(true);
        rate.setEditable(false);
        rate.setBorder(new EmptyBorder(5, 5, 5, 5));
        rate.setFont(new Font("Tahoma", Font.PLAIN, 17));
        rate.setBorder(new EmptyBorder(5, 5, 5, 5));
        prate = new JPanel();
        prate.setLayout(null);
        prate.setBounds(218+pos, py, 60, 310);
        prate.setBorder(blackborder);
        prate.add(rate);
        
        quantity = new JTextArea();
        quantity.setBounds(05, 05, 40, 300);
        quantity.setLineWrap(true);
        quantity.setCaretColor(Color.WHITE);
        quantity.setBorder(new EmptyBorder(5, 5, 5, 5));
        quantity.setFont(new Font("Tahoma", Font.PLAIN, 17));
        pquan = new JPanel();
        pquan.setLayout(null);
        pquan.setBounds(276+pos, py, 50, 310);
        pquan.setBorder(blackborder);
        pquan.add(quantity);

        amt = new JTextArea();
        amt.setBounds(05, 05, 50, 300);
        amt.setLineWrap(true);
        amt.setEditable(false);
        amt.setBorder(new EmptyBorder(5, 5, 5, 5));
        amt.setFont(new Font("Tahoma", Font.PLAIN, 17));
        pamt = new JPanel();
        pamt.setLayout(null);
        pamt.setBounds(324+pos, py, 60, 310);
        pamt.setBorder(blackborder);
        pamt.add(amt);
        
        panel.add(pitemlist);
        panel.add(prate);
        panel.add(pquan);
        panel.add(pamt);

        
        int ly = 8;
        JLabel litems, lquantity, user, lrate;
        Font lblfont = new Font("Times New Roman", Font.PLAIN, 20);

        litems = new JLabel("Items in cart");
        litems.setFont(lblfont);
        litems.setForeground(Color.white); 
        litems.setBounds(70+pos, ly, 200, 32);
        panel.add(litems);

        lrate = new JLabel("Rate");
        lrate.setFont(lblfont);
        lrate.setForeground(Color.white);
        lrate.setBounds(230+pos, ly, 130, 32);
        panel.add(lrate);
        
        lquantity = new JLabel("Qty");
        lquantity.setFont(lblfont);
        lquantity.setForeground(Color.white);
        lquantity.setBounds(289+pos, ly, 130, 32);
        panel.add(lquantity);

        user = new JLabel("Amt");
        user.setFont(lblfont);
        user.setForeground(Color.white);
        user.setBounds(338+pos, ly, 100, 32);
        panel.add(user);
        
        tftotal = new JTextField(" Total : ");
        tftotal.setBounds(242, 350, 123, 32);
        tftotal.setEditable(false);
        tftotal.setFont(new Font("Tahoma", Font.PLAIN, 19));
        tftotal.setBorder(blackborder);
        panel.add(tftotal);
        
        user = new JLabel("Dear "+username+", confirm your order");
        user.setFont(new Font("Tahoma", Font.PLAIN, 21));
        user.setForeground(Color.white);
        user.setBounds(70, 30, 600, 32);
        add(user);

        Customize = new JButton("Edit Cart");
        Customize.setBounds(900, 130, 170, 40);
        Customize.setFont(menuFont);
        Customize.setBackground(blue);
        Customize.addActionListener(this);
        Customize.setFocusPainted(false);
        add(Customize);

        calculate = new JButton("Calculate Bill");
        calculate.setBounds(900, 210, 170, 40);
        calculate.setFont(menuFont);
        calculate.setBackground(blue);
        calculate.addActionListener(this);
        calculate.setFocusPainted(false);
        add(calculate);

        debit = new JButton("Pay Later");
        debit.setBounds(900, 320, 170, 40);
        debit.setFont(menuFont);
        debit.setBackground(blue);
        debit.addActionListener(this);
        debit.setFocusPainted(false);
        add(debit);

        paynow = new JButton("Pay Now");
        paynow.setBounds(900, 370, 170, 40);
        paynow.setFont(menuFont);
        paynow.setBackground(blue);
        paynow.addActionListener(this);
        paynow.setFocusPainted(false);
        add(paynow);
        
        Finish = new JButton("Place Order");
        Finish.setBounds(900, 420, 170, 40);
        Finish.setFont(menuFont);
        Finish.setBackground(new Color(0, 20, 153));
        Finish.setEnabled(false);
        Finish.addActionListener(this);
        Finish.setFocusPainted(false);
        add(Finish);

        add(panel);
    }
    
    int count=0;
    public void addToCart(String inp) {
    	
        switch (inp) {
            case "1":
            	count++;
                itemList.append(count+". Samosa\n");
                rate.append("25\n");
                break;
            case "2":
            	count++;
                itemList.append(count+". Vada Pav\n");
                rate.append("20\n");
                break;
            case "3":
            	count++;
                itemList.append(count+". Misal Pav\n");
                rate.append("30\n");
                break;
            case "4":
            	count++;
                itemList.append(count+". Pav Bhaji\n");
                rate.append("30\n");
                break;
            case "5":
            	count++;
                itemList.append(count+". Chicken Biryani\n");
                rate.append("150\n");
                break;
            case "6":
            	count++;
                itemList.append(count+". Idli Sambar\n");
                rate.append("160\n");
                break;
            case "7":
            	count++;
                itemList.append(count+". Chole Bature\n");
                rate.append("130\n");
                break;
            case "8":
            	count++;
                itemList.append(count+". Veg Biryani\n");
                rate.append("140\n");
                break;
        }
    }

    public void setVisible() {
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Customize) {
        	setVisible(false);
        	
        }

        else if (e.getSource() == calculate) {
        	amt.setText(null);
        	tftotal.setText(null);
        	tftotal.replaceSelection(" Total : ");
        	
        	String sQuan = quantity.getText();
            String sItem = rate.getText();
            
            int[][] arrQuan = new int[10][3];

            StringBuffer tempQuan = new StringBuffer();
            StringBuffer tempItem = new StringBuffer();

            int lengthQuan=0;
            for(int i=0;i<sQuan.length();i++){
                while(i<sQuan.length() && sQuan.charAt(i)!='\n'){
                    tempQuan.append(Character.toString(sQuan.charAt(i)));
                    i++;
                }
                arrQuan[lengthQuan][0]=Integer.parseInt(tempQuan.toString());
                lengthQuan++;
                tempQuan.delete(0, tempQuan.length());
            }

            lengthQuan=0;
            for(int i=0;i<sItem.length();i++){
                while(i<sItem.length() && sItem.charAt(i)!='\n'){
                    tempItem.append(Character.toString(sItem.charAt(i)));
                    i++;
                }
                arrQuan[lengthQuan][1]=Integer.parseInt(tempItem.toString());
                lengthQuan++;
                tempItem.delete(0, tempItem.length());
            }
            
            for(int i=0;i<lengthQuan;i++){
                //System.out.println(arrQuan[i][0]+" - "+arrQuan[i][1]);
            	amtsum = amtsum + arrQuan[i][0]*arrQuan[i][1];
                amt.append(Integer.toString(arrQuan[i][0]*arrQuan[i][1])+"\n");
            }
            tftotal.replaceSelection(Integer.toString(amtsum));
            
            
        }
        else if (e.getSource() == debit) {

        	quantity.setEditable(false);
        	String query1 = "select debt from account where user_name = \""+username+"\"";
        	try {
            	Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/canteen_db", "root", "1234");
                Statement sta = connection.createStatement();
                
                ResultSet rs = sta.executeQuery(query1);
        		rs.next();
        		int prevDebt = rs.getInt("debt");
        		
        		String query2 = "UPDATE account SET debt="+ (amtsum+prevDebt) +" WHERE user_name = \""+username+"\"";
                sta.executeUpdate(query2);
        		//System.out.println();
        		
                connection.close();
            } catch (Exception exception) {
                //exception.printStackTrace();
            	System.out.println(exception);
            }
        	JOptionPane.showMessageDialog(debit, "Dear "+username+", Rs. "+amtsum+" have been\n added to your balance");
        	Finish.setEnabled(true);
        	Finish.setBackground(new Color(79, 170, 255));
        }
        else if (e.getSource() == paynow) {
        	quantity.setEditable(false);
        	paid=1;
        	Finish.setEnabled(true);
        	Finish.setBackground(new Color(79, 170, 255));
        	JOptionPane.showMessageDialog(Finish, "Dear "+username+", pay Rs. "+amtsum+" to counter");
        }
        else if(e.getSource() == Finish) {

        	try {
            	Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/canteen_db", "root", "1234");
                Statement sta = connection.createStatement();
        		
                String sit = itemList.getText();
                String squ = quantity.getText();
                String sam = amt.getText();
                StringBuffer tempIt = new StringBuffer();
                StringBuffer tempqu = new StringBuffer();
                StringBuffer tempam = new StringBuffer();

                int k=0,l=0,m=0; //==============================================
                for(int j=0;j<count;j++){

                    while(k<sit.length() && sit.charAt(k)!='\n'){
                        tempIt.append(Character.toString(sit.charAt(k)));
                        k++;
                    }
                    String itemname=tempIt.toString()+"  ";
                    tempIt.delete(0, tempIt.length());
                    k++;
                    
                    while(l<squ.length() && squ.charAt(l)!='\n'){
                        tempqu.append(Character.toString(squ.charAt(l)));
                        l++;
                    }
                    int quanno =Integer.parseInt(tempqu.toString());
                    tempqu.delete(0, tempqu.length());
                    l++;
                    
                    while(m<sam.length() && sam.charAt(m)!='\n'){
                        tempam.append(Character.toString(sam.charAt(m)));
                        m++;
                    }
                    int amount =Integer.parseInt(tempam.toString());
                    tempam.delete(0, tempam.length());
                    m++;
                    //System.out.println(itemname+"-"+quanno+amount);
                    String query = "INSERT INTO order_record values(now(),'" + username + "','" + itemname + "'," + quanno + "," + amount + "," + paid + ")";
                    sta.executeUpdate(query);
                }
        		
                connection.close();
            } catch (Exception exception) {
                //exception.printStackTrace();
            	System.out.println(exception);
            }
        	dispose();
        	Order o = new Order(username);
        	o.setVisible();
        }
        
    }
}

   