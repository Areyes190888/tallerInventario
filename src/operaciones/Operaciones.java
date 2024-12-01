package operaciones;
import java.io.*;
import java.util.*;
import productos.Productos;


public class Operaciones {
    private static final String rutaArchivo = "D:\\PROYECTOSJAVA\\PROGRAMACION\\productos.txt";
    public static void archivo () {
        try {
            File file = new File(rutaArchivo);
            //String rutaArchivo = "D:\\PROYECTOSJAVA\\PROGRAMACION\\productos.txt";


            // Validar si el archivo existe, si no, crearlo.
            if (!file.exists()) {
                file.createNewFile();
                FileWriter fileWriter = new FileWriter("productos.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write("idProducto, nombreProducto, categoria, precio, cantidadDisponible");
                bufferedWriter.close();

                }

        }catch (
                Exception e) {
            System.out.println("Error al crear el archivo: ");
        }
    }


    public static void agregar () {
        System.out.println("Esta funcion agrega nuevos productos");
        Scanner scanner = new Scanner(System.in);
        try { BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, true));

            String registrarProductos;

            while (true) {
                System.out.println("Escriba los nuevos productos. Escriba fin para terminar");
                registrarProductos = scanner.nextLine();
                if (registrarProductos.equalsIgnoreCase("fin")) {
                    break;
                }
                bw.write(registrarProductos);
                bw.newLine();
            }
        }  catch (IOException e) {
            System.err.println("Error al agregar" + e.getMessage());
        }
    }



    public static void actualizar () {
        System.out.println("Esta funcion permite actualizar productos");
    }
    public static void eliminar (){
        System.out.println("Esta funcion permite elimiar productos");
    }
    public static void busqueda () {
        System.out.println("Esta funcion permite buscar productos por categoria");
    }
    public static void precioMayor (){
        System.out.println("Esta funcion permite buscar cúal es el producto de mayor valor en el inventario");
    }
    public static void cantidadProductoCategoria () {
        System.out.println("Esta funcion permite calcular las cantidades de productos por categoria");
    }
    public static void reporteInventario () {
        System.out.println("Esta funcion genera un reporte de las existencias de productos que actualmente existen en inventario");
    }

}

