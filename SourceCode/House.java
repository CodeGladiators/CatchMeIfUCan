import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class House here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class House extends Actor
{
    private int houseNumber;
    private float moneyStored;
    private boolean isLooted;
    private boolean hasThief;
    private int x;
    private int y;
    private boolean isVisited;
    private int count=0;
    private Actor policeRemoved=null;
    String Looted = " This house has already been looted !! You lost 1 hour! ";
    String notLooted = " This house is safe!! ";
    String foundThief = " Thief's here ! You won! ";

    //private Counter actCounter;
    //yet to add house properties has thief
    //public House(Counter counter){
    //  actCounter=counter;
    //}

    public House(){
        isVisited=false;
    }

    public void setIsLooted(boolean isLooted){
        this.isLooted = isLooted;
    }

    public boolean isLooted(){
        return isLooted;
    }

    public void setHasThief(boolean hasThief){
        this.hasThief = hasThief;
    }

    public boolean hasThief(){
        return hasThief;
    }

    public void setHouseNumber(int houseNumber){
        this.houseNumber = houseNumber;
    }

    public int getHouseNumber(){
        return houseNumber;
    }

    /**
     * Act - do whatever the House wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

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
            this.setImage("houseVisited.png");
            getWorld().addObject(new Instructions(Looted), getWorld().getWidth()/2 , getWorld().getHeight()/2 + 300);
            bumpCounter();            
        }else if (!isLooted && hasThief){
            System.out.println("You Win");            
            Greenfoot.setWorld(new Level2());
        } else{
            System.out.println("You lost 1 hour!!! This house has not been looted yet !! Go back!!");
            getWorld().addObject(new Instructions(notLooted), getWorld().getWidth()/3, getWorld().getHeight()/2 + 300);
            this.setImage("houseVisited.png");
            bumpCounter();
        }    
    }

    private void bumpCounter()
    {
        if(this.getWorld().getClass().getName()== "Level1"){
            Level1 world = (Level1) getWorld();
            world.actCounter.sub(1);
            world.bumpCounter();
        }
        if(this.getWorld().getClass().getName()== "Level2"){
            Level2 world = (Level2) getWorld();
            world.actCounter.sub(1);
            world.bumpCounter();
        }
    }

    public void AddCar(){
        //Add car outside the house once arrow key is pressed
        if(policeRemoved!=null && count>50){
            //System.out.println("Car appears");
            getWorld().addObject(policeRemoved,getX(),getY()+50);
            policeRemoved=null;
            count=0;
        }

    }

    public void checkKeys()
    {
        if(Greenfoot.isKeyDown("up") && policeRemoved!=null)
        {
            count++;
            AddCar();
        }
        if(Greenfoot.isKeyDown("right") && policeRemoved!=null)
        {
            count++;
            AddCar();
        }
        if(Greenfoot.isKeyDown("left") && policeRemoved!=null)
        {
            count++;
            AddCar();
        }
        if(Greenfoot.isKeyDown("down") && policeRemoved!=null)
        {
            count++;
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

    public void setNumber(int num){
        houseNumber=num;
    }

    public void setMoney(float money){
        moneyStored=money;
    }

    public Float getMoney(){
        return moneyStored;
    }

    public int getNumber(){
        return houseNumber;
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
