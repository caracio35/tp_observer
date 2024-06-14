package observers.ejer_4.modelo;

import java.util.List;

public abstract class Observador {
    private List<Observer> observadores;

    public Observador(List<Observer> observadores) {
        this.observadores = observadores;
    }

    protected void notificar(String dato) {
        for (Observer o : observadores) {
            o.notificar(dato);
        }
    }
}
