import java.awt.*;
///////////////////////////////////////////////////////////////////////////////
//                
// Title:            (Lion.java)
// Semester:         (CS8B) Fall 2018
//
// Author:           (Matthew Roth)
// Email:            (mrroth@ucsd.edu)
// CS Login:         (cs8bfds)
// Lecturer's Name:  (Prof. Paul Cao; TA's - Grace Chen, Alberto, Cheng, Emily,
//                     Godwin, Henry, Hensen, Hilda, Lavanya, Nishil, Sneha)
// 
// Class Desc:        The Lion class will extend the Feline class. The Lion 
//                    exhibits behavior that is similar to the Feline and 
//                    leoprad with some minor variations in methods. The lion 
//                    will only get hungry and eat after it has won a fight. The
//                    lion will change its name during sleep and the name will 
//                    change back once it wakes up. The Lion will also move 
//                    randomly after 5 getMoves.
//
///////////////////////////////////////////////////////////////////////////////
/**
 * the Lion class will extend the Feline
 * class. It will override the methods
 * eat, getMove, from the Feline class
 * and then override the methods getColor, 
 * sleep, wakeup, and win from Critter
 * */
public class Lion extends Feline{
  //the fightsWon variable will hold the amount of fights a
  //lion wins 
  private int fightsWon;
  //the isHungry variable will set true of false if the lion is hungry
  private boolean isHungry;
  /**
   * the no args constructor for Lion will initialize
   * the fightsWon variable to 0, and the isHungry to
   * false, and the displayName to "Lion".
   * */
  public Lion(){
    this.fightsWon = 0;
    this.isHungry = false;
    this.displayName = "Lion";

  }
  /**
   * the getColor method will return a Color 
   * enum for the Lions color which will be yellow
   * @return Color.YELLOW the color yellow
   * */
  public Color getColor(){
    return Color.YELLOW;

  }
  /**
   * the eat method will determine if the lion is
   * hungry and then eat if it is. the lion becomes
   * hungry after it wins a fight
   * @return true/false if the lion is hungry or not
   * */
  public boolean eat(){
    //if the fightsWon is greater than zero and  the 
    //lion is hungry then return true 
    if(fightsWon > 0 && isHungry == true){
      isHungry = false;
      return true;
      //else increment the notEatenCounter and return false 
    }else{ 
      return false;
    }
  }
  /**
   * the getMove method will override the getmove
   * from Feline. the lion will move in a different
   * direction every 5 calls to getMove.
   * @return Direction.TYPE the direction enum 
   * */
  public Direction getMove(){
    //the fifth move made by lion
    final int FIFTH_MOVE = 5;
    //if the movecount is 0 and this is the lions first move
    if(moveCount == 0){
      moveCount++;
      currentDirection = Direction.SOUTH;
      return Direction.SOUTH;
      //else if the move count is a factor of 5 determine which 
      //direction the lion was previously going in and then move
      //in a new direction of the moveCount is 5 factor or stay 
      //in the same direction if the moveCount is less than 5 
      //factor and inrcement the counter
    }else if(moveCount % 5 == 0){
      if(currentDirection == Direction.SOUTH){
        moveCount++;        
        currentDirection = Direction.WEST;
        return Direction.WEST; 
      }else if(currentDirection == Direction.WEST){
        moveCount++;        
        currentDirection = Direction.NORTH;
        return Direction.NORTH;
      }else if(currentDirection == Direction.NORTH){
        moveCount++;        
        currentDirection = Direction.EAST;
        return Direction.EAST;
      }else{
        moveCount++;        
        currentDirection = Direction.SOUTH;
        return Direction.SOUTH;
      }
    }else{
      moveCount++;      
      return currentDirection;
    }
  }
  /**
   * the sleep method will override the 
   * sleep method in the Critter class
   * and when the lion is sleeping the 
   * String name will change and the 
   * fightsWon will be reset to zero and the 
   * isHungry will become false 
   * */
    public void sleep(){
      fightsWon = 0;
      this.displayName = "noiL";
      isHungry = false;
    }
  /**
   * the wakeup method wil override the 
   * wakeup method in the Critter class
   * and change the String name back to 
   * "Lion" after waking up
   * */
  public void wakeup(){

    this.displayName = "Lion";
  }
  /**
   * the win() method will override the win
   * in the Critter class and increment the 
   * fightsWon variable after a win and also
   * set the lion to become hungry 
   * */
  public void win(){
    fightsWon++;
    isHungry = true;
  }

}
