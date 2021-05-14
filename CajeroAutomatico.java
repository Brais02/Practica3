import java.util.ArrayList;

public class CajeroAutomatico {
    int idUltCaj = 0;
    int idCaj = 0;
    int Billetes[];
    ArrayList<String> listaTarjeta = new ArrayList<String>();

    void mostrarCajero(){
        for (int i = 0; this.Billetes.length > i; i++) {
        System.out.println(this.Billetes[i]);
        }
    }

    public int getIdUltCaj() {
        return idUltCaj;
    }

    public void setIdUltCaj(int idUltCaj) {
        this.idUltCaj = idUltCaj;
    }

    public int getIdCaj() {
        return idCaj;
    }

    public void setIdCaj(int idCaj) {
        this.idCaj = idCaj;
    }

    public int[] getBilletes() {
        return Billetes;
    }

    public void setBilletes(int[] Billetes) {
        this.Billetes = Billetes;
    }

    public ArrayList<String> getListaTarjeta() {
        return listaTarjeta;
    }

    public void setListaTarjeta(ArrayList<String> listaTarjeta) {
        this.listaTarjeta = listaTarjeta;
    }
}
