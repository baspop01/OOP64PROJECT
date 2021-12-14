package SquidJump;

import SquidJump.DoodleJump;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class SquidJumpView extends DoodleJump{
    public void draw() {
        Graphics2D g3 = (Graphics2D) view.getGraphics();
        if (check == 1){
            Graphics2D g2 = (Graphics2D) view.getGraphics();
            g2.drawImage(background, 0, 0, WIDTH, HEIGHT, null);
            g2.drawImage(doodle, x, y, doodle.getWidth(), doodle.getHeight(), null);
            for (int i = 0; i < 6; i++) {
            g2.drawImage(
                    platform,
                    platforms[i].x,
                    platforms[i].y,
                    platform.getWidth(),
                    platform.getHeight(),
                    null
                );
            }

            for (int i = 0; i < 3; i++) {
                g2.drawImage(
                        broke,
                        platformsBroke[i].x,
                        platformsBroke[i].y,
                        broke.getWidth(),
                        broke.getHeight(),
                        null
                );
            }

            for (int i = 0; i < 1; i++) {  
                g2.drawImage(
                        spike,
                        platformsSpike[i].x,
                        platformsSpike[i].y,
                        spike.getWidth(),
                        spike.getHeight(),
                        null
                );
            }

            for (int i = 0; i < 3; i++) {
                g2.drawImage(
                        invis,
                        platformsUn[i].x,
                        platformsUn[i].y,
                        invis.getWidth(),
                        invis.getHeight(),
                        null
                );
            }

            for (int i = 0; i < 1; i++) {
                g2.drawImage(
                        bomb,
                        platformsBomb[i].x,
                        platformsBomb[i].y,
                        bomb.getWidth(),
                        bomb.getHeight(),
                        null
                );
            }

            for (int i = 0; i < 1; i++) { //jet
                g2.drawImage(
                        Jett,
                        JettPosition[i].x,
                        JettPosition[i].y,
                        Jett.getWidth(),
                        Jett.getHeight(),
                        null
                );
        }
        
        
        
        
                    g2.drawImage(topbar, 0, 0, 500, 70, null);
                    g2.drawImage(scoretest, 10, 5, 70, 30, null);
            //        g2.drawString("" + sc1, 120, 20);
                    Font tr = new Font("Berlin Sans FB Demi", Font.PLAIN, 28);
                    g2.setFont(tr);
                    g2.drawImage(topbar, 0, 0, 500, 70, null);
                    g2.drawImage(scoretest, 10, 5, 70, 30, null);
                    g2.setColor(Color.black);
                    g2.setColor(Color.red);
                    g2.drawString("" + sc1, 90, 29);

                    if(health >= 65){
                        g2.drawImage(htet1, 310, 13, 65, 17, null);                       
                    }
                    else if(health >= -15 && health < 65){
                        g2.drawImage(htet2, 310, 13, 65, 17, null);           
                    }  
                    else if(health >= -60 && health < -14){            
                        g2.drawImage(htet3, 310, 13, 65, 17, null);      
                    }
                    else if(health < -60){
                        g2.drawImage(htet4, 310, 13, 65, 17, null);
                        //gameOver();
        } 
        }else{
            g3.drawImage(startgame, 0, 0, WIDTH, HEIGHT, null);
            x = 100;
            y = 100;
            dy = 0;
        }
             
 
        
        
        if ((y >= 500) || (health < -60)){
            g3.drawImage(background, 0, 0, WIDTH, HEIGHT, null);
            sc2 = sc1;
            if(sc2 > high){
                high = sc2;
            }
            g3.setColor(Color.WHITE);
            g3.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 70));
            g3.drawString("Game Over", (WIDTH / 2) - 180, (HEIGHT - 50) / 2);
            g3.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 30));
            g3.drawString("Your Score : " + sc2, (WIDTH / 2) - 95, (HEIGHT + 60) / 2);
            g3.drawString("Best Score : " + high, (WIDTH / 2) - 90, (HEIGHT + 150) / 2);
            g3.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
            g3.drawString("Press 'space' to restart", (WIDTH / 2) - 100, (HEIGHT + 350) / 2);
            g3.drawImage(map_end, 0, y + 1000, 700, -2000, null);
            st = 0;
            x = 420;
            if(dy == -10){
                x = -25;
            }
            right = false;
            left = false;
        }      
        Graphics g = getGraphics();
        g.drawImage(view, 0, 0, WIDTH, HEIGHT, null);
        g.dispose();
        
    }
    public SquidJumpView() {
        JFrame w = new JFrame("Squid Jump");
        w.setResizable(false);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setLayout(new BorderLayout());

        w.add(new DoodleJump(), BorderLayout.SOUTH);
        w.pack();
        w.setLocationRelativeTo(null);
        w.setVisible(true);
        
    }
    public static void main(String[] args) {
        new SquidJumpView();
    }
}
