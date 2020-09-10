import java.awt.*;
///////////////////////////////////////////////////////////////////////////////
//                
// Title:            (Leopard.java)
// Semester:         (CS8B) Fall 2018
//
// Author:           (Matthew Roth)
// Email:            (mrroth@ucsd.edu)
// CS Login:         (cs8bfds)
// Lecturer's Name:  (Prof. Paul Cao; TA's - Grace Chen, Alberto, Cheng, Emily,
//                     Godwin, Henry, Hensen, Hilda, Lavanya, Nishil, Sneha)
// 
// Class Desc:        The Leopard class will extend the Feline class. The Leopard
//                    will have similar behavior to the Feline with some minor 
//                    differences. The Leopard will maintain a collective 
//                    confidence that will determine if it will eat. and the 
//                    confidence will be incremented from wining battles
//
///////////////////////////////////////////////////////////////////////////////

/**
 * the Leopard class will override the eat method 
 * and the getMove method from Feline class, and wil
 * override the win and lose methods from the Critter 
 * class and will also override the getColor method 
 * and getAttack method
 * */
public class Leopard extends Feline{
  //the static variable confidence will hold the amount of
  //confidence all Leopards have at one time 
  public static int confidence;
  /**
   * the Leopard no args constructor will initialize
   * String Lpd to the displayName and set the confidence
   * to 0 at the start. 
   * */
  public Leopard(){
    this.displayName = "Lpd";
    this.confidence = 0 ;
  }
  /**
   * the getColor method will override the getColor method
   * from Critter and return an enum value for the color
   * @return Color the color 
   * */
  public Color getColor(){
    return Color.RED;
  }
  /**
   * the getMove method will determine the next direction the 
   * Leopard will move in. the return value is a Direction
   * enum type
   * return Direction.TYPE the direction
   * */
  public Direction getMove(){
    //if the Leopard is adjacent to food or Patrick then move into
    //that direction 
    if(this.getNeighbor(Direction.NORTH).equals(".")
        || this.getNeighbor(Direction.NORTH).equals("Patrick"))
      return Direction.NORTH;
    else if(this.getNeighbor(Direction.SOUTH).equals(".")
        || this.getNeighbor(Direction.SOUTH).equals("Patrick"))
      return Direction.SOUTH;
    else if(this.getNeighbor(Direction.EAST).equals(".")
        || this.getNeighbor(Direction.EAST).equals("Patrick"))
      return Direction.EAST;
    else if(this.getNeighbor(Direction.WEST).equals(".")
        || this.getNeighbor(Direction.WEST).equals("Patrick"))
      return Direction.WEST;
    //otherwise move into a random direction
    else 
      return direction[random.nextInt(direction.length)];
  }
  /**
   * the eat methodod will determine if the Leopard will eat
   * based on its confidence as a percentage of 100 from 
   * multiples of 10
   * return true/false
   * */
  public boolean eat(){
    //the total confidence as a percentage
    final int TOTAL_CONFIDENCE = 100;
    //the multiple of 10 to mutliply by 
    final int MULTIPLE_OF_TEN = 10;
    //if the leopard is at 100 percent confidence then eat
    if(Math.abs(random.nextInt() % 10) < confidence/10){
      return true;
    }else{ 
      return false;
    }
  }
  /**
   * the win method will override the win in the Critter
   * class. if the leopard wins then increment its confidence
   * variable.
   * */
  public void win(){
    //multiple of 10 to multiply by 
    final int MULTIPLE_OF_TEN = 10;
    //if the confidence is less than 10 then increment the 
    //confidence 
    if(confidence < MULTIPLE_OF_TEN)
      confidence++;
    //if the confidence has reached 10 then stay at 10
    else if(confidence >= MULTIPLE_OF_TEN)
      confidence = MULTIPLE_OF_TEN;
  }
  /**
   * the lose method will override the lose method from
   * the Critter class. When the Leopard loses a fight 
   * the confidence will be decremented, but neve below
   * zero
   * */
  public void lose(){
    if(confidence > 0)
      confidence--;
    else  
      confidence = 0;
  }
  /**
   * the getAttack method will be overridden 
   * and based on the confidence and the opponent of the leopard
   * it will perform a specific attack 
   * @return Attack variable
   * */
  public Attack getAttack(String opponent){
    //the confidence amount has reached adequate level
    final int CONFIDENCE_NEEDED = 5;
    //last two elements to remove from the list of attacks 
    final int LAST_TWO_ELEMENTS = 2;
    //if the opponent is a turtle and the confidence has reached 
    //more than , then ROAR
    if(opponent.equals("Turtle") || confidence > CONFIDENCE_NEEDED)
      return Attack.ROAR;
    //else return a random attack 
    else 
      return attack[random.nextInt(attack.length-LAST_TWO_ELEMENTS)];
  }

}
