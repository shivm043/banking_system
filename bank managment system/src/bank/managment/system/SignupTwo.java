
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
 
public class SignupTwo  extends JFrame implements ActionListener {
 JTextField   emailTextField,panTextField,adharTextField;
            ;
 JComboBox   religion,Category,Income,Education;
         JRadioButton  yes,n,y,number;
         JButton next;
         String formno;
    
    
    
    
    SignupTwo (String formno){
        setLayout(null);
         setSize(850,800);
        setLocation(300,20);
        setVisible(true);
        getContentPane().setBackground(white);
        
        
        JLabel PDetail=new JLabel("Page 2: Additional Details");
        PDetail.setBounds(390,70,600,30);
        PDetail.setFont(new Font("Arial",Font.BOLD,20));
          add(PDetail);
          PDetail.setHorizontalAlignment(JLabel.CENTER);
          
           JLabel name= new JLabel("Religion:");
           name.setBounds(420,120,200,30);
           name.setFont(new Font("Arial",Font.BOLD,20));
           add(name);
           
           
           String valReligion[]={"Hindu","Muslim","shikh","Christian","other"};
           religion=new JComboBox(valReligion);
           religion.setBounds(580,120,400,20);
           add(religion);
           
           JLabel category= new JLabel("Category:");
           category.setBounds(420,160,200,30);
           category.setFont(new Font("Arial",Font.BOLD,20));
           add(category);
           
            String valCategory[]={"Genral","OBC","st-sc"};
           Category=new JComboBox(valCategory);
           Category.setBounds(580,160,400,20);
           add(Category);
                       
           
           
           JLabel dob= new JLabel("Income:");
           dob.setBounds(420,210,200,25);
           dob.setFont(new Font("Arial",Font.BOLD,16));
           add(dob );
           
            String valIncome[]={"null","under 2lakhs","between 2 to 10 lakhs","above 10 lakhs"};
           Income=new JComboBox(valIncome);
           Income.setBounds(580,210,400,20);
           add(Income);
           
             JLabel Educational= new JLabel("Educational");
           Educational.setBounds(420,260,200,25);
           Educational.setFont(new Font("Arial",Font.BOLD,16));
           add(Educational );
           JLabel Qualification= new JLabel("Qualification:");
           Qualification.setBounds(420,280,200,25);
           Qualification.setFont(new Font("Arial",Font.BOLD,16));
           add(Qualification );
            String valEducation[]={"school","collage","non-garguate","gratuade","phd"};
           Education=new JComboBox(valEducation);
           Education.setBounds(580,280,400,20);
           add(Education);
           

           
            JLabel occupation= new JLabel("Occuptaion:");
           occupation.setBounds(420,340,200,25);
           occupation.setFont(new Font("Arial",Font.BOLD,16));
           add(occupation );
           emailTextField=new JTextField();
           emailTextField.setBounds(580,340,400,20);
           emailTextField.setFont(new Font("Arial",Font.BOLD,10));
           add(emailTextField);
           
             JLabel panNumber= new JLabel("PANnumber:");
           panNumber.setBounds(420,390,200,25);
           panNumber.setFont(new Font("Arial",Font.BOLD,16));
           add(panNumber);
             panTextField=new JTextField();
           panTextField.setBounds(580,390,400,20);
           panTextField.setFont(new Font("Arial",Font.BOLD,10));
           add(panTextField);
           
            JLabel AdharNumber= new JLabel("AdharNumber:");
           AdharNumber.setBounds(420,430,200,25);
           AdharNumber.setFont(new Font("Arial",Font.BOLD,16));
           add(AdharNumber);
           
            adharTextField=new JTextField();
           adharTextField.setBounds(580,430,400,20);
           adharTextField.setFont(new Font("Arial",Font.BOLD,10));
           add(adharTextField);
           
              JLabel SeniorCitizen= new JLabel("SeniorCitizen:");
           SeniorCitizen.setBounds(420,480,200,25);
           SeniorCitizen.setFont(new Font("Arial",Font.BOLD,16));
           add(SeniorCitizen);
           
            yes=new JRadioButton("YES");
           yes.setBounds(580, 480, 100, 20);
           add(yes);
           yes.setBackground(white);
           
             n=new JRadioButton("NO");
           n.setBounds(700, 480, 100, 20);
           add(n);
           n.setBackground(white);
           
            JLabel ExistingAccount= new JLabel("ExistingAccount:");
           ExistingAccount.setBounds(420,520,200,25);
           ExistingAccount.setFont(new Font("Arial",Font.BOLD,16));
           add(ExistingAccount);
            y=new JRadioButton("YES");
           y.setBounds(580, 520, 100, 20);
           add(y);
           y.setBackground(white);
           
           
           
           number=new JRadioButton("NO");
           number.setBounds(700, 520, 100, 20);
           add(number);
           number.setBackground(white);
           
           
           
           
           
           
           
           next=new JButton("Next");
           next.setBounds(880,580,100,40);
           next.setBackground(black);
           next.setForeground(white);
           next.addActionListener(this);
    
           
           add(next);
}
            public void actionPerformed(ActionEvent e) {
                
                String sreligion=(String) religion.getSelectedItem();
                String sCategory=(String ) Category.getSelectedItem();
                String sincome=(String) Income.getSelectedItem();
                String education=(String) Education.getSelectedItem();
                String occupation=emailTextField.getText();
                String pan=panTextField.getText();
                String  adhar=adharTextField.getText();
                String siniorcitizon=null;
                if(yes.isSelected()){
                    siniorcitizon="yes";
                }
                else if(n.isSelected()){
                    siniorcitizon="no";
                }
                String ExistingAccount=null;
                if(y.isSelected()){
                    ExistingAccount="yes";
                    
                    
                    
                }
                else if(number.isSelected()){
                    siniorcitizon="no";
                }
                 try{
           if(sreligion.equals("")){
               JOptionPane.showMessageDialog(null,"Name is Required");
               
           }
           else{
               conn C=new conn();
            String queryy="insert into signuptwo values('"+sreligion+"', '"+sCategory+"', '"+sincome+"', '"+education+"', '"+ occupation+"', '"+pan+"', '"+adhar+"', '"+siniorcitizon+"','"+ExistingAccount+"')";
          
             
                C.S.executeUpdate(queryy);
                setVisible(false);
                new SignupThree(formno).setVisible(true);
           } 
       }catch(Exception ea){
           System.out.println(ea);
       }  
        
    
}
          
           
           
    
    public static void main(String args[]) {
         new SignupTwo("");

 
    }
}
    
   

