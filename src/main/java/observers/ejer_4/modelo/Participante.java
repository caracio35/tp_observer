package observers.ejer_4.modelo;

public class Participante {

    private String nombre;
    private String numTelefono;
    private String region;
    private String email;

    public Participante(String nombre, String numTelefono, String region, String email) {

        if (validarDatos(nombre, numTelefono, region, email)) {
            this.nombre = nombre;
            this.numTelefono = numTelefono;
            this.region = region;
            this.email = email;
        }
    }

    private boolean validarDatos(String nombre, String numTelefono, String region, String email) {
        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("Debe cargar un nombre");
        }
        if (numTelefono.isEmpty()) {
            throw new IllegalArgumentException("Debe cargar un teléfono");
        }
        if (!validarTelefono(numTelefono)) {
            throw new IllegalArgumentException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        }
        if (!region.equals("China") && !region.equals("US")
                && !region.equals("Europa")) {
            throw new IllegalArgumentException("Región desconocida. Las conocidas son: China, US, Europa");
        }
        if (!email.isEmpty()) {
            if (!validarMail(email)) {
                throw new IllegalArgumentException("El email debe ingresarse de la siguiente forma: NNNN-NNNNNN");
            }
        } else {
            throw new IllegalArgumentException("Debe cargar un email");
        }

        return true;
    }

    private boolean validarMail(String email2) {
        return true;
    }

    public String cualEsTuNombre() {
        return nombre;
    }

    public String cualEsTuNumTelefono() {
        return numTelefono;
    }

    public String cualEsTuReguion() {
        return region;
    }

    public String cualEsTuEmail() {
        return email;
    }

    private boolean validarTelefono(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }
}
