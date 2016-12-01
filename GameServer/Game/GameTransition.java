import greenfoot.*;  

public class GameTransition extends World
{
    
    public GameTransition()
    {   
        super(1024, 768, 1); 
        prepare();
        //Greenfoot.setWorld(new GameMenu());
    }

    public void prepare(){
        NextButton next= new NextButton();
        addObject(next,900 ,320);
    }

    public void act(){

    }
}
