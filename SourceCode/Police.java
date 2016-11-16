import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Police here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Police extends Actor
{
    GreenfootSound sound = new GreenfootSound("siren.mp3");

    /**
     * Act - do whatever the Police wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act() 
    {
        checkKeys();
    }    

    private void playSiren()
    {

        sound.play();//start playing the sound;
        // sound.stop();//stop playing the sound;
        // sound.playLoop();//plays the sound over and over again;

    }

    public void checkKeys()
    {
        if(Greenfoot.isKeyDown("up"))
        {
            move(4);
            playSiren();
        }else if(Greenfoot.isKeyDown("right"))
        {
            turn(2);
        }else if(Greenfoot.isKeyDown("left"))
        {
            turn(-2);
        }else if(Greenfoot.isKeyDown("down"))
        {
            move(-2);
        }
    }

}
