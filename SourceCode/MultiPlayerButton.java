import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MultiPlayerButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MultiPlayerButton extends GameMenuComponents
{
   
    public void act() 
    {
        // Add your action code here.
        moveInAnimation();
    }    
    
      public void moveInAnimation(){
        if(getX() > 850){
            move(-5);
        }
    }
}
