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

    /**
     * Constructor for objects of class Level1.
     * 
     */
    public Level1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 768, 1); 

        prepare();
        actCounter = new Counter("Hours Left: ");
        addObject(actCounter, 80, 20);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        //actCounter.setValue(actCounter.getValue());
        List houses=new ArrayList<House>();
        List trees=new ArrayList<Tree>();

        trees.add(new FigTree(){{
                    setX(983);
                    setY(112);
                }});
        trees.add(new PineTree(){{
                    setX(105);
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
                }});
        houses.add(new House(){{
                    setX(357);
                    setY(53);
                }});
        houses.add(new House(){{
                    setX(589);
                    setY(60);
                }});
        houses.add(new House(){{
                    setX(814);
                    setY(58);
                }});
        houses.add(new House(){{
                    setX(953);
                    setY(261);
                }});
        houses.add(new House(){{
                    setX(710);
                    setY(257);
                }});
        houses.add(new House(){{
                    setX(455);
                    setY(273);
                }});

        for(Iterator<House> i = houses.iterator(); i.hasNext(); ) {
            House house = i.next();
            addObject(house,house.getX() ,house.getY());
        }

        for(Iterator<Tree> i = trees.iterator(); i.hasNext(); ) {
            Tree tree = i.next();
            addObject(tree,tree.getX() ,tree.getY());
        }

    }
}
