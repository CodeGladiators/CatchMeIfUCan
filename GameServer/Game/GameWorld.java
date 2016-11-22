import greenfoot.*;  

public class GameWorld extends World
{
    private int timer = 3600;

    public GameWorld()
    {   
        super(1024, 768, 1); 
        Greenfoot.setWorld(new GameMenu());
        // Use for testing purpose  
        //Greenfoot.setWorld(new Level4());
        //Greenfoot.setWorld(new Help());
    }

    public void act(){
        // is it needed?? TODO:verify with others
        if(timer > 0){
            timer--;
        }else{
            Greenfoot.stop();
        }
        //System.out.println("Your Score:" + timer);
    }
}
