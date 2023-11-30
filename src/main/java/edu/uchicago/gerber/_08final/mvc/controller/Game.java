package edu.uchicago.gerber._08final.mvc.controller;

import edu.uchicago.gerber._08final.mvc.model.*;
import edu.uchicago.gerber._08final.mvc.view.GamePanel;
import edu.uchicago.gerber._08final_ref.mvc.model.ShieldFloater;


import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Random;


// ===============================================
// == This Game class is the CONTROLLER
// ===============================================

public class Game implements Runnable, KeyListener {

    // ===============================================
    // FIELDS
    // ===============================================

    public static final Dimension DIM = new Dimension(1100, 900); //the dimension of the game.
    private final GamePanel gamePanel;
    //this is used throughout many classes.
    public static final Random R = new Random();

    public final static int ANIMATION_DELAY = 40; // milliseconds between frames

    public final static int FRAMES_PER_SECOND = 1000 / ANIMATION_DELAY;

    private final Thread animationThread;


    //key-codes
    private static final int
            PAUSE = 80, // p key
            QUIT = 81, // q key
            LEFT = 37, // rotate left; left arrow
            RIGHT = 39, // rotate right; right arrow
            UP = 38, // thrust; up arrow
            START = 83, // s key
            JUMP = 32, // space key
            MUTE = 77, // m-key mute

            NUKE = 78; // n-key mute

    // for possible future use
    // HYPER = 68, 					// D key
    //ALIEN = 65;                // A key
    // SPECIAL = 70; 					// fire special weapon;  F key

    private final Clip soundThrust;
    private final Clip soundBackground;



    // ===============================================
    // ==CONSTRUCTOR
    // ===============================================

    public Game() {

        gamePanel = new GamePanel(DIM);
        gamePanel.addKeyListener(this); //Game object implements KeyListener
        soundThrust = Sound.clipForLoopFactory("whitenoise.wav");
        soundBackground = Sound.clipForLoopFactory("music-background.wav");

        //fire up the animation thread
        animationThread = new Thread(this); // pass the animation thread a runnable object, the Game object
        animationThread.start();


    }

    // ===============================================
    // ==METHODS
    // ===============================================

    public static void main(String[] args) {
        //typical Swing application start; we pass EventQueue a Runnable object.
        EventQueue.invokeLater(Game::new);
    }

    // Game implements runnable, and must have run method
    @Override
    public void run() {

        // lower animation thread's priority, thereby yielding to the "main" aka 'Event Dispatch'
        // thread which listens to keystrokes
        animationThread.setPriority(Thread.MIN_PRIORITY);

        // and get the current time
        long startTime = System.currentTimeMillis();

        // this thread animates the scene
        while (Thread.currentThread() == animationThread) {


            //this call will cause all movables to move() and draw() themselves every ~40ms
            // see GamePanel class for details
            gamePanel.update(gamePanel.getGraphics());

            checkCollisions();
            checkNewLevel();
            checkObstacles();

            //keep track of the frame for development purposes
            CommandCenter.getInstance().incrementFrame();

            // surround the sleep() in a try/catch block
            // this simply controls delay time between
            // the frames of the animation
            try {
                // The total amount of time is guaranteed to be at least ANIMATION_DELAY long.  If processing (update)
                // between frames takes longer than ANIMATION_DELAY, then the difference between startTime -
                // System.currentTimeMillis() will be negative, then zero will be the sleep time
                startTime += ANIMATION_DELAY;

                Thread.sleep(Math.max(0,
                        startTime - System.currentTimeMillis()));
            } catch (InterruptedException e) {
                // do nothing (bury the exception), and just continue, e.g. skip this frame -- no big deal
            }
        } // end while
    } // end run

    private void checkObstacles(){
        spawnNewObstacles();
    }

    private void spawnNewObstacles(){
        if (CommandCenter.getInstance().getFrame() % Obstacle.SPAWN_NEW_OBSTACLE == 0) {
            Random r = new Random();
            int type = (r.nextInt()% 5) ;
            if(type < 0){// 50% chance of adding no obstacles
                return;
            }
            System.out.println("obs type is: "+ type);
            int centerX = 1099, centerY = 0, imgWidth = 100, imgHeight = 200;
            switch (type){
                case 0:
                    centerY = 650;
                    imgWidth = 42;
                    imgHeight = 111;
                    break;
                case 1:
                    centerY = 650;
                    imgWidth = 45;
                    imgHeight = 117;
                    break;
                case 2:
                    centerY = 683;
                    imgWidth = 80;
                    imgHeight = 51;
                    break;
                case 3:
                    centerY = 685;
                    imgWidth = 77;
                    imgHeight = 48;
                    break;
                case 4:
                    centerY = 690;
                    imgWidth = 64;
                    imgHeight = 38;
                    break;
            }
            CommandCenter.getInstance().getOpsQueue().enqueue(new Obstacle(new Point(centerX, centerY), imgWidth,imgHeight, type), GameOp.Action.ADD);
        }
    }


