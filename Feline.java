import java.util.Random;
///////////////////////////////////////////////////////////////////////////////
//                
// Title:            (Feline.java)
// Semester:         (CS8B) Fall 2018
//
// Author:           (Matthew Roth)
// Email:            (mrroth@ucsd.edu)
// CS Login:         (cs8bfds)
// Lecturer's Name:  (Prof. Paul Cao; TA's - Grace Chen, Alberto, Cheng, Emily,
//                     Godwin, Henry, Hensen, Hilda, Lavanya, Nishil, Sneha)
// 
// Class Desc:        The Feline class will extend the Critter class and implement
//                    the Aggressive and the Movable interface. The Feline keeps
//                    track of movements, and times it has not eaten. The eat
//                    and the getMove methods will be overriden. 
//
///////////////////////////////////////////////////////////////////////////////
/**
 * the Feline class will implement the Aggressive and Movable interfaces
 * and will extend the Critter class. The eat and getMove methods wil
 * be overridden in the Feline class. The feline will eat every fifth 
 * time it encounters food and it will move in a new direction every
 * fifth call to move
 * */
public class Feline extends Critter implements Aggressive, Movable{

  //the moverCount will hold the amount of times the Feline has moved
  public int moveCount;
  //the notEatenCount will hold the amount of times the Feline has
  //skipped a meal 
  public int notEatenCount;
  //the currentDirection will hold the current direction enum that
  //the feline is moving in 
  public Direction currentDirection;
  public Direction[] direction = Direction.values();
  Random random = new Random();

  /**
   * the feline no args constructor will initialize the 
   * String "Fe" in the super constrcutor call and set the
   * moveCount, notEatenCount and eatCount to 0
   * */
  public Feline(){
    super("Fe");
    this.moveCount = 0;
    this.notEatenCount = 0;

  }
  /**
   * the eat method will return a boolean value based on if
   * the feline decided to eat. Every 5th meal the feline will
   * eat.
   * @return true/false
   * */
  public boolean eat(){
    //the fifth skipped meal 
    final int FIFTH_SKIPPEDMEAL = 5;
    //if the feline has skipped 5 meals 
    if(notEatenCount >= FIFTH_SKIPPEDMEAL){
      notEatenCount = 0;
      return true;
    }
    //if the feline has not skipped 5 meals yet then dont eat
    else{
      notEatenCount++;
      return false;
    }
  }
  /**
   * the getMove method will return a Direction Enum
   * based on the felines decision to move. Every 5 move calls
   * the feline will change direction.
   * @return direction/currentDirection the direction to move 
   * */
  public Direction getMove(){
    //every 5th move  
    final int FIFTH_MOVE = 5;
    //if its the fifth move call then return a new random direction 
    if (moveCount % FIFTH_MOVE == 0 || moveCount == 0){
      currentDirection = direction[random.nextInt(direction.length)];
      moveCount++;      
      return currentDirection;
    }
    //if the feline hasnt moved five times yet then return the same
    //current direction 
    else{
      moveCount++;      
      return currentDirection;
    }

  }
}
