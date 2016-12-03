public class Score
{
    public int score;
    public String username;
    public int rank;

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
        return rank;
    }

    public void setRank(int rank){
        this.rank=rank;
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

