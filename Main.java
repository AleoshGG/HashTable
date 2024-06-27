import hastTable.HashTable;

public class Main {
    public static void main(String[] args) {

        HashTable table = new HashTable(13);
        table.add(1, "Hola");
        table.add(1, "Hola2");
        table.getAt(1);
    }
}
