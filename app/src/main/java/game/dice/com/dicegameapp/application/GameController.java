package game.dice.com.dicegameapp.application;

import java.util.List;
import game.dice.com.dicegameapp.domain.*;
import game.dice.com.dicegameapp.persistance.RepositoryPlayer;


public class GameController {

	private Player player;
	private RepositoryPlayer repositoryPlayer= new RepositoryPlayer();

	public GameController() {

	}

	public void createPlayer(String name)throws Exception {

		this.player = new Player(name);
		if(player==null)throw new Exception();
		repositoryPlayer.addPlayer(this.player);
	}

	public String getPlayerName() {
		return player.getName();
	}

	public boolean playGame() {
		Game game = new Game();
		boolean hasWon = game.playGame();
		player.addGame(game);
		return hasWon;
	}

	public String getPlayerGamesToString() {
		String text = "";
		List<Game> games = player.getAllGames();

		for (Game game : games) {
			text += "SUMA: " + game.getSumDices() + " RESULTAT: " + game.hasWon();
		}
		return text;
	}

	public double getPlayerRanking() {
		List<Game> games = player.getAllGames();

		double wins = 0.0;
		for (Game game : games) {
			if (game.hasWon())
				wins++;
		}
		return wins / games.size();
	}

	public boolean existPlayer(String name)throws Exception{
		if(repositoryPlayer==null)throw new Exception("No hay repositorio");
		for (Player p:repositoryPlayer.getRepositoryPlayer()){
			if(p.getName()==name) {
				return true;
			}
		}
		return false;
	}

}
