import greenfoot.*; 

public class Level3 extends World implements ILevel
{
    public Counter actCounter;
    private int timer = 3600;

    public Level3()
    {    
        super(1024, 600, 1); 
        prepare();
        actCounter = new Counter("Hours Left: ");
        actCounter.setValue(4);
        addObject(actCounter, 900, 20); 
    }

    public void act(){
        if(timer > 0){
            timer =timer-1  ;
        }
        else{
            Greenfoot.stop();
        }
        //System.out.println("Your Score:" + timer);
    }

    public void bumpCounter()
    {
        actCounter.change();
    }
    

        public void updateScore(GameWorld world){
        world.updateScore(timer);
        System.out.println("Sending Score:" + timer);
    }

    public void prepare()
    {
        // init house objects-15 houses- which is as per 2^n-1 
        House[] houses = new House[15];
        for(int i=0; i<houses.length ; i++){
            houses[i]= new WoodenHut();
        }

        int x = houses[0].getImage().getWidth()/2;
        int y = houses[0].getImage().getHeight()/2;

        // first row of houses
        addObject(houses[0],2*x ,2*y);
        addObject(houses[1],houses[0].getX()+ 2*x ,2*y);
        addObject(houses[2],houses[1].getX()+ 2*x, 2*y);
        // vertical row
        addObject(houses[3],houses[2].getX()+ 3*y ,houses[2].getY()+2*y-10);
        addObject(houses[4],houses[3].getX(), houses[3].getY()+2*y-10);
        addObject(houses[5],houses[3].getX() ,houses[4].getY()+2*y-10);
        addObject(houses[6],houses[3].getX() ,houses[5].getY()+2*y-10);
        // botom horizontal row
        addObject(houses[7],houses[6].getX()+ 4*x, houses[6].getY()+2*y-10);
        addObject(houses[8],houses[7].getX()+2*x ,houses[7].getY());
        addObject(houses[9],houses[8].getX()+2*x, houses[7].getY());
        addObject(houses[10],houses[9].getX()+2*x ,houses[7].getY());
        addObject(houses[11],houses[10].getX()+2*x ,houses[7].getY());

        addObject(houses[12],houses[11].getX(), houses[5].getY());
        addObject(houses[13],houses[11].getX(), houses[4].getY());
        addObject(houses[14],houses[11].getX(), houses[3].getY());

        // TODO-theif placement- not proper
        int[] arr = {1,3,11,13};
        int houseValue = arr[Greenfoot.getRandomNumber(arr.length)];

        // Iterate over house objects and init properties
        for(int i=0; i<houses.length; i++) {
            House house = houses[i];
            house.setMoney((i+1)*10);
            house.setHouseNumber(i+1);
            
            //add Money Counter
            // TODO-seems too big
            Counter houseCounter = new Counter(Float.toString(house.getMoney()));
            houseCounter.updateHouseCounter();
            addObject(houseCounter, house.getX(), house.getY()-25);

            if(house.getNumber()==houseValue){
                house.setHasThief(true);
            }else{
                house.setHasThief(false);
            }

            if(house.getNumber()>houseValue){
                house.setIsLooted(true);
            }else{
                house.setIsLooted(false);
            }
        }
        
        // adding police car to game level
        Police police = new Police();
        police.setImage("PoliceCarSmall.png");
        addObject(police,houses[14].getX()+40+2*x,houses[1].getY()-y+50);
        police.setRotation(90);
        
        // init tree objects
        Tree[] pineTrees = new Tree[31];

        for(int i=0;i<pineTrees.length;i++)
        {
            pineTrees[i]= new PineTree();   
        }

        x = pineTrees[0].getImage().getWidth()/2;
        y = pineTrees[0].getImage().getHeight()/4;
        //adding Trees
        // bottom left row
        addObject(pineTrees[0], x, getHeight()-y);
        addObject(pineTrees[1],pineTrees[0].getX()+ x ,pineTrees[0].getY());
        addObject(pineTrees[2],pineTrees[1].getX()+ x ,pineTrees[0].getY());
        addObject(pineTrees[3],pineTrees[2].getX()+ x ,pineTrees[0].getY());
        addObject(pineTrees[4],pineTrees[3].getX()+ x ,pineTrees[0].getY());
        addObject(pineTrees[5],pineTrees[4].getX()+ x ,pineTrees[0].getY());
        addObject(pineTrees[6],pineTrees[5].getX()+ x , pineTrees[0].getY());
        // bottom right row
        addObject(pineTrees[7], houses[10].getX(), pineTrees[0].getY());
        addObject(pineTrees[8],pineTrees[7].getX()+ x ,pineTrees[0].getY());
        addObject(pineTrees[9],pineTrees[8].getX()+ x ,pineTrees[0].getY());
        addObject(pineTrees[10],pineTrees[9].getX()+ x ,pineTrees[0].getY());
        addObject(pineTrees[11],pineTrees[10].getX()+ x ,pineTrees[0].getY());
        addObject(pineTrees[12],pineTrees[11].getX()+ x ,pineTrees[0].getY());
        addObject(pineTrees[13],pineTrees[12].getX()+ x , pineTrees[0].getY());
        // rimu trees near the house
        addObject(new RimuTree(),houses[7].getX()-2*x ,houses[7].getY());
        addObject(new RimuTree(),houses[7].getX()-3*x , houses[7].getY());      

    }
}
