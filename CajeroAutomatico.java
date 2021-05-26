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
            int dinerosacar = src.nextInt();
            


        } else {
            System.out.println("No has introducido los datos de NIF o PIN correcto");
        }
    }

    /*El metodo comprobarUsuario, devuelve un booleano y se introducen los parametros de la ArrayList de Tarjeta, un
    * String que se llamara id y un integer que se llamara con, estos últimos definidos por el usuario al llamar al
    * metodo, para ello mientras que la variable integer i sea menor que el total de Tarjetas que tiene el ArrayList
    * y al mismo tiempo, mientras que la variable boolean coincide sea false, se va a mantener realizando una comprobación
    * para asegurarse de que los datos del NIF de la tarjeta sean iguales a id (para ello se usa equals por ser String) y
    * si los datos de PIN de la tarjeta son iguales a con (para ello se usan los iguales "==" al ser numerico), y en caso
    * de que este correcto te mostrara un mensaje y de cambiar coincide a true, en caso de ser negativo te devolvera
    * false y siempre sumara +1 a la variable i, además que al final devolvera el valor que tenga coincide.*/
    public boolean comprobarUsuario(ArrayList<Tarjeta> tarjeta, String id, int con) {
        boolean coincide = false;
        int i = 0;
        while (i < tarjeta.size() && coincide == false) {
            if (tarjeta.get(i).getNif().equals(id)) {
                if (tarjeta.get(i).getPin() == con) {
                    System.out.println("Has introducido los datos de manera correcta");
                    System.out.println("Hola "+ tarjeta.get(i).getNombre());
                    coincide = true;
                } else {
                    System.out.println("El Pin introducido no es correcto!");
                    return false;
                }
            } else {
                System.out.println("El NIF introducido es incorrecto!");
            }
            i++;
        }
        return coincide;
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

