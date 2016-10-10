import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        House[] houses=new House[5];
        for (int i=0;i<houses.length;i++){
            houses[i]=new House();
            int X= Greenfoot.getRandomNumber(getWidth());    
            int Y= Greenfoot.getRandomNumber(getHeight());
            addObject(houses[i],X,Y);
        }
    }
}
