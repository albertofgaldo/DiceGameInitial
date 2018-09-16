package game.dice.com.dicegameapp.persistance;

import java.util.ArrayList;
import java.util.List;

import game.dice.com.dicegameapp.domain.Player;
import game.dice.com.dicegameapp.utilities.ExceptionPlayerNull;

public class RepositoryPlayer {

    protected static List<Player> repositoryPlayer;

    public RepositoryPlayer(){
        repositoryPlayer=new ArrayList<>();
    }

    public void addPlayer(Player player)throws ExceptionPlayerNull{
        if(player==null)throw new ExceptionPlayerNull();
        repositoryPlayer.add(player);
    }

    public List<Player> getRepositoryPlayer(){
        return repositoryPlayer;
    }
}
