import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TheifIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThiefIcon extends GameMenuComponents
{
    /**
     * Act - do whatever the TheifIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        run();
    }    

    public void run(){
        // move two places along horizontal direction 1 percent of the time
        if(Greenfoot.getRandomNumber(100)<1){
            turn(180);
            move(2);

        }else{
            move(3);
        }

        // if moves out of screen, start from the left edge again
        if(getX() == getWorld().getWidth()-10){
            setLocation(0, getY());
        }
    }

}
