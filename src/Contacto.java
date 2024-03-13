public class Contacto {

    protected String nombre;
    protected String numTelefono;

    public Contacto() {
    }

    public Contacto(String nombre, String numTelefono) {
        this.nombre = nombre;
        this.numTelefono = numTelefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }


}
