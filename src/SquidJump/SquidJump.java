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

class Platform { //พื้นธรรมดา

    int x, y;
}

class PlatformBroke { //พื้นไม้

    int x, y;
}

class PlatformSpike { //พื้นหนาม

    int x, y;
}

class PlatformUn { //พื้นหญ้า

    int x, y;
}

class PlatformBomb { //ระเบิด

    int x, y;
}

class JettPosition { //เจ็ท

    int x, y;
}

public class SquidJump extends JPanel implements Runnable, KeyListener {

    final int WIDTH = 400;
    final int HEIGHT = 533;

    SoundPlay1 sound1;
    SoundPlay2 sound2;
    SoundPlay2 sound3;
    SoundPlay2 sound4;
    SoundPlay1 sound5;

    boolean isRunning;
    Thread thread;
    BufferedImage view, background, platform, doodle, broke,spike,invis, doodleL, doodleR, doodle2, doodleJett, Jett, doodleR2
            , doodleL2, heart, topbar, scoretop, bomb, map_end, startgame, heart0, heart1, heart2, heart3;
    
    
    Platform[] platforms;
    PlatformBroke[] platformsBroke;
    PlatformSpike[] platformsSpike;
    PlatformUn[] platformsUn;
    PlatformBomb[] platformsBomb;
    JettPosition[] JettPosition;

    int x = 100, y = 100, h = 150, sc1 = 0,health = 100, st=0, sc2=0, high=0, check=0, count=0;
    float dy = (int) (Math.random());
    boolean right, left;

