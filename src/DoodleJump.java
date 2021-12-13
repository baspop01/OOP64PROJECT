
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

class PlatformPositon {

    int x, y;
}

class PlatformPositon2 {

    int x, y;
}

class PlatformPositon3 {

    int x, y;
}

class PlatformPositon4 { //เธ�เธทเน�เธ�เธ�เน�เธฒ

    int x, y;
}

class PlatformPositon5 {

    int x, y;
}

class JettPosition {

    int x, y;
}

public class DoodleJump extends JPanel implements Runnable, KeyListener {

    final int WIDTH = 400;
    final int HEIGHT = 533;
    static display dis;

    SoundPlay1 sound1;
    SoundPlay2 sound2;
    SoundPlay2 sound3;
    SoundPlay2 sound4;
    SoundPlay1 sound5;

//    File wavFile = new File("C:\\Users\\hp\\Documents\\NetBeansProjects\\project\\src\\Music\\mystery.wav"); //new
//    AudioClip sound; //new
    boolean isRunning;
    Thread thread;
    BufferedImage view, background, platform, doodle, broke,spike,invis, doodleL, doodleR, doodle2, doodleJett, Jett, doodleR2, doodleL2, heart, topbar, scoretest, htet1, htet2, htet3, htet4, bomb, map_end;

    PlatformPositon[] platformsPosition;
    PlatformPositon2[] platformsPosition2;
    PlatformPositon3[] platformsPosition3;
    PlatformPositon4[] platformsPosition4;
    PlatformPositon5[] platformsPosition5;
    JettPosition[] JettPosition;

    int x = 100, y = 100, h = 150, sc1 = 0,health = 100, st=0, sc2=0, high=0, check=0;
    float dy = (int) (Math.random());
    boolean right, left;

