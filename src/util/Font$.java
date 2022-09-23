package util;

import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.font.TextAttribute;

import java.util.Map;

import main.GamePanel;

public class Font$ {
    GamePanel gp =null;

    public Font$(GamePanel gp){
        this.gp = gp;
    }

    /**
     * Just to draw String on screen and reduce the pain of writing boilers repeatedly. :)
     * 
     * @param text
     * @param x
     * @param y
     * @param g2
     * 
     */
    public void drawFont(String text, int x, int y, Font font, int size, boolean underline, Graphics2D g2){
        int x2 = 0;
        int y2 = 0;
        g2.setFont(font);


        if (font.getSize() != size){
            g2.setFont(font.deriveFont(Font.PLAIN, size));
        }

        if (underline){
            Map underlineMaps  = font.getAttributes();
            underlineMaps.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            underlineMaps.put(TextAttribute.SIZE, 80);
            underlineMaps.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
            g2.setFont(font.deriveFont(underlineMaps));

        }

        if (x == gp.screenWidth/2){
            int length = (int) g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x2 = x-length/2;
        }else{
            x2 = x;
        }
        if (y == gp.screenHeight/2){
            int length = (int) g2.getFontMetrics().getStringBounds(text,g2).getHeight();
            y2 = y-length/2;
        }
        {
            y2 = y;
        }
        

        g2.drawString(text, x2, y2);
    }
}