    public SquidJump() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addKeyListener(this);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        if (thread == null) {
            thread = new Thread(this);
            isRunning = true;
            thread.start();
        }
    }
    public void start() {    
        try {
            view = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

            background = ImageIO.read(getClass().getResource("/Img/background.png"));
            platform = ImageIO.read(getClass().getResource("/Img/platform.png"));
            doodle = ImageIO.read(getClass().getResource("/Img/squid.png"));
            doodle2 = ImageIO.read(getClass().getResource("/Img/squid.png"));
            broke = ImageIO.read(getClass().getResource("/Img/platform1.png"));
            spike = ImageIO.read(getClass().getResource("/Img/platform2.png"));
            invis = ImageIO.read(getClass().getResource("/Img/platform3.png"));
            doodleL = ImageIO.read(getClass().getResource("/Img/squidleft.png"));
            doodleR = ImageIO.read(getClass().getResource("/Img/squidright.png"));
            doodleL2 = ImageIO.read(getClass().getResource("/Img/squidleft.png"));
            doodleR2 = ImageIO.read(getClass().getResource("/Img/squidright.png"));
            doodleJett = ImageIO.read(getClass().getResource("/Img/squidjett.png"));
            Jett = ImageIO.read(getClass().getResource("/Img/jettpack.png"));
            topbar = ImageIO.read(getClass().getResource("/Img/topbar.png"));
            scoretop = ImageIO.read(getClass().getResource("/Img/score.png"));
            heart0 = ImageIO.read(getClass().getResource("/Img/heart.png")); 
            heart3 = ImageIO.read(getClass().getResource("/Img/heart3.png"));
            heart2 = ImageIO.read(getClass().getResource("/Img/heart2.png"));
            heart1 = ImageIO.read(getClass().getResource("/Img/heart1.png"));
            bomb = ImageIO.read(getClass().getResource("/Img/bomb.png"));
            map_end = ImageIO.read(getClass().getResource("/Img/map_end.jpg"));
            startgame = ImageIO.read(getClass().getResource("/Img/startgame.png"));

            platforms = new Platform[20];

            platformsBroke = new PlatformBroke[20];
            
            platformsSpike = new PlatformSpike[20];
            
            platformsUn = new PlatformUn[20];
            
            platformsBomb = new PlatformBomb[3];

            JettPosition = new JettPosition[10];

            for (int i = 0; i < 10; i++) {
                platforms[i] = new Platform();
                platforms[i].x = new Random().nextInt(400);
                platforms[i].y = new Random().nextInt(533);
            }
            for (int i = 0; i < 10; i++) {
                platformsBroke[i] = new PlatformBroke();
                platformsBroke[i].x = new Random().nextInt(400);
                platformsBroke[i].y = new Random().nextInt(533);
            }
            for (int i = 0; i < 10; i++) {
                platformsSpike[i] = new PlatformSpike();
                platformsSpike[i].x = new Random().nextInt(400);
                platformsSpike[i].y = new Random().nextInt(533);
            }
            for (int i = 0; i < 10; i++) {
                platformsUn[i] = new PlatformUn();
                platformsUn[i].x = new Random().nextInt(400);
                platformsUn[i].y = new Random().nextInt(533);
            }
            
            for (int i = 0; i < 2; i++) {
                platformsBomb[i] = new PlatformBomb();
                platformsBomb[i].x = new Random().nextInt(400);
                platformsBomb[i].y = new Random().nextInt(533);
            }
            for (int i = 0; i < 10; i++) {
                JettPosition[i] = new JettPosition();
                JettPosition[i].x = new Random().nextInt(400);
                JettPosition[i].y = new Random().nextInt(533);
            }
            health = 100;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {

        //เกี่ยวกับตพแหน่งตัวละคร
        if (right) {
            x += 3;
        } else if (left) {
            x -= 3;
        }
        dy += 0.2;
        y += dy;
        if (x <= -30) {
            x = 425;
        }
        if (x >= 430) {
            x = -20;
        }

        //เกี่ยวกับการสร้างพื้นใหม่เมื่อกระโดดสูงขึ้นไป
        if (y < h) {
            sc1++;
            for (int i = 0; i < 6; i++) { //สร้างพื้น
                y = h;
                platforms[i].y = platforms[i].y - (int) dy;
                if (platforms[i].y > 533) {
                    platforms[i].y = 0;
                    platforms[i].x = new Random().nextInt(350);
                }
            }
            

            for (int i = 0; i < 3; i++) {  //สร้างพื้นไม้
                y = h;
                platformsBroke[i].y = platformsBroke[i].y - (int) dy;
                if (platformsBroke[i].y > 533) {
                    platformsBroke[i].y = 0;
                    platformsBroke[i].x = new Random().nextInt(400);
                }
            }
            
            for (int i = 0; i < 1; i++) { //สร้างพื้นหนาม
                y = h;
                platformsSpike[i].y = platformsSpike[i].y - (int) dy;
                if (platformsSpike[i].y > 533) {
                    platformsSpike[i].y = 0;
                    platformsSpike[i].x = new Random().nextInt(400);
                }
            }
            for (int i = 0; i < 3; i++) { //สร้างหญ้า
                y = h;
                platformsUn[i].y = platformsUn[i].y - (int) dy;
                if (platformsUn[i].y > 533) {
                    platformsUn[i].y = 0;
                    platformsUn[i].x = new Random().nextInt(400);
                }
            }
            
            for (int i = 0; i < 2; i++) { //สร้างระเบิด
                y = h;
                platformsBomb[i].y = platformsBomb[i].y - (int) dy;
                if (platformsBomb[i].y > 1000) {
                    platformsBomb[i].y = 0;
                    platformsBomb[i].x = new Random().nextInt(350);
                }
                
            }

            for (int i = 0; i < 1; i++) { //สร้างเจ็ท
                y = h;
                JettPosition[i].y = JettPosition[i].y - (int) dy;
                if (JettPosition[i].y > 2500) {
                    JettPosition[i].y = 0;
                    JettPosition[i].x = new Random().nextInt(400);
                }
            }
            
        }

        //เกี่ยวกับ Hitbox 
        for (int i = 0; i < 6; i++) {
            if ((x + 35 > platforms[i].x)
                    && (x + 35 < platforms[i].x + 68)
                    && (y + 70 > platforms[i].y)
                    && (y + 70 < platforms[i].y + 14)
                    && (dy > 0)) {
                dy = -10;
                doodle = doodle2;
                doodleR = doodleR2;
                doodleL = doodleL2;
                sound1 = new SoundPlay1("/Music/jump.wav");

            }
        }

            
        for (int i = 0; i < 1; i++) {
            if ((x + 15 > JettPosition[i].x)
                    && (x + 15 < JettPosition[i].x + 68)
                    && (y + 40 > JettPosition[i].y)
                    && (y + 40 < JettPosition[i].y + 14)
                    && ((dy < 0) || (dy >= 0))) {
                dy = -30;
                doodle = doodleJett;
                doodleR = doodleJett;
                doodleL = doodleJett;
                JettPosition[i].y = -100;
                JettPosition[i].x = -100;
                sound1 = new SoundPlay1("/Music/Jet.wav");
                
            }
        }

        
        for (int i = 0; i < 3; i++) {

            if ((x + 35 > platformsBroke[i].x)
                    && (x + 35 < platformsBroke[i].x + 68)
                    && (y + 70 > platformsBroke[i].y)
                    && (y + 70 < platformsBroke[i].y + 14)
                    && (dy > 0)) {
                dy = -8;
                doodle = doodle2;
                doodleR = doodleR2;
                doodleL = doodleL2;
                platformsBroke[i].y = -100;
                platformsBroke[i].x = -100;
                sound2 = new SoundPlay2("/Music/broke.wav");

            }
        }
        
        for (int i = 0; i < 1; i++) {
            
            if ((x + 35 > platformsSpike[i].x)
                    && (x + 35 < platformsSpike[i].x + 68)
                    && (y + 60 > platformsSpike[i].y)
                    && (y + 60 < platformsSpike[i].y + 14)
                    && (dy > 0)) {
                health -= 80;
                System.out.println(health);
                dy = -10;
                doodle = doodle2;
                doodleR = doodleR2;
                doodleL = doodleL2;
                sound3 = new SoundPlay2("/Music/spike.wav");
                if(health < -60){
                    platformsSpike[i].y = -100;
                    platformsSpike[i].x = -100;
                }
            }
          
        }
        for (int i = 0; i < 3; i++) {

            if ((x + 35 > platformsUn[i].x)
                    && (x + 35 < platformsUn[i].x + 68)
                    && (y + 150 > platformsUn[i].y + 80)
                    && (y + 60 < platformsUn[i].y + 4)
                    && (dy > 0)) {
                dy = -1;
                doodle = doodle2;
                doodleR = doodleR2;
                doodleL = doodleL2;
                platformsUn[i].y = -100;
                platformsUn[i].x = -100;
                sound2 = new SoundPlay2("/Music/grass.wav");

            }
        }
        for (int i = 0; i < 1; i++) {

            if ((x + 35 > platformsBomb[i].x)
                    && (x + 35 < platformsBomb[i].x + 48)
                    && (y + 80 > platformsBomb[i].y+20 )
                    && (y + 65 < platformsBomb[i].y+50)
                    && ((dy < 0) || (dy >= 0))) {
                dy = -1;
                doodle = doodle2;
                doodleR = doodleR2;
                doodleL = doodleL2;
                health = -61;
                sound3 = new SoundPlay2("/Music/boomb.wav");
                platformsBomb[i].y = -100;
                platformsBomb[i].x = -100;

            }
        }
        
    }
    //สร้างGraphic
    public void draw() {
        Graphics2D g3 = (Graphics2D) view.getGraphics();
        //สร้างตัวเกม
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
                    g2.drawImage(scoretop, 10, 5, 70, 30, null);
                    Font tr = new Font("Berlin Sans FB Demi", Font.PLAIN, 28);
                    g2.setFont(tr);
                    g2.drawImage(topbar, 0, 0, 500, 70, null);
                    g2.drawImage(scoretop, 10, 5, 70, 30, null);
                    g2.setColor(Color.black);
                    g2.setColor(Color.red);
                    g2.drawString("" + sc1, 90, 29);

                    if(health >= 65){
                        g2.drawImage(heart3, 310, 13, 65, 17, null);                       
                    }
                    else if(health >= -15 && health < 65){
                        g2.drawImage(heart2, 310, 13, 65, 17, null);           
                    }  
                    else if(health >= -60 && health < -14){            
                        g2.drawImage(heart1, 310, 13, 65, 17, null);      
                    }
                    else if(health < -60){
                        g2.drawImage(heart0, 310, 13, 65, 17, null);
                        //gameOver();
        } 
        //สร้างหน้าแรกของเกม
        }else{
            g3.drawImage(startgame, 0, 0, WIDTH, HEIGHT, null);
            x = 100;
            y = 100;
            dy = 0;
        }
        //สร้างหน้าเกม Over
        if ((y >= 500) || (health < -60)){
            g3.drawImage(background, 0, 0, WIDTH, HEIGHT, null);
            sc2 = sc1;
            count += 1;
            if(sc2 > high){
                high = sc2;
            }
            System.out.println(count);
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
            if(count == 1){
                sound5 = new SoundPlay1("/Music/dead.wav");
            }
            right = false;
            left = false;
        }        
        Graphics g = getGraphics();
        g.drawImage(view, 0, 0, WIDTH, HEIGHT, null);
        g.dispose();
        
    }

    @Override
    public void run() {
        try {
            requestFocus();
            start();
            while (isRunning) {
                update();
                draw();
                if(sc1 > 0 && sc1 <= 800){
                    Thread.sleep(800 / 60);
                }
                
                else if(sc1 >= 801){
                    Thread.sleep(700 / 60);
                    
                }
                else if(sc1 >= 1300){
                    Thread.sleep(650 / 60);
                }
                else if(sc1 >= 1700){
                    Thread.sleep(600 / 60);
                }
                else if(sc1 >= 2000){
                    Thread.sleep(550 / 60);
                }
                else if(sc1 >= 2500){
                    Thread.sleep(500 / 60);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void keyType(KeyEvent e) {

    }

    @Override
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

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if(st == 0){
                start();
                st = 1;
                sc1 = 0;
                y = 100;
                x = 100;
                dy = 0;
                right = false;
                left = false;
                count = 0;
            }
            if(st == 1){
                
                check = 1;
                st = 2;
                sc1 = 0;
                y = 100;
                x = 100;
                dy = 0;
                right = false;
                left = false;
            }
            
        }
    }

    
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }
}
