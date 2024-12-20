package productos;

public class Productos {
    private int idProducto;
    private String nombre;
    private String categoria;
    private double precio;
    private int cantidad;

    // crear constructores e inicializar las variables
    public Productos(int idProducto, String nombre, String categoria, double precio, int cantidad) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // armar los setters
    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
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
    public void setIdProducto(int idProducto) {
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

    // To String
    @Override
    public String toString() {
        return idProducto + "," + nombre + "," + categoria + "," + precio + "," + cantidad;
    }
}
