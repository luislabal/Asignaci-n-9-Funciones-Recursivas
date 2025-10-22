

package com.mycompany.asignacion9.recursividad;

import java.io.File;

/**
 *
 * @author E5
 */
public class Asignacion9Recursividad {

    public static void main(String[] args) {
        //Ejercicio 1
        int[] arr1 = {4, 2, 7, 1};
        System.out.println("Ejercicio 1 - Suma");
        System.out.println("Iterativa: " + sumaIterativa(arr1));
        System.out.println("Recursiva: " + sumaRecursiva(arr1, 0));

        //Ejercicio 2
        int[] arr2 = {2, 4, 2, 8, 2, 3};
        int x = 2;
        System.out.println("\nEjercicio 2 - Contar ocurrencias de " + x);
        System.out.println("Iterativa: " + contarIterativo(arr2, x));
        System.out.println("Recursiva: " + contarRecursivo(arr2, x, 0));

        //Ejercicio 3
        File raiz = new File("C:/Users/luisc/Music/Musica");
        System.out.println("\nEjercicio 3 - Exploracion de carpetas");
        explorarRecursivo(raiz);

        //Ejercicio 4
        String cadena = "hola somos el equipo 5";
        System.out.println("\nEjercicio 4 - Invertir cadena '" + cadena + "'");
        System.out.println("Iterativa: " + invertirIterativa(cadena));
        System.out.println("Recursiva: " + invertirRecursiva(cadena));

        //Ejercicio 5 
        int num = 12321;
        System.out.println("\nEjercicio 5 - Numero palindromo " + num);
        System.out.println("Iterativa: " + esPalindromoIterativo(num));
        System.out.println("Recursiva: " + esPalindromoRecursivo(String.valueOf(num)));
    }
    
        
        //EJERCICIO 1 - Suma elemntos
         public static int sumaIterativa(int[] arr) {
        int suma = 0;
        for (int num : arr) {
            suma += num;
        }
            return suma;
        }

        public static int sumaRecursiva(int[] arr, int index) {
            // Caso base: índice fuera del arreglo
            if (index == arr.length) return 0;
            // Caso recursivo: elemento actual + suma del resto
            return arr[index] + sumaRecursiva(arr, index + 1);
        }


        // 
        // EJERCICIO 2: Contar ocurrencias
        // 
        public static int contarIterativo(int[] arr, int x) {
        int count = 0;
        for (int num : arr) {
            if (num == x) count++;
        }
            return count;
        }

        public static int contarRecursivo(int[] arr, int x, int index) {
            // Caso base: índice fuera de rango
            if (index == arr.length) return 0;
            // Caso recursivo: 1 si coincide + recursión en el resto
            return (arr[index] == x ? 1 : 0) + contarRecursivo(arr, x, index + 1);
        }

        // 
        // EJERCICIO 3: Explorar archivos y carpetas
        // 
        public static void explorarRecursivo(File dir) {
        File[] archivos = dir.listFiles();
        if (archivos == null) return; // Caso base: no hay archivos
        for (File f : archivos) {
            if (f.isDirectory()) {
                System.out.println("Carpeta: " + f.getAbsolutePath());
                explorarRecursivo(f); // Caso recursivo
            } else {
                System.out.println("Archivo: " + f.getAbsolutePath());
            }
        }
        }   

        // 
        // EJERCICIO 4: Invertir cadena
        // 
        public static String invertirIterativa(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
        }

        public static String invertirRecursiva(String s) {
            // Caso base: longitud 0 o 1
            if (s.length() <= 1) return s;
            // Caso recursivo: último carácter + invertir resto
            return s.charAt(s.length() - 1) + invertirRecursiva(s.substring(0, s.length() - 1));
        }


        // 
        // EJERCICIO 5: Número palíndromo
        // 
        public static boolean esPalindromoIterativo(int num) {
        int original = num, invertido = 0;
        while (num > 0) {
            invertido = invertido * 10 + num % 10;
            num /= 10;
        }
        return original == invertido;
        }

        public static boolean esPalindromoRecursivo(String s) {
            // Caso base: longitud 0 o 1
            if (s.length() <= 1) return true;
            // Caso recursivo: comparar extremos y recortar
            if (s.charAt(0) != s.charAt(s.length() - 1)) return false;
            return esPalindromoRecursivo(s.substring(1, s.length() - 1));
        }
}
