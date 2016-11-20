import greenfoot.*; 

public class Police extends Actor
{
    GreenfootSound sound = new GreenfootSound("siren.mp3");

    public void act() 
    {
        checkKeys();
    }    

    private void playSiren()
    {
        sound.play();//start playing the sound;
    }

    public void checkKeys()
    {
        if(Greenfoot.isKeyDown("up"))
        {
            move(4);
            playSiren();
        }
        if(Greenfoot.isKeyDown("right"))
        {
            turn(2);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            turn(-2);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            move(-2);
        }
    }

}
