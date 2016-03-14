import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BufferedPersonFrame extends JFrame implements Runnable, KeyListener, WindowListener
{
  Thread t;
  int height, width;
  int height1, width1;
  int height2, width2;
  Person fatty;
  Person2 fatty2;
  String path;
  String bkgrndImageName;
  String fattyImageName;
  String victoryImage1Name;
  String victoryImage2Name;
  Image image; // used for offscreen rendering
  Image bkgrndImage;
  Image fattyImage;
  Image victoryImage2;
  Image victoryImage1;
  Graphics offscreen;
  boolean notDone;        // variable to signal end of program
  int actionCounter;
  int actionCounterFinalNum;
  int actionCounter2;
  int actionCounterFinalNum2;
  int healthBar1 = 150;
  int healthBar2 = 150;
  JFrame Fight;
  
  public static void main (String[] args)
  {
    // TODO Auto-generated method stub
   // new BufferedPersonFrame ().setVisible (true);
  }
  
  public BufferedPersonFrame (Window3 Fighter)
  
  {
    init ();
    Fight = Fighter;
    actionCounter = 0; // setting actionCopunter ==0
    actionCounterFinalNum = 130; // setting final count value = 130
    actionCounter2 = 0;
    actionCounterFinalNum2 = 130;
  }
public BufferedPersonFrame (Window2 Fighter)
  
  {
    init ();
    Fight = Fighter;
    actionCounter = 0; // setting actionCopunter ==0
    actionCounterFinalNum = 130; // setting final count value = 130
    actionCounter2 = 0;
    actionCounterFinalNum2 = 130;
  }
  
  
  public void init () 
  {
    notDone = true;
    
    // define the path of your working folder...note the slash at the end!
    path = "C:\\Users\\Jonathan Blair\\workspace\\CompCulm\\src\\picsmusic\\";
    
    // define any images that you will be using... name only! (ie. without the path)  
    // These files can be a GIF, JPEG or PNG format.
    bkgrndImageName = "BlazBackGround.jpg";
    victoryImage1Name = "KohakuVictory.gif";
    victoryImage2Name = "CielVictory.png";
    
    // Load all of your pictures...
    // get background image using filename
    bkgrndImage = new ImageIcon(path + bkgrndImageName).getImage();
    victoryImage1 = new ImageIcon(path + victoryImage1).getImage ();
    victoryImage2 = new ImageIcon(path + victoryImage2).getImage ();
    
    
    // define width, height of the window to be the same size as the image
    width = bkgrndImage.getWidth(this);
    height = bkgrndImage.getHeight(this);
    
    width1 = victoryImage1.getWidth(this);
    height1 = victoryImage1.getWidth(this);
    
    width2 = victoryImage2.getWidth(this);
    height2 = victoryImage2.getWidth(this); 
    
    ////////////////////////////////////////
    //  starting location for characters  //
    ////////////////////////////////////////
    fatty = new Person (100, 500, width, height); // starting location for kohak
    fatty2 = new Person2 (700, 500, width, height); // starting position for ciel
    
    
    pack (); // size the frame
    setSize (width, height);
    
    image = createImage(width, height);
    offscreen = image.getGraphics ();
    
    // listen to keyboard events -- eg. if a key is pressed, keyPressed() method is called 
    addKeyListener(this);
    
    t = new Thread (this);
    t.start ();  // the animation will run in this Thread
  }
  
  
  public void update (Graphics h)
  {
    paint (h);
  }
  
  
  public void paint (Graphics g)
  {
    // draw the background scene first
    offscreen.drawImage(bkgrndImage, 0, 0, width, height, this);
    offscreen.drawImage(victoryImage1, 0, 0, width, height, this);
    // draw the beach ball to the offscreen buffer
    // offscreen.drawImage(fattyImage, (int) fatty.x, (int) fatty.y, fatty.PERSON_SIZE, fatty.PERSON_SIZE, this);
    fatty.draw (offscreen); // draw kohak
    fatty2.draw (offscreen); // draw ciel
    
    ///////////////////
    //  HP BAR fatty //
    ///////////////////
    offscreen.setColor (Color.black);
    offscreen.fillRect (95, 95, 160, 20);
    offscreen.setColor (Color.red);
    offscreen.fillRect (100, 100, fatty.health1, 10);
    
    /////////////////////
    //  HP BAR fatty2  //
    ///////////////////// 
    offscreen.setColor (Color.black);
    offscreen.fillRect (759, 95, 160, 20);
    offscreen.setColor (Color.blue);
    offscreen.fillRect (764, 100, fatty2.health2, 10);
    
    if (fatty.currentActionNum > 0)
    {
      actionCounter ++;
      if (actionCounter >= actionCounterFinalNum)
      {
        fatty.setAction(0);
        actionCounter = 0;
      }
    }
    
    if (fatty2.currentActionNum2 > 0)
    {
      actionCounter2 ++;
      if (actionCounter2 >= actionCounterFinalNum2)
      {
        fatty2.setAction2(0);
        actionCounter2 = 0;
      }
    }
    // this line swaps the buffer image and makes it visible-- DO NOT CHANGE!
    g.drawImage (image, 0, 0, width, height, this);
  }
  
  
  // This method is automatically called when a Thread is started
  public void run ()
  {
    
    // TODO Auto-generated method stub
    while (notDone)
    {
      try
      {
        // update your scene here
        
        ///////////////////////////////////////
        //  COLLISION!!!!! (simple in-game)  //
        ///////////////////////////////////////
        if (fatty.x <= 0) // fatty left
        {
          fatty.x = 0;
        }
        
        if (fatty.x >= 950) // fatty right
        {
          fatty.x = 950;
        }
        
        if (fatty.y >= 500) // fatty down
        {
          fatty.y = 500;
        }
        
        if (fatty.y <= 430) // fatty up
        {
          fatty.y = 430;
        }
        
        if (fatty.x + 50 >= fatty2.x2) // fatty to fatty2 right
        {
          fatty.x = fatty2.x2 - 50;
        }
        
        // victory condition fatty 1 win
        if (fatty2.health2 <= 0)
        {
          fatty2.setAction2 (5);
        }
        
        if (fatty2.x2 <= 0) // fatty2 left
        {
          fatty2.x2 = 0;
        }
        
        if (fatty2.x2 >= 950) // fatty2 right
        {
          fatty2.x2 = 950;
        } 
        
        if (fatty2.y2 >= 500) // fatty2 down
        {
          fatty2.y2 = 500;
        }
        
        if (fatty2.y2 <= 430) // fatty2 up
        {
          fatty2.y2 = 430;
        }
        
        if (fatty2.x2 <= fatty.x + 50) // fatty2 to fatty left
        {
          fatty2.x2= fatty.x + 50;
        }
        
        // victory condition fatty 2 win
        if (fatty.health1 <= 0)
        {
          offscreen.drawImage(victoryImage2, 0, 0, width1, height1, this);
          fatty.setAction(5);
        }
        
        
        repaint ();
        Thread.sleep (10); // wait for 10 milliseconds between each frame
      }
      catch (InterruptedException e){}
    }
  }
  
  /*********************************************************************************/
  /***************************** Methods for listeners *****************************/
  /*********************************************************************************/
  
  // Keyboard Listener methods
  // This method is called when a key is pressed...if needed, place your code inside to respond to the pressed key
  public void keyPressed(KeyEvent e) 
  {
    if (e.getKeyChar() == '1')
    {
      fatty.xVel = -fatty.xVel;
    }
    
    // up
    if (e.getKeyChar() == 'w')
    {
      fatty.y = fatty.y - 70;  
    }
    
    // left
    if (e.getKeyChar() == 'a')
    {
      fatty.x = fatty.x - 5;  
    }
    
    // right
    if (e.getKeyChar() == 'd')
    {
      fatty.x = fatty.x + 5;  
    }
    
    // down
    if (e.getKeyChar() == 's')
    {
      fatty.y = fatty.y + 70;  
    }
    
    if (e.getKeyChar() == 'x')
    {
      fatty.setAction (1); // strong punch
      if (fatty.x + 70 >= fatty2.x2)
      {
        fatty2.health2 = fatty2.health2 - 20;
      }
    }
    
    if (e.getKeyChar() == 'c')
    {
      fatty.setAction (2); // special A
      if (fatty.x + 70 >= fatty2.x2)
      {
        fatty2.health2 = fatty2.health2 - 30;
      }
    }
    
    if (e.getKeyChar () == 'v')
    {
      fatty.setAction (3); // special B
      if (fatty.x + 70 >= fatty2.x2)
      {
        fatty2.health2 = fatty2.health2 - 30;;
      }
    }
    
    if (e.getKeyChar () == 'z') 
    {
      fatty.setAction (4); // weak punch 
      if (fatty.x + 70 >= fatty2.x2)
      {
        fatty2.health2 = fatty2.health2 - 10;
      }
    }
    
    // up
    if (e.getKeyChar() == 'i')
    {
      fatty2.y2 = fatty2.y2 - 70;  
    }
    
    // left
    if (e.getKeyChar() == 'j')
    {
      fatty2.x2 = fatty2.x2 - 5;  
    }
    
    // right
    if (e.getKeyChar() == 'l')
    {
      fatty2.x2 = fatty2.x2 + 5;  
    }
    
    //down
    if (e.getKeyChar() == 'k')
    {
      fatty2.y2 = fatty2.y2 + 70;  
    }
    
    if (e.getKeyChar() == 'm')
    {
      fatty2.setAction2 (1); // strong punch
      if (fatty2.x2 <= fatty.x + 70)
      {
        fatty.health1 = fatty.health1 - 20;
      }
    }
    
    if (e.getKeyChar() == ',')
    {
      fatty2.setAction2 (2); // special A
      if (fatty2.x2 <= fatty.x + 70)
      {
        fatty.health1 = fatty.health1 - 30;
      }
    }
    
    if (e.getKeyChar () == '.')
    {
      fatty2.setAction2 (3); // special B
      if (fatty2.x2 <= fatty.x + 70)
      {
        fatty.health1 = fatty.health1 - 30;
      }
    }
    
    if (e.getKeyChar () == 'n') 
    {
      fatty2.setAction2 (4); // weak punch
      if (fatty2.x2 <= fatty.x + 70)
      {
        fatty.health1 = fatty.health1 - 10;
      }
    }
    
    
  }
  
  // This method is called when a key is typed...if needed, place your code inside to respond to the typed key
  // This method is the preferred way to find out about character input 
  public void keyTyped(KeyEvent e) {
  }
  
  // This method is called when a key is released...if needed, place your code inside to respond to the released key
  public void keyReleased(KeyEvent e) {
    
  }
  
  // Window Listener methods
  public void windowActivated(WindowEvent e) {
    
  }
  
  
  public void windowClosed(WindowEvent e) {
    notDone = false;
  }
  
  
  public void windowClosing(WindowEvent e) {
    
  }
  
  
  public void windowDeactivated(WindowEvent e) {
    
  }
  
  
  public void windowDeiconified(WindowEvent e) {
    
  }
  
  
  public void windowIconified(WindowEvent e) {
    
  }
  
  
  public void windowOpened(WindowEvent e) {
    
  }
}
