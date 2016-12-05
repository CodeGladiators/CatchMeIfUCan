public class Player  
{
    // instance variables - replace the example below with your own
    private static Player instance = null;
    private String name;
    private int totalScore;

    private String username;
    private long score;

    private GameMode gamemode;
    private ILevel level;

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

    public void setLevel(ILevel level){
        this.level=level;
    }

    public ILevel getLevel(){
        return this.level;
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
