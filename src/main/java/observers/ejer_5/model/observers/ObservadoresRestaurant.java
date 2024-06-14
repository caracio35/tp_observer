package observers.ejer_5.model.observers;

import java.util.List;

public abstract class ObservadoresRestaurant {
    private List<Observer> observadores;

    public ObservadoresRestaurant(List<Observer> observadores) {
        this.observadores = observadores;
    }

    public void notificar(Object mensaje) {
        for (Observer o : observadores) {
            o.notificar(mensaje);
        }
    }
}
