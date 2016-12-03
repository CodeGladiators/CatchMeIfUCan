import greenfoot.*;
import java.util.*;
public class ScoreboardWorld extends World
{
    public ScoreboardWorld(ArrayList<Score> users)
    {   
        super(1024, 768, 1); 
        prepare();
        addObject(new ScoreBoard(800, 600, users), getWidth() / 2, getHeight() / 2); 
        //Greenfoot.setWorld(new GameMenu());
    }

    public void prepare(){
        HomeButton next= new HomeButton();
        addObject(next,900 ,320);
    }

    public void act(){

    }
}