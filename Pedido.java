package PreEntrega;

import java.util.ArrayList;

public class Pedido {

    private int id;
    private ArrayList<Articulo> articulos;

    // Constructor para inicializar el objeto Pedido
    public Pedido(int id) {
        this.id = id;                         // ID único del pedido
        this.articulos = new ArrayList<>();   // Lista de artículos en el pedido
    }

    // Getter para el atributo id (solo lectura)
    public int getId() {
        return id;
    }

    // Método para agregar un artículo al pedido
    public void agregarArticulo(Articulo articulo) {
        articulos.add(articulo);
    }

    // Método para calcular el total del pedido
    public double calcularTotal() {
        double total = 0;
        for (Articulo a : articulos) {
            total += a.getPrecio();          // Suma los precios de cada artículo
        }
        return total;
    }

    // Método para mostrar la información del pedido
    public void mostrarPedido() {
        System.out.println("Pedido ID: " + id);
        for (Articulo a : articulos) {
            a.mostrar();                     // Muestra cada artículo usando su método mostrar()
        }
        System.out.println("Total: $" + calcularTotal());
    }
}
