package entity;

import java.awt.Graphics;

import main.GamePanel;
import main.KeyHandler;

import java.awt.Color;
import java.awt.Rectangle;

public class Player extends Entity{
    KeyHandler keyH = null;
    GamePanel gp = null;
    

    public Player(GamePanel gp, int x, int y, int width, int height, int speed, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        defaultData[0] = gp.screenWidth/2 - width/2;
        defaultData[1] = y;
        defaultData[2] = width;
        defaultData[3] = height;
        defaultData[4] = speed;
        defaultData[5] = width;
        defaultData[6] = 1;


        reset();

        collision = true;
        solidArea = new Rectangle(defaultData[0], defaultData[1], defaultData[5], defaultData[6]);
    }
    
    

    public void update(){
        if (keyH.leftPressed){
            this.x -= this.speed;
            this.solidArea.x = this.x;
        }
        if (keyH.rightPressed){
            this.x += this.speed;
            this.solidArea.x = this.x;
        }
        
        if(this.x < 0 - this.width){
            this.x = gp.screenWidth - this.width;
            this.solidArea.x = this.x;
        }
        if (this.x > gp.screenWidth){
            this.x = 0;
            this.solidArea.x = this.x;
        }


        if (gp.gameState == -999){
            x = gp.screenWidth/2 - width/2;
            speed = 0;
        }
    }

    public void draw(Graphics g2){
        g2.setColor(Color.white);
        g2.fillRect(x, y, width, height);
    }
}
