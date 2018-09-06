package game.dice.com.dicegameapp.application.Controller;

import java.util.List;
import game.dice.com.dicegameapp.domain.*;
import game.dice.com.dicegameapp.persistance.RepositoryPlayer;


public class GameController {

	private static RepositoryPlayer repositoryPlayer= new RepositoryPlayer();
	private static int playerActual;

	public GameController() {

	}

	public void createPlayer(String name)throws Exception {

		Player player = new Player(name);
		if(player==null)throw new Exception();
		repositoryPlayer.addPlayer(player);
	}

	public boolean playGame(Player player) {
		Game game = new Game();
		boolean hasWon = game.playGame();
		player.addGame(game);
		return hasWon;
	}

	public String getPlayerGamesToString(Player player) {
		String text = "";
		List<Game> games = player.getAllGames();

		for (Game game : games) {
			text += "SUMA: " + game.getSumDices() + " RESULTAT: " + game.hasWon();
		}
		return text;
	}

	public double getPlayerRanking(Player player) {
		List<Game> games = player.getAllGames();

		double wins = 0.0;
		for (Game game : games) {
			if (game.hasWon())
				wins++;
		}
		return wins / games.size();
	}

	public boolean existPlayer(String name)throws Exception{
		for (Player p : repositoryPlayer.getRepositoryPlayer()){
			if(p.getName().equals(name)) {
				playerActual=p.hashCode();
				return true;
			}
		}
		return false;
	}

}
