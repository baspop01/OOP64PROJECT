
package SquidJump;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class GamePage{
    
    final int WIDTH = 400;
    final int HEIGHT = 533;
    
    SquidJump sj;
    SquidCharacter squid;
    
    BufferedImage background, topbar, scoretop, startgame;
    
    public GamePage(){
            try{
                sj = new SquidJump();
                squid = new SquidCharacter();
                background = ImageIO.read(getClass().getResource("/Img/background.png"));
                topbar = ImageIO.read(getClass().getResource("/Img/topbar.png"));
                scoretop = ImageIO.read(getClass().getResource("/Img/score.png"));
                startgame = ImageIO.read(getClass().getResource("/Img/startgame.png"));
            }catch (IOException ex) {
            System.out.println("Can't load player Left");
         }
    }
    public void FirstPage(Graphics g){
        g.drawImage(startgame, 0, 0, WIDTH, HEIGHT, null);
    }
    public void GameStart(Graphics g){
            g.drawImage(topbar, 0, 0, 500, 70, null);
            g.drawImage(scoretop, 10, 5, 70, 30, null);
            Font tr = new Font("Berlin Sans FB Demi", Font.PLAIN, 28);
            g.setFont(tr);
            g.drawImage(topbar, 0, 0, 500, 70, null);
            g.drawImage(scoretop, 10, 5, 70, 30, null);
            g.setColor(Color.black);
            g.setColor(Color.red);
    }
}
