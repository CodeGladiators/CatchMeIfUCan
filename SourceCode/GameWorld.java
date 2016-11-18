import greenfoot.*;  

/**
 * Write a description of class MyWorld here.
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
        super(1024, 768, 1); 
        Greenfoot.setWorld(new GameMenu());
        // Use for testing purpose  
         //Greenfoot.setWorld(new Level3());
    }

    public void act(){
        // is it needed??TODO:verify with others
        if(timer > 0){
            timer--;
        }else{
            Greenfoot.stop();
        }
        System.out.println("Your Score:" + timer);
    }
}
