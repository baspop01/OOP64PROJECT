package SquidJump;

import java.applet.Applet;
import java.applet.AudioClip;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import SquidJump.*;
import SquidJump.SquidJumpModel.*;
import SquidJump.SquidJumpView.*;
public class SquidJumpControler{
    public SquidJump squid;
    public SquidJumpView view;
    public SquidJumpModel model;
    
    public SquidJumpControler(){
        squid = new SquidJump();
        view = new SquidJumpView();
        model = new SquidJumpModel(); 
        
        view.setPreferredSize(new Dimension(squid.WIDTH, squid.HEIGHT));
        view.addKeyListener((KeyListener) this);
    }

    public void keyType(KeyEvent e) {

    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            squid.right = true;
            squid.doodle = squid.doodleR;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            squid.left = true;
            squid.doodle = squid.doodleL;
        }
    }
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            squid.right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            squid.left = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if(squid.st == 0){
                SquidJumpModel h = new SquidJumpModel();
                h.start();
                squid.st = 1;
                squid.sc1 = 0;
                squid.y = 100;
                squid.x = 100;
                squid.dy = 0;
                squid.right = false;
                squid.left = false;
            }
            if(squid.st == 1){
                
                squid.check = 1;
                squid.st = 1;
                squid.sc1 = 0;
                squid.y = 100;
                squid.x = 100;
                squid.dy = 0;
                squid.right = false;
                squid.left = false;
            }
            
       }
    }
    public void keyTyped(KeyEvent ke) {
        
    }
    public void run() {
        try {           
            requestFocus();
            SquidJumpModel h = new SquidJumpModel();
            h.start();
            while (squid.isRunning) {
                h.update();
                SquidJumpView v = new SquidJumpView();
                v.draw();
                if(squid.sc1 > 0 && squid.sc1 <= 800){
                    Thread.sleep(800 / 60);
                }
                
                else if(squid.sc1 >= 801){
                    Thread.sleep(700 / 60);
                    
                }
                else if(squid.sc1 >= 1300){
                    Thread.sleep(650 / 60);
                }
                else if(squid.sc1 >= 1700){
                    Thread.sleep(600 / 60);
                }
                else if(squid.sc1 >= 2000){
                    Thread.sleep(550 / 60);
                }
                else if(squid.sc1 >= 2500){
                    Thread.sleep(500 / 60);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void requestFocus() {
    }

//    private void setPreferredSize(Dimension dimension) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    private void addKeyListener(SquidJumpControler aThis) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
