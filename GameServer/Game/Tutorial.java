import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Tutorial extends World
{
    /**
     * Constructor for objects of class Help.
     * 
     */
    public Tutorial()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 600, 1); 
        prepare();
        setPaintOrder(Back.class,BinarySearch.class);
    }

    private void prepare(){

        Back back = new Back();
        addObject(back,900 ,500);

        BinarySearch search = new BinarySearch();
        addObject(search,getWidth()/2,getHeight()/2);

    }
}
