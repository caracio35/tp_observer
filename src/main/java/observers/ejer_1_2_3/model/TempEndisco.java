package observers.ejer_1_2_3.model;

import java.nio.file.Files;
import java.nio.file.Path;

import java.nio.file.StandardOpenOption;

public class TempEndisco implements Observador {
    private String path = "/home/jose/Escritorio/tp_observer/TempDeBahia.txt";

    @Override
    public void actualizar(String temperatura) {
        try {
            if (Files.notExists(Path.of(path))) {
                Files.writeString(Path.of(path), temperatura + "\n", StandardOpenOption.CREATE);

            } else {
                Files.writeString(Path.of(path), temperatura + "\n", StandardOpenOption.APPEND);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
