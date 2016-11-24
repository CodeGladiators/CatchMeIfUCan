import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
{
    public Counter actCounter;
    private int timer = 3600;
    
    /**
     * Constructor for objects of class Level1.
     * 
     */
    public Level1()
    {    
        // Create a new world with 1024x768 cells with a cell size of 1x1 pixels.
        super(1024, 600, 1); 
        // prepare level 1
        prepare();
        actCounter = new Counter("Hours Left: ");
        actCounter.setValue(3);
        addObject(actCounter, 900, 20);
    }

    public void bumpCounter()
    {
        actCounter.change();
    }
    
    public int getScore(){
        return timer;
    }
    
    public void act(){
        if(timer > 0){
            timer--;
        }
        else{
            Greenfoot.stop();
        }
        //System.out.println("Your Score:" + timer);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        List houses = new ArrayList<House>();
        List trees = new ArrayList<Tree>();
        int[] arr = {1,3,5,7};
        int houseValue = arr[Greenfoot.getRandomNumber(arr.length)];

        trees.add(new FigTree(){{
                    setX(983);
                    setY(112);
                }});
        trees.add(new PineTree(){{
                    setX(105);
                    setY(724);
                }});
        trees.add(new PineTree(){{
                    setX(200);
                    setY(724);
                }});
        trees.add(new PineTree(){{
                    setX(230);
                    setY(724);
                }});
        trees.add(new PineTree(){{
                    setX(888);
                    setY(724);
                }});
        trees.add(new RimuTree(){{
                    setX(346);
                    setY(505);
                }});
        houses.add(new House(){{
                    setX(134);
                    setY(63);
                    setMoney(1000);
                    setHouseNumber(1);
                }});
        houses.add(new House(){{
                    setX(357);
                    setY(63);
                    setMoney(5000);
                    setHouseNumber(2);
                }});
        houses.add(new House(){{
                    setX(589);
                    setY(63);
                    setMoney(10000);
                    setHouseNumber(3);
                }});
        houses.add(new House(){{
                    setX(814);
                    setY(63);
                    setMoney(50000);
                    setHouseNumber(4);
                }});
        houses.add(new House(){{
                    setX(953);
                    setY(261);
                    setMoney(100000);
                    setHouseNumber(5);
                }});
        houses.add(new House(){{
                    setX(710);
                    setY(257);
                    setMoney(500000);
                    setHouseNumber(6);
                }});
        houses.add(new House(){{
                    setX(455);
                    setY(273);
                    setMoney(1000000);
                    setHouseNumber(7);
                }});

        // Iterate over collection of house objects and init properties
        for(Iterator<House> i = houses.iterator(); i.hasNext(); ) {
            House house = i.next();
            addObject(house,house.getXCoordinate() ,house.getYCoordinate());
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

        // add Trees
        for(Iterator<Tree> i = trees.iterator(); i.hasNext(); ) {
            Tree tree = i.next();
            addObject(tree,tree.getXCoordinate() ,tree.getYCoordinate());
        }

        Police police = new Police();
        addObject(police,100,145);
    }
}