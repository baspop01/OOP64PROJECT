

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Image {
    BufferedImage view, background, platform, doodle, broke,spike,invis, doodleL, doodleR, doodle2, doodleJett, Jett, doodleR2
            , doodleL2, heart, topbar, scoretop, bomb, map_end, startgame, heart0, heart1, heart2, heart3;
    final int WIDTH = 400;
    final int HEIGHT = 533;
    public Image() {
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

    public BufferedImage getView() {
        return view;
    }

    public void setView(BufferedImage view) {
        this.view = view;
    }

    public BufferedImage getBackground() {
        return background;
    }

    public void setBackground(BufferedImage background) {
        this.background = background;
    }

    public BufferedImage getPlatform() {
        return platform;
    }

    public void setPlatform(BufferedImage platform) {
        this.platform = platform;
    }

    public BufferedImage getDoodle() {
        return doodle;
    }

    public void setDoodle(BufferedImage doodle) {
        this.doodle = doodle;
    }

    public BufferedImage getBroke() {
        return broke;
    }

    public void setBroke(BufferedImage broke) {
        this.broke = broke;
    }

    public BufferedImage getSpike() {
        return spike;
    }

    public void setSpike(BufferedImage spike) {
        this.spike = spike;
    }

    public BufferedImage getInvis() {
        return invis;
    }

    public void setInvis(BufferedImage invis) {
        this.invis = invis;
    }

    public BufferedImage getDoodleL() {
        return doodleL;
    }

    public void setDoodleL(BufferedImage doodleL) {
        this.doodleL = doodleL;
    }

    public BufferedImage getDoodleR() {
        return doodleR;
    }

    public void setDoodleR(BufferedImage doodleR) {
        this.doodleR = doodleR;
    }

    public BufferedImage getDoodle2() {
        return doodle2;
    }

    public void setDoodle2(BufferedImage doodle2) {
        this.doodle2 = doodle2;
    }

    public BufferedImage getDoodleJett() {
        return doodleJett;
    }

    public void setDoodleJett(BufferedImage doodleJett) {
        this.doodleJett = doodleJett;
    }

    public BufferedImage getJett() {
        return Jett;
    }

    public void setJett(BufferedImage Jett) {
        this.Jett = Jett;
    }

    public BufferedImage getDoodleR2() {
        return doodleR2;
    }

    public void setDoodleR2(BufferedImage doodleR2) {
        this.doodleR2 = doodleR2;
    }

    public BufferedImage getDoodleL2() {
        return doodleL2;
    }

    public void setDoodleL2(BufferedImage doodleL2) {
        this.doodleL2 = doodleL2;
    }

    public BufferedImage getHeart() {
        return heart;
    }

    public void setHeart(BufferedImage heart) {
        this.heart = heart;
    }

    public BufferedImage getTopbar() {
        return topbar;
    }

    public void setTopbar(BufferedImage topbar) {
        this.topbar = topbar;
    }

    public BufferedImage getScoretop() {
        return scoretop;
    }

    public void setScoretop(BufferedImage scoretop) {
        this.scoretop = scoretop;
    }

    public BufferedImage getBomb() {
        return bomb;
    }

    public void setBomb(BufferedImage bomb) {
        this.bomb = bomb;
    }

    public BufferedImage getMap_end() {
        return map_end;
    }

    public void setMap_end(BufferedImage map_end) {
        this.map_end = map_end;
    }

    public BufferedImage getStartgame() {
        return startgame;
    }

    public void setStartgame(BufferedImage startgame) {
        this.startgame = startgame;
    }

    public BufferedImage getHeart0() {
        return heart0;
    }

    public void setHeart0(BufferedImage heart0) {
        this.heart0 = heart0;
    }

    public BufferedImage getHeart1() {
        return heart1;
    }

    public void setHeart1(BufferedImage heart1) {
        this.heart1 = heart1;
    }

    public BufferedImage getHeart2() {
        return heart2;
    }

    public void setHeart2(BufferedImage heart2) {
        this.heart2 = heart2;
    }

    public BufferedImage getHeart3() {
        return heart3;
    }

    public void setHeart3(BufferedImage heart3) {
        this.heart3 = heart3;
    }
}
