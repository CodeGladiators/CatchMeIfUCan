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
    // private void prepare()
    // {
        // House[] houses = new House[7];
        // House sampleHouse = new House();
        // int x = sampleHouse.getImage().getWidth()/2;
        // int y = sampleHouse.getImage().getHeight()/2;

        // for (int i=0;i<houses.length;i++){
            // houses[i] = new House();
            // addObject(houses[i],x ,y);
            // x += sampleHouse.getImage().getWidth() + 10;
            // if(x > getWidth()-sampleHouse.getImage().getWidth()){
                // y += sampleHouse.getImage().getHeight() + 10;
                // x -= sampleHouse.getImage().getWidth() + 10;
            // }         
        // }
    // }
}
