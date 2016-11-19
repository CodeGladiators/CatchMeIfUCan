import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;

/**
 * Write a description of class SinglePlayerButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SinglePlayerButton extends GameMenuComponents
{   
    String username = "";
    String text = "Enter username";
    private Client client = new Client();
    public void act() 
    {
        // Add your action code here.

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
        if(getX() < 600){
            move(20);
        }
    }

    
}
