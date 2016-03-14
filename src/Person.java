import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Person
{
  double x, y, xVel, yVel, width, height;
  final static double GRAVITY = 0.1;
  final static int PERSON_SIZE = 64;
  String personImageName;
  String attack1ImageName;
  String attack2ImageName;
  String attack3ImageName; 
  String attack4ImageName;
  String death1ImageName;
  String path;
  Image fattyImage; // stationary
  Image attack1Image; // punch 
  Image attack2Image; // special A
  Image attack3Image; // special B
  Image attack4Image; // weak punch
  Image death1Image; // death
  Image currentImage;
  Image[] actionArray;
  int currentActionNum;
  int health1;
  
  Person (int x, int y, int width, int height)
  {
    currentActionNum = 0;
    this.width = width;
    this.height = height;
    this.x = x;
    this.y = y;
    xVel = 0.7;
    yVel = 0.5;
    actionArray = new Image [6]; // change when need to
    health1 = 150;
    
    // path
    path = "C:\\Users\\Jonathan Blair\\workspace\\CompCulm\\src\\picsmusic\\";
    personImageName = "Kohakstationary.gif";
    attack1ImageName = "KohakStrongPunch.gif";
    attack2ImageName = "KohakSpecialA.gif";
    attack3ImageName = "KohakSpecialB.gif";
    attack4ImageName = "KohakWeakPunch.gif";
    death1ImageName = "KohakDeath.gif";
      
    fattyImage = new ImageIcon (path + personImageName).getImage();
    attack1Image = new ImageIcon (path + attack1ImageName).getImage(); 
    attack2Image = new ImageIcon (path + attack2ImageName).getImage();
    attack3Image = new ImageIcon (path + attack3ImageName).getImage();
    attack4Image = new ImageIcon (path + attack4ImageName).getImage();
    death1Image = new ImageIcon (path + death1ImageName).getImage();
    
    currentImage = fattyImage;
    
    actionArray [0] = fattyImage;
    actionArray [1] = attack1Image;
    actionArray [2] = attack2Image;
    actionArray [3] = attack3Image;
    actionArray [4] = attack4Image;
    actionArray [5] = death1Image;
  }
  
  public void draw (Graphics g)
  {
    g.drawImage(currentImage, (int) x, (int) y, PERSON_SIZE, PERSON_SIZE, null);
  }
  
  public void setAction (int actionNum)
  {
    currentImage = actionArray [actionNum];
    currentActionNum = actionNum;
  }
  
  public void updatePerson () 
  {
    
    
    
  }
}