import greenfoot.*;  

public class TutorialButton extends GameMenuComponents
{   

    public void act() 
    {
        moveInAnimation();
        clickListener();
    }

    public void moveInAnimation(){
        if(getY() > 300){
            setLocation(getX(), getY()-10);
        }
    }

    public void clickListener(){
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Tutorial());
        }
    }

}