    private void checkCollisions() {

        Point pntFriendCenter, pntFoeCenter;
        int radFriend, radFoe;

        //This has order-of-growth of O(n^2), there is no way around this.
        //TODO collision between Friend and Foe
        processGameOpsQueue();

    }//end meth


    //This method adds and removes movables to/from their respective linked-lists.
    //This method is being called by the animationThread. The entire method is locked on the intrinsic lock of this
    // Game object. The main (Swing) thread also has access to the GameOpsQueue via the
    // key event methods such as keyReleased. Therefore, to avoid mutating the GameOpsQueue while we are iterating
    // it, we also synchronize the critical sections of the keyReleased and keyPressed methods below on the same
    // intrinsic lock.
    private synchronized void processGameOpsQueue() {

        //deferred mutation: these operations are done AFTER we have completed our collision detection to avoid
        // mutating the movable linkedlists while iterating them above.


        while(!CommandCenter.getInstance().getOpsQueue().isEmpty()){
            GameOp gameOp = CommandCenter.getInstance().getOpsQueue().dequeue();
            Movable mov = gameOp.getMovable();
            GameOp.Action action = gameOp.getAction();

            switch (mov.getTeam()) {
                case FRIEND:
                    if (action == GameOp.Action.ADD) {
                        System.out.println("Fox to add");
                        CommandCenter.getInstance().getMovFriends().add(mov);
                    } else { //GameOp.Operation.REMOVE
                        System.out.println("Fox removed from queue");
                        if (mov instanceof Fox) {
                            CommandCenter.getInstance().initFoxAndDecrementNumb();
                        } else {
                            CommandCenter.getInstance().getMovFriends().remove(mov);
                        }
                    }
                    break;
                case FOE:
                    if (action == GameOp.Action.ADD){
                        System.out.println("FOE to add");
                        CommandCenter.getInstance().getMovFoes().add(mov);
                    }else{
                        System.out.println("FOE removed from queue");
                        CommandCenter.getInstance().getMovFoes().remove(mov);
                    }


            }
        }
    }



    private void checkNewLevel() {

    }


    // Varargs for stopping looping-music-clips
    private static void stopLoopingSounds(Clip... clpClips) {
        Arrays.stream(clpClips).forEach(clip -> clip.stop());
    }

    // ===============================================
    // KEYLISTENER METHODS
    // ===============================================

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        Fox fox = CommandCenter.getInstance().getFox();
        if (keyCode == START && CommandCenter.getInstance().isGameOver()) {
            CommandCenter.getInstance().initGame();
            return;
        }


        switch (keyCode) {
            case JUMP:
                System.out.println("JUMP pressed");
                fox.setCurrentState("JUMPING");
                fox.setDeltaY(-fox.getMaxSpeed());
                Sound.playSound("thump.wav");
                break;
            case PAUSE:
                CommandCenter.getInstance().setPaused(!CommandCenter.getInstance().isPaused());
                if (CommandCenter.getInstance().isPaused()) stopLoopingSounds(soundBackground, soundThrust);
                break;
            case QUIT:
                System.exit(0);
                break;

            default:
                break;
        }

    }

    //key events are triggered by the main (Swing) thread which is listening for keystrokes. Notice that some of the
    // cases below touch the GameOpsQueue such as fire bullet and nuke.
    //The animation-thread also has access to the GameOpsQueue via the processGameOpsQueue() method.
    // Therefore, to avoid mutating the GameOpsQueue on the main thread, while we are iterating it on the
    // animation-thread, we synchronize on the same intrinsic lock. processGameOpsQueue() is also synchronized.
    @Override
    public void keyReleased(KeyEvent e) {

        int keyCode = e.getKeyCode();
        //show the key-code in the console
        System.out.println(keyCode);

        switch (keyCode) {

            //releasing either the LEFT or RIGHT arrow key will set the TurnState to IDLE
            case LEFT:

            case MUTE:
                CommandCenter.getInstance().setMuted(!CommandCenter.getInstance().isMuted());

                if (!CommandCenter.getInstance().isMuted()) {
                    stopLoopingSounds(soundBackground);
                } else {
                    soundBackground.loop(Clip.LOOP_CONTINUOUSLY);
                }
                break;

            default:
                break;
        }

    }

    @Override
    // does nothing, but we need it b/c of KeyListener contract
    public void keyTyped(KeyEvent e) {
    }

}


