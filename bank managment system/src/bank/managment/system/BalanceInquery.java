
package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import static java.awt.Color.black;
import static java.awt.Color.white;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.*;



public class BalanceInquery extends JFrame implements ActionListener {
    String pinnumber;
    BalanceInquery(String pinnumber){
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
       JButton  back=new JButton("Back");
        back.setBounds(350,455,100,22);
        back.setFont(new Font("System",Font.BOLD,8));
        back.setBackground(white);
        back.setForeground(black);
        label.add(back);
        back.addActionListener(this);
         
          int balance=0;
          conn c=new conn();
             try{
                 ResultSet rs=c.S.executeQuery("select * from Bank where pinnumber = '"+pinnumber+"'");
               
                 while(rs.next()){
                     if(rs.getString("type").equals("dep")){
                         balance+= Integer.parseInt(rs.getString("amount"));
                     }else{
                         balance-= Integer.parseInt(rs.getString("amount"));
                     }
                 }
             }
                 catch(Exception e){
                     System.out.println(e);
                         
                         }
              JLabel amount=new JLabel("your current bank balance is  "  +balance);
        amount.setBounds(210,280,400,15);
        amount.setFont(new Font("Arial",Font.BOLD,12));
        label.add(amount);
        amount.setForeground(white);
        setUndecorated(true);
        
    }
     public void actionPerformed(ActionEvent a) {
         setVisible(false);
         new Transaction(pinnumber).setVisible(true);
        
    }
    

public static void main(String args[]){
    new BalanceInquery(" ");

}

}