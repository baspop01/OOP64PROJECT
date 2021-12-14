

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Image {
   
    public static BufferedImage view, background, platform, doodle, broke,spike,invis, doodleL, doodleR, doodle2, doodleJett, Jett, doodleR2
            , doodleL2, heart, topbar, scoretest, htet1, htet2, htet3, htet4, bomb, map_end, startgame;

    public Image() {
        try {
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
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
