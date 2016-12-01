import greenfoot.*; 
/**
 * Last Level.
 */
public class Level4 extends World implements ILevel
{
    public Counter actCounter;
    private int timer;
    Player player;
    public Bar bar;

    public Level4()
    {    
        super(1024, 600, 1); 
        // prepare level 4 UI
        prepare();
        createCounter();
        timer = 3600;
        player=Player.getInstance();
        bar = new Bar(player.getName(), "Fuel", timer, timer);
        addObject(bar, 100, 530);
    }

    private void createCounter(){
        // adding hours left
        actCounter = new Counter("Hours Left: ");
        actCounter.setValue(4);
        addObject(actCounter, 900, 20); 

    }

    public void updateScore(){
        Player player=Player.getInstance();
        player.addToScore(timer);

        System.out.println("Sending Score:" + timer);
    }

    public void act(){
        if(timer > 0){
            timer = timer-1;
            bar.subtract(1);
        } else{
            Greenfoot.stop();
        }
        // System.out.println("Your Score:" + timer);
    }

    public void bumpCounter()
    {
        actCounter.change();
    }

    public void prepare(){
        // init house objects-31 houses- which is as per 2^n-1 
        House[] houses = new House[31];
        for(int i=0; i<houses.length ; i++){
            houses[i]= new WoodenHut();
        }

        int x = houses[0].getImage().getWidth()/2;
        int y = houses[0].getImage().getHeight()/2;

        // first row of houses
        addObject(houses[0],x ,4*y);
        addObject(houses[1],houses[0].getX()+ 2*x ,4*y);
        // vertical row
        addObject(houses[2],houses[1].getX()+ x, houses[1].getY()+2*y-10);
        addObject(houses[3],houses[2].getX() ,houses[2].getY()+2*y-10);
        addObject(houses[4],houses[2].getX(), houses[3].getY()+2*y-10);
        addObject(houses[5],houses[2].getX() ,houses[4].getY()+2*y-10);
        addObject(houses[6],houses[2].getX() ,houses[5].getY()+2*y-10);
        // botom horizontal row
        addObject(houses[7],houses[6].getX()+ 2*x, houses[6].getY()+y-10);
        addObject(houses[8],houses[7].getX()+2*x ,houses[7].getY());
        addObject(houses[9],houses[8].getX()+2*x, houses[7].getY());
        addObject(houses[10],houses[9].getX()+2*x ,houses[7].getY());
        addObject(houses[11],houses[10].getX()+2*x ,houses[7].getY());
        addObject(houses[12],houses[11].getX()+2*x, houses[7].getY());
        addObject(houses[13],houses[12].getX()+2*x ,houses[7].getY());
        addObject(houses[14],houses[13].getX()+2*x, houses[7].getY());
        addObject(houses[15],houses[14].getX()+2*x ,houses[7].getY());
        addObject(houses[16],houses[15].getX()+2*x ,houses[7].getY());
        addObject(houses[17],houses[16].getX()+2*x-20 ,houses[16].getY()-2*y+10);
        // corner house at right bottom
        addObject(houses[18],houses[17].getX() ,houses[17].getY()-2*y+10);
        // right Z row
        addObject(houses[19],houses[18].getX()-2*x ,houses[18].getY()-y);
        addObject(houses[20],houses[19].getX()-2*x+10 ,houses[19].getY()-y);
        addObject(houses[21],houses[20].getX()-2*x+10 ,houses[20].getY()-y);
        addObject(houses[22],houses[21].getX()-2*x ,houses[21].getY()-y+10);
        addObject(houses[23],houses[22].getX()-2*x+10 ,houses[22].getY()-y);
        addObject(houses[24],houses[23].getX()-2*x+10 ,houses[23].getY()-y);
        // corner house at center
        addObject(houses[25],houses[24].getX()-4*x ,houses[24].getY()-2*y);
        // top horizontal row
        addObject(houses[26],houses[25].getX()+2*x ,houses[25].getY()-y-10);
        addObject(houses[27],houses[26].getX()+2*x ,houses[26].getY());
        addObject(houses[28],houses[27].getX()+2*x ,houses[26].getY());
        addObject(houses[29],houses[28].getX()+2*x ,houses[26].getY());
        addObject(houses[30],houses[29].getX()+2*x ,houses[26].getY());

        // TODO-theif placement- not proper
        int[] arr = {1,3,29,31};
        int houseValue = arr[Greenfoot.getRandomNumber(arr.length)];

        // Iterate over house objects and init properties
        for(int i=0; i<houses.length; i++) {
            House house = houses[i];
            house.setMoney((i+1)*1000);
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
        addObject(police,houses[1].getX()+2*x,houses[1].getY()-y);

        // adding hours left
        actCounter = new Counter("Hours Left: ");
        actCounter.setValue(5);
        addObject(actCounter, 900, 20); 

        // init tree objects
        Tree[] pineTrees = new Tree[31];

        for(int i=0;i<pineTrees.length;i++)
        {
            pineTrees[i]= new PineTree();   
        }

        x = pineTrees[0].getImage().getWidth()/2;
        y = pineTrees[0].getImage().getHeight()/4;
        //adding Trees
        addObject(pineTrees[0], x, getHeight()-y);
        addObject(pineTrees[1],pineTrees[0].getX()+ x ,pineTrees[0].getY());
        addObject(pineTrees[2],pineTrees[1].getX()+ x ,pineTrees[0].getY());
        addObject(pineTrees[3],pineTrees[2].getX()+ x ,pineTrees[0].getY());
        addObject(pineTrees[4],pineTrees[3].getX()+ x ,pineTrees[0].getY());
        addObject(pineTrees[5],pineTrees[4].getX()+ x ,pineTrees[0].getY());
        addObject(pineTrees[6],pineTrees[5].getX()+ x , pineTrees[0].getY());

        addObject(pineTrees[7],houses[18].getX()+ x , houses[18].getY());
        addObject(pineTrees[8],houses[16].getX()+ x ,houses[16].getY());
        addObject(pineTrees[9],pineTrees[8].getX()+ x , pineTrees[8].getY());

        addObject(pineTrees[10],houses[4].getX()+ 3*x ,houses[4].getY()+20);
        addObject(pineTrees[11],pineTrees[10].getX()+ x ,pineTrees[10].getY());
        addObject(pineTrees[12],pineTrees[11].getX()+ x ,pineTrees[10].getY());
        addObject(pineTrees[13],pineTrees[12].getX()+ x ,pineTrees[10].getY());
        addObject(pineTrees[14],pineTrees[13].getX()+ x ,pineTrees[10].getY());
        addObject(pineTrees[15],pineTrees[14].getX()+ x , pineTrees[10].getY());
        addObject(pineTrees[16],pineTrees[15].getX()+ x , pineTrees[10].getY());
        addObject(pineTrees[17],pineTrees[16].getX()+ x ,pineTrees[10].getY());
        addObject(pineTrees[18],pineTrees[17].getX()+ x , pineTrees[10].getY());
        addObject(pineTrees[19],pineTrees[18].getX()+ x , pineTrees[10].getY());

        addObject(pineTrees[20],houses[0].getX(),houses[0].getY()-6*y);
        addObject(pineTrees[21],pineTrees[20].getX()+ x ,pineTrees[20].getY());
        addObject(pineTrees[22],pineTrees[21].getX()+ x ,pineTrees[20].getY());
        addObject(pineTrees[23],pineTrees[22].getX()+ x ,pineTrees[20].getY());
        addObject(pineTrees[24],pineTrees[23].getX()+ x ,pineTrees[20].getY());
        addObject(pineTrees[25],pineTrees[24].getX()+ x , pineTrees[20].getY());

        addObject(pineTrees[26],houses[30].getX()+2*x, houses[24].getY());
        addObject(pineTrees[27],pineTrees[26].getX()+ x ,pineTrees[26].getY());
        addObject(pineTrees[28],pineTrees[27].getX()+ x ,pineTrees[26].getY());
        addObject(pineTrees[29],pineTrees[28].getX()+ x ,pineTrees[26].getY());
        addObject(pineTrees[30],pineTrees[29].getX()+ x ,pineTrees[26].getY());
    }

}
