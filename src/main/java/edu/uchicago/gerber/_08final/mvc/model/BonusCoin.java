package edu.uchicago.gerber._08final.mvc.model;

import edu.uchicago.gerber._08final.mvc.controller.CommandCenter;
import edu.uchicago.gerber._08final.mvc.controller.Game;
import edu.uchicago.gerber._08final.mvc.controller.GameOp;

import java.awt.*;

public class BonusCoin extends Coin{
    public static final int SPAWN_BOUNS_COIN = Game.FRAMES_PER_SECOND * 3;
    private int stepTimer = 0;
    public boolean alive = true;
    public BonusCoin(){
        super();
        setHeight(70);
        setWidth(70);
        setCenter(new Point(1099, 500));
        getBounds().clear();
        getBounds().add(new Rectangle(getCenter().x - 35, getCenter().y - 35,70 , 70));
    }
    public void move(){
        super.move();
    }
    public void draw(Graphics g){
        if(alive){
            switch (stepTimer){
                case 0:
                    setWidth(10);
                    break;
                case 1:
                    setWidth(58);
                    break;
                case 2:
                    setWidth(70);
                    break;
                case 3:
                    setWidth(58);
                    break;
                default:
                    break;
            }
            renderRaster((Graphics2D) g, getRasterMap().get(stepTimer));
            if (getLifeSpan() % 2 == 0) {//times 2 to make coin moves slower
                stepTimer++;
                stepTimer = stepTimer % 4;//4 images in total
            }
        }else{
            System.out.println("Bouns Coin remove request sent");
            CommandCenter.getInstance().getOpsQueue().enqueue(this, GameOp.Action.REMOVE);
        }

    }
}