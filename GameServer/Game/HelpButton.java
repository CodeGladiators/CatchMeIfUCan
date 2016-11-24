import greenfoot.*;  

public class HelpButton extends GameMenuComponents
{

    public void act() 
    {
        moveInAnimation();
        
        help();

    }    

    public void moveInAnimation(){
        if(getY() > 300){
            setLocation(getX(), getY()-10);
        }
    }

    public void help()
    {
        if (Greenfoot.mouseClicked(this))
        {
            
            Greenfoot.setWorld(new Help());
        }
    }

}
