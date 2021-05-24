import java.util.Scanner;
public class Menu {
    static Scanner src = new Scanner(System.in);
    public static void main(String[] args) {
        boolean salir =false;

        int[][] carga_billetes = {{500, 1}, {200, 3}, {100, 0}, {50, 0}, {20, 0}, {10, 18}, {5, 25}};
        CajeroAutomatico micajero = new CajeroAutomatico();
        micajero.setBilletes(carga_billetes);
        TarjetaDebito mitarj1 = new TarjetaDebito("12345678a", 1111, "Fran", "Fran", 20000);
        TarjetaCredito mitarj2 = new TarjetaCredito("87654321b", 2222, "Javi", "Javi", 1000, 5000);
        micajero.getListaTarjeta().add(mitarj1);
        micajero.getListaTarjeta().add(mitarj2);

        while(salir==false) {
        System.out.println("DATOS DE LA TARJETA DEL CLIENTE");
        mitarj1.mostrarTarjeta();
        System.out.println("DATOS DE LA TARJETA DEL CLIENTE");
        mitarj2.mostrarTarjeta();
        System.out.println("DATOS DE LA TARJETA DEL CLIENTE");
        micajero.mostrarCajero();

        System.out.println("Bienvenido al menu");
        System.out.println("1. Sacar dinero");
        System.out.println("2. Salir");

        System.out.println("Que operación quiere realizar:");
        String menu = src.nextLine();
            switch (menu) {
                case "1":

                    break;

                case "2":
                    boolean condicionsalir = false;

                    while (condicionsalir == false) {
                        System.out.println("Has seleccionado salir, estas seguro? Y/N");
                        String respuesta = src.nextLine();

                        switch (respuesta) {
                            case "y", "Y":
                                System.out.println("Que tenga un buen día, tarde o noche ciudadano.");
                                salir = true;
                                condicionsalir = true;
                                break;
                            case "n", "N":
                                System.out.println("Hooray! Te devolveremos al menu de selección enseguida...");
                                condicionsalir = true;
                                break;

                            default:
                                System.out.println("La respuesta no cumple la condición de ser un Y o N.");
                        }
                    }}
                    break;
    }

}}
