import java.lang.String.*;
import java.io.*;
import java.awt.*;
import java.awt.Font.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.awt.event.ActionListener;

class ME_F extends JFrame implements ActionListener
{
	JTextField pid,tp,pr,ed,toam,cno,cname,contact;
	JLabel c1,c2,c3,c4,c5,c6,c7,c8,cu1,cu2,cu3,l3 ;
	JButton save,clear,calculate,exit,ac,us;
	ImageIcon sal;
	//String type2,type3,type4;
	JComboBox pname,pdesc,fer;
	Connection c99,c9,c999;
	Statement s11,s0,s111;
	Calendar cal=Calendar.getInstance();
	String d=""+cal.get(Calendar.DATE)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR)+"  "+cal.get(Calendar.HOUR)+":"+(cal.get(Calendar.MINUTE)+1)+":"+cal.get(Calendar.SECOND);;


	public ME_F()
		{
			Container cp=getContentPane();
			setTitle("** SALES ENTRIES **");
			setSize(970,768);
                        setVisible(true);
                        cp.setLayout(null);
			cp.setBackground(Color.orange);

	sal = new ImageIcon("love.JPG");
       l3 = new JLabel("",sal,JLabel.CENTER);
       l3.setBounds(280,350,450,320);
       add(l3);
		c1=new JLabel("PLANT ID");
		c1.setBounds(10,30,200,20);
		cp.add(c1);

		c2=new JLabel("PLANT NAME");
		c2.setBounds(10,70,200,20);
		cp.add(c2);

		c3=new JLabel("DESCRIPTION");
		c3.setBounds(10,110,200,20);
		cp.add(c3);

		c4=new JLabel("FERTILIZER");
		c4.setBounds(10,150,200,20);
		cp.add(c4);

		c5=new JLabel(" QUANTITY ");
		c5.setBounds(10,190,200,20);
		cp.add(c5);

		c6=new JLabel("RATE");
		c6.setBounds(10,230,200,20);
		cp.add(c6);

	    c7=new JLabel("SOLD DATE");
		c7.setBounds(10,270,200,20);
		cp.add(c7);

        c8=new JLabel("TOTAL AMOUNT");
		c8.setBounds(10,310,200,20);
		cp.add(c8);



		pid=new JTextField();
		pid.setBounds(200,30,200,20);
		cp.add(pid);


		pname=new JComboBox();
		pname.setBounds(200,70,200,20);
		pname.addItem("ROSE");
		pname.addItem("TULIP");
		pname.addItem("MOGRA");
		pname.addItem("CHINA-ROSE");
 		pname.addItem("SUNFLOWER");
 		pname.addItem("ALOE");
 		pname.addItem("COCONUT");
 		pname.addItem("MANGO");
 		pname.addItem("GRAPE");
 		pname.addItem("APPLE");
 		pname.addItem("KIWI");
 		pname.addItem("BANANA");
 		pname.addItem("CHIKOO");
		pname.addItem("TULSI");
		pname.addItem("EUCALYPTUS");
		pname.addItem("LOTUS");
		pname.addItem("TEA");

		pname.setEditable(true);
		cp.add(pname);


		pdesc=new JComboBox();
		pdesc.setBounds(200,110,200,20);
		pdesc.addItem("FLOWER");
		pdesc.addItem("FRUIT");
		pdesc.addItem("MEDICINAL");
		pdesc.addItem("DECORATIVE");
		pdesc.addItem("SHRUB");
		pdesc.addItem("CACTUS");
		pdesc.addItem("AQUATIC");
		pdesc.addItem("FRAGRANCE");
		pdesc.addItem("");
		pdesc.addItem("");
		pdesc.setEditable(true);
		cp.add(pdesc);



	    	fer=new JComboBox();
		fer.setBounds(200,150,200,20);
		fer.addItem("NOT NECESSARY");
		fer.addItem("ORGANIC");
		fer.addItem("INORGANIC");
		fer.addItem("");
		fer.setEditable(true);
		cp.add(fer);


		tp=new JTextField();
		tp.setBounds(200,190,200,20);
		cp.add(tp);

		pr=new JTextField();
		pr.setBounds(200,230,200,20);
		cp.add(pr);

		ed=new JTextField();
		ed.setBounds(200,270,200,20);
		ed.setText(d);
		ed.setEditable(true);
		cp.add(ed);

		toam=new JTextField();
		toam.setBounds(200,310,200,20);
		cp.add(toam);

	    cu1=new JLabel("CUSTOMER ID");
		cu1.setBounds(500,30,200,20);
		cp.add(cu1);


		cu2=new JLabel("CUSTOMER NAME");
		cu2.setBounds(500,100,200,20);
		cp.add(cu2);


	    cu3=new JLabel("CUSTOMER CONTACT");
		cu3.setBounds(500,170,200,20);
		cp.add(cu3);


		cno=new JTextField();
	    cno.setBounds(500,60,200,20);
		cp.add(cno);

		cname=new JTextField();
		cname.setBounds(500,140,200,20);
		cp.add(cname);

	    contact=new JTextField();
		contact.setBounds(500,220,200,20);
		cp.add(contact);


		save=new JButton("SAVE");
		save.setBounds(750,50,150,20);//30,360,150,20);
		save.addActionListener(this);
		cp.add(save);

		clear=new JButton("CLEAR");
		clear.setBounds(750,100,150,20);
		clear.addActionListener(this);
		cp.add(clear);


		calculate=new JButton("CALCULATE");
		calculate.setBounds(750,150,150,20);//190,360,150,20);
		calculate.addActionListener(this);
		cp.add(calculate);

		us=new JButton("SALE");
		us.setBounds(750,200,150,20);
		us.addActionListener(this);
		cp.add(us);

		exit=new JButton("HOME");
		exit.setBounds(750,250,150,20);
		exit.addActionListener(this);
		cp.add(exit);

		ac=new JButton("ADD CUST.RECORD");
	    ac.setBounds(750,300,200,20);
		ac.addActionListener(this);
		cp.add(ac);


    }



	public void actionPerformed(ActionEvent ae)
	{
			Object source=ae.getSource();
		if(source==save)
		{

			  int type1=Integer.parseInt(pid.getText());
			  String type2=(String)pname.getSelectedItem();
          	          String type3=(String)pdesc.getSelectedItem();
	                  String type4=(String)fer.getSelectedItem();

			  int type5=Integer.parseInt(tp.getText());
			  float type6=Float.parseFloat(pr.getText());
			  String type7=ed.getText();
			  float type8=Float.parseFloat(toam.getText());
			  int type9=Integer.parseInt(cno.getText());
			  String type10=cname.getText();
			  String type11=contact.getText();

			   try
				{
					Class.forName("org.postgresql.Driver");
		c9=DriverManager.getConnection("jdbc:postgresql://localhost/agri","postgres","sans");
					s0=c9.createStatement();

				String sql1="INSERT INTO Sdetail VALUES('"+type1+"','"+type2+"','"+type3+"','"+type4+"','"+type5+"','"+type6+"','"+type7+"','"+type8+"','"+type10+"','"+type11+"')";
					s0.executeUpdate(sql1);

					JOptionPane.showMessageDialog(this,"SUCCESSFULLY SAVED IN SALES TABLE");
							c9.close();
				}catch(Exception e){}
		}


		if(source==calculate)
		{
			   int type3=Integer.parseInt(tp.getText());
			   float type4=Float.parseFloat(pr.getText());

			   float  total=type3*type4;
			   String TOTAL=String.valueOf(total);
			   toam.setText(TOTAL);

	}

		if(source==clear)
		{
			pid.setText(null);
			tp.setText(null);
			pr.setText(null);
			toam.setText(null);
			cno.setText(null);
			cname.setText(null);
			contact.setText(null);

		}


			if(source==us)
		{
		      int type1=Integer.parseInt(pid.getText());
		      String type2=(String)pname.getSelectedItem();
		      String type3=(String)pdesc.getSelectedItem();
	              String type4=(String)fer.getSelectedItem();

		      int type5=Integer.parseInt(tp.getText());
		      float type6=Float.parseFloat(pr.getText());



			  try
           {
          Class.forName("org.postgresql.Driver");
		c999=DriverManager.getConnection("jdbc:postgresql://localhost/agri","postgres","sans");
			s111=c999.createStatement();

			String sql5="select * from plant";
            ResultSet rs=s111.executeQuery(sql5);
            while(rs.next())
            {
             int arr1=rs.getInt(1);
	     String arr2=rs.getString(2);
	     String arr3=rs.getString(3);
	     String arr4=rs.getString(4);
	     float arr5=rs.getFloat(5);
	     int arr6=rs.getInt(6);
                   if((arr1==type1)&&(arr2.equals(type2))&&(arr3.equals(type3))&&(arr4.equals(type4))&&(arr5==type6))
	   	   {
                     int qt=arr6-type5;
	     	     System.out.println(qt);
	     	     s111.executeUpdate("update plant set qtyavail="+qt+" where pid="+arr1+" AND pname='"+arr2+"'AND pdesc='"+arr3+"' AND fer='"+arr4+"'AND price="+arr5+"");
	            JOptionPane.showMessageDialog(this,"CONGRATULATIONS!!!!! PLANT SOLD SUCCESFULLY");

	                       }
	          //      else    JOptionPane.showMessageDialog(this,"SORRY!!!!! PLANT NOT AVAILABLE");

			}

                    JOptionPane.showMessageDialog(this,"SORRY!!!!! PLANT NOT AVAILABLE");

                         	c999.close();
						    }
						  catch(Exception e){}


		}

			if(source==ac)
		{
		          int type9=Integer.parseInt(cno.getText());
			  String type10=cname.getText();
			  String type11=contact.getText();

			 try
			 {
			Class.forName("org.postgresql.Driver");
		c99=DriverManager.getConnection("jdbc:postgresql://localhost/agri","postgres","sans");
			   s11=c99.createStatement();

			   	String sql11="INSERT INTO customer VALUES('"+type9+"','"+type10+"','"+type11+"')";
				s11.executeUpdate(sql11);

				JOptionPane.showMessageDialog(this,"CUSTOMER RECORD INSERTED SUCCESFULLY");
				c99.close();
			 }
		   catch(Exception e){}

		}


		if(source==exit)
		{
		  dispose();
		}
	}


	  public static void main(String args[])
		{
			ME_F str=new ME_F();
			str.setSize(970,768);
			str.setVisible(true);
			str.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

}
