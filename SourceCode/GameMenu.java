import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameMenu extends World
{

    /**
     * Constructor for objects of class GameMenu.
     * 
     */
    public GameMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 600, 1);
        prepare();
    }

    private void prepare(){

        ThiefIcon thiefIcon = new ThiefIcon();
        addObject(thiefIcon,280 ,300);

        SinglePlayerButton singlePlayerButton = new SinglePlayerButton();
        addObject(singlePlayerButton,600 ,200);

        MultiPlayerButton multiPlayerButton = new MultiPlayerButton();
        addObject(multiPlayerButton,850 ,200);

        HelpButton helpButton = new HelpButton();
        addObject(helpButton,720 ,300);

    }

}
