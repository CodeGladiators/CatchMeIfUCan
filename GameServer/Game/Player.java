import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private House lastHouseVisited;
    private ArrayList<House> houseList;
    MoveWithArrows mwa=new MoveWithArrows(this);
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        mwa.Move(1);
    }    
    public boolean searchHouse(House house){
        return true;
    }
}
