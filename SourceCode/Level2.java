import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{
    public Counter actCounter;
    private int timer = 3600;

    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2()
    {    
        super(1024, 600, 1); 
        // prepare level 2
        prepare();
    }

    public void act(){
        if(timer > 0){
            timer--;
        }
        else{
            Greenfoot.stop();
        }
        System.out.println("Your Score:" + timer);
    }

    public void bumpCounter()
    {
        actCounter.change();
    }

    public void prepare(){
        // init house objects
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

        // theif placement
        int[] arr = {1,2,3,5,7,9,11,13};
        int houseValue = arr[Greenfoot.getRandomNumber(arr.length)];

        // Iterate over house objects and init properties
        for(int i=0; i<13; i++) {
            House house = houses[i];
            house.setMoney((i+1)*1000);
            house.setHouseNumber(i+1);

            //add Money Counter
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
        addObject(police,150,150);

        // adding hours left
        actCounter = new Counter("Hours Left: ");
        actCounter.setValue(5);
        addObject(actCounter, 900, 20); 

        // init tree objects
        Tree[] trees = new Tree[10];

        trees[0]= new PineTree();
        trees[1]= new PineTree();
        trees[2]= new RimuTree();
        trees[3]= new PineTree();
        trees[4]= new PineTree();
        trees[5]= new PineTree();
        trees[6]= new PineTree();
        trees[7]= new FigTree();
        trees[8]= new FigTree();
        trees[9]= new FigTree();

        x = trees[0].getImage().getWidth()/2;
        y = trees[0].getImage().getHeight()/4;
        //adding Trees
        addObject(trees[0], x, getHeight()-y);
        addObject(trees[1],trees[0].getX()+ 2*x ,trees[0].getY());
        addObject(trees[2],trees[1].getX()+ 2*x ,trees[1].getY());
        addObject(trees[3],trees[2].getX()+ 2*x ,trees[2].getY());
        addObject(trees[4],trees[3].getX()+ 2*x ,trees[3].getY());
        addObject(trees[5],trees[4].getX()+ 2*x ,trees[4].getY());
        addObject(trees[6],trees[5].getX()+ 2*x , trees[5].getY());
        addObject(trees[7],trees[6].getX()+ 2*x , trees[6].getY());
        addObject(trees[8],trees[7].getX()+ 2*x , trees[7].getY());
        addObject(trees[9],houses[8].getX()+ 2*x, trees[8].getY());

    }

}
