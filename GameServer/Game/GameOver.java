import greenfoot.*; 
import java.awt.Color;
import java.util.*;
public class GameOver extends Actor
{
    String text = " GAME OVER! \n YOU LOSE! ";
    GreenfootImage inner = new GreenfootImage(text, 48, Color.black, new Color(0, 0, 0, 96));

    public GameOver(){}

    public void addedToWorld(World world)
    {
        int width = world.getWidth();
        int height = world.getHeight();
        GreenfootImage outer = new GreenfootImage(width, height);
        int topX = (width - inner.getWidth())/2;
        int topY = (height - inner.getHeight())/2;
        outer.drawImage(inner, topX, topY);
        setImage(outer);
            postScore();
        
    }

    public void postScore(){
       
                if(Player.getInstance().getGameMode().equals("MultiPlayer")){
                    System.out.println("Multiplayer");
        try{
            Player player=Player.getInstance();
            System.out.println("My Score: "+ player.getScore());
            Client client=new Client(Constant.URL.scoreboard);
            Score[] board=client.postScore();
            System.out.println("Resetting values");
            player.reset();

            ArrayList<Score> otherPlayers = new ArrayList<Score>();
            for(Score players    : board){
                otherPlayers.add(players);
            }
            Greenfoot.setWorld((World)new ScoreboardWorld(otherPlayers));

            //Greenfoot.setWorld(new GameMenu());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }else{
         ArrayList<Score> otherPlayer = new ArrayList<Score>();
                System.out.println("singlePlayer");
         Score s = new Score();
         s.setName(Player.getInstance().getName());
         s.setScore(Player.getInstance().getScore());
         otherPlayer.add(s);
         Greenfoot.setWorld((World)new ScoreboardWorld(otherPlayer));

            }
    }

    public void act(){
        if(Greenfoot.mouseClicked(this)){
            getWorld().removeObject(this);
        }
    }
}
