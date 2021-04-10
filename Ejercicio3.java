package Clase8;

import java.util.Scanner;

//1. Escribir un método que reciba un número y retorne su doble
public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese un número");
        int num = input.nextInt();
        System.out.println(obtenerDoble(num));
    }

    public static int obtenerDoble(int num) {
        return num * 2;
    }

}
