
package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import static java.awt.Color.BLACK;
import static java.awt.Color.blue;
import static java.awt.Color.white;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
        JButton signup,clear,login;
        JTextField CardTextField;
        JPasswordField pinno;
        Login(){
        setLayout(null);
        setTitle("AUTOMATED TELLER MACHINE");
        setSize(850,450);
        setVisible(true);
        setLocation(300,20);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label= new JLabel(i3);
        label.setBounds(110,10,100,100);
        add(label);
        getContentPane().setBackground(Color.WHITE);
        JLabel Text= new JLabel("WELCOME TO ATM");
        Text.setBounds(300, 40, 500, 70);
        add(Text);
        Text.setFont(new Font("Osward", Font.BOLD,25));
        JLabel card=new JLabel("Card No:");
        card.setFont(new Font("Mukta",Font.BOLD,20));
        card.setBounds(270, 120, 300, 40);
        add(card);
         CardTextField=new JTextField();
        CardTextField.setBounds(370,130,200,20);
        CardTextField.setFont(new Font("Arial",Font.BOLD,10));
        add(CardTextField);
        JLabel pin=new JLabel("PIN:");
        pin.setFont( new Font("Mukta",Font.BOLD,20));
        pin.setBounds(270,160,300,50);
        add(pin);
         pinno=new JPasswordField();
        pinno.setBounds(370,180,200,20);
        add(pinno);
        pinno.setFont(new Font("Arial",Font.BOLD,10));
         login=new JButton("Sign In");
        login.setBounds(370, 220, 90, 30);
        login.setBackground(blue);
        login.setForeground(white);
        login.addActionListener(this);
        add(login);
         clear=new JButton("clear");
        clear.setBounds(485,220,85,30);
        clear.setBackground(blue);
        clear.setForeground(white);
        clear.addActionListener(this);
        add(clear);
        signup=new JButton("Sign up");
        signup.setBounds(370, 260, 200, 30);
         signup.setBackground(blue);
         signup.setForeground(white);
         signup.addActionListener(this);
        add( signup);  
       
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==clear){
        CardTextField.setText("  ");
        pinno.setText(" ");
        }   else if(e.getSource()==login){
            conn c=new conn();
            String cardnumber=CardTextField.getText();
            String pinnumber=pinno.getText();
            String queery="select * from login where cardnumber='"+cardnumber+"' and pin='"+pinnumber+"'";
            try{
                ResultSet rs=c.S.executeQuery(queery);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card number or pin");
                }
            }catch(Exception ea){
                System.out.println(ea);
                
            }
            
        }
        else if(e.getSource()==signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    public static void main(String args[]) {
        
        new Login();
    }
}
    

    
