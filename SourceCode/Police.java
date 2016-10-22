import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Police here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Police extends Actor
{
    /**
     * Act - do whatever the Police wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act() 
    {
        checkKeys();
        //lookForGras();
        //lookForBug();
    }    
    
    public void checkKeys()
    {
        if(Greenfoot.isKeyDown("up"))
        {
            move(3);
        }
        if(Greenfoot.isKeyDown("right"))
        {
            turn(2);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            turn(-2);
        }
    }
    }
