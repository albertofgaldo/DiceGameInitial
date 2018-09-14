package game.dice.com.dicegameapp.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private int id;
	private String name;
	private List<Game> games=new ArrayList<>();
	private static int counter=1;
	
	public Player(String name){		
		this.name=name;
		this.id=counter;
		this.counter++;
	}

	public int getId(){return id;}
	
	public String getName(){
		return name;
	}
	
	public void addGame(Game game){
		this.games.add(game);
	}

	public List<Game> getAllGames() {
		return games;
	}

}
