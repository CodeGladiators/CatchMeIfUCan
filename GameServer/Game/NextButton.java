import greenfoot.*;  

public class NextButton extends GameMenuComponents
{   

    public void act() 
    {
        //moveInAnimation();
        clickListener();
    }

    public void clickListener(){
        if (Greenfoot.mouseClicked(this))
        {
            Player player=Player.getInstance();
            Greenfoot.setWorld((World)player.getLevel());
        }
    }

}
