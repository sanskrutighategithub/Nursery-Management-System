/* ** For AWT Using Frame ** */
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.imageio.*;


   public class login extends JFrame
   {
	public static login instance;

   public static JLabel label0;
   public static JLabel label1;
   public static JLabel label3;
   public static JButton button4;
   JLabel l3;
   public static JButton button9;
   public static JButton button11;
   public static TextField text10,text2;
   public static Font f;
   public static Font f1;
   public static Font f2;
   public static JLabel la;
   public static String str1,str2,arr1,arr2;
   public static Integer flag=0;
	ImageIcon iokBut, icancelBut,imgLogin;



public login()
{

	 		 Dimension dim = getToolkit().getScreenSize();
                         setLocation(dim.width/2 - getWidth()/2 ,
                         dim.height/2 - getHeight()/2 );


setTitle("********** LOGIN **********");
setSize(580,450);
setResizable(false);
setLayout(null);
setLocation(300,250);
setBackground(new Color(100,100,100));


addWindowListener(new WindowAdapter () { public void windowClosing (WindowEvent e) { System.exit(0); } } );
f=new Font("Shivaji02",Font.TRUETYPE_FONT,20);

  label0 = new JLabel(" EVERGREEN HOTHOUSE NURSERY ");
  label0.setBackground(new Color(204,204,204));
  label0.setFont(f);
    add(label0);
      label0.setBounds(5,15,400,50);


	      label1 = new JLabel("USER NAME : ");
		f1=new Font("Courier New",Font.BOLD,16);
	  label1.setBackground(new Color(255,255,255));
	  label1.setFont(f1);
    add(label1);
      label1.setBounds(31,81,120,20);

      text2 = new TextField();
    add(text2);
      text2.setBounds(195,80,125,23);



      label3 = new JLabel(" PASSWORD : ");
  label3.setBackground(new Color(255,255,255));
  label3.setFont(f1);
    add(label3);

 text10 = new TextField("");
      add(text10);
      text10.setBounds(195,129,125,23);
      text10.setEchoChar('$');
      text10.setFont(f1);
      label3.setBounds(31,130,120,20);



	iokBut = new ImageIcon ("cup.jpg");
	icancelBut = new ImageIcon ("wrong.gif");


      button4 = new JButton( iokBut);
      button4.addActionListener(new buttonListener());

      add(button4);
      button4.setBounds(80,250,180,70);

      button9 = new JButton("CANCEL", icancelBut);
      button9.addActionListener(new buttonListener());

      add(button9);
      button9.setBounds(290,250,180,70);


     /* button11 = new JButton("CLEAR");
      button11.addActionListener(new buttonListener());

      add(button11);
      button11.setBounds(400,250,180,70);*/

	imgLogin = new ImageIcon("Login-key.JPG");

       l3 = new JLabel("",imgLogin,JLabel.CENTER);

       l3.setBounds(350,5,190,230);

       add(l3);



f2=new Font("Monotype Corsiva",Font.BOLD,20);
   la =new JLabel("");

      la.setFont(f2);
    add(la);
      la.setBounds(95,160,400,50);



}

  private class buttonListener implements ActionListener {
      public void actionPerformed (ActionEvent e) {

         if (e.getSource()== button4) {
 try
{
 Class.forName("org.postgresql.Driver");
Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/agri","postgres","sans");
Statement s=con.createStatement();

String sq1="select uname,pwd from login";
ResultSet resul1=s.executeQuery(sq1);
while(resul1.next())
	{      	arr1=resul1.getString(1);
			arr2=resul1.getString(2);
	   if((arr1.equals(text2.getText()))&&(arr2.equals(text10.getText())))
	   	     {
	     	flag=1;
	     	break;
	     }
	 }
}
catch(Exception e1)
{}
		  if(flag==1)
		  	{
             	setVisible(false);
				welcome m=new welcome();
				m.show();

			 }
		  else
            {

             la.setText("!!! INVALID LOGIN !!!");
      	    }
      	 }

         if (e.getSource() == button9) {
              setVisible(false);
              System.exit(0);
         }
	/* if (e.getSource() == button11) {
	la.setText("");
	text2.setText("");
	text10.setText("");
	 }*/

    }
   }
public static void main (String [] args)
{
instance = new login();
instance.show();
}
}
