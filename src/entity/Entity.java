package entity;

import java.awt.Rectangle;

public class Entity {
    /**
     * defaultData = x, y, width, height, speed
     */
    int[] defaultData = new int[5];
    int x, y;
    int height,width;
    float speed;
    boolean collision = false;
    public Rectangle solidArea;


    public void reset(){
        this.x = defaultData[0];
        this.y = defaultData[1];
        this.width = defaultData[2];
        this.height = defaultData[3];
        this.speed = defaultData[4];
    }
}

