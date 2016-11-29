public class LevelFactory  
{
    public static ILevel createLevel (String name) {
        if (name.equalsIgnoreCase ("Level1"))
        {
            return new Level2();
        }
        else if(name. equalsIgnoreCase ("Level2"))
        {
            return new Level3();
        }
        else if(name. equalsIgnoreCase ("Level3"))
        {
            return new Level4();
        }
        else if(name. equalsIgnoreCase ("Level4"))
        {
            return new GameMenu();
        }

        throw new IllegalArgumentException("No such Level");
    }
}
