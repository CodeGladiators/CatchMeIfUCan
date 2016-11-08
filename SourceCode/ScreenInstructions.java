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
    String Looted = " This house has already been looted !! You lost 1 hour! ";
    String notLooted = " This house is safe!! ";
    String foundThief = " Thief's here ! You won! ";
    
    GreenfootImage inner = new GreenfootImage(Looted, 48, Color.blue, new Color(0, 0, 0, 96));
    
    public ScreenInstructions()
    {

    }
    
    public void setLooted(World world)
    {
        
        int width = world.getWidth();
        int height = world.getHeight();
        GreenfootImage outer = new GreenfootImage(width, height);
        int topX = (width - inner.getWidth())/2;
        int topY = (height - inner.getHeight())/2;
        outer.drawImage(inner, topX, topY);
        setImage(outer);
    }

    
        public void setNotLooted(World world)
    {
        GreenfootImage inner = new GreenfootImage(notLooted, 48, Color.blue, new Color(0, 0, 0, 96));

        int width = world.getWidth();
        int height = world.getHeight();
        GreenfootImage outer = new GreenfootImage(width, height);
        int topX = (width - inner.getWidth())/2;
        int topY = (height - inner.getHeight())/2;
        outer.drawImage(inner, topX, topY);
        setImage(outer);
    }
    
        public void setFoundLooted(World world)
    {
            GreenfootImage inner = new GreenfootImage(foundThief, 48, Color.blue, new Color(0, 0, 0, 96));

        int width = world.getWidth();
        int height = world.getHeight();
        GreenfootImage outer = new GreenfootImage(width, height);
        int topX = (width - inner.getWidth())/2;
        int topY = (height - inner.getHeight())/2;
        outer.drawImage(inner, topX, topY);
        setImage(outer);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(this)){
            getWorld().removeObject(this);
        }
    }

}
