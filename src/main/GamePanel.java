package main;

import javax.swing.JPanel;

import entity.Ball;
import entity.Player;
import ui.UI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Color;


public class GamePanel extends JPanel implements Runnable{
    Thread gameThread;
    int FPS = 60;
    public final int screenWidth = 768; //768px
    public final int screenHeight = 576;//576px
    public KeyHandler keyH = new KeyHandler(this);
    UI ui = new UI(this);
    public int recFPS;
    
    public int score = 0;
    public Player player1 = new Player(this, 00, 545, 120, 25, 6, keyH);
    Ball ball = new Ball(this, 00, 00, 25, 25, 5, keyH);
    
    /**
     * <ul>
     * <li> -999 -> Game Over </li>
     * <li> -1 -> paused  </li>
     * <li> 0 -> Not started yet </li>
     * <li> 1 -> on  </li>
     * <li> 2 -> restart game </li>
     * </ul>
     */
    public int gameState = 0;



    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }


    @Override
    public void run() {
        double drawInterval = 1000000000/FPS; //0.016666s
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null){

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime)/drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >=1000000000){
                recFPS = drawCount;
                timer =0;
                drawCount = 0;
            }
        }
    }
    
    public void update(){
        switch(gameState){
            case 1:
                ball.update();
                player1.update();
                break;
            case 2:
                ball.reset();
                player1.reset();
                score = 0;
                gameState= 0;
                break;
        }
        
        ui.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        player1.draw(g2);
        ball.draw(g2);
        ui.draw(g2);


        g2.dispose();
    }
}
