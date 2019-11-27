import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;

public class SacarCapitalesdePaises {
    private JComboBox comboBox1;
    private JPanel panelMain;
    private JComboBox comboBox2;
    private JLabel lblcapital;
    private TreeMap<String,String> capitaldepaises=new TreeMap<String, String>();

    public TreeMap leeryguardarxml(String continente){
        try{
            capitaldepaises.clear();
            String dir = System.getProperty("user.dir");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            File file=new File(dir+File.separator+"src"+ File.separator+"Paises.xml");
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile("/archivo/"+continente+"/pais/nombre/text()");
            XPathExpression expr2 = xpath.compile("/archivo/"+continente+"/pais/capital/text()");
            NodeList busqueda1=(NodeList) expr.evaluate(document, XPathConstants.NODESET);
            NodeList busqueda2=(NodeList) expr2.evaluate(document, XPathConstants.NODESET);
            for(int f=0;f<busqueda1.getLength();f++){
                capitaldepaises.put(busqueda1.item(f).getTextContent(),busqueda2.item(f).getTextContent());
                //System.out.println(busqueda1.item(f).getTextContent());
                //System.out.println(busqueda1.getLength());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return capitaldepaises;
    }
    public void rellenarcombobox(TreeMap<String,String> paises){
        comboBox2.removeAllItems();
        for(String pais:paises.keySet()){
            comboBox2.addItem(pais);
        }
        comboBox2.setEnabled(true);
    }


    public SacarCapitalesdePaises() {
        comboBox2.setEnabled(false);
        comboBox1.addItem("Africa");
        comboBox1.addItem("Asia");
        comboBox1.addItem("America");
        comboBox1.addItem("Europa");
        comboBox1.addItem("Oceania");
        comboBox1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String continente=comboBox1.getSelectedItem().toString();
                rellenarcombobox(leeryguardarxml(continente));
            }
        });
        comboBox2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String pais=comboBox2.getSelectedItem().toString();
                String capital=capitaldepaises.get(pais);
                lblcapital.setText("Capital de "+pais+": "+capital);

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Capitales de Paises");
        frame.setContentPane(new SacarCapitalesdePaises().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600,600));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
