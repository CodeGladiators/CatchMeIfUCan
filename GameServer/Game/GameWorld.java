import greenfoot.*;  

public class GameWorld extends World
{
    private int score;
    GreenfootSound sound;
    public GameWorld()
    {   
        super(1024, 768, 1); 
        //Init Game menu
        Greenfoot.setWorld(new GameMenu());
        //Init sound
        sound = new GreenfootSound("InAction.mp3");
        sound.setVolume(50);
        sound.play();
    }

    public void act(){

    }

}
