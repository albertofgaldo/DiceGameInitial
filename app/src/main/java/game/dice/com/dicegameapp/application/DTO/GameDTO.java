package game.dice.com.dicegameapp.application.DTO;

import game.dice.com.dicegameapp.domain.Dice;
import game.dice.com.dicegameapp.domain.Game;

public class GameDTO {

    private int dice1;
    private int dice2;

    public GameDTO(Game game){
        this.dice1=game.getDice1().getValue();
        this.dice2=game.getDice2().getValue();
    }

    public int getDice1(){
        return this.dice1;
    }

    public int getDice2(){
        return this.dice2;
    }
}
