import java.awt.*;
import java.util.Random;
///////////////////////////////////////////////////////////////////////////////
//                
// Title:            (Matt_mrroth.java)
// Semester:         (CS8B) Fall 2018
//
// Author:           (Matthew Roth)
// Email:            (mrroth@ucsd.edu)
// CS Login:         (cs8bfds)
// Lecturer's Name:  (Prof. Paul Cao; TA's - Grace Chen, Alberto, Cheng, Emily,
//                     Godwin, Henry, Hensen, Hilda, Lavanya, Nishil, Sneha)
// 
// Class Desc:        The rabbit is a custom designed critter class that 
//                    extends Critter and implements the Movable interface.
//                    The rabbit has been engineered to have behavior in a 
//                    specific way to beat the Raccoon critter. The rabbit uses
//                    a combination of methods from various other critters. 
//                    
///////////////////////////////////////////////////////////////////////////////
/**
 * the Matt_mrroth class extends Critter and implements
 * the movable interface. the Name of the critter is "rabbit"
 * and the rabbits main focus is to beat the raccoon class 
 * and win by point overall in the end of game
 * */
public class Matt_mrroth extends Critter implements Movable{
  //create a Direction variable to hold the current direction
  public Direction currentDirection;
  //create an array of Direction enums that can be called
  public Direction[] direction = Direction.values();
  //hold the amount of times the eat method has been called
  public int eatCall;
  Random random = new Random();

  /**
   * the no args constructor will initialize the 
   * name of the critter to "Rabbit" and set the
   * eatCall to 0
   * */
  public Matt_mrroth(){
    super("Rabbit");
    this.eatCall = 0;

  }
  /**
   * the getColor method will return 
   * the color white for the rabbit string
   * @return Color.White the rabbit color
   * */
  public Color getColor(){
    return Color.WHITE;
  }
  /**
   * the eat method will follow a simiar pattern to 
   * the elephant eat method with a slight adjustment
   * where the rabbit eats 6 out of tens times 
   * @return true/false to eat or not to eat
   **/
  public boolean eat(){

    //the rabbit will eat 6 out of ten times and
    //increment the level of the rabbit everytime it
    //eats 
    if(eatCall <= 6){
      eatCall++;
      this.incrementLevel(2);
      return true;
    }
    else if(eatCall > 6){
      if(eatCall == 10){
        eatCall = 0;
        return false;
      }else{
        eatCall++;
        return false;
      }
    }
    return false;
  }
  /**
   * the mate method will increment the rabbit
   * level each time it mates
   * */
  public void mate(){

    this.incrementLevel(4);
  }
  /**
   * the getMove method will always move towards the direction
   * of the Raccoon critter or food.
   * @return Direction the direction to move
   * */
  public Direction getMove(){
    //if the neighbor is food or a Raccoon then move towards it
    if(this.getNeighbor(Direction.NORTH).equals(".")
        || this.getNeighbor(Direction.NORTH).equals("R"))
      return Direction.NORTH;
    else if(this.getNeighbor(Direction.SOUTH).equals(".")
        || this.getNeighbor(Direction.SOUTH).equals("R"))
      return Direction.SOUTH;
    else if(this.getNeighbor(Direction.EAST).equals(".")
        || this.getNeighbor(Direction.EAST).equals("R"))
      return Direction.EAST;
    else if(this.getNeighbor(Direction.WEST).equals(".")
        || this.getNeighbor(Direction.WEST).equals("R"))
      return Direction.WEST;
    //return a random direction otherwise 
    else 
      return direction[random.nextInt(direction.length)];
  }
  /**
   * the getAttack method will take a String as a
   * parameter and return en enum value from Attack
   * this method is designed specifically to beat 
  * the Raccoon critter and will also beat other 
   * non custom critters
   * @param opponent the opponent
   * @return Attack the attack 
   * */
  public Attack getAttack(String opponent){
    //pounce always beats Raccoon
    if(opponent.equals("R")){
      return Attack.POUNCE;
    }
    else 
      return Attack.POUNCE;
  }
}  
