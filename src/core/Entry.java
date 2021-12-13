
package core;

import java.io.IOException;
import objects.Background;
import objects.Spaceship;
import render.Renderer;
import update.Updater;

public class Entry {
    public static void main(String[] args) throws IOException {
        Window window = new Window("SCGFG", Window.getWinWidth(), Window.getWinHeight());
        Renderer renderer = new Renderer();
        Updater updater = new Updater();
        
        
        window.addKeyListener(new Input());
        window.add(renderer);
        window.packWindow();
        window.setVisible(true);
        
        boolean runGame = true;
        
        new Spaceship((Window.getWinWidth() /2) -(Spaceship.width / 2), Window.getWinHeight() - 150);
        new Background(-Window.getWinHeight());
        
        while(runGame){
            renderer.repaint();
            updater.update();
            
            if(Input.keys[Input.DOWN]){
                System.out.println("DOWN");
            }
            else if(Input.keys[Input.UP]){
                System.out.println("UP");
            }
            else if(Input.keys[Input.LEFT]){
                System.out.println("LEFT");
            }
            else if(Input.keys[Input.RIGHT]){
                System.out.println("RIGHT");
            }
            else if(Input.keys[Input.SPACE]){
                System.out.println("SHOOT");
            }
            
            FPS.calcDeltaTime();
        }
    }
}
