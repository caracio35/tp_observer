package observers.ejer_4.modelo;

import java.util.ArrayList;

public interface ListaParticipantes {

    public abstract void addParticipante(observers.ejer_4.modelo.Participante p);

    public abstract Participante recuperarParticipante(Participante p);

    public abstract ArrayList<Participante> getParticipantes();
}
