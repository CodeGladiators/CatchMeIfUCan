import greenfoot.*;  

public class ThiefIcon extends GameMenuComponents
{
  
    public void act() 
    {
        run();
    }    

    public void run(){
        // move two places along horizontal direction 1 percent of the time
        if(Greenfoot.getRandomNumber(100)<1){
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
