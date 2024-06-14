package observers.ejer_5.model.restoran;

public class Bebida implements ItemMenu {
    private String nomeBebida;
    private double precoUnitario;

    public Bebida(String n, double p) {
        this.nomeBebida = n;
        this.precoUnitario = p;
    }

    public String getNombre() {
        return this.nomeBebida;
    }

    public String getDescripccion() {
        return this.nomeBebida;
    }

    public double calcularPrecio() {
        return precoUnitario;
    }

    @Override
    public double calcularPrecioBebida() {
        return this.precoUnitario;
    }

    public double calcularPrecioPlato() {
        return 0;
    }
}
