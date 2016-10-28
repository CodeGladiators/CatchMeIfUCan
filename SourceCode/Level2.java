import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{
    private Counter actCounter;
    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2()
    {    
        super(1024, 768, 1); 
        // prepare level 1
        prepare();
        actCounter = new Counter("Hours Left: ");
        addObject(actCounter, 900, 20); 
    }

    public void prepare(){

        House[] houses = new House[7];
        houses[0]= new House();
        houses[1]= new House();
        houses[2]= new House();
        houses[3]= new House();
        houses[4]= new House();
        houses[5]= new House();
        houses[6]= new House();

        int x = houses[0].getImage().getWidth()/2;
        int y = houses[0].getImage().getHeight()/2;

        addObject(houses[0],x ,y);
        addObject(houses[1],houses[0].getX()+ 2*x ,y);
        addObject(houses[2],houses[1].getX()+ 2*x ,y);
        addObject(houses[3],houses[2].getX()+ 2*x ,y);
        addObject(houses[4],houses[3].getX()+ 2*x ,y);
        addObject(houses[5],houses[4].getX()+ 2*x ,y);
      
    }
}
