import java.util.Random;
import java.awt.*;
///////////////////////////////////////////////////////////////////////////////
//                
// Title:            (Turtle.java)
// Semester:         (CS8B) Fall 2018
//
// Author:           (Matthew Roth)
// Email:            (mrroth@ucsd.edu)
// CS Login:         (cs8bfds)
// Lecturer's Name:  (Prof. Paul Cao; TA's - Grace Chen, Alberto, Cheng, Emily,
//                     Godwin, Henry, Hensen, Hilda, Lavanya, Nishil, Sneha)
// 
// Class Desc:        The Turtle class will extend the Critter class and 
//                    implement the Movable interface. the Turtle has a unique 
//                    moving pattern in an L shape and the turtle will only eat
//                    when all of its surrounding neighbors are either Patrick
//                    food or empty space. The turtle will also have a unique 
//                    fighting strategy that it will roar 50 percent of the time
//                    and escape the other 50 percent.
//
///////////////////////////////////////////////////////////////////////////////

/**
 * the Turtle class will extend Critter and implement
 * the movable interface. The override methods are
 * eat, getMove, getAttack, getColor.
 * */
public class Turtle extends Critter implements Movable{
  //the nextMove variable will hold a Direction enum for the next move
  public Direction nextMove;
  //the following timesMoved* variables will hold the amount of times
  //each Direction move call has been made 
  public int timesMovedNorth;
  public int timesMovedSouth;
  public int timesMovedEast;
  public int timesMovedWest;

  Random random = new Random();
  /**
   * the no args constructor for the Turtle class
   * will initialize the String name "Tu", set the
   * first direction move to North
   * and set all the timesMoved* vars
   * to 0
   * */
  public Turtle(){
    super("Tu");
    this.nextMove = Direction.NORTH;
    this.timesMovedNorth = 0;
    this.timesMovedSouth = 0;
    this.timesMovedEast = 0;
    this.timesMovedWest = 0;
  }
  /**
   * the getColor method will return the 
   * color GREEN 
   * @return Color.GREEN
   * */
  public Color getColor(){
    return Color.GREEN;
  }
  /**
   *the getMove method will override the 
   *getMove in the Critter class and move in 
   *and L shape pattern
   *@return Direction the direction to move 
   */
  public Direction getMove(){
    //if the nextmove is north then see if the turtle has
    //moved north three times and if it has then return south
    if(nextMove == Direction.NORTH){
      if(timesMovedNorth < 3){
        timesMovedNorth++;
        nextMove = Direction.NORTH;
        return Direction.NORTH;
      }
      else{
        timesMovedNorth = 0;
        nextMove = Direction.SOUTH;
        return Direction.SOUTH;
      }
      //if the turtle has moved south three times then return 
      //East
    }else if(nextMove == Direction.SOUTH){
      if(timesMovedSouth < 3){
        timesMovedSouth++;
        nextMove = Direction.SOUTH;
        return Direction.SOUTH;
      }
      else{
        timesMovedSouth = 0;
        nextMove = Direction.EAST;
        return Direction.EAST;
      }
      //if the turtle has moved east three times then
      //return west
    }else if(nextMove == Direction.EAST){
      if(timesMovedEast < 3){
        timesMovedEast++;
        nextMove = Direction.EAST;
        return Direction.EAST;
      }
      else{
        timesMovedEast = 0;
        nextMove = Direction.WEST;
        return Direction.WEST;
      }
      //after the turtle has finally moved west three
      //times then return North again and start over 
    }else if(nextMove == Direction.WEST){
      if(timesMovedWest < 3){
        timesMovedWest++;
        nextMove = Direction.WEST;
        return Direction.WEST;
      }
      else{
        timesMovedWest = 0;
        nextMove = Direction.NORTH;
        return Direction.NORTH;
      }
      //return null is else 
    }else 
      return null;
  }
  /**
   * the eat method will check the direction north
   * south east and west to determine the neighbor
   * and if the neighbor is Patrick or food or empty
   * then the turtle will eat
   * @return Direction the direction to move
   * */
  public boolean eat(){ 
    //check the neighbor and return true only if all the 
    //combinations of north south east and west do not 
    //have a friendly
    if(this.getNeighbor(Direction.NORTH).equals(" ") ||
        this.getNeighbor(Direction.NORTH).equals("Patrick") ||
        this.getNeighbor(Direction.NORTH).equals(".")
        && this.getNeighbor(Direction.SOUTH).equals(" ") || 
        this.getNeighbor(Direction.SOUTH).equals("Patrick") || 
        this.getNeighbor(Direction.SOUTH).equals(".") && 
        this.getNeighbor(Direction.EAST).equals(" ") || 
        this.getNeighbor(Direction.EAST).equals("Patrick") 
        || this.getNeighbor(Direction.EAST).equals(".")
        && this.getNeighbor(Direction.WEST).equals(" ") 
        || this.getNeighbor(Direction.WEST).equals("Patrick") ||
        this.getNeighbor(Direction.WEST).equals("."))
      return true;
    else
      return false;
  }
  /**
   * the getAttack method will take a String as
   * a parameter and determine who the opponent is and
   * return ROAR or ESCAPE 50 percent of the time 
   * depeding on who the opponent is
   * @param opponenet the opponent Critter
   * */
  public Attack getAttack(String opponent){
    //the 50 percent chance. a random int will be generated
    //between 0 and 1, and based on probability, there will be
    //a fifty percent chance of 1 or 0.
    int FIFTY_FIFTY = random.nextInt(1);
    //if the int is 0 then return Attack.ROAR
    if(FIFTY_FIFTY == 0)
      return Attack.ROAR;
    //if the int is 1 return Attack.ESCAPE
    else if(FIFTY_FIFTY == 1)
      return Attack.ESCAPE;
    else 
      return null;
  }

}
