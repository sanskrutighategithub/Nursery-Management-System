import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class cust extends JFrame implements ActionListener
{
	Container con=this.getContentPane();
	DefaultTableModel dm;
	JTable jt;
	Vector rows,header,row1;


	Connection cn;
	String str;
	Statement stmt;

	JButton close=new JButton("CLOSE");

	public cust()
	{
		con.setLayout(null);
		con.setBackground(Color.orange);
		rows=new Vector();
		header=new Vector();
		header.addElement("CUSTOMER ID");
		header.addElement("CUSTOMER NAME");
		header.addElement("CUSTOMER CONTACT");


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
			ResultSet rs=stmt.executeQuery("select * from customer");
			while(rs.next())
			{
			   row1=new Vector();
				row1.addElement(rs.getString(1));
				row1.addElement(rs.getString(2));
				row1.addElement(rs.getString(3));

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
		p.setBounds(10,50,700,450);
		con.add(p);
		jt.setRowSelectionAllowed(false);
		jt.setEnabled(false);

		close.setBounds(320,510,100,30);
		con.add(close);
	    close.addActionListener(this);
		close.setToolTipText("Close");

		this.setTitle("**  CUSTOMER LIST  **");

		setSize(800,590);
		setVisible(true);
		setResizable(false);
	}

	public static void main(String args[])
	{
		cust et=new cust();
		et.setSize(800,590);
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
