package operaciones;

import productos.Productos;

import java.io.*;
import java.util.*;

public class Operaciones {
    private static final String rutaArchivo = "D:\\PROYECTOSJAVA\\PROGRAMACION\\productos.txt";
    private static List<Productos> productos = new ArrayList<>();

    // si no existe el archivo en la ruta debo crearlo
    public static void archivo() {
        try {
            File file = new File(rutaArchivo);
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(rutaArchivo, true));
            bufferedWriter.write("idProducto, nombreProducto, categoria, precio, cantidadDisponible");
            bufferedWriter.newLine(); // Añadir salto de línea después del encabezado
            bufferedWriter.close();
            cargarProductos(); // Cargar los productos al iniciar
        } catch (IOException e) {
            System.out.println("Error al crear el archivo o escribir el registro: " + e.getMessage());
        }
    }

    // crear productos en el archivo
    public static void cargarProductos() {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.startsWith("idProducto")) {  // Omitir encabezado
                    String[] datos = linea.split(",");
                    if (datos.length != 5) {
                        System.out.println("Formato de línea incorrecto, se omite: " + linea);
                        continue; // Si la línea no tiene 5 datos, la ignoramos.
                    }

                    try {

                        int idProducto = Integer.parseInt(datos[0].trim());
                        String nombre = datos[1].trim();
                        String categoria = datos[2].trim();
                        double precio = Double.parseDouble(datos[3].trim());
                        int cantidad = Integer.parseInt(datos[4].trim());

                        // Si todo se parsea correctamente, agregamos el producto
                        productos.add(new Productos(idProducto, nombre, categoria, precio, cantidad));
                    } catch (NumberFormatException e) {
                        System.out.println("Error al parsear los datos de la línea: " + linea);
                        System.out.println("Detalles del error: " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los productos: " + e.getMessage());
        }
    }

    // agregar un producto
    public static void agregar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Esta función agrega nuevos productos. Escriba -1 para terminar.");

        while (true) {
            System.out.println("Ingresar un identificador de producto de tipo numérico:");
            int idProducto = scanner.nextInt();

            if (idProducto == -1) break;

            // Consumir el salto de línea pendiente
            scanner.nextLine();

            System.out.println("Ingresar nombre del producto:");
            String nombre = scanner.nextLine();

            System.out.println("Ingresar la categoría del producto:");
            String categoria = scanner.nextLine();

            System.out.println("Ingresar el precio del producto:");
            double precio = scanner.nextDouble();

            System.out.println("Ingresar la cantidad del producto:");
            int cantidad = scanner.nextInt();

            // Crear el nuevo producto
            Productos producto = new Productos(idProducto, nombre, categoria, precio, cantidad);
            productos.add(producto);

            // Guardar en el archivo
            guardarProductos();

            System.out.println("Producto agregado exitosamente.");
        }
    }

    // Guardar productos en el archivo
    private static void guardarProductos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            bw.write("idProducto, nombreProducto, categoria, precio, cantidadDisponible");
            bw.newLine(); // Añadir salto de línea
            for (Productos producto : productos) {
                bw.write(producto.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los productos: " + e.getMessage());
        }
    }

    // me permite
    public static void actualizar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ID del producto a actualizar:");
        int id = scanner.nextInt();

        Productos producto = buscarProductoPorId(id);
        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.println("Producto encontrado: " + producto.getNombre());
        scanner.nextLine(); // Consumir el salto de línea

        System.out.println("Ingrese el nuevo nombre del producto:");
        producto.setNombre(scanner.nextLine());

        System.out.println("Ingrese la nueva categoría del producto:");
        producto.setCategoria(scanner.nextLine());

        System.out.println("Ingrese el nuevo precio del producto:");
        producto.setPrecio(scanner.nextDouble());

        System.out.println("Ingrese la nueva cantidad del producto:");
        producto.setCantidad(scanner.nextInt());

        // Guardar cambios
        guardarProductos();
        System.out.println("Producto actualizado.");
    }

    // Buscar producto por ID
    private static Productos buscarProductoPorId(int id) {
        for (Productos p : productos) {
            if (p.getIdProducto() == id) {
                return p;
            }
        }
        return null;
    }

    // Método para eliminar un producto
    public static void eliminar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ID del producto a eliminar:");
        int id = scanner.nextInt();

        Productos producto = buscarProductoPorId(id);
        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        productos.remove(producto);
        guardarProductos();
        System.out.println("Producto eliminado.");
    }

    // Buscar productos por categoría
    public static void busqueda() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la categoría de los productos que desea buscar:");
        String categoria = scanner.nextLine();

        System.out.println("Productos encontrados en la categoría " + categoria + ":");
        for (Productos producto : productos) {
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                System.out.println(producto);
            }
        }
    }

    // Obtener el producto con mayor precio
    public static void precioMayor() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
            return;
        }

        Productos productoMayor = Collections.max(productos, Comparator.comparingDouble(Productos::getPrecio));
        System.out.println("El producto de mayor precio es: " + productoMayor);
    }

    // Calcular cantidad de productos por categoría
    public static void cantidadProductoCategoria() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la categoría para la cual desea calcular la cantidad de productos:");
        String categoria = scanner.nextLine();

        int cantidadTotal = 0;
        for (Productos producto : productos) {
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                cantidadTotal += producto.getCantidad();
            }
        }

        System.out.println("Total de productos en la categoría " + categoria + ": " + cantidadTotal);
    }

    // Generar reporte de inventario
    public static void reporteInventario() {
        System.out.println("Reporte de inventario:");
        for (Productos producto : productos) {
            System.out.println(producto);
        }
    }
}
