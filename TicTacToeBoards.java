/**
 * Nikita Chrystephan
 * Assignment 3: Tic Tac Toe
 * Grading Target: Challenge/Plus
 */

//importing the color library because I'm lazy
import java.awt.Color;

/**
 * This class creates a window and draws several tic-tac-toe boards in it.
 * @author Nikita Chrystephan
 *
 */
public class TicTacToeBoards {
 
 //I'm making it possible for the class to create a window when it needs one
 private NsccWindow gameTableWindow;
 
 //creating a constructor for the class
 public TicTacToeBoards() {
  gameTableWindow = new NsccWindow(10,10,300,330);
  gameTableWindow.setTitle("Tic Tac Toe boards");
   
  drawBoards(40,40);
  drawBoards(40,170,5);
  drawBoards(170,40,Color.red);
  drawBoards(170,170, Math.PI/4);
   
 }
 
 /**
  * The main method instantiates the class and doesn't do a lot else.
  * @param args I'm a pirate.
  */
 public static void main(String[] args) {
  
  //creating an instance of TicTacToe using the properties the constructor gives it
  new TicTacToeBoards();
  
  }
 
 /**
  * the drawBoards method creates a tic-tac-toe board that is 90px by 90px
  * starting at the given x,y coordinates.
  * @param x defines the horizontal starting point of the board
  * @param y defines the vertical starting point of the board
  */
 public void drawBoards(int x, int y) {

  //creating four lines that make up the board
  NsccLine horizontalLine1 = new NsccLine(x,y+30,x+90,y+30);
  NsccLine horizontalLine2 = new NsccLine(x,y+60,x+90,y+60);
  NsccLine verticalLine1 = new NsccLine(x+30,y,x+30,y+90);
  NsccLine verticalLine2 = new NsccLine(x+60,y,x+60,y+90);
  
  //adding the four lines to the parent window
  gameTableWindow.add(horizontalLine1);
  gameTableWindow.add(horizontalLine2);
  gameTableWindow.add(verticalLine1);
  gameTableWindow.add(verticalLine2);
  
  //redrawing the window to make sure the lines are visible.
  gameTableWindow.repaint();
 
 }
 
 /**
  * this version of drawBoards accepts x and y coordinates for the tic-tac-toe
  * board, but also accept t for line thickness. Thicknesses less than 2 or
  * greater than 10 will be treated as if they were 1.
  * @param x horizontal position of board
  * @param y vertical position of board
  * @param t line thickness of board
  */
 public void drawBoards(int x,int y,int t) {
  
  //this statement limits the thickness of the line to values that make sense
  //they must be positive and must not be out of scale with the board size
  if(t > 1 && t < 11) {
   
   //this version uses rectangles instead of lines. it roughly centers
   //the position of the rectangle around the intended location of the line.
   NsccRectangle horizontalLine1 = solidRectangle(x,(y+30)-(t/2),90,t);
   NsccRectangle horizontalLine2 = solidRectangle(x,(y+60)-(t/2),90,t);
   NsccRectangle verticalLine1 = solidRectangle((x+30)-(t/2),y,t,90);
   NsccRectangle verticalLine2 = solidRectangle((x+60)-(t/2),y,t,90);

   //adding the four lines to the parent window
   gameTableWindow.add(horizontalLine1);
   gameTableWindow.add(horizontalLine2);
   gameTableWindow.add(verticalLine1);
   gameTableWindow.add(verticalLine2);
   
   //redrawing the window to make sure the lines are visible.
   gameTableWindow.repaint();
   
  }
  else drawBoards(x,y);
  
 }
 
 //I felt lazy and didn't want to enter these properties into every rectangle
  //I made for the above method, so this one returns a rectangle with the desired
  //characteristics.
 private NsccRectangle solidRectangle(int x,int y,int a,int b) {
   
  NsccRectangle tempRectangle = new NsccRectangle(x,y,a,b);
  tempRectangle.setFilled(true);
  tempRectangle.setBackground(Color.black);
   
  return tempRectangle;
 }
 
