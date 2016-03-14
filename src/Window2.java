import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;

public class Window2 extends JFrame implements ActionListener
{
	JLayeredPane layeredPane;
	JButton but1, but2, but3;
	JTextField text1, text2;
	String path;

	public Window2() 
	{
		// title of window
		super("Login Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// manage crap manually
		getContentPane().setLayout(null);
		path = "C:\\Users\\Jonathan Blair\\workspace\\CompCulm\\src\\picsmusic\\";
		setSize(400, 300); // size of window 400 x 300
		setResizable(false);

		// button 1
		but1 = new JButton("Username");
		getContentPane().add(but1);
		// location
		but1.setBounds (200, 150, 150, 30);
		but1.addActionListener(this);
		//out.write("");
		// button 2
		but2 = new JButton("Password");
		getContentPane().add(but2);
		// location
		but2.setBounds (200, 200, 150, 30);
		but2.addActionListener(this);
		//out.write("");
		// button 3
		but3 = new JButton("READY TO FIGHT");
		getContentPane().add(but3);
		// location
		but3.setBounds (100, 100, 150, 30);
		but3.addActionListener(this);
		//out.write("");
		//background
		JLabel label = new JLabel(new ImageIcon(path + "meltyWin2.jpg"));
		label.setBounds(0,0,400,300);
		getContentPane().add(label);

		// extra stuff
	    text1 = new JTextField(20);
	    text1.addActionListener(this);
	    text1.setBounds (50, 150, 100, 30);
	    text2 = new JTextField(20);
	    text2.addActionListener(this);
	    text2.setBounds (50, 200, 100, 30);
	    add (text1);
	    add (text2);
	    setVisible(true);
	  }
	  public void actionPerformed(ActionEvent e) 
	  {
		  culmMenu temp = (culmMenu)getParent();
	    // what happens if but1 is pressed
	    if(e.getSource() == but1)
	    {
	      System.out.println("Button 1 was clicked ");
	    }
	    else if(e.getSource() == but3)
	    {
	    	//culmMenu temp = (culmMenu)getParent();
	    	//temp.NewRecord.Username = text1.getText();
	    	//temp.DBase.Write(temp.NewRecord);
	      //System.out.println(text1.getText());
			BufferedPersonFrame fighting = new BufferedPersonFrame(this);
			fighting.setVisible(true);
			//ReadFile reader = new ReadFile(this);
			//temp.DBase.Search
	    }
	    else if(e.getSource() == text2)
	    {
	    	
	    	temp.NewRecord.Username = text2.getText();
	    	temp.DBase.Write(temp.NewRecord);
	      System.out.println(text2.getText());
	    }
	    
	    // what happens if but2 is pressed
	    else if (e.getSource() == but2)
	    {
	      System.out.println("Button 2 was clicked ");
	    }
	  }
	}