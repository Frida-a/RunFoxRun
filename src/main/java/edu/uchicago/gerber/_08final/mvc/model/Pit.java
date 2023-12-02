package edu.uchicago.gerber._08final.mvc.model;

import edu.uchicago.gerber._08final.mvc.controller.CommandCenter;
import edu.uchicago.gerber._08final.mvc.controller.GameOp;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class Pit extends Sprite{
    private final double MOVE_SPEED = 10.0;
    public Pit(int width, int height, int type){
        super(width, height);
        setTeam(Team.FOE);
        //center set when sprawling
        //bounds set after center set
        setDeltaX(-MOVE_SPEED);
        Map<Integer, BufferedImage> rasterMap = new HashMap<>();
        switch (type){
            case 0:
                rasterMap.put(0, loadGraphic("/imgs/utils/pit1.png") );
                break;
            case 1:
                rasterMap.put(0, loadGraphic("/imgs/utils/pit2.png") );
                break;
            case 2:
                rasterMap.put(0, loadGraphic("/imgs/utils/pit3.png") );
                break;
            default:
                break;
        }
        setRasterMap(rasterMap);
    }

    @Override
    public void move(){
        //super.move();
        setCenter(new Point(getCenter().x+(int)getDeltaX(), getCenter().y));
        if (getCenter().x + 50  < 0){
            System.out.println("inside Pis: center x"+getCenter().x);
            CommandCenter.getInstance().getOpsQueue().enqueue(this, GameOp.Action.REMOVE);
            System.out.println("pit "+ " removed");
        }
    }

    @Override
    public void draw(Graphics g){
        // draw by background image
    }
}
