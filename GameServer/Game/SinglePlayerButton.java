import greenfoot.*;  
import javax.swing.JOptionPane;

public class SinglePlayerButton extends GameMenuComponents
{   
    String username = "";
    String text = "Enter username";
    private Client client = new Client(Constant.URL.register);

    public void act() 
    {
        moveInAnimation();
        clickListener();
    }

    public void moveInAnimation(){
        if(getX() < 600){
            move(20);
        }
    }

    public void clickListener(){

        if (Greenfoot.mouseClicked(this))
        {
            username = "";
            System.out.println("singleplayer clicked");
            try{
                System.out.println("Inside try");
                username = JOptionPane.showInputDialog(text);
                System.out.println("Inside if : "+username);

                //Check if username is empty or duplicate
                if(username!=null && !username.equals("")){
                    JOptionPane.showMessageDialog(null, "Hello "+username);
                    Player player=Player.getInstance();
                    player.setName(username);
                    //player.setName(username);
                    Greenfoot.setWorld(new Level1());
                    Player.getInstance().setGameMode(new SinglePlayer());
                }
                else{
                    JOptionPane.showMessageDialog(null, "Either empty. Please try again");
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }

    }
}
