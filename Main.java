import hastTable.HashTable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        menu();

    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);

        //Instanciar nuestras dos tablas a comparar
        HashTable htd = new HashTable(1);
        HashTable htm = new HashTable(2);

        int option;
        boolean flag = true;

        while(flag) {
            System.out.println("\nBienvenido elija una de las opciones");
            System.out.println("1. Cargar datos usado método hash de división");
            System.out.println("2. Cargar datos usado método hash de multiplicación");
            System.out.println("3. Obtener datos usado método hash de división");
            System.out.println("4. Obtener datos usado método hash de multiplicación");
            System.out.print("5. Salir\n>> ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    double time = readCSV("./src/dataset/bussines.csv", htd);
                    System.out.println("\nEl tiempo de carga (división) fue de " + time + "ms\n");
                    break;
                case 2:
                    time = readCSV("./src/dataset/bussines.csv", htm);
                    System.out.println("\nEl tiempo de carga (multiplicación) fue de " + time + "ms\n");
                    break;
                case 3:
                    time = getAt(htd);
                    System.out.println("\nEl tiempo de búsqueda e impresión (división) fue de " + time + "ms\n");
                    break;
                case 4:
                    time = getAt(htd);
                    System.out.println("\nEl tiempo de búsqueda e impresión (multiplicación) fue de " + time + "ms\n");
                    break;
                case 5: flag = false;
                    break;
                default:
                    System.out.println("No válido");
                    break;
            }
        }
    }

    public static double readCSV(String route, HashTable ht) {
        String line = "";
        String splitBy = ",";
        int id=1;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(route));

            long startTime = System.nanoTime();

            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] bussines = line.split(splitBy);    // use comma as separator
                //System.out.println("["+id+"] Bussines [ID=" + bussines[0] + ", Name=" + bussines[1] + ", Address=" + bussines[2] + ", City=" + bussines[3] + ", State= " + bussines[4] +"]");
                ht.add(bussines[0], bussines[1]);
                id++;
            }

            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            double durationInMillis = duration / 1_000_000.0;
            return durationInMillis;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return 0;
        }
    }

    public static double getAt(HashTable ht) {
        Scanner sc = new Scanner(System.in);

        String key;
        System.out.print("\nIngresa el id: ");
        key =  sc.nextLine();

        long startTime = System.nanoTime();
        ht.getAt(key);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        double durationInMillis = duration / 1_000_000.0;
        return durationInMillis;
    }
}
