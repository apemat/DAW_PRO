// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Agenda {

    private Contacto[] contactos;

    public Agenda() {
        contactos = new Contacto[10];
    }

    public Agenda(int tamano) {
        contactos = new Contacto[tamano];
    }

    public Agenda(Contacto[] contactos) {
        this.contactos = contactos;
    }

    public Contacto[] getContactos() {
        return contactos;
    }

    public void setContactos(Contacto[] contactos) {
        this.contactos = contactos;
    }

    /**
     * Este método debe añadir un nuevo contacto, si no existe, en la agenda.
     * Se añade en la primera posición libre del array.
     * Si logra añadirlo devolverá true, en caso contrario devolverá false
     * @param contacto
     * @return
     */
    public int anadirContacto (Contacto contacto) {
        // Comprobar si hay hueco en el array
        int hueco = buscarHueco();
        if (hueco > -1) {
            // Comprobar si el usuario existe
            if (buscarPosicionContacto(contacto.getNombre()) < 0){
                contactos[hueco] = contacto;
                return 0;
            } else {
                return -1;
            }
        }
        return -2;
    }

    public boolean eliminarContacto (String nombre) {
        // Comprobar si el usuario existe
        if (existeContacto(nombre)) {
            //Si existe busco la posición del array en la que se encuentra
            int posicion = buscarPosicionContacto(nombre);
            contactos[posicion] = null; //quito el objeto de la posicion
            return true;
        }
        return false;
    }

    public boolean existeContacto (String nombre) {
        //Chequeo cada posicion del array dado que pueden haber nulos en cualquier posición
        for (int i=0; i< contactos.length; i++) {
            /* Si la posición es distinta de null (es decir tiene un contacto),
                compruebo si el nombre coincide con el que estoy buscando (que viene por paramétro)
             */
            if (contactos[i] != null && contactos[i].getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que muestra por pantalla los contactos incluidos en la agenda
     */
    public void listarContactos() {
        for (int i=0; i < contactos.length; i++) {
            if (contactos[i] != null) {
                System.out.println(contactos[i].getNombre() + " " + contactos[i].getNumTelefono());
            }
        }
    }

    /**
     * Método que comprueba si un usuario existe y devuelve su posición
     * @param nombre
     * @return
     */
    public int buscarPosicionContacto (String nombre) {
        for (int i = 0; i < contactos.length; i++) {
            if (existeContacto(nombre)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Método que devuelve la primera posición vacía del array
     * @return
     */
    private int buscarHueco () {
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] == null) {
                return i;
            }
        }
        return -1;
    }


}