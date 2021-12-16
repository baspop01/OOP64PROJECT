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
    
    SquidCharacter squid;
    Platform plat;
    
    BufferedImage background, view, topbar, scoretop, heart0, heart3, heart2, heart1, map_end, startgame;

    int h = 150, sc1 = 0,health = 100, st=0, sc2=0, high=0, check=0, count=0;
    

    public SquidJump() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addKeyListener(this);
        plat = new Platform();
        create();
    }

    public void create(){
        squid = new SquidCharacter();
        
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
            topbar = ImageIO.read(getClass().getResource("/Img/topbar.png"));
            scoretop = ImageIO.read(getClass().getResource("/Img/score.png"));
            heart0 = ImageIO.read(getClass().getResource("/Img/heart.png")); 
            heart3 = ImageIO.read(getClass().getResource("/Img/heart3.png"));
            heart2 = ImageIO.read(getClass().getResource("/Img/heart2.png"));
            heart1 = ImageIO.read(getClass().getResource("/Img/heart1.png"));
            map_end = ImageIO.read(getClass().getResource("/Img/map_end.jpg"));
            startgame = ImageIO.read(getClass().getResource("/Img/startgame.png"));
            plat.randomPlatform();
            health = 100;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {

        //เกี่ยวกับตพแหน่งตัวละคร
        if (squid.right) {
            squid.x += 3;
        } else if (squid.left) {
            squid.x -= 3;
        }
        squid.dy += 0.2;
        squid.y += squid.dy;
        if (squid.x <= -30) {
            squid.x = 425;
        }
        if (squid.x >= 430) {
            squid.x = -20;
        }
        //เกี่ยวกับการสร้างพื้นใหม่เมื่อกระโดดสูงขึ้นไป
        if (squid.y < h) {
            sc1++;
            for (int i = 0; i < 6; i++) { //สร้างพื้น
                squid.y = h;
                plat.platforms[i].y = plat.platforms[i].y - (int) squid.dy;
                if (plat.platforms[i].y > 533) {
                    plat.platforms[i].y = 0;
                    plat.platforms[i].x = new Random().nextInt(350);
                }
            }
            

            for (int i = 0; i < 3; i++) {  //สร้างพื้นไม้
                squid.y = h;
                plat.platformsBroke[i].y = plat.platformsBroke[i].y - (int) squid.dy;
                if (plat.platformsBroke[i].y > 533) {
                    plat.platformsBroke[i].y = 0;
                    plat.platformsBroke[i].x = new Random().nextInt(400);
                }
            }
            
            for (int i = 0; i < 1; i++) { //สร้างพื้นหนาม
                squid.y = h;
                plat.platformsSpike[i].y = plat.platformsSpike[i].y - (int) squid.dy;
                if (plat.platformsSpike[i].y > 533) {
                    plat.platformsSpike[i].y = 0;
                    plat.platformsSpike[i].x = new Random().nextInt(400);
                }
            }
            for (int i = 0; i < 3; i++) { //สร้างหญ้า
                squid.y = h;
                plat.platformsUn[i].y = plat.platformsUn[i].y - (int) squid.dy;
                if (plat.platformsUn[i].y > 533) {
                    plat.platformsUn[i].y = 0;
                    plat.platformsUn[i].x = new Random().nextInt(400);
                }
            }
            
            for (int i = 0; i < 2; i++) { //สร้างระเบิด
                squid.y = h;
                plat.platformsBomb[i].y = plat.platformsBomb[i].y - (int) squid.dy;
                if (plat.platformsBomb[i].y > 1000) {
                    plat.platformsBomb[i].y = 0;
                    plat.platformsBomb[i].x = new Random().nextInt(350);
                }
                
            }

            for (int i = 0; i < 1; i++) { //สร้างเจ็ท
                squid.y = h;
                plat.JettPosition[i].y = plat.JettPosition[i].y - (int) squid.dy;
                if (plat.JettPosition[i].y > 2500) {
                    plat.JettPosition[i].y = 0;
                    plat.JettPosition[i].x = new Random().nextInt(400);
                }
            }
            
        }

        //เกี่ยวกับ Hitbox 
        for (int i = 0; i < 6; i++) {
            if ((squid.x + 35 > plat.platforms[i].x)
                    && (squid.x + 35 < plat.platforms[i].x + 68)
                    && (squid.y + 70 > plat.platforms[i].y)
                    && (squid.y + 70 < plat.platforms[i].y + 14)
                    && (squid.dy > 0)) {
                squid.dy = -10;
                squid.doodle = squid.doodle2;
                squid.doodleR = squid.doodleR2;
                squid.doodleL = squid.doodleL2;
                sound1 = new SoundPlay1("/Music/jump.wav");

            }
        }

            
        for (int i = 0; i < 1; i++) {
            if ((squid.x + 15 > plat.JettPosition[i].x)
                    && (squid.x + 15 < plat.JettPosition[i].x + 68)
                    && (squid.y + 40 > plat.JettPosition[i].y)
                    && (squid.y + 40 < plat.JettPosition[i].y + 14)
                    && ((squid.dy < 0) || (squid.dy >= 0))) {
                squid.dy = -30;
                squid.doodle = squid.doodleJett;
                squid.doodleR = squid.doodleJett;
                squid.doodleL = squid.doodleJett;
                plat.JettPosition[i].y = -100;
                plat.JettPosition[i].x = -100;
                sound1 = new SoundPlay1("/Music/Jet.wav");
                
            }
        }

        
        for (int i = 0; i < 3; i++) {

            if ((squid.x + 35 > plat.platformsBroke[i].x)
                    && (squid.x + 35 < plat.platformsBroke[i].x + 68)
                    && (squid.y + 70 > plat.platformsBroke[i].y)
                    && (squid.y + 70 < plat.platformsBroke[i].y + 14)
                    && (squid.dy > 0)) {
                squid.dy = -8;
                squid.doodle = squid.doodle2;
                squid.doodleR = squid.doodleR2;
                squid.doodleL = squid.doodleL2;
                plat.platformsBroke[i].y = -100;
                plat.platformsBroke[i].x = -100;
                sound2 = new SoundPlay2("/Music/broke.wav");

            }
        }
        
        for (int i = 0; i < 1; i++) {
            
            if ((squid.x + 35 > plat.platformsSpike[i].x)
                    && (squid.x + 35 < plat.platformsSpike[i].x + 68)
                    && (squid.y + 60 > plat.platformsSpike[i].y)
                    && (squid.y + 60 < plat.platformsSpike[i].y + 14)
                    && (squid.dy > 0)) {
                health -= 80;
                squid.dy = -10;
                squid.doodle = squid.doodle2;
                squid.doodleR = squid.doodleR2;
                squid.doodleL = squid.doodleL2;
                sound3 = new SoundPlay2("/Music/spike.wav");
                if(health < -60){
                    plat.platformsSpike[i].y = -100;
                    plat.platformsSpike[i].x = -100;
                }
            }
          
        }
        for (int i = 0; i < 3; i++) {

            if ((squid.x + 35 > plat.platformsUn[i].x)
                    && (squid.x + 35 < plat.platformsUn[i].x + 68)
                    && (squid.y + 150 > plat.platformsUn[i].y + 80)
                    && (squid.y + 60 < plat.platformsUn[i].y + 4)
                    && (squid.dy > 0)) {
                squid.dy = -1;
                squid.doodle = squid.doodle2;
                squid.doodleR = squid.doodleR2;
                squid.doodleL = squid.doodleL2;
                plat.platformsUn[i].y = -100;
                plat.platformsUn[i].x = -100;
                sound2 = new SoundPlay2("/Music/grass.wav");

            }
        }
        for (int i = 0; i < 1; i++) {

            if ((squid.x + 35 > plat.platformsBomb[i].x)
                    && (squid.x + 35 < plat.platformsBomb[i].x + 48)
                    && (squid.y + 80 > plat.platformsBomb[i].y+20 )
                    && (squid.y + 65 < plat.platformsBomb[i].y+50)
                    && ((squid.dy < 0) || (squid.dy >= 0))) {
                squid.dy = -1;
                squid.doodle = squid.doodle2;
                squid.doodleR = squid.doodleR2;
                squid.doodleL = squid.doodleL2;
                health = -61;
                sound3 = new SoundPlay2("/Music/boomb.wav");
                plat.platformsBomb[i].y = -100;
                plat.platformsBomb[i].x = -100;

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
            squid.draw(g2);
            plat.draw(g2);
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
            } 
        //สร้างหน้าแรกของเกม
        }else{
            g3.drawImage(startgame, 0, 0, WIDTH, HEIGHT, null);
            squid.x = 100;
            squid.y = 100;
            squid.dy = 0;
        }
        //สร้างหน้าเกม Over
        if ((squid.y >= 500) || (health < -60)){
            g3.drawImage(background, 0, 0, WIDTH, HEIGHT, null);
            sc2 = sc1;
            count += 1;
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
            g3.drawImage(map_end, 0, squid.y + 1000, 700, -2000, null);
            st = 0;
            squid.x = 420;
            if(squid.dy == -10){
                squid.x = -25;
            }
            if(count == 1){
                sound5 = new SoundPlay1("/Music/dead.wav");
            }
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
            squid.keyPressed(e);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            squid.keyPressed(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            squid.keyReleased(e);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            squid.keyReleased(e);
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if(st == 0){
                start();
                st = 1;
                sc1 = 0;
                squid.y = 100;
                squid.x = 100;
                squid.dy = 0;
                count = 0;
            }
            if(st == 1){
                
                check = 1;
                st = 2;
                sc1 = 0;
                squid.y = 100;
                squid.x = 100;
                squid.dy = 0;
            }
            
        }
    }

    
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }
}