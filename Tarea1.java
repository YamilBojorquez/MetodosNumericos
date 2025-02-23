import java.util.Scanner;

public class Tarea1 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t        INSTITUTO TECNOLÓGICO NACIONAL DE MÉXICO");
        System.out.println("\t            Ing. En Sistemas Computacionales");
        System.out.println("\nBojórquez Chávez Yamil Santiago.");
        System.out.println("Solución de ecuaciones.");
        System.out.println("De 9:00 a 10:00 horas.");
        System.out.println("\n\t    Este programa ejecuta la solución de problemas");
        System.out.println("\tutilizando los procesos lógicos de cálculo de Raíces de");
        System.out.println("\t     una ecuación con diversos métodos numéricos.");
        System.out.print("\nPregunta del Problema: ");
        String pregunta = sc.nextLine();

        System.out.print("Concepto: ");
        String concepto = sc.nextLine();
        System.out.print("Unidad: ");
        String unidad = sc.nextLine();

        System.out.println("\n\t\t       Raíces de una Ecuación");
        System.out.println("1.- Método de la Secante");
        System.out.println("2.- Método de Newton Raphson");
        System.out.println("10.- F I N");
        System.out.print("Cuál es su opción: ");

        int opcion = sc.nextInt();
        while (opcion != 10){
            if (opcion == 1) {
                double x1, x2, x3, fx1, fx2, fx3;

                System.out.print("\nIngrese el invervalo 1: ");
                x1 = sc.nextDouble();
                System.out.print("Ingrese el invervalo 2: ");
                x2 = sc.nextDouble();

                fx1 = Math.asin((10 * x1 / 9) - 1) + (((10 * x1 / 9) - 1) * Math.sqrt(1 - Math.pow((10 * x1 / 9) - 1, 2))) - 1.100144;
                fx2 = Math.asin((10 * x2 / 9) - 1) + (((10 * x2 / 9) - 1) * Math.sqrt(1 - Math.pow((10 * x2 / 9) - 1, 2))) - 1.100144;
                x3 = x1 - ((x1 - x2) * fx1) / (fx1 - fx2);
                fx3 = Math.asin((10 * x3 / 9) - 1) + (((10 * x3 / 9) - 1) * Math.sqrt(1 - Math.pow((10 * x3 / 9) - 1, 2))) - 1.100144;

                int calculos = 1, maxCalculos = 50;

                System.out.println("\n\t        INSTITUTO TECNOLÓGICO NACIONAL DE MÉXICO");
                System.out.println("\t            Ing. En Sistemas Computacionales");
                System.out.println("\nBojórquez Chávez Yamil Santiago.");
                System.out.println("Solución de ecuaciones: Método de la Secante.");
                System.out.println("De 9:00 a 10:00 horas.");
                System.out.println("\nPregunta: " + pregunta);
                System.out.printf("%-10s %-15s %-15s %-15s %-15s %-15s %-15s %n", "N", "x1", "fx1", "x2", "fx2", "x3", "fx3");
                System.out.println("------------------------------------------------------------------------------------------------------");
                System.out.printf("%-10d %-15.8f %-15.8f %-15.8f %-15.8f %-15.8f %-15.8f %n", calculos, x1, fx1, x2, fx2, x3, fx3);

                while (calculos < maxCalculos) {
                    x1 = x2;
                    fx1 = fx2;
                    x2 = x3;
                    fx2 = fx3;
                
                    x3 = x1 - ((x1 - x2) * fx1) / (fx1 - fx2);
                    fx3 = Math.asin((10 * x3 / 9) - 1) + (((10 * x3 / 9) - 1) * Math.sqrt(1 - Math.pow((10 * x3 / 9) - 1, 2))) - 1.100144;
                    if ( ((x2-x3) <= 0.00001) && ((x2-x3) >= -0.00001) ) break;
                    calculos++;
                
                    System.out.printf("%-10d %-15.8f %-15.8f %-15.8f %-15.8f %-15.8f %-15.8f %n", calculos, x1, fx1, x2, fx2, x3, fx3);
                }
                System.out.println("------------------------------------------------------------------------------------------------------");
                System.out.println("\n" + concepto +  " = " + x3 + " " + unidad + "\n\n");
            } else if (opcion == 2) {
                double x1, x2, fx1, dfx1,fx2;

                System.out.print("\nIngrese el punto flotante: ");
                x1 = sc.nextDouble();

                fx1 = Math.asin((10 * x1 / 9) - 1) + (((10 * x1 / 9) - 1) * Math.sqrt(1 - Math.pow((10 * x1 / 9) - 1, 2))) - 1.100144;
                dfx1 = (20.0 / 9) * Math.sqrt(1 - Math.pow((((10 * x1) / 9) - 1), 2));
                x2 = x1 - (fx1 / dfx1);
                fx2 = Math.asin((10 * x2 / 9) - 1) + (((10 * x2 / 9) - 1) * Math.sqrt(1 - Math.pow((10 * x2 / 9) - 1, 2))) - 1.100144;

                int calculos = 1, maxCalculos = 50;

                System.out.println("\n\t        INSTITUTO TECNOLÓGICO NACIONAL DE MÉXICO");
                System.out.println("\t            Ing. En Sistemas Computacionales");
                System.out.println("\nBojórquez Chávez Yamil Santiago.");
                System.out.println("Solución de ecuaciones: Método de Newton Raphson.");
                System.out.println("De 9:00 a 10:00 horas.");
                System.out.println("\nPregunta: " + pregunta);
                System.out.printf("%-10s %-15s %-15s %-15s %-15s %-15s %n", "N", "x1", "fx1", "f'x1", "x2", "fx2");
                System.out.println("------------------------------------------------------------------------------------------------------");
                System.out.printf("%-10d %-15.8f %-15.8f %-15.8f %-15.8f %-15.8f %n", calculos, x1, fx1, dfx1, x2, fx2);

                while (calculos < maxCalculos) {
                    x1 = x2;
                    fx1 = fx2;
                    dfx1 = (20.0 / 9) * Math.sqrt(1 - Math.pow((((10 * x1) / 9) - 1), 2));
                    x2 = x1 - (fx1 / dfx1);
                    fx2 = Math.asin((10 * x2 / 9) - 1) + (((10 * x2 / 9) - 1) * Math.sqrt(1 - Math.pow((10 * x2 / 9) - 1, 2))) - 1.100144;

                    if ( ((x1-x2) <= 0.00001) && ((x1-x2) >= -0.00001) ) break;
                    calculos++;
                
                    System.out.printf("%-10d %-15.8f %-15.8f %-15.8f %-15.8f %-15.8f %n", calculos, x1, fx1, dfx1, x2, fx2);
                }
                System.out.println("------------------------------------------------------------------------------------------------------");
                System.out.println("\n" + concepto +  " = " + x2 + " " + unidad + "\n\n");
            }
            System.out.println("\n\t\t       Raíces de una Ecuación");
            System.out.println("1.- Método de la Secante");
            System.out.println("2.- Método de Newton Raphson");
            System.out.println("10.- F I N");
            System.out.print("Cuál es su opción: ");
            opcion = sc.nextInt();
        }
        sc.close();
    }
}