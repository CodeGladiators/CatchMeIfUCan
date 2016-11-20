import greenfoot.*;  

public class WoodenHut extends House
{
   
    public void act() 
    {
         // Check if arrow keys are pressed
        checkKeys();

        // Remove car if it is inside house
        Actor car;
        car = getOneObjectAtOffset(0,0,Police.class);

        if(car != null && policeRemoved == null && !isVisited){
            isVisited = true;
            World world = getWorld();
            policeRemoved = car;
            world.removeObject(car);
            checkThief();
        }
    } 
    
    protected void checkThief(){
        if(isLooted){
            System.out.println("You lost 1 hour!!This house has been loooted!!");
            this.setImage("house2visited.png");
            getWorld().addObject(new Instructions(LOOTED), getWorld().getWidth()/2 , getWorld().getHeight()/2 + 250);
            bumpCounter();  
            System.out.println(this.getWorld().getClass().getName());

        }else if (!isLooted && hasThief){
            System.out.println("You Win");            

            if(this.getWorld().getClass().getName()== "Level3"){
                Greenfoot.setWorld(new Level4());
            }
            
            if(this.getWorld().getClass().getName()== "Level4"){
                Greenfoot.setWorld(new GameMenu());
            }
            
        } else{
            System.out.println("You lost 1 hour!!! This house has not been looted yet !! Go back!!");
            getWorld().addObject(new Instructions(NOT_LOOTED), getWorld().getWidth()/3, getWorld().getHeight()/2 + 250);
            this.setImage("house2visited.png");
            bumpCounter();
        }    
    }
}
