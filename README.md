#Questions
1. One benefit of inheritance is that by using inheritance, the amount of code 
needed to accomplish a given task or program is minimized, which in turn 
reduces the possibility of any errors in the file. Inheritance provides the 
programmer assistance in streamlining the code writing process. For example, 
writing a method in the superclass and allowing the derived classes to inherit 
the method creates a uniformity across the family of classes and simplifies the
implemenation of code within each inheriting derived class. 

2. public: The public access modifier allows for accesiblity to all other 
classes within the same package, regardless of inheritance. This is the most 
accesible modifier.
  private: The private modifier allows for limited accessibility to its members
  to only calling methods within its own class. Otherwise, derived classes and 
  other classes within the package may access private intance variables with 
  public mutator and getter methods. Private methods are not accessible to 
  anything outside ofn the class.

  protected: the protected access modifier allows for accessiblity from within
  its own class and also from inheriting derived classes, but not other classes
  within the package or outside of the package. 

  default: The default access modifier is used when no other modifier is
  specified in the class. This modifies allows for accessiblity to all within 
  the same package.

3. static variables are useful in situations where you want to provide easy
access to multiple types of classes or objects, etc. to one method or to
one instance variable(assuming they are not made private). In PSA4, the 
static variable was use in the Leopard.java derived class, and the Elephant.java
derived class. The Leopard class has an instance varible "confidence" that 
shares information across all instances of Leopard, and the Elephant class 
has a (x,y) coordinate location on the map, that was shared across all instances
of Elephant.

4. Interfaces are useful in a sense that they allow for multiple classes
to use them, and they create a standard set of methods for all implementing 
classes to go by, keeping uniformity across a family of classes. 

5. The attack behavior of the Leopard is define within the Leopard class itself.
The interface requires Leopard to implement the method for attack, while the 
Leopard class itself will Override it, and determine exactly what those methods
will do.

6. The superclass constructor is called with the parameters "Patrick"
initializing the toString() in the abstract superclass, and since Starfish
doesnt have it's own toString() method, the Critter class toString() will
be called implicitly with the String "Patrick" from the initialzed variable.

7. When an abstract class is implementing an interface that contains an 
abstract default method, then the implementing abstract class has the options
to either, override the method with a new set of definitions, or choose not 
to define the method in the class and it remains default abstract meethod, 
then the subclasses are forced to 
override the abstract method 

8. Tutrle has to override getAttack() method since the Turtle derived class 
is implementing its own verion of getAttack() to spefification. All classes
implementing an interface will have to implicitly call the methods within the 
interface, unless the derived class explicitly overrides the interface method.

9. No. the Starfish is not supposed to move on the game map, and if the Starfish
derived class decides to implement the Movable interface it would be required
to use the method within or override it. 

10. The critter I chose to make is called the "rabbit".The rabbit will move in 
a similar pattern as the Leopard, which was determined to have the most dynamic
and effective movement pattern in the game. The rabbit will implement an eating
style similar to the Elephant, in that it will prioritze eating about 60 percent
of the time to maximize point without sacrificing other benefits. The rabbit 
will also be rewarded for mating with level increments. And finally the rabbit 
will implement a unique Pounce only fighting strategy which will be the most
effective winning strategy for beating the Raccoon and all the other Critters
within the game. 

