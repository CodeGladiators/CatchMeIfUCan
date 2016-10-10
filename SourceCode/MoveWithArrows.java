import greenfoot.*;

/**
 * Moves actor passed with the arrow keys. Expects an argument actor
 * 
 * @author Ashutosh Singh 
 * @version 10/9/2016
 */
public class MoveWithArrows  
{
    // instance variables - replace the example below with your own
    private int x;
    Actor officer=null;
    /**
     * Constructor for objects of class MoveWithArrows
     */
    public MoveWithArrows(Actor a)
    {
        officer=a;
    }

    public void Move(int speed)
    {
        if(Greenfoot.isKeyDown("right")){
            officer.setRotation(0);
            officer.move(speed);
        }

        if(Greenfoot.isKeyDown("down")){
            officer.setRotation(90);
            officer.move(speed);
        }
        if(Greenfoot.isKeyDown("up")){
            officer.setRotation(270);
            officer.move(speed);
        }
        if(Greenfoot.isKeyDown("left")){
            officer.setRotation(-180);
            officer.move(speed);
        }
    }
}
