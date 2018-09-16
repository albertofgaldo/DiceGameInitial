package game.dice.com.dicegameapp.application.Controller;

import java.util.List;

import game.dice.com.dicegameapp.application.DTO.PlayerDTO;
import game.dice.com.dicegameapp.utilities.*;
import game.dice.com.dicegameapp.domain.*;
import game.dice.com.dicegameapp.persistance.RepositoryPlayer;


public class GameController {

	private static RepositoryPlayer repositoryPlayer= new RepositoryPlayer();


	public GameController() {

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
			text += "SUMA: " + game.getSumDices() + " RESULTAT: " + game.hasWon() + "\n";
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

	public boolean existGame (Player player){
		if(player.getAllGames()==null){
			return false;
		}else{
			return true;
		}
	}

	public Game getLastGame(Player player){
		return player.getAllGames().get(player.getAllGames().size()-1);
	}
}
