import greenfoot.*;  

public class HomeButton extends GameMenuComponents
{   

    public void act() 
    {
        //moveInAnimation();
        clickListener();
    }

    public void clickListener(){
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld((World)new GameMenu());
        }
    }

}
