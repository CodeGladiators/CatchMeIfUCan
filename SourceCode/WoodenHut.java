import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WoodenHut here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WoodenHut extends House
{
    
    // private Counter actCounter;
    // public WoodenHut(Counter counter){
        // super(counter);
    // }
    
    /**
     * Act - do whatever the WoodenHut wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
         // Check if arrow keys are pressed
        checkKeys();

        // Remove car if it is inside house
        Actor car;
        car=getOneObjectAtOffset(0,0,Police.class);

        if(car!=null && policeRemoved==null && !isVisited){
            isVisited=true;
            World world=getWorld();
            policeRemoved=car;
            world.removeObject(car);
            checkThief();
        }
    } 
    
    public void checkThief(){
        if(isLooted){
            System.out.println("You lost 1 hour!!This house has been loooted!!");
            this.setImage("WoodenHutVisited.png");
            getWorld().addObject(new Instructions(Looted), getWorld().getWidth()/2 , getWorld().getHeight()/2 + 250);
            bumpCounter();            
        }
        else if (!isLooted && hasThief){
            System.out.println("You Win");           
            Greenfoot.setWorld(new Level2());
        } else{
            System.out.println("You lost 1 hour!!! This house has not been looted yet !! Go back!!");
            getWorld().addObject(new Instructions(notLooted), getWorld().getWidth()/3, getWorld().getHeight()/2 + 250);
            this.setImage("WoodenHutVisited.png");
            bumpCounter();
        }    
    }
}
