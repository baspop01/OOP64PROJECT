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

class PlatformPositon{
    int x,y;
}

class PlatformPositon2{
    int x,y;
}

public class DoodleJump extends JPanel implements Runnable, KeyListener{
    final int WIDTH = 400;
    final int HEIGHT = 533;
    static display dis;
    SoundPlay1 sound1;
    SoundPlay2 sound2;
    


//    File wavFile = new File("C:\\Users\\hp\\Documents\\NetBeansProjects\\project\\src\\Music\\mystery.wav"); //new
//    AudioClip sound; //new
    
    
    
    
    
    boolean isRunning;
    Thread thread;
    BufferedImage view, background, platform, doodle, broke, doodleL, doodleR, doodle2;
    
    PlatformPositon[] platformsPosition;
    PlatformPositon2[] platformsPosition2;
    int x = 100, y = 100, h = 150;
    float dy = 0;
    boolean right, left;
    
    
     
    public DoodleJump(){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addKeyListener(this);
    }

    @Override
    public void addNotify(){
        super.addNotify();
        if(thread == null){
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
    
    
    
    public void start(){
//        audio(); //new      
        try{
            view = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
            
            background = ImageIO.read(getClass().getResource("background.png"));
            platform = ImageIO.read(getClass().getResource("platform.png"));
            doodle = ImageIO.read(getClass().getResource("doodle.png"));
            doodle2 = ImageIO.read(getClass().getResource("doodle.png"));
            broke = ImageIO.read(getClass().getResource("platform1.png"));
            doodleL = ImageIO.read(getClass().getResource("doodleleft.png")); //new
            doodleR = ImageIO.read(getClass().getResource("doodleright.png")); //new
             
            platformsPosition = new PlatformPositon[20];
            
            platformsPosition2 = new PlatformPositon2[20];
            
            for(int i = 0; i < 10; i++){
                platformsPosition[i] = new PlatformPositon();
                platformsPosition[i].x = new Random().nextInt(400);
                platformsPosition[i].y = new Random().nextInt(533);
            }
            
            for(int i = 0; i < 10; i++){
                platformsPosition2[i] = new PlatformPositon2();
                platformsPosition2[i].x = new Random().nextInt(400);
                platformsPosition2[i].y = new Random().nextInt(533);
            }
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void update(){
        
        //เกี่ยวกับตำแหน่งตัวละคร
        if(right){
            x += 3;
        }else if(left){
            x -= 3;
        }
        dy += 0.2;
        y += dy;
        if(y >= 500){
            JOptionPane.showMessageDialog(null, "คุณเกมโอเวอร์แล้ว กด OK เพื่อเริ่มใหม่", "Game Over", JOptionPane.WARNING_MESSAGE);
            start();
            y = 100;
            x = 100;
            dy = 0;
            right = false;
            left = false;
                   
        }
        if(x <= -30){
            x = 425;
        }
        if(x >= 430){
            x = -20;
        }
        
        //สร้างแพลตฟอร์ม
        if (y < h){
            for(int i = 0; i < 6; i++){
                y = h;
                platformsPosition[i].y = platformsPosition[i].y - (int) dy;
                if (platformsPosition[i].y > 533){
                    platformsPosition[i].y = 0;
                    platformsPosition[i].x = new Random().nextInt(400);
                }
                
               
            }
            
            for(int i = 0; i < 3; i++){
                y = h;
                platformsPosition2[i].y = platformsPosition2[i].y - (int) dy;
                if (platformsPosition2[i].y > 533){
                    platformsPosition2[i].y = 0;
                    platformsPosition2[i].x = new Random().nextInt(400);
                }
            }
        }
        
        //เมื่อเหยียบพื้นธรรมดา
        for(int i = 0; i < 6; i++){
            if ((x + 35 > platformsPosition[i].x) &&
                    (x + 35 < platformsPosition[i].x + 68) &&
                    (y + 70 > platformsPosition[i].y) &&
                    (y + 70 < platformsPosition[i].y + 14) &&
                    (dy > 0)) {
                dy = -10;
                doodle = doodle2;
                sound1 = new SoundPlay1("/Music/jump.wav");
            }
            
            
        }
        
        //เมื่อเหยียบพื้นแตก
        for(int i = 0; i < 3; i++){
           
            if ((x + 35 > platformsPosition2[i].x) &&
                    (x + 35 < platformsPosition2[i].x + 68) &&
                    (y + 70 > platformsPosition2[i].y) &&
                    (y + 70 < platformsPosition2[i].y + 14) &&
                    (dy > 0)) {
                dy = -8;
                doodle = doodle2;
                platformsPosition2[i].y = -100;
                platformsPosition2[i].x = -100;                
                sound2 = new SoundPlay2("/Music/broke.wav");
                
            }
        }
        
    }
    
        
   
                  
    public void draw(){
        Graphics2D g2 = (Graphics2D) view.getGraphics();
        g2.drawImage(background, 0, 0, WIDTH, HEIGHT, null);
        g2.drawImage(doodle, x, y, doodle.getWidth(), doodle.getHeight(), null);
        for(int i = 0; i < 6; i++){
            g2.drawImage(
                platform,
                platformsPosition[i].x,
                platformsPosition[i].y,
                platform.getWidth(),
                platform.getHeight(),
                null
            );
        }
        for(int i = 0; i < 3; i++){
            g2.drawImage(
                broke,
                platformsPosition2[i].x,
                platformsPosition2[i].y,
                broke.getWidth(),
                broke.getHeight(),
                null
            );
        }
        Graphics g = getGraphics();
        g.drawImage(view, 0, 0, WIDTH, HEIGHT, null);
        g.dispose();
    }
    
    @Override
    public void run(){
        try{
            requestFocus();
            start();
            while(isRunning){
                update();
                draw();
                Thread.sleep(1000/ 60);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void keyType(KeyEvent e){
    
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            right = true;
            doodle = doodleR; //new
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            left = true;
            doodle = doodleL; //new
        }     
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            right = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            left = false;
        }
    } 

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}