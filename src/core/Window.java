/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import javax.swing.JFrame;

/**
 *
 * @author ins
 */
public class Window extends JFrame{
    public static double winWidth = 500;
    public static double winHeight = 600;
    
    public static String winName;

    public static double getwinWidth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Window(String winName, double winWidth, double winHeight){
        super(winName);
        
        Window.winHeight = winHeight;
        Window.winWidth = winWidth;
        Window.winName = winName;
        
        setWindowAttributes();
        
    }
    
    public void packWindow(){
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    public void setWindowAttributes(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static double getWinWidth() {
        return winWidth;
    }

    public static double getWinHeight() {
        return winHeight;
    }
    
    public static String getwinName() {
        return winName;
    }
}
