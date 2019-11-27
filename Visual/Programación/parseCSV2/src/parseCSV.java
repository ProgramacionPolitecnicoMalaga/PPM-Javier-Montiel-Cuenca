import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class parseCSV {
    private JPanel panelMain;
    private JTextField txtBuscar;
    private JButton butBuscar;
    private JTextArea txtProductos;
    public static final int n = 77;
    static int[] idProducto = new int[n];
    static String[] nombre = new String[n];
    static String[] categoria = new String[n];
    static String[]productos=new String[n];
    static float[]precio=new float[n];
    static String idnom[]=new String[n];


    public parseCSV() {
        butBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = txtBuscar.getText();
                String result = "";
                /*for (int i = 0; i < n; i++) {
                    System.out.println(idProducto[i] + " " + nombre[i] + " " + categoria[i]);
                }*/
                if (str != null && !str.isEmpty()) {
                    for (String idnon : idnom) {
                        if (idnon.toLowerCase().contains(str.toLowerCase())) {
                            result += idnon+"\n";
                        }
                    }
                    if (result.isEmpty()) {
                        result = "No encontrado!!!";
                    }
                    txtProductos.setText(result);
                }
            }
        });
    }

    public static void main(String[] args) {
        int k = 0;
        String csvFile = "productos.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        JFrame frame = new JFrame("parse CSV");
        frame.setContentPane(new parseCSV().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] linea = line.split(cvsSplitBy);
                // Chequo por consola de la lectura del fichero...
                // String[] producto = new String[] {linea[0], linea[1], linea[2], linea[3], linea[4]};
                //System.out.println(Arrays.toString(producto));
                idProducto[k] = Integer.parseInt(linea[0]);
                nombre[k] = linea[1];
                categoria[k] = linea[2];
                productos[k]= linea[3];
                idnom[k]=idProducto[k]+nombre[k];
                k++;

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
