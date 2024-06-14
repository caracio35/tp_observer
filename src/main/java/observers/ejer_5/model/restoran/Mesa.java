package observers.ejer_5.model.restoran;

import java.util.ArrayList;
import java.util.List;

import observers.ejer_5.model.tarjetas.Tarjeta;

public class Mesa {

    private int numMesa;
    private ArrayList<ItemMenu> platosYBebidas;// Crear um array de 30 posicioes para los produtos de la mesa
    @SuppressWarnings("unused")
    private Tarjeta tarjeta;
    @SuppressWarnings("unused")
    private Double monto;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Mesa(int numMesa) {
        this.numMesa = numMesa;
        platosYBebidas = new ArrayList(30);
        monto = 0.0;

    }

    public void agregarItem(ItemMenu item) {
        platosYBebidas.add(item);
    }

    public List<ItemMenu> getPlatosYBebidas() {
        return platosYBebidas;
    }

    public double pagarMontoTotal(Tarjeta t, double Propina) {

        double totalBebidas = calcularPrecioTotalBebidas();
        double totalPlatos = calcularPrecioTotalPlatos();
        // pagarPropina(totalPlatos, totalBebidas,Propina);
        double montoPagado = t.cobrar(totalBebidas, totalPlatos);
        return montoPagado;

    }

    public double calcularPrecioTotalBebidas() {
        double precioTotal = 0;
        for (ItemMenu bebida : platosYBebidas) {
            precioTotal += bebida.calcularPrecioBebida();
        }
        return precioTotal;
    }

    public double calcularPrecioTotalPlatos() {
        double precio = 0;
        for (ItemMenu p : platosYBebidas) {
            precio += p.calcularPrecioPlato();
        }
        return precio;
    }

    public double pagarPropina(Tarjeta t, double Propina) {

        double porsentajePropina = Propina / 100;
        double tBebidas = calcularPrecioTotalBebidas();
        double tPlatos = calcularPrecioTotalPlatos();
        tBebidas = tBebidas * porsentajePropina;
        tPlatos = tPlatos * porsentajePropina;
        return t.cobrar(tBebidas, tPlatos);
    }

    public Object getNumero() {
        return numMesa;
    }

}
