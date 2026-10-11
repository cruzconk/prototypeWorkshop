package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Inventory: holds the list of items a character owns.
 * It knows how to copy itself so that the copy NEVER shares
 * the internal list with the original (deep copy).
 */
public class Inventario {

    // Internal list of item names. Private: nobody outside can touch it directly.
    private final List<String> items;

    /** Creates an empty inventory. */
    public Inventario() {
        this.items = new ArrayList<>();
    }

    /**
     * Copy constructor (used for cloning).
     * IMPORTANT: it builds a brand new ArrayList with the same elements,
     * instead of reusing the other inventory's list reference.
     * Since items are Strings (immutable), copying the list is enough
     * to get a true deep copy.
     */
    private Inventario(Inventario other) {
        this.items = new ArrayList<>(other.items);
    }

    /** Adds a new item to this inventory. */
    public void agregarItem(String item) {
        items.add(item);
    }

    /** Returns a new, independent copy of this inventory. */
    public Inventario clonar() {
        return new Inventario(this);
    }

    /** Returns a read-only view so callers cannot modify the list behind our back. */
    public List<String> getItems() {
        return Collections.unmodifiableList(items);
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
