import greenfoot.*;

public class Tree extends Actor
{
    private int x;
    private int y;
    private Actor policeRemoved = null;

    public void act() 
    {
        Actor car;
        car = getOneObjectAtOffset(0,0,Police.class);

        if(car!=null && policeRemoved==null){
            World world=getWorld();
            policeRemoved=car;
            world.removeObject(car);

        }

    }    

    public void AddCar(){
        //System.out.println(policeRemoved==null);
        if(policeRemoved!=null){
            //System.out.println("Car appears");
            getWorld().addObject(policeRemoved,getX(),getY()+50);
            policeRemoved=null;
        }

    }

    public void checkKeys()
    {
        if(Greenfoot.isKeyDown("up"))
        {
            AddCar();
        }
        if(Greenfoot.isKeyDown("right"))
        {
            AddCar();
        }
        if(Greenfoot.isKeyDown("left"))
        {
            AddCar();
        }
        if(Greenfoot.isKeyDown("down"))
        {
            AddCar();
        }
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    // renamed as it overrode default Greenfoot getX()
    public int getXCoordinate()
    {
        return x;
    }

    public int getYCoordinate()
    {
        return y;
    }

}
