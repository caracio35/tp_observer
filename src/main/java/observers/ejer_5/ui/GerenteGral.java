package observers.ejer_5.ui;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.*;

import observers.ejer_5.model.observers.Observer;;

public class GerenteGral implements Observer {
    private Label label;

    public GerenteGral() {
        JFrame ventana = new JFrame("Gerente");

        ventana.getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        label = new Label("");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        ventana.add(label);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300, 150);
        ventana.setVisible(true);

    }

    @Override
    public void notificar(Object mensaje) {
        double monto = (Double) mensaje;
        if (monto > 30000) {
            label.setText(String.valueOf(monto));
            label.setForeground(Color.RED);
        } else {
            label.setText(String.valueOf(monto));
            label.setForeground(Color.BLUE);
        }
    }
}