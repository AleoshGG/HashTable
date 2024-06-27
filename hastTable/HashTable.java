package hastTable;

import linkedList.LinkedList;

public class HashTable {
    private LinkedList[] table;
    private LinkedList list;


    public HashTable(int size) {
        this.table = new LinkedList[size];
        for (int i = 0; i < this.table.length; i++) {
            this.table[i]= new LinkedList();
        }
    }

    //Función hash por el método de la división
    private int hashCodeD(int value) {
        int hash = ((value & 0x7fffffff)% this.table.length);
        return hash;
    }

    //Función hash por el método de la multiplicaión
    private int hasCodeM(int value) {
        final double A = (Math.sqrt(5)-1)/2; //Constante
        double hash = (this.table.length*(value*A % 1));
        return (int) hash; //Conversión a su parte entera
    }

    //Agregar
   public void add(int value, Object data) {
        if (value >= 0) {
            int hash = hashCodeD(value);
            this.table[hash].push(data);
        } else {
            System.out.println("Error al agregar");
        }
   }

   //Obtener los datos
    public void getAt(int value) {
        if (value >= 0) {
            int hash = hashCodeD(value);
            for (int i = 0; i < this.table[hash].size(); i++){
                System.out.println(this.table[hash].getAt(i));
            }
        } else {
            System.out.println("Error al agregar");
        }
    }
}
