package edu.uchicago.gerber._08final.mvc.controller;



import edu.uchicago.gerber._08final.mvc.model.*;
import lombok.Data;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

//The CommandCenter is a singleton that manages the state of the game.
//the lombok @Data gives us automatic getters and setters on all members
@Data
public class CommandCenter {

	private int numFoxes;
	private  int level;
	private  long score;
	private  boolean paused;
	private  boolean muted;

	//this value is used to count the number of frames (full animation cycles) in the game
	private long frame;

	//the fox is located in the movFriends list, but since we use this reference a lot, we keep track of it in a
	//separate reference. Use final to ensure that the fox ref always points to the single fox object on heap.
	//Lombok will not provide setter methods on final members

	private final Fox fox = new Fox();

	private  final BackGround bgImage1 = new BackGround(new Point(899, 450));
	//private  final BackGround bgImage2 = new BackGround(new Point(1100, 450));

	//lists containing our movables subdivided by team
	private final List<Movable> movFriends = new LinkedList<>();
	private final List<Movable> movFoes = new LinkedList<>();

	private final GameOpsQueue opsQueue = new GameOpsQueue();


	//for sound playing. Limit the number of threads to 5 at a time.
	private final ThreadPoolExecutor soundExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

	//singleton
	private static CommandCenter instance = null;

	// Constructor made private
	private CommandCenter() {}

    //this class maintains game state - make this a singleton.
	public static CommandCenter getInstance(){
		if (instance == null){
			instance = new CommandCenter();
		}
		return instance;
	}


	public void initGame(){
		clearAll();
		setLevel(0);
		setScore(0);
		setPaused(false);
		//set to one greater than number of fox lives in your game as initFoxAndDecrementNum() also decrements

		setNumFoxes(2);
		initFoxAndDecrementNumb();
		opsQueue.enqueue(bgImage1, GameOp.Action.ADD);
		//opsQueue.enqueue(bgImage2, GameOp.Action.ADD);
		//add the fox to the movFriends list
		opsQueue.enqueue(fox, GameOp.Action.ADD);




	}


	public void initFoxAndDecrementNumb(){
		numFoxes--;
		if(isGameOver()) return;
		// fox.setCenter(new Point(Game.DIM.width / 5, fox.getCurrentHeight()));
		fox.setDeltaX(0);
		fox.setDeltaY(0);
	}


	public void incrementFrame(){
		//use of ternary expression to simplify the logic to one line
		frame = frame < Long.MAX_VALUE ? frame + 1 : 0;
	}

	private void clearAll(){
		movFriends.clear();
		movFoes.clear();
	}

	public boolean isGameOver() {		//if the number of foxes is zero, then game over
		return numFoxes < 1;
	}


}
