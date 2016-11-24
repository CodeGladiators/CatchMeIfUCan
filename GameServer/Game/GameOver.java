import greenfoot.*; 
import java.awt.Color;

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
        try{
            Player player=Player.getInstance("");
            System.out.println("My Score: "+ player.getScore());
            Client client=new Client(Constant.URL.scoreboard);
            Scoreboard board=client.postScore();
            //Greenfoot.setWorld(new GameMenu());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void act(){
        if(Greenfoot.mouseClicked(this)){
            getWorld().removeObject(this);
        }
    }
}
