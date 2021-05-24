import java.util.ArrayList;
import java.util.Scanner;

public class CajeroAutomatico {
    static Scanner src = new Scanner(System.in);
    int idUltCaj = 0;
    int idCaj = 0;
    int Billetes[][];
    ArrayList<Tarjeta> listaTarjeta = new ArrayList<Tarjeta>();

    void mostrarCajero(){
        for (int i = 0; 7 > i; i++) {
        System.out.println(this.Billetes[i][1]+ " billetes de " + this.Billetes[i][0]);
        }
    }
    void sacarDinero(){
        System.out.println("Introduce tu NIF:");
        String nif = src.nextLine();
        System.out.println("Introduce tu PIN:");
        int pin = src.nextInt();
        boolean usuarioigual = comprobarUsuario(this.getListaTarjeta(), nif, pin);
        if (usuarioigual == true) {
            /*Ahora si que deberia de empezar a sacar cuartos en orden de mas a menos*/
            System.out.println("Cuanto dinero quieres sacar?");
        } else {
            System.out.println("No has introducido un NIF o PIN correcto");
        }
    }

    public boolean comprobarUsuario(ArrayList<Tarjeta> tarjeta, String id, int con){
    /*Aqui lo que hace falta es comprobar que el valor de la tarjeta dentro del array de tarjetas es igual al parametro
    que sera el nif y el pin en la tarjeta.*/
        if (id != tarjeta.get(int)){
            System.out.println("No has introducido el NIF correcto");
            return false;

        } else {

            if (con == tarjeta.indexOf()) {
                return true;

            } else {
                System.out.println("No has introducido el PIN correcto");
                return false;
            }
            }

    }


    public CajeroAutomatico() {
        this.setIdCaj(idUltCaj++);
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

    public int[][] getBilletes() {
        return Billetes;
    }

    public void setBilletes(int[][] Billetes) {
        this.Billetes = Billetes;
    }

    public ArrayList<Tarjeta> getListaTarjeta() {
        return listaTarjeta;
    }

    public void setListaTarjeta(ArrayList<Tarjeta> listaTarjeta) {
        this.listaTarjeta = listaTarjeta;
    }
}
