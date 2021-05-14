public class TarjetaCredito extends Tarjeta {
    int saldoDisponible;
    int creditoDisponible;

    @Override
    void mostrarTarjeta() {
        super.mostrarTarjeta();
        System.out.println(this.saldoDisponible);
        System.out.println(this.creditoDisponible);
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
