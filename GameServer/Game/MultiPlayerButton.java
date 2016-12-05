import greenfoot.*;  
import javax.swing.JOptionPane;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;

public class MultiPlayerButton extends GameMenuComponents
{
    //private String url="http://localhost:8080/register";
    String username = "";
    String text = "Enter username";
    private Client client = new Client(Constant.URL.register);

    public void act() 
    {
        moveInAnimation();
        clickListener();
    }    

    public void moveInAnimation(){
        if(getX() > 850){
            move(-5);
        }
    }

    public void clickListener(){
        if (Greenfoot.mouseClicked(this))
        {
            username = "";
            try{
                username = JOptionPane.showInputDialog(text);
                //Check if username is empty or duplicate
                if(username!=null && !username.equals("")&& client.checkDuplicateUsername(username)){
                    JOptionPane.showMessageDialog(null, "Hello "+username);
                    Player player=Player.getInstance();
                    player.setName(username);
                    //player.setName(username);
                    Greenfoot.setWorld(new Level1());
                    Player.getInstance().setGameMode(new MultiPlayer());
                }
                else{
                    JOptionPane.showMessageDialog(null, "Either empty or duplicate username entered. Please try again");
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }

    }
}
