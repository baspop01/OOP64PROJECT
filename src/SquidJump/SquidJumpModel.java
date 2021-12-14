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

public class SquidJumpModel extends SquidJump{
    public void start() {
//        audio(); //new      
        try {
            view = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

            background = ImageIO.read(getClass().getResource("/Img/background.png"));
            platform = ImageIO.read(getClass().getResource("/Img/platform.png"));
            doodle = ImageIO.read(getClass().getResource("/Img/doodle1.png"));
            doodle2 = ImageIO.read(getClass().getResource("/Img/doodle1.png"));
            broke = ImageIO.read(getClass().getResource("/Img/platform1.png"));
            spike = ImageIO.read(getClass().getResource("/Img/platform2.png"));
            invis = ImageIO.read(getClass().getResource("/Img/platform3.png"));
            doodleL = ImageIO.read(getClass().getResource("/Img/doodleleft1.png"));
            doodleR = ImageIO.read(getClass().getResource("/Img/doodleright1.png"));
            doodleL2 = ImageIO.read(getClass().getResource("/Img/doodleleft1.png"));
            doodleR2 = ImageIO.read(getClass().getResource("/Img/doodleright1.png"));
            doodleJett = ImageIO.read(getClass().getResource("/Img/doodlejett.png"));
            Jett = ImageIO.read(getClass().getResource("/Img/jettpack.png"));
            topbar = ImageIO.read(getClass().getResource("/Img/topbar.png"));
            scoretest = ImageIO.read(getClass().getResource("/Img/sctest1.png"));
            htet4 = ImageIO.read(getClass().getResource("/Img/testh.png")); 
            htet1 = ImageIO.read(getClass().getResource("/Img/testh1.png"));
            htet2 = ImageIO.read(getClass().getResource("/Img/testh2.png"));
            htet3 = ImageIO.read(getClass().getResource("/Img/testh3.png"));
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

        //ตำแหน่งตัวละคร
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

        //พื้น
        if (y < h) {
            sc1++;
            for (int i = 0; i < 6; i++) { //ปกติ
                y = h;
                platforms[i].y = platforms[i].y - (int) dy;
                if (platforms[i].y > 533) {
                    platforms[i].y = 0;
                    platforms[i].x = new Random().nextInt(350);
                }
            }
            

            for (int i = 0; i < 3; i++) {  //แตก
                y = h;
                platformsBroke[i].y = platformsBroke[i].y - (int) dy;
                if (platformsBroke[i].y > 533) {
                    platformsBroke[i].y = 0;
                    platformsBroke[i].x = new Random().nextInt(400);
                }
            }
            
            for (int i = 0; i < 1; i++) { //หนาม
                y = h;
                platformsSpike[i].y = platformsSpike[i].y - (int) dy;
                if (platformsSpike[i].y > 533) {
                    platformsSpike[i].y = 0;
                    platformsSpike[i].x = new Random().nextInt(400);
                }
            }
            for (int i = 0; i < 3; i++) { //ไม่โดด
                y = h;
                platformsUn[i].y = platformsUn[i].y - (int) dy;
                if (platformsUn[i].y > 533) {
                    platformsUn[i].y = 0;
                    platformsUn[i].x = new Random().nextInt(400);
                }
            }
            
            for (int i = 0; i < 2; i++) {
                y = h;
                platformsBomb[i].y = platformsBomb[i].y - (int) dy;
                if (platformsBomb[i].y > 1000) {
                    platformsBomb[i].y = 0;
                    platformsBomb[i].x = new Random().nextInt(350);
                }
                
            }

            for (int i = 0; i < 1; i++) { //jet
                y = h;
                JettPosition[i].y = JettPosition[i].y - (int) dy;
                if (JettPosition[i].y > 533) {
                    JettPosition[i].y = 0;
                    JettPosition[i].x = new Random().nextInt(400);
                }
            }
            
        }

        //เหยียบปกติ
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

            
        //เหยียบไอเทม
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

        
        //เหยียบแตก
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
        
        //เหยียบหนาม
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
        //เหยียบไม่โดด
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
                sound2 = new SoundPlay2("/Music/broke.wav");

            }
        }
        //เหยียบระเบิด
        for (int i = 0; i < 1; i++) {

            if ((x + 35 > platformsBomb[i].x)
                    && (x + 35 < platformsBomb[i].x + 48)
                    && (y + 80 > platformsBomb[i].y + 40)
                    && (y + 65 < platformsBomb[i].y + 39)
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
}
