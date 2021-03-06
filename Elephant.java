import java.util.Random;
import java.awt.*;
///////////////////////////////////////////////////////////////////////////////
//                
// Title:            (Elephant.java)
// Semester:         (CS8B) Fall 2018
//
// Author:           (Matthew Roth)
// Email:            (mrroth@ucsd.edu)
// CS Login:         (cs8bfds)
// Lecturer's Name:  (Prof. Paul Cao; TA's - Grace Chen, Alberto, Cheng, Emily,
//                     Godwin, Henry, Hensen, Hilda, Lavanya, Nishil, Sneha)
// 
// Class Desc:        The Elephant class is a Critter named "El" that extends 
//                    the Critter class and implements Sensible and Movable 
//                    interfaces. The Elephant will move around the map in a
//                    herd, and eat food 80% of the time. The elephant will be
//                    rewarded for mating, and inherits the Sensible default 
//                    getAttack method as is.
//                    
///////////////////////////////////////////////////////////////////////////////

/**
 * the Elephant class will implement the eat() and getMove() methods
 * from Critter class. The getColor and mat() class will also be 
 * Overriden from Critter.
 * */
public class Elephant extends Critter implements Sensible, Movable{

  //the goalX and goalY will be an int value representin a place marker on
  //the x y axis of the game map and the elephants will collectively 
  //move towards the goals. It is a static variable to allow all the 
  //Elephant Critters to obtain the information simultaneously.
  public static int goalX;
  public static int goalY;
  //eatCall will hold the amount of time the eat method has been called 
  public int eatCall;

  Random random = new Random();
  //an array of Direction enums to return a random direction if needed
  Direction[] direction = Direction.values();

  /**
   * the Elephant constructor will initialze the super with 
   * String "El" to be the name of the Critter, and set the
   * starting goals to 0,0 and the eatCall to 0.
   * */
  public Elephant(){
    //call the super constructor with parameters for String name
    super("El");
    this.goalX = 0;
    this.goalY = 0;
    this.eatCall = 0;
  }

  /**
   * the getColor method will return a color for
   * the Critter. Enum value.
   * @return Color enum value 
   * */
  public Color getColor(){
    return Color.GRAY;
  }

  /**
   * the getMove method will determine what direction the 
   * elphant critter will move in next call
   * @return move the direction
   * */
  public Direction getMove(){
    //the direction variable to be returned
    Direction move;

    //if the elephant has reached its goal then set a new goal 
    if (this.getY() == goalY && this.getX() == goalX) {
      goalX = Math.abs(random.nextInt(this.getWidth()));
      goalY = Math.abs(random.nextInt(this.getHeight()));
    } 
    //if the x position goal is further away than the y direction than move
    //in the X axis direction 
    if (Math.abs(this.getX() - goalX) > Math.abs(this.getY() - goalY)) { 
      if (this.getX() > goalX) {
        move = Direction.WEST;
      } else {
        move = Direction.EAST;
      }
      //if the Y direction is further away then move into the Y
      //goal direction 
    } else {
      if (this.getY() > goalY) {
        move = Direction.NORTH;
      } else {
        move = Direction.SOUTH;
      } 
    }
    return move;     
  }

  /**
   * the eat method will return a boolean value based on if
   * the elephant decides to eat. the Elephant will eat 
   * 80 percent of the time. so 8 out of ten calls will return true
   * @return true/false
   * */
  public boolean eat(){

    //the elephant will eat 8 out of ten times
    if(eatCall <= 8){
      eatCall++;
      this.incrementLevel(1);
      return true;
    }
    //if the eatCall has reached 8 then dont eat 
    else if(eatCall > 8){
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
   * the mate method will increment the elephants
   * level by two everytime it mates
   * */
  public void mate(){

    this.incrementLevel(2);
  }
}

