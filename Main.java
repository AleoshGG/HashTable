import hastTable.HashTable;

public class Main {
    public static void main(String[] args) {

        HashTable table = new HashTable();
        table.add("Primero", "Hola");
        table.add("Primero", "Hola2");
        table.add("Segundo", "Chanchito feliz");
        table.add("Alexis", 1);
        table.getAt("Primero");
        table.getAt("Segundo");
        table.getAt("Alexis");

    }
}
