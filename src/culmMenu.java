import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.awt.FlowLayout;

public class culmMenu extends JFrame implements ActionListener, WindowListener
{
	JLayeredPane layeredPane;
	JButton but1, but2, but3;
	JTextField text;
	Window2 win2;
	Window3 win3;
	//Window4 win4;
	static String path;
	String DataBasePath;
	//String input;
	DataBase DBase;
	Record NewRecord;
	static JFrame owner;
	
	public static void main(String[] args) 
	{
		// making window
		culmMenu myWindow = new culmMenu(null, "Melty Blood");
		//culmMenu myWindow = new culmMenu();
		// Window2 win2 = new Window2();
	}

	public culmMenu(JFrame owner, String name) 
	{
		// title of window
		super(name);
		Scanner in = new Scanner (System.in);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().setLayout(null);
		path = "C:\\Users\\Jonathan Blair\\workspace\\CompCulm\\src\\picsmusic\\";
		setSize(600, 450); // size of window 600 x 450
		setResizable(false); 
		String filename = path + "Music.mp3";
		MP3 mp3 = new MP3(filename);
		mp3.play();
		
		DataBasePath = "C:\\Users\\Jonathan Blair\\workspace\\CompCulm\\src\\";
		DBase = new DataBase (DataBasePath + "TierOneDataBase.txt");
		NewRecord = new Record ();
		
		//input = in.nextString();
		// button 1
		but1 = new JButton("PLAY");
		getContentPane().add(but1);
		// location
		but1.setBounds (250, 300, 100, 30);
		but1.addActionListener(this);

		// button 2
		but2 = new JButton("HIGH SCORES");
		getContentPane().add(but2);
		// location
		but2.setBounds (210, 350, 180, 30);
		but2.addActionListener(this);

		// button 3
		but3 = new JButton("REGISTER");
		getContentPane().add(but3);
		// location
		but3.setBounds (240, 260, 120,30);
		but3.addActionListener(this);

		//background
		JLabel label = new JLabel(new ImageIcon(path + "melty.jpg"));
		label.setBounds(0,0,600,450);
		getContentPane().add(label);

		// extra stuff
		text = new JTextField(20);
		add(text);
		setVisible(true);
		win2 = new Window2();
		win2.setVisible(false);
		win3 = new Window3(this);
		win3.setVisible(false);
		//win4 = new Window 4();
		//win4.setVisible (false);

	}

	public void actionPerformed(ActionEvent e) 
	{
		// what happens if but1 is pressed
		if(e.getSource() == but1)
		{
			//BufferedPersonFrame.main(null);
			win2.setVisible(true);
			//win4.setVisible(true);
			setVisible(true);
		}
		//what happens if but3 is pressed
		if(e.getSource() == but3)
		{
			win3.setVisible(true);
			setVisible(true);
			//Register window create new record
			
		}
		// what happens if but2 is pressed
		else if (e.getSource() == but2)
		{
			System.out.println ("Button 2 was pressed");
		}
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		DBase.close();
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
}
