import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PDT  extends JFrame implements ActionListener
{
	Container con=this.getContentPane();
	DefaultTableModel dm;
	JTable jt;
	Vector rows,header,row1;


	Connection cn;
	String str;
	Statement stmt;

	JButton close=new JButton("CLOSE");
	JButton prod=new JButton("PURCHASE ");
	JButton mef=new JButton("SALES");
	JButton sp=new JButton("SUPPLIER");
	JButton ct=new JButton("CUSTOMER");
	JButton bl=new JButton("STOCK");

	public PDT()
	{
		con.setLayout(null);
		con.setBackground(Color.orange);


		rows=new Vector();
		header=new Vector();
		header.addElement("PID");
		header.addElement("PLANT NAME");
		header.addElement("DESCRIPTION");
		header.addElement("FERTILIZER");
		header.addElement("QUANTITY");
		header.addElement("RATE");
		header.addElement("PUR-DATE");
		header.addElement("TOTAL AMT");
		header.addElement("SUP.NAME");
		header.addElement("CONTACT");


		try
		{
    Class.forName("org.postgresql.Driver");
		cn=DriverManager.getConnection("jdbc:postgresql://localhost/agri","postgres","sans");	stmt=cn.createStatement();
		}
		catch(SQLException ae)
		{
			System.out.print("Driver not found");
			ae.printStackTrace();
		}
		catch(ClassNotFoundException ae)
		{
			System.out.print("Class not found");
				ae.printStackTrace();
		}
		try
		{
			ResultSet rs=stmt.executeQuery("select * from PDetail");
			while(rs.next())
			{
			   row1=new Vector();
		           row1.addElement(rs.getInt(1));
			   row1.addElement(rs.getString(2));
			   row1.addElement(rs.getString(3));
			   row1.addElement(rs.getString(4));
			   row1.addElement(rs.getInt(5));
			   row1.addElement(rs.getFloat(6));
			   row1.addElement(rs.getString(7));
			   row1.addElement(rs.getFloat(8));
			   row1.addElement(rs.getString(9));
			   row1.addElement(rs.getString(10));


			    rows.addElement(row1);
			}
		}
		catch(NullPointerException e)
		{
			System.out.print("Exception is there" +e);
				e.printStackTrace();
		}
		catch(SQLException aw)
		{
			System.out.print("Exception for sql" +aw);
				aw.printStackTrace();
		}


		dm=new DefaultTableModel(rows,header);
		jt=new JTable(dm);
		JScrollPane p=new JScrollPane(jt);
		p.setBounds(10,50,900,500);
		con.add(p);
		jt.setRowSelectionAllowed(true);
		jt.setEnabled(true);

		close.setBounds(780,600,100,30);
		con.add(close);
	    close.addActionListener(this);
		close.setToolTipText("CLOSE");

		prod.setBounds(10,600,130,30);
		con.add(prod);
	    prod.addActionListener(this);
		prod.setToolTipText("PURCHASE");


		mef.setBounds(440,600,130,30);
		con.add(mef);
	    mef.addActionListener(this);
		mef.setToolTipText("SALES");


	   	sp.setBounds(150,600,130,30);
		con.add(sp);
	    sp.addActionListener(this);
		sp.setToolTipText("SUPPLIER");


		ct.setBounds(290,600,130,30);
		con.add(ct);
	    ct.addActionListener(this);
		ct.setToolTipText("CUSTOMER");

		bl.setBounds(590,600,160,30);
		con.add(bl);
	    bl.addActionListener(this);
		bl.setToolTipText("STOCK");



		this.setTitle("  ** RECORDS/REPORTS ** ");

		setSize(1000,1000);
		setVisible(true);
	}

public static void main(String args[])
	{
		PDT et=new PDT();
		et.setSize(1000,980);
		et.setVisible(true);
	}


	public void actionPerformed(ActionEvent e)
	{
		String title=e.getActionCommand();
		if(title=="CLOSE")
		{
			dispose();
		}

		if(title=="PURCHASE")
		{
			new PDT();
		}

			if(title=="SUPPLIER")
		{
			new supp();
		}


				if(title=="CUSTOMER")
		{
			new cust();
		}


		if(title=="SALES")
		{
		ME_FTABLE ME=new ME_FTABLE();
		}


		if(title=="STOCK")
		{
		blist bl1=new blist();
		}



	}
}
