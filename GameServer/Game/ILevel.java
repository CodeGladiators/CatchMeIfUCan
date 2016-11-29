import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public interface ILevel 
{
    public abstract void bumpCounter();

    public abstract void updateScore(GameWorld game);
}
