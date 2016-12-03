import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.*;

/**
 * An actor class that can display a scoreboard, using Greenfoot's
 * UserInfo class.  
 * 
 * You typically use this by including some code into the world for when your game ends:
 * 
 * <pre>
 *   addObject(new ScoreBoard(800, 600), getWidth() / 2, getHeight() / 2); 
 * </pre>
 * 
 * Where 800 by 600 should be replaced by the desired size of the score board. 
 * 
 * @author Neil Brown 
 * @version 1.0
 */
public class ScoreBoard extends Actor
{
    // The vertical gap between user images in the scoreboard:
    private static final int GAP = 10;
    // The height of the "All Players"/"Near Me" text at the top:
    private static final int HEADER_TEXT_HEIGHT = 25;
    // The main text color:
    private static final Color MAIN_COLOR = new Color(0x60, 0x60, 0x60); // dark grey
    // The score color:
    private static final Color SCORE_COLOR = new Color(0xB0, 0x40, 0x40); // orange-y
    // The background colors:
    private static final Color BACKGROUND_COLOR = new Color(0xFF, 0xFF, 0xFF, 0xB0);
    private static final Color BACKGROUND_HIGHLIGHT_COLOR = new Color(180, 230, 255, 0xB0);

    ArrayList<Score> allPlayers;
    /**
     * Constructor for objects of class ScoreBoard.
     * <p>
     * You can specify the width and height that the score board should be, but
     * a minimum width of 600 will be enforced.
     */
    public ScoreBoard(int width, int height,ArrayList<Score> users)
    {    
        setImage(new GreenfootImage(Math.max(600, width), height)); 
        allPlayers = users;
        drawScores();
    }
    
    private void drawString(String text, int x, int y, Color color, int height)
    {
        getImage().drawImage(new GreenfootImage(text, height, color, new Color (0, true)), x, y);
    }
    
    private void drawScores()
    {
        // 50 pixels is the max height of the user image
        final int pixelsPerUser = 50 + 2*GAP;
        // Calculate how many users we have room for:
        final int numUsers = ((getImage().getHeight() - (HEADER_TEXT_HEIGHT + 10)) / pixelsPerUser);
        final int topSpace = getImage().getHeight() - (numUsers * pixelsPerUser) - GAP;
        
        getImage().setColor(BACKGROUND_COLOR);
        getImage().fill();

        drawString("All Players", 100, topSpace - HEADER_TEXT_HEIGHT - 5, MAIN_COLOR, HEADER_TEXT_HEIGHT);
        
        drawUserPanel(GAP, topSpace, (getImage().getWidth() / 2) - GAP, topSpace + numUsers * pixelsPerUser, allPlayers);
    }
    
    private void drawUserPanel(int left, int top, int right, int bottom, List users)
    {
        getImage().setColor(MAIN_COLOR);
        getImage().drawRect(left, top, right - left, bottom - top);
        
        if (users == null)
            return;
        
            drawString("Rank", left + 10, top  , SCORE_COLOR, 14);
            
            drawString("Score ", left + 100, top , SCORE_COLOR, 14);
            
            drawString("Name", left + 210, top , MAIN_COLOR, 14);
            
            
        Player me = Player.getInstance();
        int y = top + GAP + 18;
        for (Object obj : users)
        {
            Score playerData = (Score)obj;            
            Color c;
            
            if (me != null && playerData.getName().equals(me.getName()))
            {
                // Highlight our row in a sky blue colour:
                c = BACKGROUND_HIGHLIGHT_COLOR;
            }
            else
            {
                c = BACKGROUND_COLOR;
            }
            getImage().setColor(c);
            getImage().fillRect(left + 5, y - GAP + 1, right - left - 10, 50 + 2*GAP - 1);

            int x = left + 30;
            
            
            
            drawString(Integer.toString(playerData.getRank()), x, y+18, SCORE_COLOR, 14);
            x += 80;
            
            drawString(Integer.toString(playerData.getScore()), x, y+18, SCORE_COLOR, 14);
            x += 80;
            drawString(playerData.getName(), x, y + 18, MAIN_COLOR, 14);
            y += 50 + 2*GAP;
        }
    }
}