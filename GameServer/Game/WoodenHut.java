import greenfoot.*;  

public class WoodenHut extends HouseBase
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

    
    public void getHouseImage(){
        this.setImage("house2visited.png");
    }
    

}
