///////////////////////////////////////////////////////////////////////////////
//                
// Title:            (Sensible.java)
// Semester:         (CS8B) Fall 2018
//
// Author:           (Matthew Roth)
// Email:            (mrroth@ucsd.edu)
// CS Login:         (cs8bfds)
// Lecturer's Name:  (Prof. Paul Cao; TA's - Grace Chen, Alberto, Cheng, Emily,
//                     Godwin, Henry, Hensen, Hilda, Lavanya, Nishil, Sneha)
// 
// Class Desc:        The sensible interface will extend the Trait interface and
//                    override the getAttack method. The Critter will make a 
//                    specific attack based on the critter level and also on
//                    a multiple of three for every 3 attacks.
//                    
///////////////////////////////////////////////////////////////////////////////
/**
 * the Sensible interface will extend the Trait interface
 * and implement the getAttack method overriding the 
 * method to specifications. 
 * */
public interface Sensible extends Trait {
  //the three multiple for every third level 
  final int THREE = 3;
  //the two used for modulo
  final int TWO = 2;
  /**
   * the default constructor that will take a 
   * opponent as a String and return a
   * Attack enum based on the critter level
   * @return Attack the attack to return
   * @param opponent the opponent to fight 
   * */
  default Attack getAttack(String opponent) {
    //cast to a Critter on the this object for the 
    //derived class to call the abstract critter methods
    Critter critter = (Critter)this;
    //if the critter is less than level three increment
    //the level and return escape
    if(critter.getLevel() < THREE){
      critter.incrementLevel(1);
      return Attack.ESCAPE;
      //if the critter is at a multiple of three then
      //return pounce
    }else if(critter.getLevel() % THREE == 0){
      return Attack.POUNCE;
      //if the critter is at a 1 remainder of the multiple
      //three then return ROAR
    }else if(critter.getLevel() % THREE == 1){
      return Attack.ROAR;
      //if the critter is at a two remainder of multiple three
      //then return Scratch
    }else if(critter.getLevel() % THREE == TWO){
      return Attack.SCRATCH;
    }else
      return null;
  }
}
