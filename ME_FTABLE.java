import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ME_FTABLE extends JFrame implements ActionListener
{
	Container con=this.getContentPane();
	DefaultTableModel dm;
	JTable jt;
	Vector rows,header,row1;
	Connection cn;
	String str;
	Statement stmt;

	JButton close=new JButton("CLOSE");

	public ME_FTABLE()
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
		header.addElement("SALE-DATE");
		header.addElement("TOTAL AMT");
		header.addElement("CUST.NAME");
		header.addElement("CONTACT");


		try
		{
Class.forName("org.postgresql.Driver");
		cn=DriverManager.getConnection("jdbc:postgresql://localhost/agri","postgres","sans");
		stmt=cn.createStatement();
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
			ResultSet rs=stmt.executeQuery("select * from Sdetail");
			while(rs.next())
			{row1=new Vector();
				row1.addElement(rs.getString(1));
				row1.addElement(rs.getString(2));
				row1.addElement(rs.getString(3));
				row1.addElement(rs.getString(4));
				row1.addElement(rs.getString(5));
				row1.addElement(rs.getString(6));
				row1.addElement(rs.getString(7));
				row1.addElement(rs.getString(8));
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
		p.setBounds(10,40,800,450);
		con.add(p);
		jt.setRowSelectionAllowed(false);
		jt.setEnabled(false);

		close.setBounds(400,520,100,30);
		con.add(close);
	    close.addActionListener(this);
		close.setToolTipText("Close");

		this.setTitle("  **  SALES DETAILS  **  ");

		//setSize(1000,800);
		setSize(950,600);
		setVisible(true);
		setResizable(false);
	}

	public static void main(String args[])
	{
		ME_FTABLE et=new ME_FTABLE();
		//et.setSize(1000,800);
		et.setSize(950,600);
		et.setVisible(true);
		et.setResizable(false);
	}


	public void actionPerformed(ActionEvent e)
	{
		String title=e.getActionCommand();
		if(title=="CLOSE")
		{
			dispose();
		}


	}
}
