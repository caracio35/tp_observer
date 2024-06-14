package observers.ejer_4.main;

import java.util.List;

import observers.ejer_4.UI.AgregarParticipantesUI;
import observers.ejer_4.mail.EnvioDeMailConcursantes;
import observers.ejer_4.modelo.AplicacionRegistracionParticipantes;
import observers.ejer_4.persistencia.ParticipanteBd;

public class Main {
    public static void main(String[] args) {
        launchApplication();
    }

    private static void launchApplication() {
        try {
            ParticipanteBd aplicacionBd = new ParticipanteBd(List.of(new EnvioDeMailConcursantes())); // Declare and
                                                                                                      // initialize the
                                                                                                      // variable
            AplicacionRegistracionParticipantes AplicacionRegistracionParticipantes = new AplicacionRegistracionParticipantes(
                    aplicacionBd);
            AgregarParticipantesUI UIpar = new AgregarParticipantesUI(AplicacionRegistracionParticipantes);
            UIpar.setupUIComponents();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
