package menu;

public class Menu {
    public static void menu (){
        System.out.println("Selecciona la acción a realizar" +
                "\n" +
                """
                        1. Agregar un producto.
                        2. Actualizar un producto.
                        3. Elimintar un producto.
                        4. Busqueda de productos.
                        5. Precio de producto.
                        6. Cantidad de productos.
                        7. Reporte de inventario.
                        0. Finalizar programa.
                        """);

    }
    public static void menuInicial () {
        System.out.println(
                              """
                              Hola, ésta es una aplicación que permite 
                              realizar un control de inventarios.
                              
                              Para iniciar vamos a validar si el archivo
                              de inventarios productos.txt existe, si no
                              es así debemos crearlo. 
                              
                              ¿Deseas continuar?
                              1. Si.
                              2. No. Salir.
                              """);

    }
}
