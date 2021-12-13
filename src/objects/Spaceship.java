
package objects;

import core.FPS;
import core.Input;
import core.Window;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import render.Renderable;
import render.Renderer;
import update.Updateable;
import update.Updater;


public class Spaceship implements Renderable, Updateable{
    public static double width = 75;
    private static double height = 75;
    private double x;
    private double y;
    
    private int layer = 1;
    
    private static BufferedImage spaceShip;
    
    private double speed = 200;
    
    public Spaceship(double x, double y) throws IOException{
        this.x=x;
        this.y=y;
        
        spaceShip = ImageIO.read(new File("res/000.jpg"));
        Renderer.addRenderableObject(this);
        Updater.addUpdateableObjects(this);
        
    }

    public  double getWidth() {
        return width;
    }

    public static void setWidth(double width) {
        Spaceship.width = width;
    }

    public  double getHeight() {
        return height;
    }

    public static void setHeight(double height) {
        Spaceship.height = height;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }



    @Override
    public int getLayer() {
        return layer;
    }

    @Override
    public void update() {
        if(Input.keys[Input.RIGHT] && x <=Window.getWinWidth() - width){
            x += speed * FPS.getDeltaTime();
        }
        if(Input.keys[Input.LEFT] && x >= 0){
            x -= speed * FPS.getDeltaTime();
        }
        if(Input.keys[Input.UP] && y >= 0){
            y -= speed * FPS.getDeltaTime();
        }
        if(Input.keys[Input.DOWN] && y <=Window.getWinHeight() - height){
            y += speed * FPS.getDeltaTime();
        }
    }


    @Override
    public BufferedImage getBufferedImage() {
        return spaceShip;
    }
}
