package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {
    GamePanel gp;
    Font arial_40;
    Font consolas_20;
    String score;

    public UI(GamePanel gp){
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        consolas_20 = new Font("Consolas", Font.PLAIN, 20);
    }

    public void update(){
        score = "" + gp.score;
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        switch (gp.gameState) {
            case -999:
                g2.setFont(arial_40);
                g2.drawString("GAME OVER", gp.screenWidth/2 - 40*3, gp.screenHeight/2);
                g2.setFont(consolas_20);
                g2.drawString("Press any key to restart.", gp.screenWidth/2 - 40*3, gp.screenHeight/2 + 80);
                g2.drawString("Press 'q' to exit.", gp.screenWidth/2 - 40*3, gp.screenHeight/2 + 100);
                break;
            case -1:
                g2.setFont(arial_40);
                g2.drawString("Paused", gp.screenWidth/2 - 40*3, gp.screenHeight/2);
                break;
            case 0:
                g2.setFont(arial_40);
                g2.drawString("JONG", gp.screenWidth/2 - 40*1, gp.screenHeight/2-20);
                g2.setFont(consolas_20);
                g2.drawString("Press 'a' or 'd' to control", gp.screenWidth/2 - 40*3, gp.screenHeight/2 + 80);
                break;
        }


        g2.setFont(arial_40);
        g2.drawString(score, 10, 40);
        g2.setFont(consolas_20);
        g2.drawString("FPS: " + gp.recFPS, gp.screenWidth-20*5, 20);
    }
}
