
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Jframe extends JFrame {


    public Jframe() {
        JFrame window = new JFrame("Doodle Jump");
        window.setSize(400, 533);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        window.setLayout(new BorderLayout());
        window.add(new DoodleJump(), BorderLayout.CENTER);

        window.setVisible(true);
    }
}
