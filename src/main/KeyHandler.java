package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    GamePanel gp = null;

    public KeyHandler(GamePanel gp){
        this.gp = gp;
    } 

    public boolean upPressed, rightPressed, downPressed, leftPressed;

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
            upPressed = true;
        }
        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){
            leftPressed = true;
        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
            downPressed = true;
        }
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
            rightPressed = true;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        switch(gp.gameState){
            case 0:
            gp.gameState =1;
            break;
            case -999:
            if (code == KeyEvent.VK_Q){
                System.exit(0);
            }else{
                gp.gameState = 2;
            }
            break;
        }
        
        if(code == KeyEvent.VK_P){
            gp.gameState = (gp.gameState == -1)? 1: -1;
        }
        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
            upPressed = false;
        }
        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
            downPressed = false;
        }
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Just a ritual: Not to be used
    }
    
}
