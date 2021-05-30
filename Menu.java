import java.util.Scanner;

public class Menu {
    /*Creación del escaner como static para poder usarlo en toda la clase*/
    static Scanner src = new Scanner(System.in);

    public static void main(String[] args) {
        /*salir se usa para controlar el bucle de menu*/
        boolean salir = false;

        /*Añadiendo los datos a los distintos objetos para poder usarlos despues*/
        int[][] carga_billetes = {{500, 1}, {200, 3}, {100, 0}, {50, 0}, {20, 0}, {10, 18}, {5, 25}};
        CajeroAutomatico micajero = new CajeroAutomatico();
        micajero.setBilletes(carga_billetes);
        TarjetaDebito mitarj1 = new TarjetaDebito("12345678a", 1111, "Fran", "Fran", 20000);
        TarjetaCredito mitarj2 = new TarjetaCredito("87654321b", 2222, "Javi", "Javi", 1000, 5000);
        micajero.getListaTarjeta().add(mitarj1);
        micajero.getListaTarjeta().add(mitarj2);

        /*Mientras salir sea false se ejecutara el menu*/
        while (salir == false) {
            /*Muestra un mensaje y llama a los metodos de mostrar en
            * los diferentes objetos*/
            System.out.println("");
            System.out.println("+=================================+");
            System.out.println("| DATOS DE LA TARJETA DEL CLIENTE |");
            System.out.println("+---------------------------------+");
            mitarj1.mostrarTarjeta();
            System.out.println("+=================================+");

            System.out.println("");
            System.out.println("+=================================+");
            System.out.println("| DATOS DE LA TARJETA DEL CLIENTE |");
            System.out.println("+---------------------------------+");
            mitarj2.mostrarTarjeta();
            System.out.println("+=================================+");

            System.out.println("");
            System.out.println("+=================================+");
            System.out.println("| DINERO QUE CONTIENE EL CAJERO " + micajero.idUltCaj + " |");
            System.out.println("+---------------------------------+");
            micajero.mostrarCajero();
            System.out.println("+=================================+");

            System.out.println("");
            System.out.println("+=================================+");
            System.out.println("|       BIENVENIDO AL MENU        |");
            System.out.println("+---------------------------------+");
            System.out.println("| 1. Sacar dinero                 |");
            System.out.println("| 2. Salir                        |");
            System.out.println("+=================================+");
            System.out.println("");

            /*Pregunta que quieres hacer en el menu y lo guarda en una variable*/
            System.out.println("Que operación quiere realizar:");
            String menu = src.nextLine();
            System.out.println("");

            switch (menu) {

                case "1":
                    /*Llama al metodo sacarDinero de micajero*/
                    micajero.sacarDinero();
                    System.out.println("Finalizando proceso");
                    break;

                case "2":
                    /*condionsalir se usa para controlar el bucle de pregunta*/
                    boolean condicionsalir = false;

                    /*Mientras condicionsalir sea false se ejecutara el codigo de dentro*/
                    while (condicionsalir == false) {
                        /*Pregunta si quieres salir y guarda el resultado en una variable*/
                        System.out.println("Has seleccionado salir, estas seguro? Y/N");
                        String respuesta = src.nextLine();

                        /*En caso de que la respuesta no sea Y o N, mostrara un mensaje de error
                         * y te volvera a pedir que introduzcas una respuesta*/
                        switch (respuesta) {
                            case "y", "Y":
                                /*Muestra un mensaje de salida y cierra el bucle tanto del menu
                                 * como de esta pregunta*/
                                System.out.println("Que tenga un buen día, tarde o noche.");
                                salir = true;
                                condicionsalir = true;
                                break;

                            case "n", "N":
                                /*Muestra un mensaje y cierra el bucle de esta pregunta pero no el del menu*/
                                System.out.println("Te devolveremos al menu de selección enseguida...");
                                condicionsalir = true;
                                break;

                            default:
                                System.out.println("La respuesta no cumple la condición de ser un Y o N.");
                        }
                    }
            }

        }

    }
}
