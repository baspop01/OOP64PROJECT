package SquidJump;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class SquidCharacter {
    int x = 100, y = 100;
    BufferedImage doodle, doodleL, doodleR, doodlejett, doodle2, doodleL2, doodleR2, doodleJett;
    float dy = (int) (Math.random());
    public SquidCharacter(){
       try{
            doodle = ImageIO.read(getClass().getResource("/Img/squid.png"));
            doodle2 = ImageIO.read(getClass().getResource("/Img/squid.png"));
            doodleL = ImageIO.read(getClass().getResource("/Img/squidleft.png"));
            doodleR = ImageIO.read(getClass().getResource("/Img/squidright.png"));
            doodleL2 = ImageIO.read(getClass().getResource("/Img/squidleft.png"));
            doodleR2 = ImageIO.read(getClass().getResource("/Img/squidright.png"));
            doodleJett = ImageIO.read(getClass().getResource("/Img/squidjett.png"));
            }catch (IOException ex) {
            System.out.println("Can't load player Left");
         }
}
    boolean right, left;
    public void draw(Graphics g){
            g.drawImage(doodle, x, y, doodle.getWidth(), doodle.getHeight(), null);
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = true;
            doodle = doodleR;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = true;
            doodle = doodleL;
        }
    }
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = false;
        }
    }
}