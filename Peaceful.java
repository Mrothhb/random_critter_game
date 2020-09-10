///////////////////////////////////////////////////////////////////////////////
//                
// Title:            (Peaceful.java)
// Semester:         (CS8B) Fall 2018
//
// Author:           (Matthew Roth)
// Email:            (mrroth@ucsd.edu)
// CS Login:         (cs8bfds)
// Lecturer's Name:  (Prof. Paul Cao; TA's - Grace Chen, Alberto, Cheng, Emily,
//                     Godwin, Henry, Hensen, Hilda, Lavanya, Nishil, Sneha)
// 
// Class Desc:        The peaceful interface extends the Trait interface. The 
//                    default method is getAttack which will be overriden. 
//                    Any critter that implements Peaceful will always Forfeit
//                    in a fight, unless the critter overrides the getAttack 
//                    method.
//                    
///////////////////////////////////////////////////////////////////////////////
/**
 * the Peaceful interface extends the Trait interface
 * and overrides the getAttack method
 * */
public interface Peaceful extends Trait {

  /**
   * the getAttack method will take a String as a
   * parameter and return the Attack which will
   * always be Forfeit
   * @param opponent the opponent
   * @return Attack.FORFEIT
   * */
  default Attack getAttack(String opponent) {
    if(opponent.equals("null")){
      return null;
    }
    return Attack.FORFEIT;
  }
}
