import greenfoot.*;  

/**
 * Game Menu for CatchMeIfUCan
 */
public class GameMenu extends World implements ILevel
{

    public GameMenu()
    {   
        super(1024, 600, 1);
        prepare();
        
    }

    public void updateScore(){
       //Do Nothing
    }
    public void bumpCounter()
    {
        // Do nothing
    }
    
    public int getScore(){
        return 0;
    }

    
    private void prepare(){

        ThiefIcon thiefIcon = new ThiefIcon();
        addObject(thiefIcon,280 ,320);

        DetectiveIcon detectiveIcon = new DetectiveIcon();
        addObject(detectiveIcon,-200 ,340);

        SinglePlayerButton singlePlayerButton = new SinglePlayerButton();
        addObject(singlePlayerButton,0 ,200);

        MultiPlayerButton multiPlayerButton = new MultiPlayerButton();
        addObject(multiPlayerButton, getWidth(), 200);

        HelpButton helpButton = new HelpButton();
        addObject(helpButton, 800 , getHeight());        

        TutorialButton tutorialButton = new TutorialButton();
        addObject(tutorialButton, 640 , 0); 

    }
}