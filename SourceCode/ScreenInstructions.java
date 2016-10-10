import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class ScreenInstructions here.
 * 
 * @author Ashutosh Singh
 * @email ashutosh.singh@sjsu.edu
 * @version 9/16/16
 */
public class ScreenInstructions extends Actor
{
    private int counter=0;
    private String text;
    private int size;
    private Color foreground;
    private Color background;

    public ScreenInstructions(){   
    }
  

    public void UpdateImage(String text){

        GreenfootImage img = getImage();
        img.drawString(text,4,20);
    }

}
