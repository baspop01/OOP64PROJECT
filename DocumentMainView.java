import javax.swing.*;
import java.awt.*;
public class DocumentMainView {
    private JFrame fr;
    private JLabel lb1, lb2, lb3;
    private JTextField tf1, tf2, tf3;
    private JButton bnPrevious, bnNext, bnAdd, bnUpdate, bnDelete;
    private JPanel pn1, pn2, pn3,pn4,pn5,pn6,pn7;
    private JComboBox cb;
    
    public DocumentMainView(){
        fr = new JFrame("Document");
        pn1 = new JPanel(new GridLayout(4,0));
        pn2 = new JPanel();
        pn4 = new JPanel();
        pn5 = new JPanel();
        pn6 = new JPanel();
        pn7 = new JPanel();
        pn3 = new JPanel();
        lb1 = new JLabel("Title");
        lb2 = new JLabel("Type");
        lb3 = new JLabel("Detail");
        tf1 = new JTextField(10);
        tf2 = new JTextField(20);
        tf3 = new JTextField("0", 4);
        bnPrevious = new JButton("Previous");
        bnNext = new JButton("Next");
        bnAdd = new JButton("Add");
        bnUpdate = new JButton("Update");
        bnDelete = new JButton("Delete");
        cb = new JComboBox();
        
        cb.addItem("Normal");
        cb.addItem("Formal");
        cb.addItem("Informal");
        cb.addItem("etc");
        
        pn2.add(lb1, BorderLayout.NORTH);
        pn2.add(tf1, BorderLayout.NORTH);
        
        pn3.add(lb2, BorderLayout.NORTH);
        pn3.add(cb, BorderLayout.CENTER);
        
        pn4.add(lb3);
        pn5.add(tf2);
        
        
        pn1.add(pn2);
        pn1.add(pn3);
        pn1.add(pn4);
        pn1.add(pn5);
        pn6.add(bnPrevious);
        pn6.add(tf3);
        pn6.add(bnNext);
        
        pn7.add(bnAdd);
        pn7.add(bnUpdate);
        pn7.add(bnDelete);
                     
        fr.add(pn1, BorderLayout.NORTH);
        fr.add(pn6, BorderLayout.CENTER);
        fr.add(pn7, BorderLayout.SOUTH);
        
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

    public JTextField getTf1() {
        return tf1;
    }

    public void setTf1(JTextField tf1) {
        this.tf1 = tf1;
    }

    public JTextField getTf2() {
        return tf2;
    }

    public void setTf2(JTextField tf2) {
        this.tf2 = tf2;
    }

    public JTextField getTf3() {
        return tf3;
    }

    public void setTf3(JTextField tf3) {
        this.tf3 = tf3;
    }

    public JButton getBnPrevious() {
        return bnPrevious;
    }

    public void setBnPrevious(JButton bnPrevious) {
        this.bnPrevious = bnPrevious;
    }

    public JButton getBnNext() {
        return bnNext;
    }

    public void setBnNext(JButton bnNext) {
        this.bnNext = bnNext;
    }

    public JButton getBnAdd() {
        return bnAdd;
    }

    public void setBnAdd(JButton bnAdd) {
        this.bnAdd = bnAdd;
    }

    public JButton getBnUpdate() {
        return bnUpdate;
    }

    public void setBnUpdate(JButton bnUpdate) {
        this.bnUpdate = bnUpdate;
    }

    public JButton getBnDelete() {
        return bnDelete;
    }

    public void setBnDelete(JButton bnDelete) {
        this.bnDelete = bnDelete;
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

    public JPanel getPn4() {
        return pn4;
    }

    public void setPn4(JPanel pn4) {
        this.pn4 = pn4;
    }

    public JPanel getPn5() {
        return pn5;
    }

    public void setPn5(JPanel pn5) {
        this.pn5 = pn5;
    }

    public JPanel getPn6() {
        return pn6;
    }

    public void setPn6(JPanel pn6) {
        this.pn6 = pn6;
    }

    public JPanel getPn7() {
        return pn7;
    }

    public void setPn7(JPanel pn7) {
        this.pn7 = pn7;
    }

    public JComboBox getCb() {
        return cb;
    }

    public void setCb(JComboBox cb) {
        this.cb = cb;
    }
    
    public static void main(String[] args) {
        new DocumentMainView ();
    }
}
