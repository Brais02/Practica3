public class TarjetaDebito extends Tarjeta {
    int saldoDisponible;

    /*Constructor de la clase sin parametros por si se instancia vacia, que no de
     * error y poder llamar a algun constructor*/
    public TarjetaDebito() {
    }

    /*Constructor de la clase con los parametros heredados de Tarjeta y los propios*/
    public TarjetaDebito(String nif, int pin, String nombre, String apellido, int saldoDisponible) {
        super(nif, pin, nombre, apellido);
        this.saldoDisponible = saldoDisponible;
    }

    /*Muestra por pantalla el valor de los atributos del constructor además
     * de los heredados de Tarjeta*/
    @Override
    void mostrarTarjeta() {
        super.mostrarTarjeta();
        System.out.println("|                                 |");
        System.out.println("|        TARJETA DE DEBITO:       |");
        System.out.println("| El saldo es: " + this.saldoDisponible + "              |");
    }

    public int getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(int saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }
}
