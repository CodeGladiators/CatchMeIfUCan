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
            System.out.println("Switching back to home");
            
            Greenfoot.setWorld((World)new GameMenu());
        }
    }

}
