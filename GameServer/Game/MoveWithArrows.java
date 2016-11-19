import greenfoot.*;

/**
 * Moves actor passed with the arrow keys. Expects an argument actor
 * 
 * @author Ashutosh Singh 
 * @version 10/9/2016
 */
public class MoveWithArrows  
{
    private int x;
    private Actor officer = null;
  
    public MoveWithArrows(Actor actor)
    {
        officer = actor;
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
