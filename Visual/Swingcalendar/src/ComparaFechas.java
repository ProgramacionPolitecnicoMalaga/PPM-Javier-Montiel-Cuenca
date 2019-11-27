import com.github.lgooddatepicker.components.CalendarPanel;
import com.github.lgooddatepicker.components.TimePicker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;

import static java.util.concurrent.TimeUnit.DAYS;
public class ComparaFechas {
    private JPanel panelMain;
    private JLabel lblfecha1;
    private JLabel lblfecha2;
    private JButton butcalcular;
    private CalendarPanel calendar2;
    private CalendarPanel calendar1;
    private JPanel panelfecha1;
    private JPanel panelfecha2;
    private JTextField txtaños;
    private JTextField txtmeses;
    private JTextField txtdias;
    private JLabel lbldiferencias;
    private JLabel lblaños;
    private JLabel lblmeses;
    private JLabel lbldias;
    private JPanel panelCalendar;
    private JTextField txthoras;
    private JTextField txtminutos;
    private JTextField txtsegundos;
    private JLabel lblsegundo;
    private LocalDate fecha1;
    private LocalDate fecha2;
        public double[] calcularCambiofechas(LocalDate fecha1,LocalDate fecha2){
            double[]fechas=new double[6];
            fechas[0]= DAYS.toChronoUnit().between(fecha1,fecha2)/(double)(365);
            System.out.println(fechas[0]);
            fechas[1]=DAYS.toChronoUnit().between(fecha1,fecha2)/(double)(30);
            System.out.println(fechas[1]);
            fechas[2]= (double)(DAYS.toChronoUnit().between(fecha1,fecha2));
            System.out.println(fechas[2]);
            fechas[3]= DAYS.toChronoUnit().between(fecha1,fecha2)*(double)(24);
            System.out.println(fechas[3]);
            fechas[4]=DAYS.toChronoUnit().between(fecha1,fecha2)*(double)(1440);
            System.out.println(fechas[4]);
            fechas[5]=DAYS.toChronoUnit().between(fecha1,fecha2)*(double)(86400);
            System.out.println(fechas[5]);
            return fechas;
        }

        public void rellenardiferencia(double[]fechas){
            txtaños.setText(String.valueOf(Math.abs(fechas[0])));
            txtmeses.setText(String.valueOf(Math.abs(fechas[1])));
            txtdias.setText(String.valueOf(Math.abs(fechas[2])));
            txthoras.setText(String.valueOf(Math.abs(fechas[3])));
            txtminutos.setText(String.valueOf(Math.abs(fechas[4])));
            txtsegundos.setText(String.valueOf(Math.abs(fechas[5])));

        }

    public ComparaFechas() {


        butcalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fecha1=calendar1.getSelectedDate();
                fecha2=calendar2.getSelectedDate();
                rellenardiferencia(calcularCambiofechas(fecha1,fecha2));
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Compara Fechas");
        frame.setContentPane(new ComparaFechas().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

