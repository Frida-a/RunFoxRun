package edu.uchicago.gerber._08final.mvc.model;

import edu.uchicago.gerber._08final.mvc.controller.CommandCenter;
import edu.uchicago.gerber._08final.mvc.controller.Game;
import edu.uchicago.gerber._08final.mvc.controller.GameOp;
import edu.uchicago.gerber._08final.mvc.model.Movable;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class Obstacle extends Sprite {

    //TODO: set bounds

    private final Rectangle[] bounds = {
            new Rectangle(getCenter().x+ 30, getCenter().y + 59, 29, 18),
    };
    private final double MOVE_SPEED = 10.0;
    public boolean alive = true;
    public static final int SPAWN_NEW_OBSTACLE = Game.FRAMES_PER_SECOND * 2;

    public enum ObstacleType{
        CACTUS,
        STONE,
    }

    public Obstacle(Point center, int width, int height, int type){
        super(width, height);
        setTeam(Team.FOE);
        setBounds(bounds);
        setCenter(center);
        setDeltaX(-MOVE_SPEED);
        Map<Integer, BufferedImage> rasterMap = new HashMap<>();
        switch (type){
            case 0:
                rasterMap.put(0, loadGraphic("/imgs/obstacles/cactus1.png") );
                break;
            case 1:
                rasterMap.put(0, loadGraphic("/imgs/obstacles/cactus2.png") );
                break;
            case 2:
                rasterMap.put(0, loadGraphic("/imgs/obstacles/stone1.png") );
                break;
            case 3:
                rasterMap.put(0, loadGraphic("/imgs/obstacles/stone2.png") );
                break;
            case 4:
                rasterMap.put(0, loadGraphic("/imgs/obstacles/stone3.png") );
                break;
            default:
                break;
        }

        setRasterMap(rasterMap);
    }

    @Override
    public void move(){
        super.move();
    }

    @Override
    public void draw(Graphics g){
        if (alive) {
            //System.out.println("render obst raster");
            renderRaster((Graphics2D) g, getRasterMap().get(0));
        }else{
            CommandCenter.getInstance().getOpsQueue().enqueue(this, GameOp.Action.REMOVE);
        }
    }

}
