package observers.ejer_1_2_3.main;

import java.util.List;

import observers.ejer_1_2_3.Clima.WhatherChanelService;
import observers.ejer_1_2_3.model.MedidorTemp;
import observers.ejer_1_2_3.model.Notificador;
import observers.ejer_1_2_3.model.NotificarPorConsola;
import observers.ejer_1_2_3.model.TempEndisco;

public class Main {
    public static void main(String[] args) {
        var medidorTemp = new Notificador(new MedidorTemp(new WhatherChanelService()),
                List.of(new TempEndisco(), new NotificarPorConsola()));
        System.out.println("Temperatura: " + medidorTemp.leerTemp());
    }

}
