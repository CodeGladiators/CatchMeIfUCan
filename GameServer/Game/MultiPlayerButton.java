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
            System.out.println("Multiplayer clicked");
            try{
                System.out.println("Inside try");
                username = JOptionPane.showInputDialog(text);
                System.out.println("Inside if : "+username);

                //Check if username is empty or duplicate
                if(!username.equals("")&& client.checkDuplicateUsername(username)){
                    JOptionPane.showMessageDialog(null, "Hello "+username);
                    Player player=Player.getInstance();
                    player.setName(username);
                    //player.setName(username);
                    Greenfoot.setWorld(new Level1());
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
