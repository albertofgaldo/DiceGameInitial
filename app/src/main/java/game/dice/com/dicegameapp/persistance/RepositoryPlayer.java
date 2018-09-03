package game.dice.com.dicegameapp.persistance;

import java.util.ArrayList;
import java.util.List;

import game.dice.com.dicegameapp.domain.Player;

public class RepositoryPlayer {

    protected List<Player> repositoryPlayer;

    public RepositoryPlayer(){
        repositoryPlayer=new ArrayList<>();
    }

    public void addPlayer(Player player)throws Exception{
        if(player==null)throw new Exception();
        repositoryPlayer.add(player);
    }

    public List<Player> getRepositoryPlayer(){
        return repositoryPlayer;
    }
}
