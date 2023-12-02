package edu.uchicago.gerber._08final.mvc.model;

import edu.uchicago.gerber._02arrays.P7_5;
import edu.uchicago.gerber._08final.mvc.controller.CommandCenter;
import edu.uchicago.gerber._08final.mvc.controller.Game;
import edu.uchicago.gerber._08final.mvc.controller.GameOp;
import javafx.util.Pair;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

public class BackGround extends Sprite{
    private final double MOVE_SPEED = 10.0;
    private final int groundLevel = 685;

    private static Map<Integer, Pit> pits = new HashMap<>();
    // Pits on background mapped with its location index


    public BackGround(Point center){
        super(2200, 900);
        setCenter(center);
        setDeltaX(-MOVE_SPEED);
        setTeam(Team.FRIEND);
        Map<Integer, BufferedImage> rasterMap = new HashMap<>();
        rasterMap.put(0, loadGraphic("/imgs/background.png") );

        setRasterMap(rasterMap);
        //System.out.println("bg init time");
        //System.out.println("pits num: "+ pits.size());
        //spawnPits(1);
        // cannot spawn the pits in the constructor, the singleton CommandCenter would try to init again and again
    }

    private void spawnPits(int times){

        for (int i = 0; i < times; i++){
            //System.out.println("spawn times left" + i);
            int intervalidx = ThreadLocalRandom.current().nextInt(12, 22);
            // int intervalidx = 21;
            //System.out.println("pits id " + intervalidx);
            if (!pits.containsKey(intervalidx)){
                Pit current = spawnOnePit();
                System.out.println("at "+intervalidx+" !");
                pits.put(intervalidx, current);
                //set center for the pit
                int centerX = (intervalidx - 11) * 100 + this.getCenter().x + 50;
                int centerY = 685 + current.getHeight()/2;
                current.setCenter(new Point(centerX, centerY));
                current.setDeltaX(-MOVE_SPEED);
            }
        }
    }

    private Pit spawnOnePit(){
        int type = ThreadLocalRandom.current().nextInt(0, 3);
        int width = 100;
        int height = 45;
        switch (type){
            case 0:
                height = 72;
                break;
            case 1:
                height = 45;
                break;
            case 2:
                height = 59;
                break;
            default:
                break;
        }
        Pit current = new Pit(width, height, type);
        CommandCenter.getInstance().getOpsQueue().enqueue(current, GameOp.Action.ADD);
        System.out.println("spawn one pit "+type);

        return current;
    }

    private void drawPits(Graphics g){
        for(Integer i: pits.keySet()){
            Pit current = pits.get(i);
            int centerX = current.getCenter().x;
            System.out.println("pits center x: "+current.getCenter().x);
            if(centerX + 50 > 0){
                current.renderRaster((Graphics2D) g, current.getRasterMap().get(0));
            }

        }
    }

    private void removePits(){
        for (Integer i : pits.keySet()) {
            Pit current = pits.get(i);

            if(current.getCenter().x + 150 < 0){ // if input 50 there will be a concurrent modification exception
                pits.remove(i);
                System.out.println("pits "+ i + "removed from bg map");
            }

        }
    }


    @Override
    public void move(){
        if(getCenter().x < 0){
            removePits();
            super.move();
            spawnPits(3);
        }else{
            super.move();
        }

    }

    @Override
    public void draw(Graphics g){
        renderRaster((Graphics2D) g, getRasterMap().get(0));
        drawPits(g);
    }

}
