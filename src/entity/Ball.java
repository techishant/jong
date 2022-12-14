package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Rectangle;

public class Ball extends Entity {
    GamePanel gp = null;
    KeyHandler keyH = null;
    Random r = new Random();
    float speedX;
    float speedY;
    boolean intersected = false;

    public Ball(GamePanel gp, int x, int y, int height, int width, int speed, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        defaultData[0] = gp.screenWidth/2 - width/2;
        defaultData[1] = gp.screenHeight/2 - height/2;
        defaultData[2] = width;
        defaultData[3] = height;
        defaultData[4] = speed;
        defaultData[5] = defaultData[0];
        defaultData[6] = defaultData[1];
        defaultData[7] = width;
        defaultData[8] = height;

        reset();
        
        collision = true;
        solidArea = new Rectangle(defaultData[0], defaultData[1], defaultData[7], defaultData[8]);
    }

    public void reset(){
        this.x = defaultData[0];
        this.y = defaultData[1];
        this.width = defaultData[2];
        this.height = defaultData[3];
        this.speed = defaultData[4];
        this.speedX = speed;
        this.speedY = 0-speed;
    }

    public void update(){
        if (x <= 0 || this.x >= gp.screenWidth-width){
            speedX *= -1;
        }
        if(y <= 0 ){
            speedY *= -1;
        }
        if (solidArea.intersects(gp.player1.solidArea) && this.speedY >0){
            gp.score++;
            speedY *= -1;
            speedY = (speedY<0) ? speedY - 0.2F: speedY + 0.2F;
            speedX = (speedX<0) ? speedX - 0.2F: speedX + 0.2F;
        }
        if (y >= gp.screenHeight-height){
            gp.gameState = -999;
        }
        if (gp.gameState == -999){
            speedX=0;
            speedY=0;
            x = gp.screenWidth/2 - width/2;
            y = gp.screenHeight/2;
        }

        x += speedX * gp.dt;
        y += speedY * gp.dt;
        this.solidArea.x = x;
        this.solidArea.y = y;

        // System.out.println(speedX + " " + speedY);
    }

    Color ballColor = Color.green; 
    public void draw(Graphics g2){
        g2.setColor(ballColor);
        g2.fillOval(x, y, width, height);
    }
}
