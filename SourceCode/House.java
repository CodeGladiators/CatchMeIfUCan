import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class House here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class House extends Actor
{
    private Thief thief;
    private int houseNumber;
    private float moneyStored;
    private boolean thiefLooted;
    private int X;
    private int Y;
//yet to add house properties hasthief
    public House(){
    }

    /**
     * Act - do whatever the House wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

        // Add your action code here.
    }    

    public void setX(int x)
    {
        X=x;
    }

    public void setY(int y)
    {
        Y=y;
    }

    public int getX()
    {
        return X;
    }

    public int getY()
    {
        return Y;
    }

}
