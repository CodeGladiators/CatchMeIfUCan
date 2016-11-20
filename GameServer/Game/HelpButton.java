import greenfoot.*;  

public class HelpButton extends GameMenuComponents
{

    public void act() 
    {
        moveInAnimation();
    }    

    public void moveInAnimation(){
        if(getY() > 300){
            setLocation(getX(), getY()-10);
        }
    }

}
