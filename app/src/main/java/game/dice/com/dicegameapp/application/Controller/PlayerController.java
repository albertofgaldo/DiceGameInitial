package game.dice.com.dicegameapp.application.Controller;

import game.dice.com.dicegameapp.application.DTO.PlayerDTO;
import game.dice.com.dicegameapp.domain.Player;
import game.dice.com.dicegameapp.persistance.RepositoryPlayer;
import game.dice.com.dicegameapp.utilities.ExceptionPlayerNull;

public class PlayerController {

    private static RepositoryPlayer repositoryPlayer= new RepositoryPlayer();

    public boolean existPlayer(String name){
        for (Player p : repositoryPlayer.getRepositoryPlayer()){
            if(p.getName().equals(name)) {
                //playerActual=p;
                return true;
            }
        }
        return false;
    }

    public Player createPlayer(String name)throws RuntimeException {

        Player player = new Player(name);
        repositoryPlayer.addPlayer(player);
        return (player);
    }

    public Player getPlayer(String name) {

        for (Player p : repositoryPlayer.getRepositoryPlayer()) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    public Player getPlayerById (int id)throws ExceptionPlayerNull {
        for (Player p : repositoryPlayer.getRepositoryPlayer()){
            if(p.getId()==id);
            //playerActual=p;
            return p;
        }
        throw new ExceptionPlayerNull();
    }
}
