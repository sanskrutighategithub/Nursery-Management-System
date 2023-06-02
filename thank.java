import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class thank extends JFrame
 {
   JLabel th,part,name1,name2,name3,guide,l3;
   JButton exit;
   ImageIcon  thanks;
  public thank()
  {
     setLayout(null);
     setTitle(" EVERGREEN HOTHOUSE NURSERY ");

/*
	thanks = new ImageIcon("/root/finalproject/LILY.JPG");

       l3 = new JLabel("",thanks,JLabel.CENTER);

       l3.setBounds(5,5,190,230);

       add(l3);


  l1=new JLabel("WELCOME TO GREENLAND PLANT NURSURY");
     l1.setFont(new Font("Courier",Font.BOLD|Font.ITALIC,36));
     l1.setBounds(100,120,800,45);
        l1.setBackground(new Color(254,224,204));
     add(l1);
*/
  th=new JLabel("**THANK YOU FOR USING THIS SOFTWARE**");
 th.setFont(new Font("Times New Roman",Font.BOLD|Font.ITALIC,22));
   th.setBounds(100,40,550,150);

 add(th);

  part=new JLabel("PROJECT BY :-");
part.setFont(new Font("Courier",Font.BOLD|Font.ITALIC,22));

 part.setBounds(80,200,260,50);
  add(part);

  name1=new JLabel("Sanskruti Ghate");
 name1.setFont(new Font("Courier",Font.BOLD|Font.ITALIC,20));
  name1.setBounds(250,230,250,50);
  add(name1);

  name2=new JLabel("Radhika Parkhi");
 name2.setFont(new Font("Courier",Font.BOLD|Font.ITALIC,20));

  name2.setBounds(250,260,250,50);
  add(name2);

  guide=new JLabel("PROJECT GUIDE :-");
  guide.setFont(new Font("Courier",Font.BOLD|Font.ITALIC,22));

  guide.setBounds(80,290,300,70);
  add(guide);

  name3=new JLabel("Saee Joshi");
 name3.setFont(new Font("Courier",Font.BOLD|Font.ITALIC,20));

  name3.setBounds(250,320,350,80);
  add(name3);

  exit=new JButton("EXIT");
  exit.setBounds(335,430,100,50);
 exit.addActionListener (new myexit());
  add(exit);

       thanks = new ImageIcon("nursery6.jpg");

       l3 = new JLabel("",thanks,JLabel.CENTER);

       l3.setBounds(1,1,750,590);

       add(l3);


 setSize(750,640);
  setVisible(true);
  setLocation(300,500);
 setDefaultCloseOperation(EXIT_ON_CLOSE);
// setLayout(null);
  }


 public static void main(String args[])
 {
  thank t=new thank();
 }


 class myexit implements ActionListener
 {
  public void actionPerformed(ActionEvent ae)
  {
    System.exit(0);
  }
 }
}
