package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import static java.awt.Color.black;
import static java.awt.Color.blue;
import static java.awt.Color.white;
import java.util.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 class SignupThree  extends JFrame  implements ActionListener{
     JRadioButton  saving,fixed,current,recurring;
     JCheckBox c1,c2,c3,c4,c5,c6,c7;
     JButton submit,cancel;
     String formno;
     
     SignupThree(String formno){
         this.formno=formno;
          setLayout(null);
         setSize(850,800);
        setLocation(300,20);
        setVisible(true);
        getContentPane().setBackground(white);
        
        
        JLabel PDetail=new JLabel("Page 3: Account Details");
        PDetail.setBounds(390,70,600,30);
        PDetail.setFont(new Font("Arial",Font.BOLD,20));
          add(PDetail);
          PDetail.setHorizontalAlignment(JLabel.CENTER);
          
          JLabel accounttype=new JLabel("Account Type");
          accounttype.setBounds(420,140,400,30);
          accounttype.setFont(new Font("Arial",Font.BOLD,20));
          add(accounttype);
          
          
          saving=new JRadioButton("Saving Account");
          saving.setBounds(420,180,150,20);
          add(saving);
          saving.setBackground(white);
          
          fixed=new JRadioButton("Fixed Deposite Account");
          fixed.setBounds(600,180,300,20);
          add(fixed);
          fixed.setBackground(white);
          
          current=new JRadioButton("Current Account");
          current.setBounds(420,210,150,20);
          add(current);
          current.setBackground(white);
          
          recurring=new JRadioButton("Recurring Deposite Account");
          recurring.setBounds(600,210,300,20);
          add(recurring);
          recurring.setBackground(white);
          
           JLabel cardno=new JLabel("Card Number");
          cardno.setBounds(420,270,400,30);
          cardno.setFont(new Font("Arial",Font.BOLD,20));
          add(cardno);
          JLabel card=new JLabel("your 16 digits card number");
          card.setBounds(420,300,400,12);
          card.setFont(new Font("Arial",Font.BOLD,12));
          add(card);
          
          JLabel number=new JLabel("XXXX-XXXX-XXXX-4184");
          number.setBounds(630,270,400,40);
          number.setFont(new Font("Arial",Font.BOLD,30));
          add(number);
          
          JLabel pin=new JLabel("PIN:");
          pin.setBounds(420,340,400,30);
          pin.setFont(new Font("Arial",Font.BOLD,20));
          add(pin);
          
           JLabel p=new JLabel("your 4 digits password");
          p.setBounds(420,370,400,12);
          p.setFont(new Font("Arial",Font.BOLD,12));
          add(p);
          
          JLabel n=new JLabel("XXXX");
          n.setBounds(630,340,400,40);
          n.setFont(new Font("Arial",Font.BOLD,30));
          add(n);
          
           JLabel service=new JLabel("Services Required:");
          service.setBounds(420,410,400,30);
          service.setFont(new Font("Arial",Font.BOLD,20));
          add(service);
          
           c1=new JCheckBox("Atm Card");
          c1.setBounds(420,450,150,12);
          c1.setFont(new Font("Arial",Font.BOLD,12));
          add(c1);
          c1.setBackground(white);
          
          c2=new JCheckBox("Internet Banking");
          c2.setBounds(620,450,250,12);
          c2.setFont(new Font("Arial",Font.BOLD,12));
          add(c2);
          c2.setBackground(white);
          
          
          c3=new JCheckBox("Mobile Banking");
          c3.setBounds(420,480,150,12);
          c3.setFont(new Font("Arial",Font.BOLD,12));
          add(c3);
          c3.setBackground(white);
          
          c4=new JCheckBox("Email & SMS Alerts");
          c4.setBounds(620,480,400,12);
          c4.setFont(new Font("Arial",Font.BOLD,12));
          add(c4);
          c4.setBackground(white);
          
          c5=new JCheckBox("Cheque Book");
          c5.setBounds(420,510,150,12);
          c5.setFont(new Font("Arial",Font.BOLD,12));
          add(c5);
          c5.setBackground(white);
          
          c6=new JCheckBox("E Statement");
          c6.setBounds(620,510,150,12);
          c6.setFont(new Font("Arial",Font.BOLD,12));
          add(c6);
          c6.setBackground(white);
          
          c7=new JCheckBox("i hereby declares that the above entered details are correct to the best of my knowledge");
          c7.setBounds(420,600,600,12);
          c7.setFont(new Font("Arial",Font.BOLD,12));
          add(c7);
          c7.setBackground(white);
          submit=new JButton("Submit");
           submit.setBounds(530,630,100,30);
           submit.setBackground(black);
           submit.setForeground(white);
           submit.addActionListener(this);
           add(submit);
           
            cancel=new JButton("Cancel");
           cancel.setBounds(720,630,100,30);
           cancel.setBackground(black);
           cancel.setForeground(white);
           cancel.addActionListener(this);
           add(cancel);
           
          
          
          
     }
     public void actionPerformed(ActionEvent e) {
         
         if(e.getSource()==submit){
             String Accounttype=null;
             if(saving.isSelected()){
                 Accounttype="Saving Account";
             }
             else if(fixed.isSelected()){
                 Accounttype="Fixed Deposite Account";
    }
             else if(current.isSelected()){
                 Accounttype="Current Account";
                 
             }
             else if(recurring.isSelected()){
                 Accounttype="Recurring Deposite Account";
             }
             
             
             Random random = new Random();
             String cardno=""+ Math.abs((random.nextLong()%90000000)+ 5040936000000000L);
             
             String pin=""+Math.abs((random.nextLong()%9000L)+1000L);
             
             String Facility=" ";
             if(c1.isSelected()){
                 Facility=Facility+"Atm Card";
             
             }
             else if(c2.isSelected()){
                 Facility=Facility+"Internet Banking";
             
             }
                 
             
             else if(c3.isSelected()){
                 Facility=Facility+"Mobile Banking";
             
             
             }
             else if(c4.isSelected()){
                 Facility=Facility+"Email & SMS Alerts";
             
             
                 
             }
             else if(c5.isSelected()){
                 Facility=Facility+"Cheque Book";
             
             
                 
             }
              else if(c6.isSelected()){
                  Facility=Facility+"E Statement";
                 
             }
             try{
                 if(Accounttype.equals("")){
                     JOptionPane.showMessageDialog(null,"Account type is required");
                 }
                 else{
                     conn Cr=new conn();
                     String query="insert into SignupThree values('"+formno+"', '"+Accounttype+"', '"+cardno+"', '"+pin+"', '"+Facility +"')";
                     String query2="insert into login values('"+formno+"', '"+cardno+"', '"+pin+"')";
                     Cr.S.executeUpdate(query);
                     Cr.S.executeUpdate(query2);
                     setVisible(false);
                     new SignupTwo(formno).setVisible(true);
                     
                      JOptionPane.showMessageDialog(null, "Card Number: " + cardno+"\n pin : "+pin);
                      setVisible(false);
                      new Deposite(pin).setVisible(false);
                      
                 }
                 
             }catch(Exception ae){
                 System.out.println(ae);
             }
                 
         }
         
         
         
             else if(e.getSource()==cancel){
                 setVisible(false);
                 new Login().setVisible(true);
                 
                 
                 }
     }

    public static void main(String args[]) {
        
       new  SignupThree("");
        }

}
