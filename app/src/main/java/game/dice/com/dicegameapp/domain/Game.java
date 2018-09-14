package game.dice.com.dicegameapp.domain;

public class Game {

	private int id;
	private Dice dice1=new Dice();
	private Dice dice2=new Dice();
	private int counter=1;

	public Game(){

	}
	
	public boolean playGame() {

		id=counter;
		counter++;

		dice1.rollDice();
		dice2.rollDice();
		
		return hasWon();
	}
	
	public int getSumDices(){
		return dice1.getValue()+dice2.getValue();	
	}
	
	public boolean hasWon() {
		return getSumDices()==7;
	}

	public Dice getDice1() {
		return dice1;
	}

	public Dice getDice2() {
		return dice2;
	}

	public int getId(){return id;}
}
