package main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Main{
    public static void main(String[] args) {
        JFrame window = new JFrame();

        
        ImageIcon img = new ImageIcon("/res/icon.png");

        window.setIconImage(img.getImage());
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("PONG");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();


        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();
    }
}