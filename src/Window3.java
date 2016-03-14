import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Window3 extends JFrame implements ActionListener
{
	JLayeredPane layeredPane;
	JButton but1, but2, but3;
	JTextField text1, text2;
	String path;
	culmMenu Registration;

	private static String OK = "ok";
	private static String HELP = "help";

	private JFrame controllingFrame; //needed for dialogs
	private JPasswordField passwordField;

	public Window3(culmMenu Registration) 
	{
		// title of window
		super("Player Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.Registration = Registration;
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

		// button 2
		but2 = new JButton("Password");


		//getContentPane().add(but2);
		// location
		but2.setBounds (200, 200, 150, 30);
		but2.addActionListener(this);




		JComponent buttonPane = createButtonPanel();

		// button 2
		but3 = new JButton("READY TO FIGHT");
		getContentPane().add(but3);
		// location
		but3.setBounds (100, 100, 150, 30);
		but3.addActionListener(this);

		//JLabel for background
		JLabel label = new JLabel(new ImageIcon(path + "meltyWin2.jpg"));
		label.setBounds(0,0,400,300);
		getContentPane().add(label);

		//JLabel for password field
		passwordField = new JPasswordField(10);
		passwordField.setActionCommand(OK);
		passwordField.addActionListener(this);

		JLabel label2 = new JLabel("Password: ");
		label2.setBounds(100, 100, 150, 30);
		//label2.setLabelFor(passwordField);
		getContentPane().add(label2);
		setVisible (true);
		
		// TextFields and the ActionListeners to tell if enter has been pressed
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

	private JComponent createButtonPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	public void actionPerformed(ActionEvent e) 
	{
		culmMenu temp = (culmMenu)getParent();
		// what happens if but1 is pressed
		if(e.getSource() == but1)
		{
			System.out.println("Button 1 was clicked ");
		}
		else if(e.getSource() == text1)
		{
			
		}
		else if(e.getSource() == but3)
		{
			//Registration = (Registration)getParent();
			Registration.NewRecord.setUsername(text1.getText());
			//Registration.DBase.Write(Registration.NewRecord);
			//System.out.println(text1.getText());
			//Registration temp = (Registration)getParent();
			Registration.NewRecord.setPassword (text2.getText());
			Registration.NewRecord.kills = 0;
			Registration.NewRecord.deaths = 0;
			Record R = Registration.DBase.Search(Registration.NewRecord.Username);
			if (R.Username == null)
				Registration.DBase.Write(Registration.NewRecord);
			
			BufferedPersonFrame fighting = new BufferedPersonFrame(this);
			
			
			fighting.setVisible(true);
		}
		else if(e.getSource() == text2)
		{
			//Registration temp = (Registration)getParent();
			//Registration.NewRecord.setPassword (text2.getText());
			//Registration.DBase.Write(Registration.NewRecord);

			//output.write R.Password;
			//System.out.println(text2.getText());
		}

		// what happens if but2 is pressed
		else if (e.getSource() == but2)
		{
			System.out.println("Button 2 was clicked ");
		}
	}
}
