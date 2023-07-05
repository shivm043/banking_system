
package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import static java.awt.Color.black;
import static java.awt.Color.blue;
import static java.awt.Color.white;
import java.util.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser; 


import java.awt.event.*;
 
 
public class SignupOne extends JFrame implements ActionListener{
   Long random ;
    JTextField   nameTextField, fnameTextField,dobTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField
            ;
            JRadioButton male , female,married,Unmarried,other;
                    JButton next;
                      JDateChooser dateChooser;
   
    SignupOne(){
        setLayout(null);
        Random run=new Random();
         random=Math.abs((run.nextLong()%9000L)+1000L);
        JLabel  formno=new JLabel("APPLICATION FORM NO ." +random);
        formno.setBounds(300, 20, 800, 40);
        formno.setFont(new Font("Arial",Font.BOLD,28));
        add(formno);
        
        setSize(850,800);
        setLocation(300,20);
        setVisible(true);
        getContentPane().setBackground(white);
        formno.setHorizontalAlignment(JLabel.CENTER);
        
        JLabel PDetail=new JLabel("Page 1: Personal Details");
        PDetail.setBounds(390,70,600,30);
        PDetail.setFont(new Font("Arial",Font.BOLD,20));
          add(PDetail);
          PDetail.setHorizontalAlignment(JLabel.CENTER);
          
          JLabel name= new JLabel("Name:");
           name.setBounds(420,120,200,30);
           name.setFont(new Font("Arial",Font.BOLD,20));
           add(name);
           
            nameTextField=new JTextField();
           nameTextField.setBounds(550,125,400,20);
           nameTextField.setFont(new Font("Arial",Font.BOLD,10));
           add(nameTextField);
           
           JLabel fname= new JLabel("Father's Name:");
           fname.setBounds(420,170,200,25);
           fname.setFont(new Font("Arial",Font.BOLD,16));
           add(fname);
           
            fnameTextField=new JTextField();
           fnameTextField.setBounds(550,170,400,20);
           fnameTextField.setFont(new Font("Arial",Font.BOLD,10));
           add(fnameTextField);
           
            JLabel dob= new JLabel("Date of Birth:");
           dob.setBounds(420,210,200,25);
           dob.setFont(new Font("Arial",Font.BOLD,16));
           add(dob );
           
            dateChooser=new JDateChooser();
           dateChooser.setBounds(550,210,400,20);
           add(dateChooser);
           
            JLabel gender= new JLabel("Gender:");
           gender.setBounds(420,250,200,25);
           gender.setFont(new Font("Arial",Font.BOLD,16));
           add(gender);
           
           male=new JRadioButton("male");
           male.setBounds(550,250,100,20);
           add(male);
           male.setBackground(white);
           female=new JRadioButton("female");
           female.setBounds(700,250,100,20);
           add(female);
           female.setBackground(white);
           ButtonGroup GenderGroup=new ButtonGroup();
           GenderGroup.add(male);
           GenderGroup.add(female);
           
           
            JLabel email= new JLabel("Email Address:");
           email.setBounds(420,290,200,25);
           email.setFont(new Font("Arial",Font.BOLD,16));
           add(email);
           
           emailTextField=new JTextField();
           emailTextField.setBounds(550,290,400,20);
           emailTextField.setFont(new Font("Arial",Font.BOLD,10));
           add(emailTextField);
           
            JLabel marital= new JLabel("Marital Status:");
           marital.setBounds(420,330,200,25);
          marital.setFont(new Font("Arial",Font.BOLD,16));
           add(marital);
           
           married=new JRadioButton("Married");
           married.setBounds(550,330,100,20);
           add(married);
           married.setBackground(white);
           Unmarried= new JRadioButton("UnMarried");
           Unmarried.setBounds(700,330,100,20);
           add(Unmarried);
           Unmarried.setBackground(white);
           other=new JRadioButton("other");
           other.setBounds(900,330,100,20);
           add(other);
           ButtonGroup MrriedGroup=new ButtonGroup();
           MrriedGroup.add(married);
           MrriedGroup.add(Unmarried);
           MrriedGroup.add(other);
           other.setBackground(white);
            JLabel address= new JLabel("Address:");
           address.setBounds(420,380,200,25);
           address.setFont(new Font("Arial",Font.BOLD,16));
           add(address);
           
            addressTextField=new JTextField();
           addressTextField.setBounds(550,380,400,20);
           addressTextField.setFont(new Font("Arial",Font.BOLD,10));
           add(addressTextField);
           
            JLabel city= new JLabel("City:");
           city.setBounds(420,440,200,25);
           city.setFont(new Font("Arial",Font.BOLD,16));
           add(city);
           cityTextField=new JTextField();
           cityTextField.setBounds(550,440,400,20);
           cityTextField.setFont(new Font("Arial",Font.BOLD,10));
           add(cityTextField);
            JLabel state= new JLabel("State:");
           state.setBounds(420,490,200,25);
           state.setFont(new Font("Arial",Font.BOLD,16));
           add(state);
            stateTextField=new JTextField();
           stateTextField.setBounds(550,490,400,20);
           stateTextField.setFont(new Font("Arial",Font.BOLD,10));
           add(stateTextField);
            JLabel pin= new JLabel("Pincode:");
           pin.setBounds(420,540,200,25);
           pin.setFont(new Font("Arial",Font.BOLD,16));
           add(pin);
           pinTextField=new JTextField();
           pinTextField.setBounds(550,540,400,20);
           pinTextField.setFont(new Font("Arial",Font.BOLD,10));
           add(pinTextField);
           next=new JButton("Next");
           next.setBounds(850,580,100,40);
           next.setBackground(black);
           next.setForeground(white);
           next.addActionListener(this);
           
           
           add(next);
          
           }
    public void actionPerformed(ActionEvent ae){
        
       String formno=" "+random;
       String name=nameTextField.getText();
       String fname=fnameTextField.getText();
       String dob=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
       String gender=null;
       if(male.isSelected()){
           gender="Male";
       }
       else if(female.isSelected()){
           gender="female";
       }
       String email=emailTextField.getText();
       
       String marital =null;
       if(married.isSelected()){
           marital="married";
    }
       else if(Unmarried.isSelected()){
           marital="UnMarried";
       }
       else if(other.isSelected()){
          marital="other"; 
       }
       String address=addressTextField.getText();
       String city=cityTextField.getText();
       String state=stateTextField.getText();
       String pin=pinTextField.getText();
       
       try{
           if(name.equals("")){
               JOptionPane.showMessageDialog(null,"Name is Required");
           }
           if(fname.equals("")){
               JOptionPane.showMessageDialog(null,"fatherName is Required");
               
           }
            if(dob.equals("")){
               JOptionPane.showMessageDialog(null,"date of birth is Required");
           }
           else{
               conn C=new conn();
            String queryy="insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"')";
          
             
                C.S.executeUpdate(queryy);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
                new SignupThree(formno).setVisible(true);
           }
       }catch(Exception e){
           System.out.println(e);
       }  
    }
    public static void main(String args[]) {
        new SignupOne();
    }
}

