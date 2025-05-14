package PreEntrega;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Articulo> lista = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
// Bucle principal del programa con menú interactivo
        int opcion;
        do {
            System.out.println("\n--- Menú de Artículos ---");
            System.out.println("1. Crear artículo");
            System.out.println("2. Listar artículos");
            System.out.println("3. Modificar artículo");
            System.out.println("4. Eliminar artículo");
            System.out.println("5. Consultar artículo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> crearArticulo();
                case 2 -> listarArticulos();
                case 3 -> modificarArticulo();
                case 4 -> eliminarArticulo();
                case 5 -> consultarArticulo();
                case 6 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 6);
    }

// Método para crear un nuevo artículo
    public static void crearArticulo() {
        System.out.print("ID: ");
        int id = sc.nextInt(); sc.nextLine();     // Leer ID
        //validacion ID
        if (id <= 0) {
            System.out.println("ID inválido.");
            return;
        }
        for (Articulo art : lista) {
            if (art.getId() == id) {
                System.out.println("ID ya existe.");
                return;
            }
        }
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();            // Leer nombre
        //validacion Nombre
        if (nombre.isEmpty()) {
            System.out.println("Nombre no puede estar vacío.");
            return;
        }
        System.out.print("Precio: ");
        double precio = sc.nextDouble();          // Leer precio
        //validacion Precio
        if (precio < 0) {
            System.out.println("Precio inválido.");
            return;
        }
        // Crear un nuevo objeto Articulo y agregarlo a la lista
        Articulo nuevo = new Articulo(id, nombre, precio);
        lista.add(nuevo);
        System.out.println("Artículo agregado.");
    }

// Método para mostrar todos los artículos de la lista
    public static void listarArticulos() {
        if (lista.isEmpty()) {
            System.out.println("No hay artículos cargados.");
        } else {
            for (Articulo a : lista) {
                a.mostrar();   // Llamada polimórfica al método mostrar()
            }
        }
    }

// Método para modificar un artículo existente
    public static void modificarArticulo() {
        System.out.print("ID del artículo a modificar: ");
        int id = sc.nextInt();
        for (Articulo articulo : lista) {
            if (articulo.getId() == id) {
                sc.nextLine();
                System.out.print("Nuevo nombre: ");
                articulo.setNombre(sc.nextLine());       // Usar setter para cambiar nombre
                System.out.print("Nuevo precio: ");
                articulo.setPrecio(sc.nextDouble());  
                   // Usar setter para cambiar precio
                System.out.println("Artículo actualizado.");
                return;
            }
        }
        System.out.println("Artículo no encontrado.");
    }


// Método para eliminar un artículo por ID
    public static void eliminarArticulo() {
        System.out.print("ID del artículo a eliminar: ");
        int id = sc.nextInt();
        // Usamos removeIf con expresión lambda para eliminar por ID
        boolean eliminado = lista.removeIf(a -> a.getId() == id);
        if (eliminado) {
            System.out.println("Artículo eliminado.");
        } else {
            System.out.println("Artículo no encontrado.");
        }
    }

// Metodo para consultar articulo por su ID
    public static void consultarArticulo() {
        System.out.print("ID del artículo a consultar: ");
        int id = sc.nextInt();

        for (Articulo art : lista) {
            if (art.getId() == id) {
                System.out.println("ID: " + art.getId());
                System.out.println("Nombre: " + art.getNombre());
                System.out.println("Precio: " + art.getPrecio());
                return;
            }
        }
        System.out.println("Artículo no encontrado.");
    }

}