 /**
  * This version of drawBoards creates a tic-tac-toe board with a user-selectable color. 
  * @param x horizontal position of board
  * @param y vertical position of board
  * @param c color of board, using the java.awt.Color library.
  */
 public void drawBoards(int x, int y, Color c) {
  
  //creating four lines that make up the board
  NsccLine horizontalLine1 = new NsccLine(x,y+30,x+90,y+30);
  NsccLine horizontalLine2 = new NsccLine(x,y+60,x+90,y+60);
  NsccLine verticalLine1 = new NsccLine(x+30,y,x+30,y+90);
  NsccLine verticalLine2 = new NsccLine(x+60,y,x+60,y+90);
    
  //no special tricks here, we're just changing the color of the lines, which happen to be
  //foreground objects instead of background objects.
  horizontalLine1.setForeground(c);
  horizontalLine2.setForeground(c);
  verticalLine1.setForeground(c);
  verticalLine2.setForeground(c);
  
  //adding the four lines to the parent window
  gameTableWindow.add(horizontalLine1);
  gameTableWindow.add(horizontalLine2);
  gameTableWindow.add(verticalLine1);
  gameTableWindow.add(verticalLine2);
    
  //redrawing the window to make sure the lines are visible.
  gameTableWindow.repaint();
  
 }
 /**
  * This method creates a tic-tac-toe board with a prescribed rotation applied to it. It takes<br>
  * two integers and a double as parameters.<br>
  * @param x horizontal position of desired tic-tac-toe board<br>
  * @param y vertical position of desired tic-tac-toe board<br>
  * @param r desired rotation of tic-tac-toe board , specified in radians.<br>
  */
 public void drawBoards(int x,int y,double r) {
 
  //redefining the x and y position as the center of the board for the purposes of rotation
  int newx = x + 45;
  int newy = y + 45;
  
  //setting up some initial values that we'll need to call on later. 
  //since we're working with a symmetrical shape, we can use the same radius and
  //angles repeatedly!
  double mod = r;
  double theta = Math.atan((double) (9/3));
  double omega = Math.atan((double) 3/9);
  double radius = Math.sqrt(2250);
  
  //creating four lines that make up the board. in order to avoid really long messy
  //lines of code, i've broken down the math for each x and y coordinate into it's own variable.
  //the math basically breaks down to x= radius * cos(theta) and y= radius * sin(theta)
  //with adaptations depending on which quadrant the specified point is found. 
  //the variable "mod" is added to the angle to reach the desired rotation. mod=0 gives zero rotation.
  int vLineOneX1 = newx + (int) (radius * StrictMath.cos(theta + mod));
  int vLineOneY1 = newy + (int) (radius * StrictMath.sin(theta + mod));
  int vLineOneX2 = newx + (int) (radius * StrictMath.cos(-1*theta + mod));
  int vLineOneY2 = newy + (int) (radius * StrictMath.sin(-1*theta + mod));
  NsccLine verticalLine1 = new NsccLine( vLineOneX1 , vLineOneY1 , vLineOneX2 ,vLineOneY2);
  
  int vLineTwoX1 = newx + (int) (radius * StrictMath.cos(Math.PI - theta + mod));
  int vLineTwoY1 = newy + (int) (radius * StrictMath.sin(Math.PI - theta + mod));
  int vLineTwoX2 = newx + (int) (radius * StrictMath.cos(Math.PI + theta + mod));
  int vLineTwoY2 = newx + (int) (radius * StrictMath.sin(Math.PI + theta + mod));
  NsccLine verticalLine2 = new NsccLine( vLineTwoX1 , vLineTwoY1 , vLineTwoX2 , vLineTwoY2 );
  
  int hLineOneX1 = newx + (int) (radius * StrictMath.cos(omega + mod));
  int hLineOneY1 = newy + (int) (radius * StrictMath.sin(omega + mod));
  int hLineOneX2 = newx + (int) (radius * StrictMath.cos(Math.PI - omega + mod));
  int hLineOneY2 = newy + (int) (radius * StrictMath.sin(Math.PI - omega + mod));
  NsccLine horizontalLine1 = new NsccLine( hLineOneX1 , hLineOneY1 , hLineOneX2 , hLineOneY2 );
  
  int hLineTwoX1 = newx + (int) (radius * StrictMath.cos(-1*omega + mod));
  int hLineTwoY1 = newy + (int) (radius * StrictMath.sin(-1*omega + mod));
  int hLineTwoX2 = newx + (int) (radius * StrictMath.cos(Math.PI + omega + mod));
  int hLineTwoY2 = newy + (int) (radius * StrictMath.sin(Math.PI + omega + mod));
  NsccLine horizontalLine2 = new NsccLine( hLineTwoX1 , hLineTwoY1 , hLineTwoX2 , hLineTwoY2 );
  
  
  
  //debug indicators
  //System.out.println(vLineOneX1);
  //System.out.println(vLineOneY1);
  //System.out.println(vLineOneX2);
  //System.out.println(vLineOneY2);

  //adding the four lines to the parent window
  gameTableWindow.add(horizontalLine1);
  gameTableWindow.add(horizontalLine2);
  gameTableWindow.add(verticalLine1);
  gameTableWindow.add(verticalLine2);
    
  //redrawing the window to make sure the lines are visible.
  gameTableWindow.repaint();
   
  
 }
 
}