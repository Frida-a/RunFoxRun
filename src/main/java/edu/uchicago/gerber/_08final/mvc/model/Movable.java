package edu.uchicago.gerber._08final.mvc.model;

import java.awt.*;
import java.util.List;

public interface Movable {

	enum Team {FRIEND, FOE, LAND, COIN}

	//for the game to move and draw movable objects. See the GamePanel class.
	void move();
	void draw(Graphics g);

	//for collision detection
	List<Rectangle> getBounds();
	boolean isProtected();
	Team getTeam();


} //end Movable
