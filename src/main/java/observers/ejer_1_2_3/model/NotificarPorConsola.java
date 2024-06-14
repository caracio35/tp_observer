package observers.ejer_1_2_3.model;

public class NotificarPorConsola implements Observador {

    @Override
    public void actualizar(String temperatura) {
        String[] tempPart1 = temperatura.split(" ");
        String[] tempPart2 = tempPart1[0].split(",");
        String numeroString = tempPart2[0];
        float tem = Float.parseFloat(numeroString);
        if (tem >= 17) {
            System.out.println("hace calor , se encendera el haire acondicionado");
        }
        if (tem <= 12) {
            System.out.println("hace frio encender la calefaccion");

        }

    }

}