import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
        
        //Added to remove actors from reducing readability
        removeActors();
    }

    public void removeActors()
    {
        removeObjects(getObjects(ThiefIcon.class));
        removeObjects(getObjects(DetectiveIcon.class));
    }
}
