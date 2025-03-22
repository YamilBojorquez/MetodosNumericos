import java.util.Scanner;

public class Tarea2 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        /*System.out.println("\n\t        INSTITUTO TECNOLÓGICO NACIONAL DE MÉXICO");
        System.out.println("\t            Ing. En Sistemas Computacionales");
        System.out.println("\nBojórquez Chávez Yamil Santiago.");
        System.out.println("Solución de Sistema de Ecuaciones.");
        System.out.println("De 9:00 a 10:00 horas.");
        System.out.println("\n\t    Este programa ejecuta la solución de problemas");
        System.out.println("\t  utilizando los procesos lógicos de Solución de sistemas");
        System.out.println("\t   de Ecuaciones utilizando diversos métodos numéricos.");
        System.out.print("\nPregunta del Problema: ");
        String pregunta = sc.nextLine();*/

        int orden = 0;
        do {
            System.out.print("Orden (2 a 10): ");
            orden = sc.nextInt();
        } while (orden < 2 || orden > 10);

        /*System.out.print("Concepto: ");
        String concepto = sc.nextLine();
        sc.nextLine();
        System.out.print("Unidad: ");
        String unidad = sc.nextLine();*/

        int opcion = 0;
        do {
            System.out.println("\n\t\t       Solución de Ecuaciones");
            System.out.println("1.- Método de Gauss Jordan");
            System.out.println("2.- Método de Gauss Seidel");
            System.out.println("10.- F I N");
            System.out.print("Cuál es su opción: ");

            opcion = sc.nextInt();
            if (opcion == 1) {
                double piv, Ecero, factor;

                //double [][] matriz = new double[orden][orden+1];
                double [][] matriz = {
                    {20, 10, 9, 9, 125*100},
                    {8, 18, 6, 14, 136*100},
                    {8, 8, 9, 24, 133*100},
                    {8, 8, 16, 12, 144*100}
                };

                /*for (int f = 0; f < orden; f++) {
                    for (int c = 0; c < orden+1; c++) {
                        matriz[f][c] = sc.nextInt();
                    }
                }*/
                System.out.println("Matriz de Datos:");
                imprimirMatriz(matriz, orden);

                for (int k = 0; k < orden-1; k++) {
                    piv = matriz[k][k];
                    for (int f = k+1; f < orden; f++) {
                        Ecero = matriz[f][k];
                        for (int c = k; c < orden+1; c++) {
                            matriz[f][c] = (piv*matriz[f][c]) - (Ecero*matriz[k][c]);
                        }
                    }
                }
                System.out.println("Matriz de ceros abajo de la diagonal:");
                imprimirMatriz(matriz, orden);

                for (int k = orden-1; k > 0; k--) {
                    piv = matriz[k][k];
                    for (int f = 0; f < k; f++) {
                        factor = matriz[f][k] / piv;
                        for (int c = k; c < orden+1; c++) {
                            matriz[f][c] = matriz[f][c] - (factor*matriz[k][c]);
                        }
                        matriz[f][k] = 0;
                    }
                }
                System.out.println("Matriz ceros abajo y arriba de la diagonal:");
                imprimirMatriz(matriz, orden);

                for (int f = 0; f < orden; f++) {
                    matriz[f][orden] = matriz[f][orden] / matriz [f][f];
                    matriz[f][f] = matriz [f][f] / matriz[f][f];
                }
                System.out.println("Matriz Identidad:");
                imprimirMatriz(matriz, orden);

                System.out.println("Resultados:");

            } else if (opcion == 2) {
                double [] vAnt = new double [orden];
                double [] vAct = new double [orden];
                double nc = 0, errorTotal = 0, suma, coef;

                for (int f = 0; f < orden; f++) {
                    vAnt[f] = 50;
                    vAct[f] = 0;
                }

                int error = 1, totalCalculos = 50;

                double [][] matriz = {
                    {20, 10, 9, 9, 125*100},
                    {8, 18, 6, 14, 136*100},
                    {8, 8, 16, 12, 144*100},
                    {8, 8, 9, 24, 133*100}
                };




                for (int f = 0; f < orden; f++) {
                    System.out.print(vAnt[f] + " | ");
                }
                System.out.println("Error total: " + errorTotal);

                for (int f = 0; f < orden; f++) {
                    suma = 0;
                    coef = matriz[f][f];
                    suma = suma + matriz[f][orden];
                    for (int c = 0; c < orden; c++) {
                        if (f == c) {
                            
                        } else if (c < f) {
                            suma = suma + ( (matriz[f][c] * -1.0) * vAct[c] );
                        } else {
                            suma = suma + ( (matriz[f][c] * -1.0) * vAnt[c] );
                        }
                    }
                    suma = suma / coef;
                    vAct[f] = suma;
                }



                for (int p = 0; p < orden; p++) {
                    errorTotal = errorTotal + Math.abs( Math.abs(vAct[p])  -  Math.abs(vAnt[p]) );               
                }
                nc = nc + 1;
                System.out.println(nc);
                for (int p = 0; p < orden; p++) {
                    System.out.println(vAct[p]);
                    vAnt[p] = vAct[p];
                }
                System.out.println(errorTotal);

                

            }
        } while (opcion != 10);
        sc.close();
    }

    private static void imprimirMatriz(double[][] matriz, int orden){
      System.out.println("--------------------------------------------------------------------------------------------------");
      for (int i = 0; i < orden; i++) {
        for (int j = 0; j < orden+1; j++) {
          System.out.printf("%-15.5f", matriz[i][j]);
        }
        System.out.println();
      }
      System.out.println("--------------------------------------------------------------------------------------------------\n");
    }
}