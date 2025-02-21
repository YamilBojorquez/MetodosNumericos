import java.util.Scanner;

public class MetodoSecante {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        imprimirPresentacion();

        imprimirMenu();
        int opcion = sc.nextInt();
        while (opcion != 10){
            if (opcion == 1) {
                double x1, x2, x3, fx1, fx2, fx3;

                System.out.print("\nIngrese el invervalo 1: ");
                x1 = sc.nextDouble();
                System.out.print("Ingrese el invervalo 2: ");
                x2 = sc.nextDouble();

                fx1 = formulaProblema(x1);
                fx2 = formulaProblema(x2);
                x3 = formulaSecante(x1, x2, fx1, fx2);
                fx3 = formulaProblema(x3);

                int calculos = 1, maxCalculos = 50;

                System.out.printf("%-10s %-15s %-15s %-15s %-15s %-15s %-15s %n", "N", "x1", "fx1", "x2", "fx2", "x3", "fx3");
                System.out.println("------------------------------------------------------------------------------------------------------");
                System.out.printf("%-10d %-15.8f %-15.8f %-15.8f %-15.8f %-15.8f %-15.8f %n", calculos, x1, fx1, x2, fx2, x3, fx3);

                while (calculos < maxCalculos) {
                    x1 = x2;
                    fx1 = fx2;
                    x2 = x3;
                    fx2 = fx3;
                
                    x3 = formulaSecante(x1, x2, fx1, fx2);
                    fx3 = formulaProblema(x3);
                    if ( ((x2-x3) <= 0.00001) && ((x2-x3) >= -0.00001) ) break;
                    calculos++;
                
                    System.out.printf("%-10d %-15.8f %-15.8f %-15.8f %-15.8f %-15.8f %-15.8f %n", calculos, x1, fx1, x2, fx2, x3, fx3);
                }
                System.out.println("------------------------------------------------------------------------------------------------------\n\n");
            } else if (opcion == 2) {

            }
            imprimirMenu();
            opcion = sc.nextInt();
        }
    }






    private static void imprimirPresentacion(){
        System.out.println("\tINSTITUTO TECNOLÓGICO NACIONAL DE MÉXICO");
        System.out.println("\t    Ing. En Sistemas Computacionales");
        System.out.println("\nBojórquez Chávez Yamil Santiago.");
        System.out.println("Solución de ecuaciones.");
        System.out.println("De 9:00 a 10:00 horas.");
        System.out.println("\n\t    Este programa ejecuta la solución de problemas");
        System.out.println("\tutilizando los procesos lógicos de cálculo de Raíces de");
        System.out.println("\t     una ecuación con diversos métodos numéricos.");
        System.out.println("\t\nPregunta del Problema: ");
    }

    private static void imprimirMenu(){
        System.out.println("\n\tRaíces de una Ecuación");
        System.out.println("1.- Método de la Secante");
        System.out.println("2.- Método de Newton Raphson");
        System.out.println("10.- F I N");
        System.out.print("Cuál es su opción: ");
    }


    private static double formulaSecante (double x1, double x2, double fx1, double fx2){
        return x1 - ((x1 - x2) * fx1) / (fx1 - fx2);
    }

    private static double formulaProblema (double x){
        double fx = (10 * x / 9) - 1;
        return Math.asin(fx) + (fx * Math.sqrt(1 - Math.pow(fx, 2))) - 1.100144;
    }
}