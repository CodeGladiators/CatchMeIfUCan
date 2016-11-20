import greenfoot.*;  

public class DetectiveIcon extends GameMenuComponents
{
    
    public void act() 
    {
        // Add your action code here.
        chase();
    }    

    public void chase(){
        // move two places along horizontal direction 1 percent of the time
        if(Greenfoot.getRandomNumber(100)<2){
            turn(180);
            move(2);
            
        }else{
            move(3);
        }
        // if moves out of screen, start from the left edge again
        if(getX() == getWorld().getWidth()-10){
            setLocation(0, getY());
        }
    }
}
