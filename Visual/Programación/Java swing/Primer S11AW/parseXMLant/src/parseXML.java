import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class parseXML {
    private JPanel panelMain;
    private JTextArea txtpalabra;
    private JTextField textField1;
    private JButton butcomprobar;
    private JButton butreiniciar;
    private JLabel Resultado;
    private int f;
    private String palabra;
    private String[] palabras;


    public parseXML() {
        butcomprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                palabra=butcomprobar.getText();
                Resultado.setText(palabras[f]);
                if(palabras[f].compareToIgnoreCase(palabra)==0){
                    Resultado.setText("Has acertado");
                }else{
                    Resultado.setText("Has fallado");
                }
            }
        });
        butreiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f=(int)(Math.random()*55092+1);

                JFrame frame = new JFrame("XML palabras");
                frame.setSize(550, 300);
                //frame.pack();
                palabras = getXML();
                txtpalabra.setText(palabras[f]);
            }
        });
    }

    /*https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm*/
    private static String[] getXML() {
        String[] palabrasXML = new String[0];
        try {
            final String dir = System.getProperty("user.dir");
            File inputFile = new File(dir + "/src/" + "PALABRAS.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Elemento raíz :" + doc.getDocumentElement().getNodeName());
            NodeList nodos = doc.getElementsByTagName("ROW");
            System.out.println(nodos.getLength());
            palabrasXML = new String[nodos.getLength()];
            for (int i = 0; i < nodos.getLength(); i++) {
                Node nodo = nodos.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element palabra = (Element) nodo;
                    palabrasXML[i]=palabra.getAttribute("PALABRA");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return palabrasXML;
    }

    public static void main(String[] args) {
        String[] palabras;
        JFrame frame = new JFrame("XML palabras");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new parseXML().panelMain);
        frame.setSize(550, 300);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        palabras = getXML();
    }
}
