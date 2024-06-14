package observers.ejer_1_2_3.model;

public class MedidorTemp implements VerClima {

    private String temperatura;
    private ClimaOnline clima;

    public MedidorTemp(ClimaOnline clima) {
        this.clima = clima;
    }

    public String leerTemp() {
        this.temperatura = clima.temperatura();
        return this.temperatura;
    }

}
