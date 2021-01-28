/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cris.proyectoserpientecristinaj;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Cris
 */
public class proyectoSerpiente {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int i;
        int cont = 0;
        boolean flat = true;
        int pos = 0;
        int posFinal = 0;
        int diferencia = 0;
        int salida = -1;
        
        do{
        System.out.println("------------------------------------------");
        //Pedimos el número del tamaño del array.
        System.out.println("Introduce el numero de mediciones:");
        int mediciones = teclado.nextInt();

        //Para asegurar las cantidades correctas.
        if (mediciones >= 1 && mediciones <= 100) {

            //Creamos el array para llenarlo de los datos
            int array[] = new int[mediciones];

            //Comenzamos a pedir datos.
            System.out.println("Introduce número de mediciones consecutivas por debajo del humbral(k): ");
            int consecutivas = teclado.nextInt();

            for (i = 0; i < array.length; i++) {
                System.out.println("Introduzca número: ");
                array[i] = teclado.nextInt();
            }
            for (int j = 0; j < array.length; j++) {
                if (array[j] == 1) {
                    
                    if (flat == true) {
                        pos = j;
                        flat = false;
                        cont = 0;
                        posFinal = j;
                        
                    }
                    if (cont > consecutivas) {
                        cont = 0;
                        pos = j;
                    }
                    if (diferencia < (j - pos)) {
                        diferencia = j - pos;
                        posFinal = pos;
                    }
                    
                    cont = 0;
                } else if (array[j] == 0) {
                    cont++;

                }
            }
            System.out.println("El periodo óptimo tiene longitud " + (diferencia + 1)
                    + " y comienza en la medición " + (posFinal + 1));
            System.out.println("¿Desea continuar?\n1.Sí\n0.No");
            salida = teclado.nextInt();
        } else {
            System.out.println("Introduzca valores válidos.");

        }
        }while (salida == 1);
    }

}
