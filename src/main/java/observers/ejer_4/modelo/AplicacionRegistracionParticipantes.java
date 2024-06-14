package observers.ejer_4.modelo;

public class AplicacionRegistracionParticipantes {
    private ListaParticipantes participantes;

    public AplicacionRegistracionParticipantes(ListaParticipantes participantes) {
        this.participantes = participantes;
    }

    public void agregarParticipantes(String nombre, String telefono, String region, String email) {
        try {
            Participante p = new Participante(nombre, telefono, region, email);
            participantes.addParticipante(p);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

}