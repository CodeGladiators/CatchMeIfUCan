import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{
    private Counter actCounter;
    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2()
    {    
        super(1024, 600, 1); 
        // prepare level 1
        prepare();
        actCounter = new Counter("Hours Left: ");
        addObject(actCounter, 900, 20); 
    }

    public void prepare(){

        House[] houses = new House[20];
        houses[0]= new House();
        houses[1]= new House();
        houses[2]= new House();
        houses[3]= new House();
        houses[4]= new House();
        houses[5]= new House();
        houses[6]= new House();
        houses[7]= new House();
        houses[8]= new House();
        houses[9]= new House();
        houses[10]= new House();
        houses[11]= new House();
        houses[12]= new House();

        int x = houses[0].getImage().getWidth()/2;
        int y = houses[0].getImage().getHeight()/2;

        // first row of houses
        addObject(houses[0],x ,y);
        addObject(houses[1],houses[0].getX()+ 2*x ,y);
        addObject(houses[2],houses[1].getX()+ 2*x ,y);
        addObject(houses[3],houses[2].getX()+ 2*x ,y);
        addObject(houses[4],houses[3].getX()+ 2*x ,y);
        addObject(houses[5],houses[4].getX()+ 2*x ,y);
        // first vertical row at the right
        addObject(houses[6],houses[5].getX()+ 3*x-20 ,3*y-30);
        addObject(houses[7],houses[5].getX()+ 3*x-20 ,houses[6].getY()+2*y+20);
        addObject(houses[8],houses[5].getX()+ 3*x-20 ,houses[7].getY()+2*y+10);
        // second horizontal row of houses
        addObject(houses[9],houses[5].getX(),houses[8].getY()+y-10);
        addObject(houses[10],houses[4].getX()-10,houses[8].getY()+y-10);
        addObject(houses[11],houses[3].getX()-20,houses[8].getY()+y-10);
        addObject(houses[12],houses[2].getX()-30,houses[8].getY()+y-10);

        Police police = new Police();
        addObject(police,150,150);
    }
}
