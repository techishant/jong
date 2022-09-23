package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;


import main.GamePanel;
import util.Font$;

public class UI {
    GamePanel gp;
    Font arial_40;
    Font consolas_20;
    String score;
    Font$ font;

    public UI(GamePanel gp){
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        consolas_20 = new Font("Consolas", Font.PLAIN, 20);
        font = new Font$(gp);
    }

    public void update(){
        score = "" + gp.score;
    }


    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        switch (gp.gameState) {
            case -999:
                font.drawFont("GAME OVER", gp.screenWidth/2, gp.screenHeight/2 - 10, arial_40, 80,false, g2);
                g2.setFont(consolas_20);
                font.drawFont("Press any key to restart", gp.screenWidth/2, gp.screenHeight/2 + 50, consolas_20, 20,false, g2);
                font.drawFont("Press 'q' to exit", gp.screenWidth/2, gp.screenHeight/2 + 90, consolas_20, 20,false, g2);
                break;
            case -1:
                g2.setColor(Color.WHITE);
                font.drawFont("Paused", gp.screenWidth/2, gp.screenHeight/2, arial_40, 55, false, g2);
                break;
            case 0:
                font.drawFont("JONG", gp.screenWidth/2, gp.screenHeight/2 - 40, arial_40, 80,true, g2);
                font.drawFont("> Press 'A' or 'D' to control <", gp.screenWidth/2, gp.screenHeight/2 + 40, consolas_20, 20,false, g2);
                break;
        }


        g2.setFont(arial_40);
        g2.drawString(score, 10, 40);
        g2.setFont(consolas_20);
        g2.drawString("FPS: " + gp.recFPS, gp.screenWidth-20*5, 20);
    }
}
