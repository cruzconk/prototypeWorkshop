package registry;

import prototype.Personaje;

import java.util.HashMap;
import java.util.Map;

/**
 * Prototype registry: stores base characters identified by a key
 * and hands out CLONES of them. It never builds characters from scratch
 * and never returns the stored original.
 */
public class RegistroPrototipos {

    // Key (e.g. "Guerrero") -> base character
    private final Map<String, Personaje> prototipos = new HashMap<>();

    /** Registers a base character under the given key. */
    public void registrarPrototipo(String clave, Personaje personaje) {
        prototipos.put(clave, personaje);
    }

    /**
     * Returns a cloned copy of the prototype stored under the key.
     * If the prototype does not exist, nothing is cloned and null is returned.
     */
    public Personaje obtenerCopia(String clave) {
        Personaje prototipo = prototipos.get(clave);
        if (prototipo == null) {
            System.out.println("[Registro] No existe el prototipo '" + clave
                    + "'. No se puede clonar.");
            return null;
        }
        return prototipo.clonar(); // always a copy, never the original
    }

    /** Read access to the stored original, used only to verify it did not change. */
    public Personaje consultarPrototipo(String clave) {
        return prototipos.get(clave);
    }
}
