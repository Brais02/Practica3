public class TarjetaDebito extends Tarjeta {
    int saldoDisponible;

    public TarjetaDebito() {
    }

    public TarjetaDebito(String nif, int pin, String nombre, String apellido, int saldoDisponible) {
        super(nif, pin, nombre, apellido);
        this.saldoDisponible = saldoDisponible;
    }

    @Override
    void mostrarTarjeta() {
        super.mostrarTarjeta();
        System.out.println(this.saldoDisponible);
    }

    public int getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(int saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }
}
