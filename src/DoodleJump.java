
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

class PlatformPositon { //พื้นธรรมดา

    int x, y;
}

class PlatformPositon2 { //พื้นแตก

    int x, y;
}

class PlatformPositon3 { //พื้นหนาม

    int x, y;
}

class PlatformPositon4 { //พื้นฟ้า

    int x, y;
}

class PlatformPositon5 { //bomb

    int x, y;
}

class JettPosition {

    int x, y;
}

public class DoodleJump extends JPanel implements Runnable, KeyListener {

    final int WIDTH = 400;
    final int HEIGHT = 533;
    static display dis;
    private int st = 0;
    SoundPlay1 sound1;
    SoundPlay2 sound2;
    SoundPlay2 sound3;

//    File wavFile = new File("C:\\Users\\hp\\Documents\\NetBeansProjects\\project\\src\\Music\\mystery.wav"); //new
//    AudioClip sound; //new
    boolean isRunning;
    Thread thread;
    BufferedImage view, background, platform, doodle, broke,spike,invis,bomb, doodleL, doodleR, doodle2, doodleJett, Jett, doodleR2, doodleL2, heart, map_end;

    PlatformPositon[] platformsPosition;
    PlatformPositon2[] platformsPosition2;
    PlatformPositon3[] platformsPosition3;
    PlatformPositon4[] platformsPosition4;
    PlatformPositon5[] platformsPosition5;
    JettPosition[] JettPosition;

    int x = 100, y = 100, h = 150, sc1 = 0,health = 145;
    float dy = 0;
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

            background = ImageIO.read(getClass().getResource("background.png"));
            platform = ImageIO.read(getClass().getResource("platform.png"));
            doodle = ImageIO.read(getClass().getResource("doodle1.png"));
            doodle2 = ImageIO.read(getClass().getResource("doodle1.png"));
            broke = ImageIO.read(getClass().getResource("platform1.png"));
            spike = ImageIO.read(getClass().getResource("platform2.png"));
            invis = ImageIO.read(getClass().getResource("platform3.png"));
            bomb = ImageIO.read(getClass().getResource("bomb.png"));
            doodleR = ImageIO.read(getClass().getResource("doodleright1.png"));
            doodleL = ImageIO.read(getClass().getResource("doodleleft1.png"));
            doodleR2 = ImageIO.read(getClass().getResource("doodleright1.png"));
            doodleL2 = ImageIO.read(getClass().getResource("doodleleft1.png"));
            doodleJett = ImageIO.read(getClass().getResource("doodlejett.png"));
            Jett = ImageIO.read(getClass().getResource("jettpack.png"));
            heart = ImageIO.read(getClass().getResource("png-clipart-heart-heart.png"));
//            map_end = ImageIO.read(getClass().getResource("map_end.jpg"));

            platformsPosition = new PlatformPositon[9];

            platformsPosition2 = new PlatformPositon2[3]; //พื้นแตก
            
            platformsPosition3 = new PlatformPositon3[1];
            
            platformsPosition4 = new PlatformPositon4[3];
            
            platformsPosition5 = new PlatformPositon5[1];

            JettPosition = new JettPosition[2];

            for (int i = 0; i < 8; i++) {
                platformsPosition[i] = new PlatformPositon();
                platformsPosition[i].x = new Random().nextInt(400);
                platformsPosition[i].y = new Random().nextInt(533);
            }

