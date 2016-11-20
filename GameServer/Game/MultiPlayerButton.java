import greenfoot.*;  
import javax.swing.JOptionPane;

public class MultiPlayerButton extends GameMenuComponents
{
    String username = "";
    String text = "Enter username";
    private Client client = new Client();
    
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
        {
            if(username.equals("")){
                username = JOptionPane.showInputDialog(text);
                
                if(!username.equals("")){
                    JOptionPane.showMessageDialog(null, "Hello "+username);
                    client.getUsername(username);
                    Greenfoot.setWorld(new Level1());
                }
            }
        }

        moveInAnimation();
    }    
    
      public void moveInAnimation(){
        if(getX() > 850){
            move(-5);
        }
    }
}
