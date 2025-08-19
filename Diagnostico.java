//Yamil Santiago Bojórquez Chávez
//Tópicos Avanzados de Programación, 8-9 am

import java.util.Random;
import java.util.Scanner;

public class Diagnostico{
    public static void main(String [] args){
        //Declaración de variables
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        System.out.print("Introduce el número de filas de la matriz: ");
        int m = sc.nextInt();
        System.out.print("Introduce el número de columnas la matriz: ");
        int n = sc.nextInt();

        int [][] matriz = new int[m][n];

        double [] PromFilas = new double[m];
        double [] PromColumnas = new double[n];
        double PromTotal = 0;



        // 
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                matriz[i][j] = (rd.nextInt(900) + 100);
                
                PromFilas[i] += matriz[i][j];
                PromTotal += matriz[i][j];
            }
            PromFilas[i] /= n;
        }
        PromTotal /= m*n;



        //Impresión de resultados
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                System.out.print(matriz[i][j] + "   ");
            }
            System.out.println("        Promedio de la fila: " + PromFilas[i]);
        }
        System.out.println("Promedio total: " + PromTotal);
    }
}