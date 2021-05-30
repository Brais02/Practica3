import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CajeroAutomatico {
    /*Creación del escaner como static para poder usarlo en toda la clase*/
    static Scanner src = new Scanner(System.in);
    /*idCaj se usa para saber el numero total de cajero que tenemos, es static
     * porque las variables estaticas se crean una vez por clase*/
    static int idCaj = 0;
    /*idUltCaj se usa para saber en que cajero estamos, no es static porque las
     * variables no estaticas para que se pueda variar el numero*/
    int idUltCaj;
    /*Billetes se usa para guardar el total de billetes de un tipo que tenemos y
     * el tipo del billete*/
    int Billetes[][];
    ArrayList<Tarjeta> listaTarjeta = new ArrayList<Tarjeta>();

    /*Este metodo cambia el numero del cajero cada vez que se instancia*/
    public CajeroAutomatico() {
        /*Cada vez que se instancie aumenta uno el valor de idCaj*/
        idCaj++;
        /*Pone el valor de idCaj a idUltCaj*/
        idUltCaj = idCaj;
    }

    /*Este metodo nos va a mostrar por pantalla un desglose de los billetes que tenemos*/
    void mostrarCajero() {
        /*total guarda el resultado del metodo dineroTotalCajero*/
        int total = dineroTotalCajero();
        /*El bucle se realizara mientras el tamaño de la array de billetes sea mayor que i*/
        for (int i = 0; Billetes.length > i; i++) {
            /*Mostrara por pantalla un mensaje que tendra el total de billetes de un tipo que tenemos y
             * el tipo del billete*/
            System.out.println("| " + this.Billetes[i][1] + " billetes de " + this.Billetes[i][0] + " €             |");
        }
        System.out.println("| El Total:     " + total + " €            |");
    }

    /*Este metodo nos va a pedir cuanto dineros queremos sacar y nos mostrara
     * por pantalla un desglose de los billetes sacados*/
    void sacarDinero() {
        /*i se usa en el bucle while*/
        int i = 0;
        /*recuentoBilletes se usa durante el bucle para contar cuantos billetes de un tipo
         * hemos sacado*/
        int recuentoBilletes = 0;
        /*recuento guarda el resultado del metodo dineroTotalCajero*/
        int recuento = dineroTotalCajero();

        /*Va a intentar hacer el grueso del metodo y si encuentra un fallo en el que
         * se introduzca un dato que no pertoca mostrara un mensaje de error*/
        try {
            /*Solicita el NIF, pero tiene dos nextLine porque con solo uno en la
             * segunda ejecución no me detectaba el nextLine*/
            System.out.println("Introduce tu NIF: (La primera vez lo tendras que introducir 2 veces)");
            src.nextLine();
            String nif = src.nextLine();
            /*Solicita el PIN y igual que nif, lo guarda en una variable*/
            System.out.println("Introduce tu PIN:");
            int pin = src.nextInt();
            /*Llama al metodo comprobarUsuario con los parametros de la listatarjeta, nif y pin
             * que estos dos últimos son introducidos anteriormente*/
            boolean usuarioigual = comprobarUsuario(this.getListaTarjeta(), nif, pin);

            /*Comprueba que los datos introducidos sean los de alguna tarjeta,
             * en caso contrario muestra un mensaje de error en PIN o NIF*/
            if (usuarioigual == true) {
                /*Pregunta cuanto dinero quieres sacar y lo guarda en una variable*/
                System.out.println("Cuanto dinero quieres sacar?");
                int dinerosacar = src.nextInt();
                /*Si el dinero que quiere sacar el usuario es mayor que el total del
                 * dinero que tiene el cajero, mostrara un mensaje de error*/
                if (recuento >= dinerosacar) {
                    System.out.println("");
                    System.out.println("+-----------------------------------+");
                    System.out.println("|   Recuento del Total de Billetes  |");
                    System.out.println("+-----------------------------------+");
                    /*Mientras el dinero que quiere sacar el cliente no sea 0 va a
                     * realizar lo que haya dentro del bucle*/
                    while (dinerosacar != 0) {
                        /*Si el total de billetes de un tipo es diferente a 0 y el
                         * valor del billete es menor o igual que el dinero que quiere
                         * sacar el usuario*/
                        if (Billetes[i][1] != 0 && Billetes[i][0] <= dinerosacar) {
                            /*Resta el valor que ha pedido el cliente al valor del billete*/
                            dinerosacar = dinerosacar - Billetes[i][0];
                            /*Resta uno al total de billetes de un tipo*/
                            Billetes[i][1] = Billetes[i][1] - 1;
                            /*Aumenta el recuentoBilletes en 1*/
                            recuentoBilletes++;
                        } else {
                            /*Muestra por pantalla el recuentoBilletes y el valor del billete*/
                            System.out.println("| Se ha sacado " + recuentoBilletes + " billetes de " + Billetes[i][0] + " € |");
                            /*Deja recuentoBilletes a 0*/
                            recuentoBilletes = recuentoBilletes - recuentoBilletes;
                            /*Aumenta en 1 la variable i para que pase a la siguiente ronda de billetes*/
                            i++;
                        }
                    }
                    if (dinerosacar == 0) {
                        /*Muestra por pantalla el valor de recuentoBilletes y el valor del billete*/
                        System.out.println("| Se ha sacado " + recuentoBilletes + " billetes de " + Billetes[i][0] + " € |");
                        System.out.println("+-----------------------------------+");

                    } else {
                        /*Muestra por pantalla un mensaje de fallo en la transacción*/
                        System.out.println("No se ha completado la transacción");
                        System.out.println("+-----------------------------------+");
                    }
                } else {
                    System.out.println("El cajero no dispone de suficiente dinero para realizar la transacción");
                }
            } else {
                System.out.println("No has introducido los datos de NIF o PIN correcto");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error!");
        }
    }

    /*El metodo dineroTotalCajero calcula el total de dinero que tiene el cajero en el momento de la llamada al mismo*/
    public int dineroTotalCajero() {
        /*dinerototal se usa para guardar el total del dinero que tiene el cajero*/
        int dinerototal = 0;
        /*recuentoBilletes se usa durante el bucle para contar cuantos billetes de un tipo
         * hemos sacado */
        int recuentoBilletes = 0;
        /*acabar se usa para controlar el bucle del metodo*/
        boolean acabar = false;
        /*i se usa en el bucle while*/
        int i = 0;

        /*Mientras el tamaño de la array de billetes sea mayor que i y acabar sea false va
         * a realizar lo que haya dentro del bucle*/
        while (Billetes.length > i && acabar == false) {
            /*Si el total de billetes de un tipo es mayor que 0*/
            if (Billetes[i][1] > 0) {
                /*Se suma el valor del billete a dinertotal */
                dinerototal = dinerototal + Billetes[i][0];
                /*Resta uno al total de billetes de un tipo*/
                Billetes[i][1] = Billetes[i][1] - 1;
                /*Aumenta el recuentoBilletes en 1*/
                recuentoBilletes++;

                /*Si el total de billetes de un tipo es igual a 0*/
            } else if (Billetes[i][1] == 0) {
                /*Devuelve el valor del billete como estaba*/
                Billetes[i][1] = Billetes[i][1] + recuentoBilletes;
                /*Deja el valor de recuentoBilletes a 0*/
                recuentoBilletes = recuentoBilletes - recuentoBilletes;
                /*Aumenta en 1 la variable i para que pase a la siguiente ronda de billetes*/
                i++;
            }
            /*Si el tamaño de la array de billetes es igual a i*/
            if (Billetes.length == i) {
                /*El valor de acabar sera true y con ello acaba el bucle del metodo*/
                acabar = true;
            }
        }
        /*Devuelve el resultado de contar el dinero del cajero*/
        return dinerototal;
    }

    /*El metodo comprobarUsuario, comprueba que los parametros sean iguales a los datos de la tarjeta
     * dependiendo del resultado devuelve un booleano*/
    public boolean comprobarUsuario(ArrayList<Tarjeta> tarjeta, String id, int con) {
        /*coincide se usa para controlar el bucle del metodo y como atributo a devolver*/
        boolean coincide = false;
        /*i se usa en el bucle while*/
        int i = 0;

        /*Mientras i sea menor que el tamaño de la array de tarjetas y coincide sea false*/
        while (i < tarjeta.size() && coincide == false) {
            /*Si el valor del Nif de una de las tarjetas es igual al parametro id*/
            if (tarjeta.get(i).getNif().equals(id)) {
                /*Si el valor del Pin de una de las tarjetas es igual al parametro con*/
                if (tarjeta.get(i).getPin() == con) {
                    /*Muestra por pantalla un mensaje y el nombre del usuario al que le
                     * pertenece la tarjeta*/
                    System.out.println("Has introducido los datos de manera correcta");
                    System.out.println("");
                    System.out.println("Hola " + tarjeta.get(i).getNombre());
                    /*El valor de coincide pasa a ser true, acabando el bucle*/
                    coincide = true;
                } else {
                    /*Muestra un mensaje de PIN incorrecto y devuelve el valor false*/
                    System.out.println("El Pin introducido no es correcto!");
                    return false;
                }
            }
            /*Aumenta en 1 la variable i para que pase a la siguiente tarjeta*/
            i++;
        }
        /*Devuelve el valor de coincide*/
        return coincide;
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