            for (int i = 0; i < 3; i++) {
                platformsPosition2[i] = new PlatformPositon2();
                platformsPosition2[i].x = new Random().nextInt(400);
                platformsPosition2[i].y = new Random().nextInt(533);
            }
            for (int i = 0; i < 1; i++) {
                platformsPosition3[i] = new PlatformPositon3();
                platformsPosition3[i].x = new Random().nextInt(400);
                platformsPosition3[i].y = new Random().nextInt(533);
            }
            for (int i = 0; i < 3; i++) {
                platformsPosition4[i] = new PlatformPositon4();
                platformsPosition4[i].x = new Random().nextInt(400);
                platformsPosition4[i].y = new Random().nextInt(533);
            }
            for (int i = 0; i < 1; i++) {
                platformsPosition5[i] = new PlatformPositon5();
                platformsPosition5[i].x = new Random().nextInt(400);
                platformsPosition5[i].y = new Random().nextInt(533);
            }
            for (int i = 0; i < 1; i++) {
                JettPosition[i] = new JettPosition();
                JettPosition[i].x = new Random().nextInt(400);
                JettPosition[i].y = new Random().nextInt(533);
            }
            health = 145;
            sc1 = 0;
            st = 1;
            y = 100;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {

        //เกี่ยวกับตำแหน่งตัวละคร
        if (right) {
            x += 3;
        } else if (left) {
            x -= 3;
        }
        dy += 0.2;
        y += dy;
//        if (y >= 500) {
//            sound3 = new SoundPlay2("/Music/dead.wav");
//            JOptionPane.showMessageDialog(null, "คุณเกมโอเวอร์แล้ว กด OK เพื่อเริ่มใหม่", "Game Over", JOptionPane.WARNING_MESSAGE);
//            start();
//            sc1 = 0;
//            y = 100;
//            x = 100;
//            dy = 0;
//            right = false;
//            left = false;
//
//        }
        if (x <= -30) {
            x = 425;
        }
        if (x >= 430) {
            x = -20;
        }

        //สร้างแพลตฟอร์ม
        if (y < h) {
            sc1++;
            for (int i = 0; i < 8; i++) {
                y = h;
                platformsPosition[i].y = platformsPosition[i].y - (int) dy;
                if (platformsPosition[i].y > 533) {
                    platformsPosition[i].y = 0;
                    platformsPosition[i].x = new Random().nextInt(350);
                }

            }

            for (int i = 0; i < 3; i++) {
                y = h;
                platformsPosition2[i].y = platformsPosition2[i].y - (int) dy;
                if (platformsPosition2[i].y > 533) {
                    platformsPosition2[i].y = 0;
                    platformsPosition2[i].x = new Random().nextInt(350);
                }
            }
            for (int i = 0; i < 1; i++) {
                y = h;
                platformsPosition3[i].y = platformsPosition3[i].y - (int) dy;
                if (platformsPosition3[i].y > 533) {
                    platformsPosition3[i].y = 0;
                    platformsPosition3[i].x = new Random().nextInt(350);
                }
            }
            for (int i = 0; i < 1; i++) {
                y = h;
                platformsPosition4[i].y = platformsPosition4[i].y - (int) dy;
                if (platformsPosition4[i].y > 533) {
                    platformsPosition4[i].y = 0;
                    platformsPosition4[i].x = new Random().nextInt(350);
                }
            }
            for (int i = 0; i < 1; i++) {
                y = h;
                platformsPosition5[i].y = platformsPosition5[i].y - (int) dy;
                if (platformsPosition5[i].y > 1000) {
                    platformsPosition5[i].y = 0;
                    platformsPosition5[i].x = new Random().nextInt(350);
                }
                
            }
            
            for (int i = 0; i < 1; i++) {
                y = h;
                JettPosition[i].y = JettPosition[i].y - (int) dy;
                if (JettPosition[i].y > 1400) {
                    JettPosition[i].y = 0;
                    JettPosition[i].x = new Random().nextInt(350);
                }
            }
        }

        //เมื่อเหยียบพื้นธรรมดา
        for (int i = 0; i < 8; i++) {
            if ((x + 35 > platformsPosition[i].x)
                    && (x + 35 < platformsPosition[i].x + 68)
                    && (y + 105 > platformsPosition[i].y + 35)
                    && (y + 60 < platformsPosition[i].y + 4)
                    && (dy > 0)) {
                dy = -10;
                doodle = doodle2;
                doodleR = doodleR2;
                doodleL = doodleL2;
                sound1 = new SoundPlay1("/Music/jump.wav");
            }
        }
        //ไอเทม
        for (int i = 0; i < 1; i++) {
            if ((x + 15 > JettPosition[i].x)
                    && (x + 15 < JettPosition[i].x + 68)
                    && (y + 90 > JettPosition[i].y + 50)
                    && (y + 50 < JettPosition[i].y + 24)
                    && ((dy < 0) || (dy >= 0))) {
                dy = -40;
                doodle = doodleJett;
                doodleR = doodleJett;
                doodleL = doodleJett;
                JettPosition[i].y = -100;
                JettPosition[i].x = -100;
                sound1 = new SoundPlay1("/Music/jump.wav");
            }
        }

        //เมื่อเหยียบพื้นแตก
        for (int i = 0; i < 3; i++) {

            if ((x + 35 > platformsPosition2[i].x)
                    && (x + 35 < platformsPosition2[i].x + 68)
                    && (y + 110 > platformsPosition2[i].y + 40)
                    && (y + 79 < platformsPosition2[i].y + 24)
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
        
        //เมื่อเหยียบระบิด
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
                
                sound3 = new SoundPlay2("/Music/boomb.wav");
                JOptionPane.showMessageDialog(null, "คุณเกมโอเวอร์แล้ว กด OK เพื่อเริ่มใหม่", "Game Over", JOptionPane.WARNING_MESSAGE);                  
                start();

            }
        }
        
        //เมื่อเหยียบพื้นล่องหน
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
        
        //เมื่อเหยียบหนาม
        for (int i = 0; i < 1; i++) {

            if ((x + 35 > platformsPosition3[i].x)
                    && (x + 35 < platformsPosition3[i].x + 68)
                    && (y + 120 > platformsPosition3[i].y + 60)
                    && (y + 85 < platformsPosition3[i].y + 39)
                    && (dy > 0)) {
                
//                sound3 = new SoundPlay2("/Music/spike.wav");
//                doodle = doodle2;
//                doodleR = doodleR2;
//                doodleL = doodleL2;
                
                if(health > 0){
                    health -= 50;
                    dy = -10;
                    doodle = doodle2;
                    doodleR = doodleR2;
                    doodleL = doodleL2;
                    sound3 = new SoundPlay2("/Music/spike.wav");
                }else{
                    sound3 = new SoundPlay2("/Music/dead.wav");
                    JOptionPane.showMessageDialog(null, "คุณเกมโอเวอร์แล้ว กด OK เพื่อเริ่มใหม่", "Game Over", JOptionPane.WARNING_MESSAGE);                  
                    start();
                }
                
                

            }
        }
  
        
        

    }
    
