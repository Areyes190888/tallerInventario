package archivo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Archivo {
    public static void archivo (){
        try {
            String rutaArchivo = "D:\\PROYECTOSJAVA\\PROGRAMACION\\productos.txt";
            File file = new File("D:\\PROYECTOSJAVA\\PROGRAMACION\\productos.txt");

            // Validar si el archivo existe, si no, crearlo.
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter("productos.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("idProducto, nombreProducto, categoria, precio, cantidadDisponible");
            bufferedWriter.close();

        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }

}


