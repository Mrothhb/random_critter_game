/**
 * Starfish.java
 * Bilguun Bulgan
 * 1 May 2018
 * defines Patrick Star, a Critter
 * do not modify
 */

import java.awt.Color;

/**
 * class Starfish
 * this class extends Critter, inherits the default behavior of a critter
 * this class implements Peaceful, inherits the default attack behavior
 * Starfish are very interesting creatures and one particularly interesting 
 * specimen is the lovable goof and best friend of Spongebob Squarepants, 
 * Patrick Star.
 */
public class Starfish extends Critter implements Peaceful{

    /**
     * default constructor
     * initializes Patrick's name
     */
    public Starfish() {
        super("Patrick");
    }

    /**
     * overrides method getColor
     * Patrick is pink
     * @return the color of a starfish
     */
    @Override 
    public Color getColor() {
        return Color.PINK;
    }
}
