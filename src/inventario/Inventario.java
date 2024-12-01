package inventario;

import menu.Menu;
import operaciones.Operaciones;
import java.util.Scanner;

public class Inventario {
    public static void main(String[] args) {
        Menu.menuInicial();
        int opcionMenuInicial;
        Scanner scanner = new Scanner(System.in);
        opcionMenuInicial = scanner.nextInt();
        if (opcionMenuInicial == 1) {
            //Validar si existe archivo productos.txt, si no crearlo para iniciar tareas.
            Operaciones.archivo();
            int opcionMenuInventario;
            Menu.menu();
            opcionMenuInventario = scanner.nextInt();
            switch (opcionMenuInventario) {
                case 1:
                    Operaciones.agregar();
                    break;
                case 2:
                    Operaciones.actualizar();
                    break;
                case 3:
                    Operaciones.eliminar();
                    break;
                case 4:
                    Operaciones.busqueda();
                    break;
                case 5:
                    Operaciones.precioMayor();
                    break;
                case 6:
                    Operaciones.cantidadProductoCategoria();
                    break;
                case 7:
                    Operaciones.reporteInventario();
                    break;
                case 0:
                    System.out.println("Gracias. Hasta la próxima");
                    break;
                default:
                    System.out.println("Por favor seleccione una opción entre 0 y 7");
            }
        } else {
            System.out.println("Gracias. Hasta la próxima.");
        }
    }
}