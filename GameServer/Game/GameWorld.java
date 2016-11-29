import greenfoot.*;  

public class GameWorld extends World
{
    private int score;
    GreenfootSound sound = new GreenfootSound("game_menu_background.mp3");

    public GameWorld()
    {   
        super(1024, 768, 1); 
         
        sound.play();
        
        Greenfoot.setWorld(new GameMenu());
        // Use for testing purpose  
        //Greenfoot.setWorld(new Level4());
        //Greenfoot.setWorld(new Help());
    }

    public void act(){

    }

     
    public int getScore(){
        System.out.println("World Score:" + score);
        return score;
    }
    
    public void updateScore(int score){
        this.score = score;
    }
    
}
