package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import static java.awt.Color.black;
import static java.awt.Color.white;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
         JButton deposite,fast,pin,cash,mini,balance,exit;
       String pinnumber;
     
    FastCash(String pinnumber){
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
        
        JLabel select=new JLabel ("SELECT WITHDRWAL AMOUNT");
        select.setBounds(200,280,400,15);
        select.setFont(new Font("System",Font.BOLD,15));
        label.add(select);
        select.setForeground(white);
        deposite=new JButton("Rs 100");
        deposite.setBounds(170,375,100,22);
        deposite.setBackground(white);
        deposite.setForeground(black);
        label.add(deposite);
        deposite.addActionListener(this);
        
        fast=new JButton("RS 1000");
        fast.setBounds(170,400,100,22);
        fast.setBackground(white);
        fast.setForeground(black);
        label.add(fast);
         fast.addActionListener(this);
        
        pin=new JButton("RS 10000");
        pin.setBounds(170,425,100,22);
        pin.setBackground(white);
        pin.setForeground(black);
        label.add(pin);
         pin.addActionListener(this);
        
        cash=new JButton("RS 5000");
        cash.setBounds(350,375,100,22);
         cash.setFont(new Font("System",Font.BOLD,8));
        cash.setBackground(white);
        cash.setForeground(black);
        label.add(cash);
        cash.addActionListener(this);
        
        mini=new JButton("RS 500");
        mini.setBounds(350,400,100,22);
        mini.setFont(new Font("System",Font.BOLD,8));
        mini.setBackground(white);
        mini.setForeground(black);
        label.add(mini);
        mini.addActionListener(this);
        
        balance=new JButton("RS 2000");
        balance.setBounds(350,425,100,22);
        balance.setFont(new Font("System",Font.BOLD,8));
        balance.setBackground(white);
        balance.setForeground(black);
        label.add(balance);
        balance.addActionListener(this);
        
        exit=new JButton("Exit");
        exit.setBounds(350,450,100,22);
        exit.setFont(new Font("System",Font.BOLD,8));
        exit.setBackground(white);
        exit.setForeground(black);
        label.add(exit);
        exit.addActionListener(this);
        setVisible(true);
        setUndecorated(true);
       
        
        
        
    }
      public void actionPerformed(ActionEvent e) {
          if(e.getSource()==exit){
              setVisible(false);
              new Transaction(pinnumber).setVisible(true);
              
          }
        
          else {
             String amount=((JButton)e.getSource()).getText().substring(3);
             conn c=new conn();
             try{
                 ResultSet rs=c.S.executeQuery("select * from Bank where pinnumber = '"+pinnumber+"'");
                 int balance=0;
                 while(rs.next()){
                     if(rs.getString("type").equals("dep")){
                         balance+= Integer.parseInt(rs.getString("amount"));
                     }else{
                         balance-= Integer.parseInt(rs.getString("amount"));
                     }
                 }
                 
                 if(e.getSource() !=exit && balance < Integer.parseInt(amount)){
                     JOptionPane.showMessageDialog(null,"Insufficient Balance");
                     return;
                 }
                 Date date=new Date();
                 String query="insert into Bank values('"+pinnumber+"','"+date+"', 'withdraw', '"+amount+"')";
                 c.S.executeUpdate(query);
                 JOptionPane.showMessageDialog(null,"RS"+amount+"debited sucessfully");
                 
                 setVisible(false);
                 new Transaction(pinnumber).setVisible(true);
                 
                 
                 
             }catch(Exception ae){
                 System.out.println(ae);
             }
             
          }
        
    }
    public static void main(String args[]) {
        new FastCash(" ");

    }
}

