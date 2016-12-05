import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class HouseBase extends Actor 
{

    private int x;
    private int y;
    private float moneyStored;
    protected int houseNumber;
    protected boolean isLooted;
    protected boolean hasThief;
    protected boolean isVisited = false;
    protected int count = 0;
    protected Actor policeRemoved = null;
    protected static final String LOOTED = " This house has already been looted !! You lost 1 hour! ";
    protected static final String NOT_LOOTED = " This house is safe!! ";
    protected static final String FOUND_THEIF = " Thief's here ! You won! ";
    ArrayList<Score> otherPlayers = new ArrayList<Score>();

    public HouseBase(){}

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

    public void checkThief()
    {
        if(isLooted){
            this.getHouseImage();
            getWorld().addObject(new Instructions(LOOTED), getWorld().getWidth()/2 , getWorld().getHeight()/2 + 250);
            bumpCounter();  
        }else if (!isLooted && hasThief){
            Player player=Player.getInstance();
            if(this.getWorld().getClass().getName()== "Level4"){
                ILevel lvl = (ILevel)this.getWorld();
                int score = lvl.getScore();
                player.addToScore(score);
                if(Player.getInstance().getGameMode().equals("MultiPlayer")){
                    try{
                        Client client=new Client(Constant.URL.scoreboard);
                        Score[] board=client.postScore();
                        for(Score players    : board){
                            otherPlayers.add(players);
                        }
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }else{
                    Score s = new Score();
                    s.setName(player.getName());
                    s.setScore(player.getScore());
                    otherPlayers.add(s);
                    }
                Greenfoot.setWorld((World)new ScoreboardWorld(otherPlayers));
            }
            else{
                ILevel lvl = (ILevel)this.getWorld();
                int score = lvl.getScore();
                player.addToScore(score);
                ILevel level= LevelFactory.createLevel(this.getWorld().getClass().getName());
                player.setLevel(level);
                GameTransition transitionScreen=new GameTransition();
                Greenfoot.setWorld(transitionScreen);
            }
        } else{
            getWorld().addObject(new Instructions(NOT_LOOTED), getWorld().getWidth()/3, getWorld().getHeight()/2 + 250);
            this.getHouseImage();
            bumpCounter();
        }    
    }

    public void getHouseImage(){
    }

    protected void bumpCounter()
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
        if(this.getWorld().getClass().getName()== "Level3"){
            Level3 world = (Level3) getWorld();
            world.actCounter.sub(1);
            world.bumpCounter();
        }
        if(this.getWorld().getClass().getName()== "Level4"){
            Level4 world = (Level4) getWorld();
            world.actCounter.sub(1);
            world.bumpCounter();
        }
    }

    public void AddCar(){
        //Add car outside the house once arrow key is pressed
        if(policeRemoved!=null && count>50){
            getWorld().addObject(policeRemoved,getX(),getY());
            policeRemoved = null;
            count = 0;
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

    /*GETTERS and SETTERS*/

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

    public void setNumber(int num){
        houseNumber = num;
    }

    public void setMoney(float money){
        moneyStored = money;
    }

    public Float getMoney(){
        return moneyStored;
    }

    public int getNumber(){
        return houseNumber;
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
