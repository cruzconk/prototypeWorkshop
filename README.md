# Prototype Pattern Workshop (Java)

Character generator for a video game, built with the **Prototype** creational pattern.

## Structure
- `src/prototype/Personaje.java` - the prototype; `clonar()` returns a deep copy
- `src/model/Inventario.java` - item list; clones itself with a new internal list
- `src/registry/RegistroPrototipos.java` - stores base characters and returns clones
- `src/main/Main.java` - test scenario

## Compile and run
```
mkdir out
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out main.Main
```

## Expected output
See `output.txt`.
