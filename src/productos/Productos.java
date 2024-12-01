package productos;


public class Productos {

    // Definir atributos de la clase productos.
    private int idProducto;
    private String nombre;
    private String categoria;
    private double precio;
    private int cantidad;

    //armar un constructor
    public Productos(int idProducto, String nombre, String categoria, double precio, int cantidad) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    //armar los getters
    public int getIdProducto() {
        return idProducto;
    }

    public String getnombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }
    // armar los setters

    public void setIdProducto(int producto) {
        this.idProducto = idProducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return idProducto + "," + nombre + "," + categoria + "," + precio + "," + cantidad;
    }
}

