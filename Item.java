import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;
import java.util.*;
import java.io.*;

public class Item  extends JFrame
  {

  	JLabel jlabel,jlabel1,jlabel2,name;
        img i;
 	JPanel p,p1;
 	JButton b0=new JButton("PURCHASE ENTRY");
        JButton b6=new JButton("SALES ENTRY");
 	JButton b5=new JButton("QUIT");
 	JButton b7=new JButton("STOCK REPORT");


public Item()
 	{
 		setSize(900,800);
 		setTitle(" EVERGREEN HOTHOUSE NURSERY ");
 		Container c=this.getContentPane();
 		c.setLayout(null);
     	        i=new img();
 		i.setBounds(10,45,800,350);
 		c.add(i);

 		JLabel jlabel3=new JLabel(new ImageIcon("nursery1.jpg"));
 		jlabel3.setBounds(10,10,900,800);
 		c.add(jlabel3);

 	        c.add(b0);
                b0.setBounds(50,500,200,30);

 		c.add(b6);
 		b6.setBounds(270,500,150,30);

 		c.add(b5);
 		b5.setBounds(630,500,150,30);

 		c.add(b7);
 		b7.setBounds(450,500,150,30);




               b0. addActionListener(new ActionListener()
                {
                  public void actionPerformed(ActionEvent event)
                        {
                          setVisible(true);
                          OM o=new OM();
                         }
                });


 		b6.addActionListener(new ActionListener()
 		{
 		   public void actionPerformed(ActionEvent event)
 			{
   					setVisible(true);
   					ME_F str=new ME_F();
   	   			}
 		});


         	b5.addActionListener(new ActionListener()
 		{
 		   public void actionPerformed(ActionEvent event)
 			{
   				setVisible(true);
				thank t=new thank();
   			}
 		});



 		b7.addActionListener(new ActionListener()
 		{
 		   public void actionPerformed(ActionEvent event)
 			{
   					setVisible(true);
   					PDT str=new PDT();

   			}
 		});

  	}


 	public static void main(String args[])
 	{
 	    Item f=new Item();
 		f.setVisible(true);
 		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


 	}

 }


 class img extends JPanel
  {

    img()
    {
    }

    public void paintComponent(Graphics g)
 	{
 		String str=" EVERGREEN HOTHOUSE NURSURY ";
 		Font f1=new Font("Times New Roman",Font.BOLD|Font.PLAIN,38);
 	        g.setColor(Color.black);
 		g.setFont(f1);
 		g.drawString(str,55,50);
 	}

  }
