package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import static java.awt.Color.black;
import static java.awt.Color.white;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.*;


public class Deposite extends JFrame implements ActionListener{
    JButton dep,back;
       JTextField  balance;
       String pinnumber;
    Deposite(String pinnumber){
        this.pinnumber=pinnumber;
          setSize(800,800);
        setLocation(300,0);
        setVisible(true);
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label= new JLabel(i3);
        label.setBounds(300,0,800,800);
        add(label);
        JLabel amount=new JLabel("Enter amount you want to Deposite");
        amount.setBounds(210,280,400,15);
        amount.setFont(new Font("Arial",Font.BOLD,12));
        label.add(amount);
        amount.setForeground(white);
        balance=new JTextField();
        balance.setBounds(210,310,200,22);
        balance.setFont(new Font("Arial",Font.BOLD,10));
           label.add(balance);
        dep=new JButton("Deposite");
        dep.setBounds(350,425,100,22);
        dep.setFont(new Font("System",Font.BOLD,8));
        dep.setBackground(white);
        dep.setForeground(black);
        label.add(dep);
        dep.addActionListener(this);
        
        back=new JButton("Back");
        back.setBounds(350,450,100,22);
        back.setFont(new Font("System",Font.BOLD,8));
        back.setBackground(white);
        back.setForeground(black);
        label.add(back);
        back.addActionListener(this);
        
    }
     public void actionPerformed(ActionEvent e) {
         if (e.getSource()==dep){
             String number=balance.getText();
             Date date = new Date();
             if(number.equals("")){
                 JOptionPane.showMessageDialog(null,"please inter the amount you want");
             }else {
                 try{
                     
                 
                 conn c=new conn();
                 String query="insert into Bank values('"+pinnumber+"','"+date+"','dep','"+number+"')";
                 c.S.executeUpdate(query);
                 JOptionPane.showMessageDialog(null,"RS "+number+" deposite succcesful");
                 new Transaction(pinnumber).setVisible(true);
                 
             } catch(Exception ae){
                 System.out.println(ae);
             }
                 
             }
             
         }
         else if(e.getSource()==back){
             setVisible(false);
             new Transaction(pinnumber).setVisible(true);
             
             
         }
         
    }
public static void main (String args[]){
   new Deposite("");
}

   
}

