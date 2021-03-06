package SquidJump;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;


public class Platform {
    private int x, y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Platform[] platforms, platformsBroke, platformsSpike, platformsUn, platformsBomb, JettPosition;
    
    BufferedImage platform, broke, spike, grass, Jett, bomb;

    public Platform(){
            platforms = new Platform[20];

            platformsBroke = new Platform[20];

            platformsSpike = new Platform[20];

            platformsUn = new Platform[20];

            platformsBomb = new Platform[3];

            JettPosition = new Platform[10];
            try{
                platform = ImageIO.read(getClass().getResource("/Img/platform.png"));
                broke = ImageIO.read(getClass().getResource("/Img/platform1.png"));
                spike = ImageIO.read(getClass().getResource("/Img/platform2.png"));
                grass = ImageIO.read(getClass().getResource("/Img/platform3.png"));
                Jett = ImageIO.read(getClass().getResource("/Img/jettpack.png"));
                bomb = ImageIO.read(getClass().getResource("/Img/bomb.png"));
            }catch (IOException ex) {
                System.out.println("Can't load Platform");
            }
    }
    public void draw(Graphics g){
            for (int i = 0; i < 6; i++) {
            g.drawImage(
                    platform,
                    platforms[i].x,
                    platforms[i].y,
                    platform.getWidth(),
                    platform.getHeight(),
                    null
                );
            }

            for (int i = 0; i < 3; i++) {
                g.drawImage(
                        broke,
                        platformsBroke[i].x,
                        platformsBroke[i].y,
                        broke.getWidth(),
                        broke.getHeight(),
                        null
                );
            }

            for (int i = 0; i < 1; i++) {  
                g.drawImage(
                        spike,
                        platformsSpike[i].x,
                        platformsSpike[i].y,
                        spike.getWidth(),
                        spike.getHeight(),
                        null
                );
            }

            for (int i = 0; i < 3; i++) {
                g.drawImage(
                        grass,
                        platformsUn[i].x,
                        platformsUn[i].y,
                        grass.getWidth(),
                        grass.getHeight(),
                        null
                );
            }

            for (int i = 0; i < 1; i++) {
                g.drawImage(
                        bomb,
                        platformsBomb[i].x,
                        platformsBomb[i].y,
                        bomb.getWidth(),
                        bomb.getHeight(),
                        null
                );
            }

            for (int i = 0; i < 1; i++) { //jet
                g.drawImage(
                        Jett,
                        JettPosition[i].x,
                        JettPosition[i].y,
                        Jett.getWidth(),
                        Jett.getHeight(),
                        null
                );
        }
    }
            public void randomPlatform(){
                for (int i = 0; i < 10; i++) {
                platforms[i] = new Platform();
                platforms[i].setX(new Random().nextInt(400));
                platforms[i].setY(new Random().nextInt(533));
                platformsBroke[i] = new Platform();
                platformsBroke[i].setX(new Random().nextInt(400));
                platformsBroke[i].setY(new Random().nextInt(533));
                platformsSpike[i] = new Platform();
                platformsSpike[i].setX(new Random().nextInt(400));
                platformsSpike[i].setY(new Random().nextInt(533));
                platformsUn[i] = new Platform();
                platformsUn[i].setX(new Random().nextInt(400));
                platformsUn[i].setY(new Random().nextInt(533));
                JettPosition[i] = new Platform();
                JettPosition[i].setX(new Random().nextInt(400));;
                JettPosition[i].setY(new Random().nextInt(533));
            }
            
            for (int i = 0; i < 2; i++) {
                platformsBomb[i] = new Platform();
                platformsBomb[i].setX(new Random().nextInt(400));
                platformsBomb[i].setY(new Random().nextInt(533));
            }
        } 
}
