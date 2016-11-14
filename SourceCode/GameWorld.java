import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    private int timer = 3600;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 768, 1); 
        //prepare();
        Greenfoot.setWorld(new GameMenu());
        // Use for testing purpose
        //Greenfoot.setWorld(new Level3());
    }

    public void act(){
        if(timer > 0){
            timer--;
        }
        else{
            Greenfoot.stop();
        }
        System.out.println("Your Score:" + timer);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
   
}
