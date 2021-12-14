package SquidJump;

import SquidJump.display;
import java.awt.image.BufferedImage;
public class SquidJump {
    public final int WIDTH = 400;
    public  final int HEIGHT = 533;
    public static display dis;
    
    public SoundPlay1 sound1;
    public SoundPlay2 sound2;
    public SoundPlay2 sound3;
    public SoundPlay2 sound4;
    public SoundPlay1 sound5;
    
    public boolean isRunning;
    public Thread thread;
    public BufferedImage view, background, platform, doodle, broke,spike,invis, doodleL, doodleR, doodle2, doodleJett, Jett, doodleR2
            , doodleL2, heart, topbar, scoretest, htet1, htet2, htet3, htet4, bomb, map_end, startgame;
    
    
    public Platform[] platforms;
    public PlatformBroke[] platformsBroke;
    public PlatformSpike[] platformsSpike;
    public PlatformUn[] platformsUn;
    public PlatformBomb[] platformsBomb;
    public JettPosition[] JettPosition;

    public int x = 100, y = 100, h = 150, sc1 = 0,health = 100, st=0, sc2=0, high=0, check=0;
    public float dy = (int) (Math.random());
    public boolean right, left;
    
    class Platform { //ปกติ

        int x, y;
    }

    class PlatformBroke { //แตก

        int x, y;
    }

    class PlatformSpike { //หนาม

        int x, y;
    }

    class PlatformUn { //ไม่โดด

        int x, y;
    }

    class PlatformBomb { //ระเบิด

        int x, y;
    }

    class JettPosition {

        int x, y;
    }

    public static display getDis() {
        return dis;
    }

    public static void setDis(display dis) {
        SquidJump.dis = dis;
    }

    public SoundPlay1 getSound1() {
        return sound1;
    }

    public void setSound1(SoundPlay1 sound1) {
        this.sound1 = sound1;
    }

    public SoundPlay2 getSound2() {
        return sound2;
    }

    public void setSound2(SoundPlay2 sound2) {
        this.sound2 = sound2;
    }

    public SoundPlay2 getSound3() {
        return sound3;
    }

    public void setSound3(SoundPlay2 sound3) {
        this.sound3 = sound3;
    }

    public SoundPlay2 getSound4() {
        return sound4;
    }

    public void setSound4(SoundPlay2 sound4) {
        this.sound4 = sound4;
    }

    public SoundPlay1 getSound5() {
        return sound5;
    }

    public void setSound5(SoundPlay1 sound5) {
        this.sound5 = sound5;
    }

    public boolean isIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
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

    public BufferedImage getScoretest() {
        return scoretest;
    }

    public void setScoretest(BufferedImage scoretest) {
        this.scoretest = scoretest;
    }

    public BufferedImage getHtet1() {
        return htet1;
    }

    public void setHtet1(BufferedImage htet1) {
        this.htet1 = htet1;
    }

    public BufferedImage getHtet2() {
        return htet2;
    }

    public void setHtet2(BufferedImage htet2) {
        this.htet2 = htet2;
    }

    public BufferedImage getHtet3() {
        return htet3;
    }

    public void setHtet3(BufferedImage htet3) {
        this.htet3 = htet3;
    }

    public BufferedImage getHtet4() {
        return htet4;
    }

    public void setHtet4(BufferedImage htet4) {
        this.htet4 = htet4;
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

    public Platform[] getPlatforms() {
        return platforms;
    }

    public void setPlatforms(Platform[] platforms) {
        this.platforms = platforms;
    }

    public PlatformBroke[] getPlatformsBroke() {
        return platformsBroke;
    }

    public void setPlatformsBroke(PlatformBroke[] platformsBroke) {
        this.platformsBroke = platformsBroke;
    }

    public PlatformSpike[] getPlatformsSpike() {
        return platformsSpike;
    }

    public void setPlatformsSpike(PlatformSpike[] platformsSpike) {
        this.platformsSpike = platformsSpike;
    }

    public PlatformUn[] getPlatformsUn() {
        return platformsUn;
    }

    public void setPlatformsUn(PlatformUn[] platformsUn) {
        this.platformsUn = platformsUn;
    }

    public PlatformBomb[] getPlatformsBomb() {
        return platformsBomb;
    }

    public void setPlatformsBomb(PlatformBomb[] platformsBomb) {
        this.platformsBomb = platformsBomb;
    }

    public JettPosition[] getJettPosition() {
        return JettPosition;
    }

    public void setJettPosition(JettPosition[] JettPosition) {
        this.JettPosition = JettPosition;
    }

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

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getSc1() {
        return sc1;
    }

    public void setSc1(int sc1) {
        this.sc1 = sc1;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSt() {
        return st;
    }

    public void setSt(int st) {
        this.st = st;
    }

    public int getSc2() {
        return sc2;
    }

    public void setSc2(int sc2) {
        this.sc2 = sc2;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public float getDy() {
        return dy;
    }

    public void setDy(float dy) {
        this.dy = dy;
    }

    public boolean getRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean getLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }
}
