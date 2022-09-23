package entity;

import java.awt.Rectangle;

public class Entity {
    /**
     * <ol> 
     * <li>x</li>
     * <li>y</li>
     * <li>width</li>
     * <li>height</li>
     * <li>speed</li>
     * <li>collisionX</li>
     * <li>collisionY</li>
     * <li>collisionWidth</li>
     * <li>collisionHeight</li>
     * </ol> 
     * x, y, width, height, speed,collisionX,collisionY, collisionWidth, collisionHeight
     */
    int[] defaultData = new int[9];
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
        if (collision == true){
        solidArea = new Rectangle(defaultData[5], defaultData[6], defaultData[7], defaultData[8]);
        }
    }
}

