package edu.uchicago.gerber._08final.mvc.model;

import java.awt.*;

public interface Movable {

	enum Team {FRIEND, FOE, LAND, COIN}

	//for the game to move and draw movable objects. See the GamePanel class.
	void move();
	void draw(Graphics g);

	//for collision detection
	Rectangle[] getBounds();
	boolean isProtected();
	Team getTeam();


} //end Movable
