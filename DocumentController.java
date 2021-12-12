import java.awt.event.*;
import javax.swing.JOptionPane;
public class DocumentController implements ActionListener, WindowListener{
    private DocumentMainView view;
    private DocumentModel model;
    private DocumentDetailView add;
    
    public DocumentController(){
     view = new DocumentMainView();
     model = new DocumentModel();
     add = new DocumentDetailView();
     
     view.getBnPrevious().addActionListener(this);
     view.getBnNext().addActionListener(this);
     view.getBnAdd().addActionListener(this);
     view.getBnUpdate().addActionListener(this);
     view.getBnDelete().addActionListener(this);
     view.getFr().addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(view.getBnAdd())){
            add.getFr().setVisible(true);
        }else if(ae.getSource().equals(view.getBnPrevious())){
            if(Integer.parseInt(view.getTf3().getText()) - 2 >= 0){
                int pso = Integer.parseInt(view.getTf3().getText()) - 2;
                view.getTf1().setText(model.getDocumen().get(pso).getTitle());
                view.getTf2().setText(model.getDocumen().get(pso).getDetail());
                view.getCb().setSelectedItem(model.getDocumen().get(pso).getType());
                view.getTf3().setText((pso + 1)+ "");
            }
        }
        else if(ae.getSource().equals(view.getBnNext())){
            if(Integer.parseInt(view.getTf3().getText()) < model.getDocumen().size()){
                int pso = Integer.parseInt(view.getTf3().getText());
                view.getTf1().setText(model.getDocumen().get(pso).getTitle());
                view.getTf2().setText(model.getDocumen().get(pso).getDetail());
                view.getCb().setSelectedItem(model.getDocumen().get(pso).getType());
                view.getTf3().setText((pso + 1)+ "");
            }
        }
        else if(ae.getSource().equals(view.getBnUpdate())){
            model.getDocumen().set(Integer.parseInt)
        }
    }

    @Override
    public void windowOpened(WindowEvent we) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
        model.save();
    }

    @Override
    public void windowClosed(WindowEvent we) {
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }
    
}
