public class Score
{
    public int score;
    public String username;


    public String getName()
    {
        return username;
    }
    public int getScore()
    {
        // put your code here
        return score;
    }

    
    public int getRank(){
    
        return 1;
    }
    
    
    
    public void setName(String name)
    {
        // put your code here
        this.username=name;
    }
    
    
    public void setScore(int score){
    
        this.score = score;
    }

}