    public DoodleJump() {
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

//    public void audio(){ //new
//        try{
//            sound = Applet.newAudioClip(wavFile.toURL());
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//        sound.loop();
//        
////        sound.play();
//        
////        if(test == 0){
////            sound.loop();
////        }
////        else{
////            sound.stop();
////            System.out.println("test");         
////        }  
//    } //new
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

            platformsPosition = new PlatformPositon[20];

            platformsPosition2 = new PlatformPositon2[20];
            
            platformsPosition3 = new PlatformPositon3[20];
            
            platformsPosition4 = new PlatformPositon4[20];
            
            platformsPosition5 = new PlatformPositon5[3];

            JettPosition = new JettPosition[10];

            for (int i = 0; i < 10; i++) {
                platformsPosition[i] = new PlatformPositon();
                platformsPosition[i].x = new Random().nextInt(400);
                platformsPosition[i].y = new Random().nextInt(533);
            }
            for (int i = 0; i < 10; i++) {
                platformsPosition2[i] = new PlatformPositon2();
                platformsPosition2[i].x = new Random().nextInt(400);
                platformsPosition2[i].y = new Random().nextInt(533);
            }
            for (int i = 0; i < 10; i++) {
                platformsPosition3[i] = new PlatformPositon3();
                platformsPosition3[i].x = new Random().nextInt(400);
                platformsPosition3[i].y = new Random().nextInt(533);
            }
            for (int i = 0; i < 10; i++) {
                platformsPosition4[i] = new PlatformPositon4();
                platformsPosition4[i].x = new Random().nextInt(400);
                platformsPosition4[i].y = new Random().nextInt(533);
            }
            
            for (int i = 0; i < 2; i++) {
                platformsPosition5[i] = new PlatformPositon5();
                platformsPosition5[i].x = new Random().nextInt(400);
                platformsPosition5[i].y = new Random().nextInt(533);
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

        //เน€เธ�เธตเน�เธขเธงเธ�เธฑเธ�เธ•เธณเน�เธซเธ�เน�เธ�เธ•เธฑเธงเธฅเธฐเธ�เธฃ
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

        //เธชเธฃเน�เธฒเธ�เน�เธ�เธฅเธ•เธ�เธญเธฃเน�เธก
        if (y < h) {
            sc1++;
            for (int i = 0; i < 6; i++) { //เน�เธ�เน�เธ�เธ�เธ�เธ•เธด
                y = h;
                platformsPosition[i].y = platformsPosition[i].y - (int) dy;
                if (platformsPosition[i].y > 533) {
                    platformsPosition[i].y = 0;
                    platformsPosition[i].x = new Random().nextInt(350);
                }
            }
            

            for (int i = 0; i < 3; i++) {  //เน�เธ�เน�เธ�เน�เธ•เธ�
                y = h;
                platformsPosition2[i].y = platformsPosition2[i].y - (int) dy;
                if (platformsPosition2[i].y > 533) {
                    platformsPosition2[i].y = 0;
                    platformsPosition2[i].x = new Random().nextInt(400);
                }
            }
            
            for (int i = 0; i < 1; i++) { //เน�เธ�เน�เธ�เธฅเธ”เน€เธฅเธทเธญเธ”
                y = h;
                platformsPosition3[i].y = platformsPosition3[i].y - (int) dy;
                if (platformsPosition3[i].y > 533) {
                    platformsPosition3[i].y = 0;
                    platformsPosition3[i].x = new Random().nextInt(400);
                }
            }
            for (int i = 0; i < 3; i++) { //เน�เธ�เน�เธ�เน�เธกเน�เน�เธ”เธ”
                y = h;
                platformsPosition4[i].y = platformsPosition4[i].y - (int) dy;
                if (platformsPosition4[i].y > 533) {
                    platformsPosition4[i].y = 0;
                    platformsPosition4[i].x = new Random().nextInt(400);
                }
            }
            
            for (int i = 0; i < 2; i++) {
                y = h;
                platformsPosition5[i].y = platformsPosition5[i].y - (int) dy;
                if (platformsPosition5[i].y > 1000) {
                    platformsPosition5[i].y = 0;
                    platformsPosition5[i].x = new Random().nextInt(350);
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

        //เน€เธกเธทเน�เธญเน€เธซเธขเธตเธขเธ�เธ�เธทเน�เธ�เธ�เธฃเธฃเธกเธ”เธฒ
        for (int i = 0; i < 6; i++) {
            if ((x + 35 > platformsPosition[i].x)
                    && (x + 35 < platformsPosition[i].x + 68)
                    && (y + 70 > platformsPosition[i].y)
                    && (y + 70 < platformsPosition[i].y + 14)
                    && (dy > 0)) {
                dy = -10;
                doodle = doodle2;
                doodleR = doodleR2;
                doodleL = doodleL2;
                sound1 = new SoundPlay1("/Music/jump.wav");

            }
        }

            
        //เน�เธญเน€เธ—เธก
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

        //เน€เธกเธทเน�เธญเน€เธซเธขเธตเธขเธ�เธ�เธทเน�เธ�เน�เธ•เธ�

        for (int i = 0; i < 3; i++) {

            if ((x + 35 > platformsPosition2[i].x)
                    && (x + 35 < platformsPosition2[i].x + 68)
                    && (y + 70 > platformsPosition2[i].y)
                    && (y + 70 < platformsPosition2[i].y + 14)
                    && (dy > 0)) {
                dy = -8;
                doodle = doodle2;
                doodleR = doodleR2;
                doodleL = doodleL2;
                platformsPosition2[i].y = -100;
                platformsPosition2[i].x = -100;
                sound2 = new SoundPlay2("/Music/broke.wav");

            }
        }
        
        //เน€เธกเธทเน�เธญเน€เธซเธขเธตเธขเธ�เธซเธ�เธฒเธก
        for (int i = 0; i < 1; i++) {
            
            if ((x + 35 > platformsPosition3[i].x)
                    && (x + 35 < platformsPosition3[i].x + 68)
                    && (y + 60 > platformsPosition3[i].y)
                    && (y + 60 < platformsPosition3[i].y + 14)
                    && (dy > 0)) {
                health -= 80;
                System.out.println(health);
                dy = -10;
                doodle = doodle2;
                doodleR = doodleR2;
                doodleL = doodleL2;
                sound3 = new SoundPlay2("/Music/spike.wav");
                if(health < -60){
                    platformsPosition3[i].y = -100;
                    platformsPosition3[i].x = -100;
                }
            }
          
        }
        //เน€เธกเธทเน�เธญเน€เธซเธขเธตเธขเธ�เธ�เธทเน�เธ�เน�เธกเน�เน�เธ”เธ”
        for (int i = 0; i < 3; i++) {

            if ((x + 35 > platformsPosition4[i].x)
                    && (x + 35 < platformsPosition4[i].x + 68)
                    && (y + 150 > platformsPosition4[i].y + 80)
                    && (y + 60 < platformsPosition4[i].y + 4)
                    && (dy > 0)) {
                dy = -1;
                doodle = doodle2;
                doodleR = doodleR2;
                doodleL = doodleL2;
                platformsPosition4[i].y = -100;
                platformsPosition4[i].x = -100;
                sound2 = new SoundPlay2("/Music/broke.wav");

            }
        }
        
        for (int i = 0; i < 1; i++) {

            if ((x + 35 > platformsPosition5[i].x)
                    && (x + 35 < platformsPosition5[i].x + 48)
                    && (y + 80 > platformsPosition5[i].y + 40)
                    && (y + 65 < platformsPosition5[i].y + 39)
                    && ((dy < 0) || (dy >= 0))) {
                dy = -1;
                doodle = doodle2;
                doodleR = doodleR2;
                doodleL = doodleL2;
                health = -61;
                sound3 = new SoundPlay2("/Music/boomb.wav");
                platformsPosition5[i].y = -100;
                platformsPosition5[i].x = -100;

            }
        }
        
    }

    
//    public void gameOver(){
//            sound3 = new SoundPlay2("/Music/dead.wav");
//                 
//            start();
//            sc1 = 0;
//            y = 100;
//            x = 100;
//            dy = 0;
//            right = false;
//            left = false;
//    }
    public void draw() {
        Graphics2D g3 = (Graphics2D) view.getGraphics();
        if (check == 1){
            Graphics2D g2 = (Graphics2D) view.getGraphics();
            g2.drawImage(background, 0, 0, WIDTH, HEIGHT, null);
            g2.drawImage(doodle, x, y, doodle.getWidth(), doodle.getHeight(), null);
            for (int i = 0; i < 6; i++) {
            g2.drawImage(
                    platform,
                    platformsPosition[i].x,
                    platformsPosition[i].y,
                    platform.getWidth(),
                    platform.getHeight(),
                    null
                );
            }

            for (int i = 0; i < 3; i++) {
                g2.drawImage(
                        broke,
                        platformsPosition2[i].x,
                        platformsPosition2[i].y,
                        broke.getWidth(),
                        broke.getHeight(),
                        null
                );
            }

            for (int i = 0; i < 1; i++) {  
                g2.drawImage(
                        spike,
                        platformsPosition3[i].x,
                        platformsPosition3[i].y,
                        spike.getWidth(),
                        spike.getHeight(),
                        null
                );
            }

            for (int i = 0; i < 3; i++) {
                g2.drawImage(
                        invis,
                        platformsPosition4[i].x,
                        platformsPosition4[i].y,
                        invis.getWidth(),
                        invis.getHeight(),
                        null
                );
            }

            for (int i = 0; i < 1; i++) {
                g2.drawImage(
                        bomb,
                        platformsPosition5[i].x,
                        platformsPosition5[i].y,
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
            g3.drawImage(background, 0, 0, WIDTH, HEIGHT, null);
            g3.setColor(Color.WHITE);
            g3.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 50));
            g3.drawString("SQUID JUMP", (WIDTH / 2) - 130, (HEIGHT - 100) / 2);
            g3.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
            g3.drawString("Press 'space' to play", (WIDTH / 2) - 110, (HEIGHT + 0) / 2);
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
        
        
//        g2.drawImage(heart, 10, 60, 30, 25, null);
//        g2.setStroke(new BasicStroke(16.0f));
//	g2.setColor(new Color(241, 98, 69));
//        g2.drawLine(50, 60, 60 + health, 60);	
//	g2.setColor(Color.white);
//	g2.setStroke(new BasicStroke(5.0f));
//        g2.drawRect(40, 60, 170 ,20);
        
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
            }
            if(st == 1){
                
                check = 1;
                st = 1;
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
