public class TarjetaCredito extends Tarjeta {
    int saldoDisponible;
    int creditoDisponible;

    /*Constructor de la clase sin parametros por si se instancia vacia, que no de
     * error y poder llamar a algun constructor*/
    public TarjetaCredito() {
    }

    /*Constructor de la clase con los parametros heredados de Tarjeta y los propios*/
    public TarjetaCredito(String nif, int pin, String nombre, String apellido, int saldoDisponible, int creditoDisponible) {
        super(nif, pin, nombre, apellido);
        this.saldoDisponible = saldoDisponible;
        this.creditoDisponible = creditoDisponible;
    }

    /*Muestra por pantalla el valor de los atributos del constructor además
     * de los heredados de Tarjeta*/
    @Override
    void mostrarTarjeta() {
        super.mostrarTarjeta();
        System.out.println("|                                 |");
        System.out.println("|        TARJETA DE CREDITO:      |");
        System.out.println("| El saldo es: " + this.saldoDisponible + "               |");
        System.out.println("| El credito es: " + this.creditoDisponible + "             |");
    }

    public int getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(int saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public int getCreditoDisponible() {
        return creditoDisponible;
    }

    public void setCreditoDisponible(int creditoDisponible) {
        this.creditoDisponible = creditoDisponible;
    }

}
