package observers.ejer_1_2_3.model;

import java.util.List;

public class Notificador extends Observable implements VerClima {
    private MedidorTemp medidorTemp;

    public Notificador(MedidorTemp medidorTemp, List<Observador> observadores) {
        super(observadores);
        this.medidorTemp = medidorTemp;
    }

    public String leerTemp() {
        String temperatura = medidorTemp.leerTemp();
        notificar(temperatura);
        return temperatura;
    }

}
