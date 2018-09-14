package game.dice.com.dicegameapp.application.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import game.dice.com.dicegameapp.domain.Game;
import game.dice.com.dicegameapp.domain.Player;

public class PlayerDTO implements Serializable {

    private int id;
    private String name;
    private List<GameDTO> games=new ArrayList<>();

    public PlayerDTO(Player player){

        this.id=player.getId();
        this.name=player.getName();
        for(Game game:player.getAllGames()){
            this.games.add(new GameDTO(game));
        }
    }

    public int getId(){return this.id;}

    public String getName(){
        return this.name;
    }

    public List<GameDTO> getGames(){
        return this.games;
    }
}
