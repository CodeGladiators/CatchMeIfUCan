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
            this.setImage("houseVisited.png");
            getWorld().addObject(new Instructions(LOOTED), getWorld().getWidth()/2 , getWorld().getHeight()/2 + 250);
            bumpCounter();  
            System.out.println(this.getWorld().getClass().getName());

        }else if (!isLooted && hasThief){
            System.out.println("You Win");            
            if(this.getWorld().getClass().getName()== "Level1"){
                Level1 world=(Level1)getWorld();
                int score=world.getScore();
                Player player=Player.getInstance("");
                player.addToScore(score);
                System.out.println("Score after level 1: "+ player.getScore());
                Greenfoot.setWorld(new Level2());
            }

            if(this.getWorld().getClass().getName()== "Level2"){
                Level2 world=(Level2)getWorld();
                int score=world.getScore();
                Player player=Player.getInstance("");
                player.addToScore(score);
                System.out.println("Score after level 2: "+ player.getScore());
                Greenfoot.setWorld(new Level3());
            }

            if(this.getWorld().getClass().getName()== "Level3"){
                Level3 world=(Level3)getWorld();
                int score=world.getScore();
                Player player=Player.getInstance("");
                player.addToScore(score);
                System.out.println("Score after level 3: "+ player.getScore());
                Greenfoot.setWorld(new Level4());
            }

            if(this.getWorld().getClass().getName()== "Level4"){
                try{
                    Level4 world=(Level4)getWorld();
                    int score=world.getScore();
                    Player player=Player.getInstance("");
                    player.addToScore(score);
                    System.out.println("My Score: "+ player.getScore());

                    Client client=new Client(Constant.URL.scoreboard);
                    Scoreboard board=client.postScore();

                    //Greenfoot.setWorld(new GameMenu());
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }

        } else{
            System.out.println("You lost 1 hour!!! This house has not been looted yet !! Go back!!");
            getWorld().addObject(new Instructions(NOT_LOOTED), getWorld().getWidth()/3, getWorld().getHeight()/2 + 250);
            this.setImage("houseVisited.png");
            bumpCounter();
        }    
    }
   
}
