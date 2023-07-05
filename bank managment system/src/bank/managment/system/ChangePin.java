package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import static java.awt.Color.black;
import static java.awt.Color.white;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;

public class ChangePin extends JFrame implements ActionListener{
    JTextField newpin,rewpin;
    JButton change;
    String pinnumber;
ChangePin(String pinnumber){
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
         JLabel select=new JLabel ("CHANGE YOUR PIN");
        select.setBounds(250,280,400,15);
        select.setFont(new Font("System",Font.BOLD,15));
        label.add(select);
        select.setForeground(white);
        JLabel NEW=new JLabel("New PIN:");
        NEW.setBounds(180,310,100,15);
        NEW.setFont(new Font("System",Font.BOLD,12));
        label.add(NEW);
        NEW.setForeground(white);
        newpin=new JTextField();
        newpin.setBounds(290,308,150,17);
        newpin.setFont(new Font("Arial",Font.BOLD,10));
        label.add(newpin);
         JLabel re=new JLabel("Re-Enter New Pin:");
        re.setBounds(180,350,150,15);
        re.setFont(new Font("System",Font.BOLD,12));
        label.add(re);
        re.setForeground(white);
        rewpin=new JTextField();
        rewpin.setBounds(290,350,150,17);
        rewpin.setFont(new Font("Arial",Font.BOLD,10));
        label.add(rewpin);
         change=new JButton("CHANGE");
        change.setBounds(350,425,100,22);
        change.setFont(new Font("System",Font.BOLD,8));
        change.setBackground(white);
        change.setForeground(black);
        label.add(change);
        change.addActionListener(this);
        
        JButton exit=new JButton("back");
        exit.setBounds(350,450,100,22);
        exit.setFont(new Font("System",Font.BOLD,8));
        exit.setBackground(white);
        exit.setForeground(black);
        label.add(exit);
        exit.addActionListener(this);
        setVisible(true);
       // setUndecorated(true);
}
        public void actionPerformed(ActionEvent e) {
                            if(e.getSource()==change){
            try{
                
                String npin=newpin.getText();
                String rpin=rewpin.getText();
                
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Enter pin does not match");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"please Enter new npin");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"please re-Enter new pin");
                    return;
                }
                conn c=new conn();
                String query1="update Bank set pinnumber='"+rpin+"' where pinnumber='"+pinnumber+"'";
                 String query2="update login set pin='"+rpin+"' where pin='"+pinnumber+"'";
                 String query3="update SignupThree set pin='"+rpin+"' where pin='"+pinnumber+"'";
                 c.S.executeUpdate(query1);
                 c.S.executeUpdate(query2);
                 c.S.executeUpdate(query3);
                 JOptionPane.showMessageDialog(null,"pin changed sussefuly");
                 setVisible(false);
                 new Transaction(pinnumber).setVisible(true);

            }
            catch(Exception ea){
                    System.out.println(ea);
                
            }
                            }else {
                                setVisible(false);
                                new Transaction(pinnumber).setVisible(true);
                            }
            
   
    
}
    public static void main(String args[]) {
      new   ChangePin("");
      
    }

   
    
}
