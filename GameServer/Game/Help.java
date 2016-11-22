import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Help here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Help extends World
{

    /**
     * Constructor for objects of class Help.
     * 
     */
    public Help()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 600, 1); 
        prepare();
    }
    private void prepare(){

        ThiefIcon thiefIcon = new ThiefIcon();
        addObject(thiefIcon,900 ,440);

        DetectiveIcon detectiveIcon = new DetectiveIcon();
        addObject(detectiveIcon,-200 ,100);
        
        Back back = new Back();
        addObject(back,900 ,500);
        
       
    }
}
