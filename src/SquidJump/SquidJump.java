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

    boolean isRunning;
    Thread thread;
    
    SquidCharacter squid;
    Platform plat;
    GamePage gamep;
    SoundPlay sound1;
    SoundPlay sound2;
    SoundPlay sound3;
    SoundPlay sound4;
    SoundPlay sound5;
    
    BufferedImage background, view, map_end;

    int sc1 = 0,health = 100, st=0, sc2=0, high=0, check=0, count=0, h = 150;
    

    public SquidJump() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addKeyListener(this);
        plat = new Platform();
        createCharacter();
    }

    public void createCharacter(){
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
            map_end = ImageIO.read(getClass().getResource("/Img/map_end.jpg"));
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
                plat.platforms[i].setY(plat.platforms[i].getY() - (int) squid.dy);
                if (plat.platforms[i].getY() > 533) {
                    plat.platforms[i].setY(0);
                    plat.platforms[i].setX(new Random().nextInt(350));
                }
            }
            

            for (int i = 0; i < 3; i++) {  //สร้างพื้นไม้
                squid.y = h;
                plat.platformsBroke[i].setY(plat.platformsBroke[i].getY() - (int) squid.dy);
                if (plat.platformsBroke[i].getY() > 533) {
                    plat.platformsBroke[i].setY(0);
                    plat.platformsBroke[i].setX(new Random().nextInt(400));
                }
            }
            
            for (int i = 0; i < 1; i++) { //สร้างพื้นหนาม
                squid.y = h;
                plat.platformsSpike[i].setY(plat.platformsSpike[i].getY() - (int) squid.dy);
                if (plat.platformsSpike[i].getY() > 533) {
                    plat.platformsSpike[i].setY(0);
                    plat.platformsSpike[i].setX(new Random().nextInt(400));
                }
            }
            for (int i = 0; i < 3; i++) { //สร้างหญ้า
                squid.y = h;
                plat.platformsUn[i].setY(plat.platformsUn[i].getY() - (int) squid.dy);
                if (plat.platformsUn[i].getY() > 533) {
                    plat.platformsUn[i].setY(0);
                    plat.platformsUn[i].setX(new Random().nextInt(400));
                }
            }
            
            for (int i = 0; i < 2; i++) { //สร้างระเบิด
                squid.y = h;
                plat.platformsBomb[i].setY(plat.platformsBomb[i].getY() - (int) squid.dy);
                if (plat.platformsBomb[i].getY() > 1000) {
                    plat.platformsBomb[i].setY(0);
                    plat.platformsBomb[i].setX(new Random().nextInt(350));
                }
                
            }

            for (int i = 0; i < 1; i++) { //สร้างเจ็ท
                squid.y = h;
                plat.JettPosition[i].setY(plat.JettPosition[i].getY() - (int) squid.dy);
                if (plat.JettPosition[i].getY() > 2000) {
                    plat.JettPosition[i].setY(0);
                    plat.JettPosition[i].setX(new Random().nextInt(400));
                }
            }
            
        }

        //เกี่ยวกับ Hitbox 
        for (int i = 0; i < 6; i++) {
            if ((squid.x + 35 > plat.platforms[i].getX())
                    && (squid.x + 35 < plat.platforms[i].getX() + 68)
                    && (squid.y + 70 > plat.platforms[i].getY())
                    && (squid.y + 70 < plat.platforms[i].getY() + 14)
                    && (squid.dy > 0)) {
                squid.dy = -10;
                squid.doodle = squid.doodle2;
                squid.doodleR = squid.doodleR2;
                squid.doodleL = squid.doodleL2;
                sound1 = new SoundPlay("/Music/jump.wav", (float) 0.05);

            }
        }

            
        for (int i = 0; i < 1; i++) {
            if ((squid.x + 15 > plat.JettPosition[i].getX())
                    && (squid.x + 15 < plat.JettPosition[i].getX() + 68)
                    && (squid.y + 40 > plat.JettPosition[i].getY())
                    && (squid.y + 40 < plat.JettPosition[i].getY() + 14)
                    && ((squid.dy < 0) || (squid.dy >= 0))) {
                squid.dy = -30;
                squid.doodle = squid.doodleJett;
                squid.doodleR = squid.doodleJett;
                squid.doodleL = squid.doodleJett;
                plat.JettPosition[i].setY(-100);
                plat.JettPosition[i].setX(-100);
                sound1 = new SoundPlay("/Music/Jet.wav", (float) 0.2);
                
            }
        }

        
        for (int i = 0; i < 3; i++) {

            if ((squid.x + 35 > plat.platformsBroke[i].getX())
                    && (squid.x + 35 < plat.platformsBroke[i].getX() + 68)
                    && (squid.y + 70 > plat.platformsBroke[i].getY())
                    && (squid.y + 70 < plat.platformsBroke[i].getY() + 14)
                    && (squid.dy > 0)) {
                squid.dy = -8;
                squid.doodle = squid.doodle2;
                squid.doodleR = squid.doodleR2;
                squid.doodleL = squid.doodleL2;
                plat.platformsBroke[i].setY(-100);
                plat.platformsBroke[i].setX(-100); 
                sound2 = new SoundPlay("/Music/broke.wav" , (float) 0.2);

            }
        }
        
        for (int i = 0; i < 1; i++) {
            
            if ((squid.x + 35 > plat.platformsSpike[i].getX())
                    && (squid.x + 35 < plat.platformsSpike[i].getX() + 68)
                    && (squid.y + 60 > plat.platformsSpike[i].getY())
                    && (squid.y + 60 < plat.platformsSpike[i].getY() + 14)
                    && (squid.dy > 0)) {
                health -= 80;
                squid.dy = -10;
                squid.doodle = squid.doodle2;
                squid.doodleR = squid.doodleR2;
                squid.doodleL = squid.doodleL2;
                sound3 = new SoundPlay("/Music/spike.wav", (float) 0.2);
                if(health < -60){
                    plat.platformsSpike[i].setY(-100);
                    plat.platformsSpike[i].setX(-100);
                }
            }
          
        }
        for (int i = 0; i < 3; i++) {

            if ((squid.x + 35 > plat.platformsUn[i].getX())
                    && (squid.x + 35 < plat.platformsUn[i].getX() + 68)
                    && (squid.y + 150 > plat.platformsUn[i].getY() + 80)
                    && (squid.y + 60 < plat.platformsUn[i].getY() + 4)
                    && (squid.dy > 0)) {
                squid.dy = -1;
                squid.doodle = squid.doodle2;
                squid.doodleR = squid.doodleR2;
                squid.doodleL = squid.doodleL2;
                plat.platformsUn[i].setY(-100);
                plat.platformsUn[i].setX(-100);
                sound2 = new SoundPlay("/Music/grass.wav", (float) 0.2);

            }
        }
        for (int i = 0; i < 1; i++) {

            if ((squid.x + 35 > plat.platformsBomb[i].getX())
                    && (squid.x + 35 < plat.platformsBomb[i].getX() + 48)
                    && (squid.y + 80 > plat.platformsBomb[i].getY()+20 )
                    && (squid.y + 65 < plat.platformsBomb[i].getY()+50)
                    && ((squid.dy < 0) || (squid.dy >= 0))) {
                squid.dy = -1;
                squid.doodle = squid.doodle2;
                squid.doodleR = squid.doodleR2;
                squid.doodleL = squid.doodleL2;
                health = -61;
                sound3 = new SoundPlay("/Music/boomb.wav", (float) 0.2);
                plat.platformsBomb[i].setY(-100);
                plat.platformsBomb[i].setX(-100);

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
            gamep.GameStart(g2);
            g2.drawString("" + sc1, 90, 29);
            gamep.life(g2, health);
        //สร้างหน้าแรกของเกม
        }else{
            gamep.FirstPage(g3);
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
            gamep.gameOver(g3, high, sc2);
            g3.drawImage(map_end, 0, squid.y + 1000, 700, -2000, null);
            st = 0;
            squid.x = 420;
            if(squid.dy == -10){
                squid.x = -25;
            }
            if(count == 1){
                sound5 = new SoundPlay("/Music/dead.wav", (float) 0.2);
            }
        }        
        Graphics g = getGraphics();
        g.drawImage(view, 0, 0, WIDTH, HEIGHT, null);
        g.dispose();
        
    }

    @Override
    public void run() {
        try {
            gamep = new GamePage();
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