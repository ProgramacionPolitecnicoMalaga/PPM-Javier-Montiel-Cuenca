package ParseCSV;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ParseCSV {
    private JTextField txtbusqueda;
    private JButton butbuscar;
    private JTextArea areabusqueda;
    private JPanel panelMain;
    private JLabel lblbusqueda;
    private JButton butborrarLista;
    private JScrollPane scrollbusqueda;
    private String separadorCSV=";";
    private BufferedReader br;
    private String lineacsv;
    private String[] lineasplit;
    String busqueda;
    public ParseCSV() {
        butbuscar.setEnabled(false);
        butborrarLista.setEnabled(false);
        butbuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                busqueda=txtbusqueda.getText();
                areabusqueda.setText("");
                try{
                    br=new BufferedReader(new FileReader("productos.csv"));
                    lineacsv=br.readLine();
                    while(lineacsv!=null){
                        lineasplit=lineacsv.split(separadorCSV);
                        if (lineacsv.toLowerCase().contains(busqueda.toLowerCase())){
                            areabusqueda.append(lineasplit[1]+", Precio: "+lineasplit[4]);
                            areabusqueda.append(System.getProperty("line.separator"));
                        }
                        lineacsv=br.readLine();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                txtbusqueda.setText("");
                butbuscar.setEnabled(false);
                txtbusqueda.grabFocus();
                butborrarLista.setEnabled(true);
            }
        });
        txtbusqueda.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(txtbusqueda.getText().trim().equalsIgnoreCase("")){
                    butbuscar.setEnabled(false);
                }else{
                    butbuscar.setEnabled(true);
                }
            }
        });
        butborrarLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                areabusqueda.setText("");
                butborrarLista.setEnabled(false);
            }
        });
        txtbusqueda.addKeyListener(new KeyAdapter() {
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lista Productos");
        frame.setContentPane(new ParseCSV().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500,300));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
