/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package update;

import java.util.ArrayList;

/**
 *
 * @author ins
 */
public class Updater {
    private static ArrayList<Updateable> updateableObjects = new ArrayList<Updateable>();
    private static ArrayList<Updateable> addUpdateableObjects = new ArrayList<Updateable>();
    private static ArrayList<Updateable> removeUpdateableObjects = new ArrayList<Updateable>();
    
    public static void update(){
        for(Updateable object: updateableObjects){
            object.update();
        }
        
        updateableObjects.removeAll(removeUpdateableObjects);
        updateableObjects.addAll(addUpdateableObjects);
        
        addUpdateableObjects.clear();
        removeUpdateableObjects.clear();
    }
    
    public static void addUpdateableObjects(Updateable object){
        addUpdateableObjects.add(object);
    }
    
    public static void removeUpdateableObjects(Updateable object){
        removeUpdateableObjects.add(object);
    }
}
