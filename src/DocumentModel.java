import java.io.*;
import java.util.ArrayList;
public class DocumentModel {
    private ArrayList<Documen> documen =  new ArrayList<Documen>();
    
    public void load(){
        File f = new File("Documen.data");
        if(f.exists()){
            try(FileInputStream fin = new FileInputStream(f);
            ObjectInputStream in = new ObjectInputStream(fin);){
                documen = (ArrayList<Documen>)in.readObject();
            }catch(Exception i){
                System.out.println(i);
            }
        }
    }
    public void save(){
        File f = new File("Documen.data");
        try(FileOutputStream fOut = new FileOutputStream(f);
        ObjectOutputStream oout = new ObjectOutputStream(fOut);){
            oout.writeObject(documen);
        }catch(Exception i){
            System.out.println(i);
        }
    }

    public ArrayList<Documen> getDocumen() {
        return documen;
    }

    public void setDocumen(ArrayList<Documen> documen) {
        this.documen = documen;
    }
    
}
