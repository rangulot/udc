/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej6;

import java.util.Scanner;

/**
 *
 * @author hacke
 */
public class Ej6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] notasEstudiante = new int[5];
        
        Scanner key = new Scanner(System.in);
        
        //LLENANDO EL ARREGLO
        for(int i = 0; i < notasEstudiante.length; i++){
            System.out.println("Ingrese las notas del estudiante: ");
            notasEstudiante[i] = key.nextInt();
        }
        
        //ORDENANDO ARREGLO DESCENDENTEMENTE (MAYOR A MENOR)
        
            
        int indice = 0;
        for (int notas : notasEstudiante) {
            indice++;
            System.out.println("Nota ["+indice+"]: "+notas);
        }
    }
    
}
