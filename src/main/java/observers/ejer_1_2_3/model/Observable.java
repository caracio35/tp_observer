package observers.ejer_1_2_3.model;

import java.util.List;

public abstract class Observable {
    private List<Observador> observadores;

    public Observable(List<Observador> observadores) {
        this.observadores = observadores;
    }

    protected void notificar(String valor) {
        for (Observador observador : observadores) {
            observador.actualizar(valor);
        }
    }
}