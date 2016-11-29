import greenfoot.*;  

public class SinglePlayerButton extends GameMenuComponents
{   
    
    public void act() 
    {
        moveInAnimation();
        clickListener();
    }

    public void moveInAnimation(){
        if(getX() < 600){
            move(20);
        }
    }

    public void clickListener(){
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Level1());
        }
    }
}