    public void gameOver(){
            sound3 = new SoundPlay2("/Music/dead.wav");
            Graphics2D g3 = (Graphics2D) view.getGraphics();
                 
            
            if ((y >= 500)){
                g3.setColor(new Color(63, 121, 186));
                g3.fillRect(0, 0, 400, 533); 
                g3.setColor(Color.BLACK);
                g3.setFont(new Font("Monospaced", Font.PLAIN, 70));
                g3.drawString("Game Over", (WIDTH / 2) - 180, (HEIGHT - 50) / 2);
                g3.setFont(new Font("Monospaced", Font.PLAIN, 30));
                g3.drawString("Your Score " + sc1, (WIDTH / 2) - 150, (HEIGHT + 60) / 2);
    //            g3.drawImage(map_end, 0, y - 1000, 700, 2000, null);
                g3.drawImage(map_end, 0, y + 1000, 700, -2000, null);
                st = 0;
                sc1 = 0;
                y = 100;
                x = 100;
                dy = 0;
                right = false;
                left = false;
            }
            

    }

    public void draw() {
        Graphics2D g3 = (Graphics2D) view.getGraphics();
        Graphics2D g2 = (Graphics2D) view.getGraphics();
        g2.drawImage(background, 0, 0, WIDTH, HEIGHT, null);
        g2.drawImage(doodle, x, y, doodle.getWidth(), doodle.getHeight(), null);
        for (int i = 0; i < 8; i++) {
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
        for (int i = 0; i < 1; i++) {
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
        for (int i = 0; i < 1; i++) {
            g2.drawImage(
                    Jett,
                    JettPosition[i].x,
                    JettPosition[i].y,
                    Jett.getWidth(),
                    Jett.getHeight(),
                    null
            );
        }
        g2.setColor(Color.black);
        g2.drawString("score : "+sc1, 15, 15);
        
        g2.drawImage(heart,10,23,30,25,null);
        g2.setStroke(new BasicStroke(16.0f));
	g2.setColor(new Color(241, 98, 69));
        g2.drawLine(50,35,60+health,35);	
	g2.setColor(Color.white);
	g2.setStroke(new BasicStroke(5.0f));
        g2.drawRect(40,25,170,20);
        
        if ((y >= 500)){
            g3.setColor(new Color(63, 121, 186));
            g3.fillRect(0, 0, 400, 533); 
            g3.setColor(Color.BLACK);
            g3.setFont(new Font("Monospaced", Font.PLAIN, 70));
            g3.drawString("Game Over", (WIDTH / 2) - 180, (HEIGHT - 50) / 2);
            g3.setFont(new Font("Monospaced", Font.PLAIN, 30));
            g3.drawString("Your Score " + sc1, (WIDTH / 2) - 150, (HEIGHT + 60) / 2);
//            g3.drawImage(map_end, 0, y - 1000, 700, 2000, null);
            g3.drawImage(map_end, 0, y + 1000, 700, -2000, null);
            st = 0;
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
                    Thread.sleep(1000 / 60);
                }
                
                else if(sc1 >= 801){
                    Thread.sleep(900 / 60);
                    
                }
                else if(sc1 >= 1300){
                    Thread.sleep(800 / 60);
                }
                else if(sc1 >= 1700){
                    Thread.sleep(700 / 60);
                }
                else if(sc1 >= 2000){
                    Thread.sleep(600 / 60);
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
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if(st == 0){
                start();
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
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = false;
        }
    }

    
    @Override
    public void keyTyped(KeyEvent ke) {
    }
    

}
