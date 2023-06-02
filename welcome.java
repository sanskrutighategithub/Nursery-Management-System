import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Image;
import java.lang.*;

public class welcome extends JFrame implements ActionListener
{
  public static welcome instance;
  JLabel part,name1,name2,guide,name3,l1,lab,labl;
  JButton proceed;
  ImageIcon pro,backgr,bkgr;

public welcome()
{
  setLayout(null);
  //setBackground(Color.cyan);
  setTitle(" EVERGREEN HOTHOUSE NURSERY ");

     l1=new JLabel("WELCOME TO EVERGREEN HOTHOUSE NURSERY ");
     l1.setFont(new Font("Times New Roman",Font.BOLD|Font.ITALIC,35));
     l1.setBounds(100,120,860,45);
	l1.setBackground(new Color(254,224,204));
     add(l1);

	part=new JLabel("The Best Place For Beautiful Plants And Flowers");
	part.setFont(new Font("Algerian",Font.BOLD,22));
	part.setBounds(200,180,650,150);
	part.setBackground(new Color(204,204,204));
	add(part);

  name1=new JLabel("WE HELP U TO ADD COLORS TO UR LIFE");
  name1.setFont(new Font("Courier",Font.BOLD,25));
  name1.setBounds(250,240,600,150);
  name1.setBackground(new Color(204,204,204));
	add(name1);

	pro = new ImageIcon ("forward.jpg" ) ;

  proceed=new JButton("PROCEED", pro);
  proceed.setBounds(450,420,190,45);
  proceed.addActionListener(this);
  add(proceed);

	backgr = new ImageIcon("rose.jpg");

       lab = new JLabel("",backgr,JLabel.CENTER);

       lab.setBounds(490,120,600,750);

       add(lab);


  bkgr = new ImageIcon("rose.jpg");

       labl = new JLabel("",bkgr,JLabel.CENTER);

       labl.setBounds(3,120,600,750);

       add(labl);



  setSize(1000,800);
  setVisible(true);
  setLocation(350,200);
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public static void main(String args[])
  {
     instance = new welcome();
	instance.show();
  }

     public void actionPerformed(ActionEvent ae)
         {
           if(ae.getActionCommand()=="PROCEED")
           {
            Item m= new Item();
		    m.show();

           }
}
}
