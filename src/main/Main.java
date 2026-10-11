package main;

import model.Inventario;
import prototype.Personaje;
import registry.RegistroPrototipos;

/**
 * Test scenario. The client obtains characters ONLY by asking the registry
 * for a copy; it never builds the clones by hand.
 */
public class Main {

    public static void main(String[] args) {

        RegistroPrototipos registro = new RegistroPrototipos();

        // 1) Register two base prototypes (the only place constructors are used)
        Inventario invGuerrero = new Inventario();
        invGuerrero.agregarItem("Poción de vida");
        registro.registrarPrototipo("Guerrero",
                new Personaje("Guerrero-Base", "Guerrero", invGuerrero));

        Inventario invMago = new Inventario();
        invMago.agregarItem("Poción de maná");
        invMago.agregarItem("Libro de hechizos");
        registro.registrarPrototipo("Mago",
                new Personaje("Mago-Base", "Mago", invMago));

        // 2) Clone the prototypes (two different clonations)
        Personaje guerreroCopia = registro.obtenerCopia("Guerrero");
        guerreroCopia.setNombre("Guerrero-Copia");

        Personaje magoCopia = registro.obtenerCopia("Mago");
        magoCopia.setNombre("Mago-Copia");

        System.out.println("=== Después de clonar ===");
        System.out.println(registro.consultarPrototipo("Guerrero"));
        System.out.println(guerreroCopia);
        System.out.println(registro.consultarPrototipo("Mago"));
        System.out.println(magoCopia);

        // 3) Modify the inventory of one copy
        guerreroCopia.getInventario().agregarItem("Escudo");

        // 4) Show that the original prototype did NOT change (deep copy)
        System.out.println("\n=== Después de agregar 'Escudo' a Guerrero-Copia ===");
        System.out.println("Prototipo Guerrero : " + registro.consultarPrototipo("Guerrero").getInventario());
        System.out.println("Guerrero-Copia     : " + guerreroCopia.getInventario());
        System.out.println("Prototipo Mago     : " + registro.consultarPrototipo("Mago").getInventario());
        System.out.println("Mago-Copia         : " + magoCopia.getInventario());

        // Extra check: the inventories are different objects in memory
        System.out.println("\n¿Mismo objeto Inventario? "
                + (registro.consultarPrototipo("Guerrero").getInventario() == guerreroCopia.getInventario()));

        // 5) Requesting a prototype that does not exist
        System.out.println("\n=== Prototipo inexistente ===");
        Personaje inexistente = registro.obtenerCopia("Arquero");
        System.out.println("Resultado: " + inexistente);
    }
}
