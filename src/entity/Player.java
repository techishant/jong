package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Entity{
    KeyHandler keyH = null;
    GamePanel gp = null;
    BufferedImage p1 = null;
    BufferedImage p2 = null;
    int imageCount = 1;
    BufferedImage image = null;
    int animTime;

    

    public Player(GamePanel gp, int x, int y, int width, int height, int speed, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        defaultData[0] = gp.screenWidth/2 - width/2;
        defaultData[1] = y;
        defaultData[2] = width;
        defaultData[3] = height;
        defaultData[4] = speed;
        defaultData[5] = defaultData[0];
        defaultData[6] = defaultData[1] + 30;
        defaultData[7] = width;
        defaultData[8] = 1;


        reset();
        loadImages();

        collision = true;
        solidArea = new Rectangle(defaultData[5], defaultData[6], defaultData[7], defaultData[8]);
    }
    
    public void loadImages(){
        try{
            p1 = ImageIO.read(getClass().getResourceAsStream("/res/blue2.png"));
            p2 = ImageIO.read(getClass().getResourceAsStream("/res/blue1.png"));
            image = p1; 
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    

    public void update(){
        if (keyH.leftPressed){
            this.x -= this.speed * gp.dt;
            this.solidArea.x = this.x;
        }
        if (keyH.rightPressed){
            this.x += this.speed * gp.dt;
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

        if (gp.ball.solidArea.intersects(solidArea) || animTime > 0){
            animTime++;
            image = p2;
            if (animTime > 10){
                animTime = 0;
            }
        }else{
            image = p1;
        }
        
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        // g2.fillRect(x, y, width, height);
        g2.drawImage(image, x, y,width, height, null);
        // g2.drawRect(solidArea.x, solidArea.y, solidArea.width, solidArea.height);
    }
}
