/**
 * Trait.java
 * Junshen (Kevin) Chen
 * 1 May 2018
 * contains an interface defining the attack behavior of a Critter
 * do not modify
 */

/**
* interface Trait
 * Critter must implement this interface, and define getAttack to return 
 * one of the possible attack moves
 * interfaces can extend Trait and define default behaviors for getAttack
 */
public interface Trait {

    /**
     * returns the attack selected by some Critter implementing Trait
     * @param the string representation of the opponent critter
     * @return attack selected
     */
    Attack getAttack(String opponent);
}
