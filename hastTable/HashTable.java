package hastTable;

import linkedList.LinkedList;

public class HashTable {
    private LinkedList[] table;
    private int size = 13;

    public HashTable() {
        this.table = new LinkedList[this.size];
        for (int i = 0; i < this.size; i++) {
            this.table[i]= new LinkedList();
        }
    }

    //Función para la coneverión a ASCCI
    private int converTo(String text){
        text.split("");
        int result = 0;

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);     //Obtengo los caracteres de la cadena
            int asciiValue = (int) character;    //Se convierten a números enteros ASCCI
            result += asciiValue;                //El resultado de la suma se guarda para mandarlo al hash
        }
        return result;
    }

    //Función hash por el método de la división
    private int hashCodeD(int value) {
        int hash = ((value & 0x7fffffff)% this.size);
        return hash;
    }

    //Función hash por el método de la multiplicaión
    private int hashCodeM(int value) {
        final double A = (Math.sqrt(5)-1)/2; //Constante
        double hash = (this.size*(value*A % 1));
        return (int) hash; //Conversión a su parte entera
    }

    //Agregar
   public void add(String key, Object data) {
        int newKey = this.converTo(key);

        if (newKey >= 0) {
            int hash = hashCodeM(newKey);
            this.table[hash].push(data);
        } else {
            System.out.println("Error al agregar");
        }
   }

   //Obtener los datos
    public void getAt(String key) {
        int newKey = this.converTo(key);

        if (newKey >= 0) {
            int hash = hashCodeM(newKey);
            for (int i = 0; i < this.table[hash].size(); i++){
                System.out.println(this.table[hash].getAt(i));
            }
        } else {
            System.out.println("Error al obtener");
        }
    }
}
