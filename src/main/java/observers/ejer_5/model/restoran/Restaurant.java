package observers.ejer_5.model.restoran;

import java.util.List;

import jakarta.mail.FetchProfile.Item;
import observers.ejer_5.model.observers.ObservadoresRestaurant;
import observers.ejer_5.model.observers.Observer;
import observers.ejer_5.model.tarjetas.Tarjeta;

public class Restaurant extends ObservadoresRestaurant {
    private List<Mesa> mesas;

    public Restaurant(List<Observer> observadores) {
        super(observadores);
        mesas = List.of(new Mesa(1), new Mesa(2), new Mesa(
                3), new Mesa(4), new Mesa(5));
    }

    public void agregarItem(ItemMenu item, int mesa) {
        mesas.get(mesa).agregarItem(item);

    }

    public void pagar(Tarjeta tarjeta, double Propina, int mesa) {
        double montoPagado = mesas.get(mesa).pagarMontoTotal(tarjeta, Propina);
        super.notificar(montoPagado);
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

}
