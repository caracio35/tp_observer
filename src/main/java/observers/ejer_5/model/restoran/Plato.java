package observers.ejer_5.model.restoran;

public class Plato implements ItemMenu {
    private String nombre;
    private String descripccion;
    private Double precioUnitario;

    public Plato(String nombre, String descrpcion, Double precio) {
        this.nombre = nombre;
        this.descripccion = descrpcion;
        this.precioUnitario = precio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripccion() {
        return this.descripccion;
    }

    public double calcularPrecio() {
        return precioUnitario;
    }

    @Override
    public double calcularPrecioBebida() {
        return 0;
    }

    @Override
    public double calcularPrecioPlato() {
        return this.precioUnitario;
    }
}
