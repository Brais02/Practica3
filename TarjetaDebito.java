public class TarjetaDebito extends Tarjeta {
    int saldoDisponible;

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
