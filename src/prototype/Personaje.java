package prototype;

import model.Inventario;

/**
 * Character: the PROTOTYPE of the pattern.
 * It knows how to create a copy of itself through clonar(),
 * so client code never needs to know how to build it from scratch.
 */
public class Personaje {

    private String nombre;
    private String clase;
    private Inventario inventario;

    /** Regular constructor, used only to configure the base prototypes. */
    public Personaje(String nombre, String clase, Inventario inventario) {
        this.nombre = nombre;
        this.clase = clase;
        this.inventario = inventario;
    }

    /** Private copy constructor used by clonar(). */
    private Personaje(Personaje other) {
        this.nombre = other.nombre;   // String: immutable, safe to share
        this.clase = other.clase;     // String: immutable, safe to share
        // DEEP COPY: the clone gets its own new Inventario instance.
        // A shallow copy (this.inventario = other.inventario) would make
        // both characters share the same inventory, which is the classic bug.
        this.inventario = other.inventario.clonar();
    }

    /** Prototype method: returns an independent copy of this character. */
    public Personaje clonar() {
        return new Personaje(this);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClase() {
        return clase;
    }

    public Inventario getInventario() {
        return inventario;
    }

    @Override
    public String toString() {
        return "Personaje{nombre='" + nombre + "', clase='" + clase
                + "', inventario=" + inventario + "}";
    }
}
