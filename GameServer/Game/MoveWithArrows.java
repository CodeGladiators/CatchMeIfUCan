import greenfoot.*;

/**
 * Moves actor passed with the arrow keys. Expects an argument actor
 * 
 * @author Ashutosh Singh 
 * @version 10/9/2016
 */
public class MoveWithArrows  
{
    private Actor actor = null;
  
    public MoveWithArrows(Actor actor)
    {
        this.actor = actor;
    }

    public void Move(int speed)
    {
        if(Greenfoot.isKeyDown("right")){
            actor.setRotation(0);
            actor.move(speed);
        } 
        if(Greenfoot.isKeyDown("down")){
            actor.setRotation(90);
            actor.move(speed);
        } 
        if(Greenfoot.isKeyDown("up")){
            actor.setRotation(270);
            actor.move(speed);
        } 
        if(Greenfoot.isKeyDown("left")){
            actor.setRotation(-180);
            actor.move(speed);
        }
    }
}
