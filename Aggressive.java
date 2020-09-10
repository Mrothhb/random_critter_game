import java.util.Random;
///////////////////////////////////////////////////////////////////////////////
//                
// Title:            (Aggressive.java)
// Semester:         (CS8B) Fall 2018
//
// Author:           (Matthew Roth)
// Email:            (mrroth@ucsd.edu)
// CS Login:         (cs8bfds)
// Lecturer's Name:  (Prof. Paul Cao; TA's - Grace Chen, Alberto, Cheng, Emily,
//                     Godwin, Henry, Hensen, Hilda, Lavanya, Nishil, Sneha)
// 
// Class Desc:        The Aggressive interface is designed to extend the Trait 
//                    Interface, and define specific methods for getAttack().
//                    The Aggressive interface will determine if the incoming 
//                    String parameter is a "Patrick" Starfish class, and 
//                    escape if so, and otherwise for all other Cirtters the 
//                    Attack will return a random Attack enum value.
//                    
///////////////////////////////////////////////////////////////////////////////

/**
 * the Aggressive interface extends the Trait
 * interface and overrides the getAttack default
 * method.
 * */
public interface Aggressive extends Trait {
  //random object created for returning a random enum value for 
  //the next Attack 
  Random random = new Random();
  //an Attack enum array is created for the values defined in Attack
  Attack[] attack = Attack.values();
  /**
   * the getAttack method will override the default getAttack
   * method in the Trait interface.
   * @param opponent the name of the Critter
   * @return Attack the attack 
   * */
  default Attack getAttack(String opponent) {
    //return null string value as null return value 
    if(opponent.equals("null"))
        return null;
    //if the string is Patrick then return the ESCAPE enum attack 
    else if(opponent.equals("Patrick"))
        return Attack.ESCAPE;
    //else return a random Attack using the random.nextInt method call
    else
        return attack[random.nextInt(attack.length)];
  }
}
