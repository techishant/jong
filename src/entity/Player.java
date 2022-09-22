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

        defaultData[0] = x;
        defaultData[1] = y;
        defaultData[2] = width;
        defaultData[3] = height;
        defaultData[4] = speed;

        reset();

        collision = true;
        solidArea = new Rectangle(0, y, width, 1);
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
    }

    public void draw(Graphics g2){
        g2.setColor(Color.white);
        g2.fillRect(x, y, width, height);
    }

}
