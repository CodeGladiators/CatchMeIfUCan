/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player  
{
    // instance variables - replace the example below with your own
    private static Player instance = null;
    private String name;
    private int totalScore;
    
    private String username;
    private long score;
    
    private GameMode gamemode;
    
  
    
    private Player()
    {

    }

    public static Player getInstance() {
        if(instance == null) {
            instance = new Player();
            instance.gamemode = new MultiPlayer(); // default game mode
           
        }

        return instance;
    }

    public void setName(String name)
    {
        // put your code here
        this.name=name;
    }

    public int getScore()
    {
        // put your code here
        return totalScore;
    }

    public void reset()
    {
        this.totalScore=0;
        this.name="";
        //instance=null;        
    }

    public String getName()
    {
        return name;
    }

    public void addToScore(int score){
        this.totalScore+=score;
    }
    
     public String getGameMode(){
        return gamemode.getGameMode();
    }
    
    public void setGameMode(GameMode gamemode){
        this.gamemode = gamemode;
    }
}
