
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
    
    BufferedImage background, topbar, scoretop, startgame, heart0, heart3, heart2, heart1;
    
    public GamePage(){
            try{
                sj = new SquidJump();
                squid = new SquidCharacter();
                background = ImageIO.read(getClass().getResource("/Img/background.png"));
                topbar = ImageIO.read(getClass().getResource("/Img/topbar.png"));
                scoretop = ImageIO.read(getClass().getResource("/Img/score.png"));
                startgame = ImageIO.read(getClass().getResource("/Img/startgame.png"));
                heart0 = ImageIO.read(getClass().getResource("/Img/heart.png")); 
                heart3 = ImageIO.read(getClass().getResource("/Img/heart3.png"));
                heart2 = ImageIO.read(getClass().getResource("/Img/heart2.png"));
                heart1 = ImageIO.read(getClass().getResource("/Img/heart1.png"));
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
    public void gameOver(Graphics g, int high, int score){
            g.setColor(Color.WHITE);
            g.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 70));
            g.drawString("Game Over", (WIDTH / 2) - 180, (HEIGHT - 50) / 2);
            g.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 30));
            g.drawString("Your Score : " + score, (WIDTH / 2) - 95, (HEIGHT + 60) / 2);
            g.drawString("Best Score : " + high, (WIDTH / 2) - 90, (HEIGHT + 150) / 2);
            g.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
            g.drawString("Press 'space' to restart", (WIDTH / 2) - 100, (HEIGHT + 350) / 2);
    }
    public void life(Graphics g, int health){
            if(health >= 65){
                g.drawImage(heart3, 310, 13, 65, 17, null);                       
            }
            else if(health >= -15 && health < 65){
                g.drawImage(heart2, 310, 13, 65, 17, null);           
            }  
            else if(health >= -60 && health < -14){            
                g.drawImage(heart1, 310, 13, 65, 17, null);      
            }
            else if(health < -60){
                g.drawImage(heart0, 310, 13, 65, 17, null);
            } 
    }
}
