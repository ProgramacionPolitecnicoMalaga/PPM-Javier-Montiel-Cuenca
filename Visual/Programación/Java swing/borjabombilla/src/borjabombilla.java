import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class borjabombilla {
    private JPanel panelMain;
    private JPanel panelbombillaapagada;
    private JPanel panelbombillaencendido;
    private JButton butapagar;
    private JButton Butencender;
    private JPanel Panelbotones;
    private JLabel lblbombillaencendido;
    private JLabel lblbombillaapagada;
    File fichero;
    /*private File ficherobombillaapagado;
    private File ficherobombillaencendido;
    String rutabombillaapagado;
    String rutabombillaencendido;*/

    public String rutabombilla(String nombreimagen){
        fichero=new File(nombreimagen);
        String ruta=fichero.getAbsolutePath();
        return ruta;
    }
    public borjabombilla() {
        panelbombillaencendido.setVisible(false);
        butapagar.setEnabled(false);
        /*ficherobombillaapagado=new File("bombillaApagada.jpg");
        rutabombillaapagado=ficherobombillaapagado.getAbsolutePath();
        ficherobombillaencendido=new File("bombillaEncendida.jpg");
        rutabombillaencendido=ficherobombillaencendido.getAbsolutePath();*/

        lblbombillaapagada.setIcon(new ImageIcon(rutabombilla("bombillaApagada.jpg")));
        lblbombillaencendido.setIcon(new ImageIcon(rutabombilla("bombillaEncendida.jpg")));
        butapagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                panelbombillaapagada.setVisible(true);
                panelbombillaencendido.setVisible(false);
                butapagar.setEnabled(false);
                Butencender.setEnabled(true);
            }
        });
        Butencender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                panelbombillaapagada.setVisible(false);
                panelbombillaencendido.setVisible(true);
                butapagar.setEnabled(true);
                Butencender.setEnabled(false);
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("borjabombilla");
        frame.setContentPane(new borjabombilla().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
