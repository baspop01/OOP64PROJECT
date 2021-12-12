import javax.swing.*;
import java.awt.*;
public class DocumentDetailView {
    private JFrame fr;
    private JLabel lb1, lb2, lb3, lb4, lb5, lb6;
    private JPanel pn1, pn2, pn3;
    
    public DocumentDetailView(){
        fr = new JFrame("DocumentDetail");
        pn1 = new JPanel();
        pn2 = new JPanel();
        pn3 = new JPanel();
        
        lb1 = new JLabel("Title : ");
        lb2 = new JLabel("Type : ");
        lb3 = new JLabel("Detail : ");
        lb4 = new JLabel("");
        lb5 = new JLabel("");
        lb6 = new JLabel("");
        
        pn1.add(lb1);
        pn1.add(lb4);
        pn2.add(lb2);
        pn2.add(lb5);
        pn3.add(lb3);
        pn3.add(lb6);
        
        fr.add(pn1, BorderLayout.NORTH);
        fr.add(pn2, BorderLayout.CENTER);
        fr.add(pn3, BorderLayout.SOUTH);
        
        fr.pack();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
    }

    public JFrame getFr() {
        return fr;
    }

    public void setFr(JFrame fr) {
        this.fr = fr;
    }

    public JLabel getLb1() {
        return lb1;
    }

    public void setLb1(JLabel lb1) {
        this.lb1 = lb1;
    }

    public JLabel getLb2() {
        return lb2;
    }

    public void setLb2(JLabel lb2) {
        this.lb2 = lb2;
    }

    public JLabel getLb3() {
        return lb3;
    }

    public void setLb3(JLabel lb3) {
        this.lb3 = lb3;
    }

    public JLabel getLb4() {
        return lb4;
    }

    public void setLb4(JLabel lb4) {
        this.lb4 = lb4;
    }

    public JLabel getLb5() {
        return lb5;
    }

    public void setLb5(JLabel lb5) {
        this.lb5 = lb5;
    }

    public JLabel getLb6() {
        return lb6;
    }

    public void setLb6(JLabel lb6) {
        this.lb6 = lb6;
    }

    public JPanel getPn1() {
        return pn1;
    }

    public void setPn1(JPanel pn1) {
        this.pn1 = pn1;
    }

    public JPanel getPn2() {
        return pn2;
    }

    public void setPn2(JPanel pn2) {
        this.pn2 = pn2;
    }

    public JPanel getPn3() {
        return pn3;
    }

    public void setPn3(JPanel pn3) {
        this.pn3 = pn3;
    }
    
    public static void main(String[] args) {
        new DocumentDetailView ();
    }
}
