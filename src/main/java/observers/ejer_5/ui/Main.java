package observers.ejer_5.ui;

import java.util.List;

import observers.ejer_5.model.observers.Observer;
import observers.ejer_5.model.restoran.Restaurant;

public class Main {
    public static void main(String[] args) {
        List<Observer> observadores = List.of(new GerenteGral()); // Agrega los observadores necesarios
        Restaurant restoran = new Restaurant(observadores);
        new RestoranUI(restoran);
    }
}
