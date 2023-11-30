package edu.uchicago.gerber._08final.mvc.model;

import edu.uchicago.gerber._02arrays.P7_5;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class BackGround extends Sprite{
    private final double MOVE_SPEED = 10.0;
    public BackGround(Point center){
        super(2200, 900);
        setCenter(center);
        setDeltaX(-MOVE_SPEED);
        setTeam(Team.FRIEND);
        Map<Integer, BufferedImage> rasterMap = new HashMap<>();
        rasterMap.put(0, loadGraphic("/imgs/background.png") );

        setRasterMap(rasterMap);
    }

    @Override
    public void move(){
        super.move();

    }

    @Override
    public void draw(Graphics g){
        renderRaster((Graphics2D) g, getRasterMap().get(0));
    }

}
