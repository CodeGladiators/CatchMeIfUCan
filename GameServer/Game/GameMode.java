
public interface GameMode  
{
    public String getGameMode();
}

class SinglePlayer implements GameMode{

    public String getGameMode(){

        return "SinglePlayer";
    }
}

class MultiPlayer implements GameMode{

    public String getGameMode(){

        return "MultiPlayer";
    }
}