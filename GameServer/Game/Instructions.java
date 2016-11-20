import greenfoot.*; 
import java.awt.*;
/**
 * Writes messages on the screen.
 * 
 * @author Ashutosh Singh
 * @email ashutosh.singh@sjsu.edu
 * @version 9/16/16
 */
public class Instructions extends Actor
{

    public Instructions(String text){
        setImage(new GreenfootImage(text, 28, Color.BLACK, Color.WHITE));
    }

    /**
     * Updates the messages on the screen.
     */
    public void update(String text){

        GreenfootImage img = getImage();
        img.clear();
        img.setColor(Color.BLACK);
        img.setFont(new java.awt.Font("Arial", Font.PLAIN, 24));
        img.drawString(text,10,18);

    }

    public void act(){
        if(Greenfoot.isKeyDown("down")){
            getWorld().removeObject(this);
        }
    }
}
