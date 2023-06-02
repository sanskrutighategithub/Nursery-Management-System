import java.lang.String.*;
import java.io.*;
import java.awt.*;
import java.awt.Font.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.util.*;

class OM extends JFrame implements ActionListener

{
	JTextField pid,tp,pr,ed,toam,s1,s2,s3,s4;
	JLabel c1,c2,c3,c4,c5,c6,c7,c8,sno,sname,sc,sa,l3;
	JButton save,clear,calculate,exit,us,as;
	ImageIcon sal;
	JComboBox pname,pdesc,fer;
	Connection c99,c9,c999,c01;
	Statement s11,s0,s111,s01;
	Calendar cal=Calendar.getInstance();
	String d=""+cal.get(Calendar.DATE)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR)+"  "+cal.get(Calendar.HOUR)+":"+(cal.get(Calendar.MINUTE)+1)+":"+cal.get(Calendar.SECOND);;
    int flag=0;

	public OM()
		{
			Container cp=getContentPane();
			setTitle("** PURCHASE ENTRIES **");
			setSize(900,850);
                        setVisible(true);
                        cp.setLayout(null);
			cp.setBackground(Color.orange);

	sal = new ImageIcon("love.JPG");
        l3 = new JLabel("",sal,JLabel.CENTER);
        l3.setBounds(410,350,400,320);
        add(l3);

		c1=new JLabel("PLANT ID");
		c1.setBounds(20,180,200,20);
		cp.add(c1);

		c2=new JLabel("PLANT NAME");
		c2.setBounds(20,210,200,20);
		cp.add(c2);

		c3=new JLabel("DESCRIPTION");
		c3.setBounds(20,240,200,20);
		cp.add(c3);

		c4=new JLabel("FERTILIZERS");
		c4.setBounds(20,270,200,20);
		cp.add(c4);

		c5=new JLabel(" QUANTITY ");
		c5.setBounds(20,300,200,20);
		cp.add(c5);

		c6=new JLabel("RATE");
		c6.setBounds(20,330,200,20);
		cp.add(c6);

	    c7=new JLabel("PURCHASE DATE");
		c7.setBounds(20,360,200,20);
		cp.add(c7);

        c8=new JLabel("TOTAL AMOUNT");
		c8.setBounds(20,390,200,20);
		cp.add(c8);



		pid=new JTextField();
		pid.setBounds(170,180,200,20);
		cp.add(pid);

		pname=new JComboBox();
		pname.setBounds(170,210,200,20);
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

		cp.add(pname);

		pdesc=new JComboBox();
		pdesc.setBounds(170,240,200,20);
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
		fer.setBounds(170,270,200,20);
		fer.addItem("NOT NECESSARY");
		fer.addItem("ORGANIC");
		fer.addItem("INORGANIC");
		fer.addItem("");
		fer.setEditable(true);
		cp.add(fer);


		tp=new JTextField();
		tp.setBounds(170,300,200,20);
		cp.add(tp);

		pr=new JTextField();
		pr.setBounds(170,330,200,20);
		cp.add(pr);

		ed=new JTextField();
		ed.setBounds(170,360,200,20);
		ed.setText(d);
		ed.setEditable(true);
		cp.add(ed);

		toam=new JTextField();
		toam.setBounds(170,390,200,20);
		cp.add(toam);


	    sno=new JLabel("SUPPLIER ID");
		sno.setBounds(20,20,200,20);
		cp.add(sno);


		sname=new JLabel("SUPPLIER NAME");
		sname.setBounds(20,50,200,20);
		cp.add(sname);


	    sc=new JLabel("SUPPLIER CONTACT");
		sc.setBounds(20,80,200,20);
		cp.add(sc);

		sa=new JLabel("SUPPLIER ADDRESS");
		sa.setBounds(20,110,200,20);
		cp.add(sa);

		s1=new JTextField();
		s1.setBounds(170,20,200,20);
		cp.add(s1);

		s2=new JTextField();
		s2.setBounds(170,50,200,20);
		cp.add(s2);

	    s3=new JTextField(12);
		s3.setBounds(170,80,200,20);
		cp.add(s3);

		s4=new JTextField();
		s4.setBounds(170,110,200,20);
		cp.add(s4);

		save=new JButton("SAVE");
		save.setBounds(450,250,150,30);
		save.addActionListener(this);
		cp.add(save);

		clear=new JButton("CLEAR");
		clear.setBounds(450,100,150,30);
		clear.addActionListener(this);
		cp.add(clear);


		calculate=new JButton("CALCULATE");
		calculate.setBounds(450,150,150,30);
		calculate.addActionListener(this);
		cp.add(calculate);

	        us=new JButton("PURCHASE");
		us.setBounds(450,200,150,30);
		us.addActionListener(this);
		cp.add(us);


		exit=new JButton("HOME");
		exit.setBounds(450,300,150,30);
		exit.addActionListener(this);
		cp.add(exit);

                as=new JButton("ADD SUPP.RECORD");
	        as.setBounds(450,50,190,30);//510,320,150,20);
		as.addActionListener(this);
		cp.add(as);

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
                          int type9=Integer.parseInt(s1.getText());
                          String type10=s2.getText();
                          String type11=s3.getText();

                           try
                                {
Class.forName("org.postgresql.Driver");
		c9=DriverManager.getConnection("jdbc:postgresql://localhost/agri","postgres","sans");
                                                        s0=c9.createStatement();

                                                        String sql1="INSERT INTO PDetail VALUES('"+type1+"','"+type2+"','"+type3+"','"+type4+"','"+type5+"','"+type6+"','"+type7+"','"+type8+"','"+type10+"','"+type11+"')";
                                                        s0.executeUpdate(sql1);

                                                        JOptionPane.showMessageDialog(this,"SUCCESSFULLY SAVED IN PURCHASE TABLE");
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
			s4.setText(null);
			s1.setText(null);
			s2.setText(null);
			s3.setText(null);
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
		                         String	arr2=rs.getString(2);
		                         String arr3=rs.getString(3);
		                         String	arr4=rs.getString(4);
		                         float arr5=rs.getFloat(5);
		                         int arr6=rs.getInt(6);


	       if((arr1==type1)&&(arr2.equals(type2))&&(arr3.equals(type3))&&(arr4.equals(type4))&&(arr5==type6))
	      {
               int qt=arr6+type5;
	       System.out.println(qt);

               s111.executeUpdate("update plant set qtyavail="+qt+" where pid="+arr1+" AND pname='"+arr2+"'AND pdesc='"+arr3+"' AND fer='"+arr4+"'AND price="+arr5+"");

                JOptionPane.showMessageDialog(this," PLANT ALREADY AVAILABE!!!!!STOCK UPDATED SUCCESFULLY");
	                          flag=1;
	     }
	     }

             	if(flag==0)
               	{
              String sql4="INSERT INTO plant VALUES('"+type1+"','"+type2+"','"+type3+"','"+type4+"','"+type6+"','"+type5+"')";
	       s111.executeUpdate(sql4);
		JOptionPane.showMessageDialog(this,"NEW PLANT!!!!! INSERTED PLANT RECORD SUCCESSFULLY");
           }
                         	 c999.close();
	}
	  catch(Exception e){}


		}



			if(source==as)
		{
		           int type9=Integer.parseInt(s1.getText());
			   String type10=s2.getText();
			   String type11=s3.getText();
		           String type12=s4.getText();
	           try
	           {
	       Class.forName("org.postgresql.Driver");
		c01=DriverManager.getConnection("jdbc:postgresql://localhost/agri","postgres","sans");
			        s01=c01.createStatement();

			        String sql2="INSERT INTO suplier VALUES('"+type9+"','"+type10+"','"+type11+"','"+type12+"')";
							s01.executeUpdate(sql2);

			   JOptionPane.showMessageDialog(this,"SUPPLIER RECORD ADDED SUCCESSFULLY");

			      c01.close();
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
			OM str=new OM();
			str.setSize(900,850);
			str.setVisible(true);
			str.setVisible(true);
			str.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }


}
