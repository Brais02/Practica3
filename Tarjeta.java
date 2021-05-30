public abstract class Tarjeta {
    String nif;
    int pin;
    String nombre;
    String apellido;
    private boolean estado;

    /*Constructor de la clase sin parametros por si se instancia vacia, que no de
     * error y poder llamar a algun constructor*/
    public Tarjeta() {
    }

    /*Constructor de la clase con todos los parametros propios menos estado*/
    public Tarjeta(String nif, int pin, String nombre, String apellido) {
        this.nif = nif;
        this.pin = pin;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    /*Muestra por pantalla el valor de los atributos del constructor quitado
     * de pin*/
    void mostrarTarjeta() {
        System.out.println("| El nombre es: " + this.nombre + "              |");
        System.out.println("| El apellido es: " + this.apellido + "            |");
        System.out.println("| El NIF es: " + this.nif + "            |");
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
