/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import core.FPS;
import core.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import render.Renderable;
import render.Renderer;
import update.Updateable;
import update.Updater;

/**
 *
 * @author ins
 */
public class Background implements  Renderable, Updateable{
    private static double width = Window.getWinWidth();
    private static double height = Window.getWinHeight() * 2;
    private static double x;
    private double y;
    
    private final int layer = 0;
    
    private static BufferedImage background;
    
    private double speed = 200;
    
    public Background(double y) throws IOException{
        this.y = y;
        
        background = ImageIO.read(new File("res/background.png"));
        Renderer.addRenderableObject(this);
        Updater.addUpdateableObjects(this);
    }

    @Override
    public int getLayer() {
        return layer;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public BufferedImage getBufferedImage() {
        return background;
    }

    @Override
    public void update() {
        y += speed * FPS.getDeltaTime();
        
        if(y >= 0){
            y = -Window.getWinHeight();
        }
    }
    
}
