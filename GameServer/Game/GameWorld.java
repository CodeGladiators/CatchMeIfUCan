import greenfoot.*;  

public class GameWorld extends World
{
    private int score;

    public GameWorld()
    {   
        super(1024, 768, 1); 
        Greenfoot.setWorld(new GameMenu());
        // Use for testing purpose  
    }

    public void act(){

    }

     
    public int getScore(){
        return score;
    }
    
    public void updateScore(int score){
        this.score = score;
    }
    
}
