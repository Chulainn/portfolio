import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Person2 
{
  double x2, y2, xVel2, yVel2, width2, height2;
  final static double GRAVITY = 0.1;
  final static int PERSON_SIZE = 64;
  String personImageName2;
  String attack1Image2Name2;
  String attack2Image2Name2;
  String attack3Image2Name2; 
  String attack4Image2Name2;
  String death2ImageName2;
  String path2;
  Image fattyImage2; // stationary
  Image attack1Image2; // punch 
  Image attack2Image2; // special A
  Image attack3Image2; // special B
  Image attack4Image2; // weak punch
  Image death2Image;
  Image currentImage2;
  Image[] actionArray2;
  int currentActionNum2;
  int health2;
  
  Person2 (int x2, int y2, int width2, int height2)
  {
    currentActionNum2 = 0;
    this.width2 = width2;
    this.height2 = height2;
    this.x2 = x2;
    this.y2 = y2;
    xVel2 = 0.7;
    yVel2 = 0.5;
    actionArray2 = new Image [6]; // change when need to
    health2 = 150;
    
    // path2
    path2 = "C:\\Users\\Jonathan Blair\\workspace\\CompCulm\\src\\picsmusic\\";
    personImageName2 = "Cielstationary.gif";
    attack1Image2Name2 = "CielStrongPunch.gif";
    attack2Image2Name2 = "CielSpecialA.gif";
    attack3Image2Name2 = "CielSpecialB.gif";
    attack4Image2Name2 = "CielWeakPunch.gif";
    death2ImageName2 = "CielDeath.gif";
      
    fattyImage2 = new ImageIcon (path2 + personImageName2).getImage();
    attack1Image2 = new ImageIcon (path2 + attack1Image2Name2).getImage(); 
    attack2Image2 = new ImageIcon (path2 + attack2Image2Name2).getImage();
    attack3Image2 = new ImageIcon (path2 + attack3Image2Name2).getImage();
    attack4Image2 = new ImageIcon (path2 + attack4Image2Name2).getImage();
    death2Image = new ImageIcon (path2 + death2ImageName2).getImage();
    
    currentImage2 = fattyImage2;
    
    actionArray2 [0] = fattyImage2;
    actionArray2 [1] = attack1Image2;
    actionArray2 [2] = attack2Image2;
    actionArray2 [3] = attack3Image2;
    actionArray2 [4] = attack4Image2;
    actionArray2 [5] = death2Image;
  }
  
  public void draw (Graphics g)
  {
    g.drawImage(currentImage2, (int) x2, (int) y2, PERSON_SIZE, PERSON_SIZE, null);
  }
  
  public void setAction2 (int actionNum)
  {
    currentImage2 = actionArray2 [actionNum];
    currentActionNum2 = actionNum;
  }
  

}