package SquidJump;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class GetIm {
    BufferedImage view, background, platform, doodle, broke,spike,invis, doodleL, doodleR, doodle2, doodleJett, Jett, doodleR2
            , doodleL2, heart, topbar, scoretop, bomb, map_end, startgame, heart0, heart1, heart2, heart3;
    final int WIDTH = 400;
    final int HEIGHT = 533;
    public GetIm() {
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
