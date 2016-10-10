import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write messages on the screen.
 * 
 * @author Ashutosh Singh
 * @email ashutosh.singh@sjsu.edu
 * @version 9/16/16
 */
public class Instructions extends Actor
{
    private int score;

    public Instructions(){

        setImage(new GreenfootImage("Drag coin over machine to start",28,Color.BLACK,Color.WHITE));
    }

    /**
     * Update the messages on the screen.
     */
    public void Update(String text){

        GreenfootImage img=getImage();
        img.clear();
        img.setColor(Color.BLACK);
        img.setFont(new java.awt.Font("Arial", Font.PLAIN, 24));
        img.drawString(text,10,18);
    }
}
