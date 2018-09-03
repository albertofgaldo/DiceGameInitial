package game.dice.com.dicegameapp.application;

import game.dice.com.dicegameapp.domain.Dice;
import game.dice.com.dicegameapp.domain.Game;

public class GameDTO {

    private Dice dice1;
    private Dice dice2;

    public GameDTO(Game game){
        this.dice1=game.getDice1();
        this.dice2=game.getDice2();
    }

    public Dice getDice1(){
        return this.dice1;
    }

    public Dice getDice2(){
        return this.dice2;
    }
}
