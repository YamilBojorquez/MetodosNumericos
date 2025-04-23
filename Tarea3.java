import java.util.Scanner;

public class Tarea3 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t\t\t        INSTITUTO TECNOLÓGICO NACIONAL DE MÉXICO");
        System.out.println("\t\t\t            Ing. En Sistemas Computacionales");
        System.out.println("\nBojórquez Chávez Yamil Santiago.");
        System.out.println("Métodos Numéricos - Integración Numérica.");
        System.out.println("Método de los Trapecios.");
        System.out.println("Horario de 9:00 a 10:00 horas.");
        System.out.print("\nPregunta del Problema: ");
        String pregunta = sc.nextLine();
        System.out.print("Unidad: ");
        String unidad = sc.nextLine();

        System.out.print("Valor real: ");
        Double valorReal = sc.nextDouble();
        System.out.print("Límite Inferior: ");
        double limInf = sc.nextDouble();
        System.out.print("Límite Superior: ");
        double limSup = sc.nextDouble();
        System.out.print("Número de Trapecios: ");
        int trapecios = sc.nextInt();
        System.out.print("Error del Problema: ");
        Double errorProblema = sc.nextDouble();
        System.out.print("Número de Procesos: ");
        int numeroProcesos = sc.nextInt();

        double limInfInicial = limInf;
        double limSupInicial = limSup;
        int trapeciosIniciales = trapecios;
        int calcTotales = 0;
        double errorMetodo;
        do {
            System.out.println("\n\t\t\t        INSTITUTO TECNOLÓGICO NACIONAL DE MÉXICO");
            System.out.println("\t\t\t            Ing. En Sistemas Computacionales");
            System.out.println("\nBojórquez Chávez Yamil Santiago.");
            System.out.println("Métodos Numéricos - Integración Numérica.");
            System.out.println("Método de los Trapecios.");
            System.out.println("Horario de 9:00 a 10:00 horas.");
            System.out.println("\nPregunta: " + pregunta);
            System.out.println("---------------------------------------------------------------------");
            System.out.printf("  %-4s | %-9s  | %-9s | %-9s | %-9s | %-9s\n", "No.", "    a ", "  a+h", "  f(a)", " f(a+h)", "  Area");
            System.out.println("---------------------------------------------------------------------");

            double h = (limSupInicial - limInfInicial) / trapecios;
            double valorCalculado = 0;
            limInf = limInfInicial;
            for(int i = 0; i < trapecios; i++) {
                limSup = limInf + h;
                double fa = 40 + ( 8 * Math.sqrt(limInf));
                double fah = 40 + ( 8 * Math.sqrt(limSup));
                double area = (h / 2) * (fah + fa); 
                System.out.printf("  %-4s |  %-9g | %-9g | %-9g | %-9g | %-9g\n", (i+1), limInf, limSup, fa, fah, area);
                valorCalculado = valorCalculado + area;
                limInf = limSup;
            }        
            calcTotales = calcTotales + 1;

            System.out.println("---------------------------------------------------------------------");

            errorMetodo = Math.abs(valorReal - valorCalculado);
            if( errorMetodo <= errorProblema ) {
                System.out.println("\nResultados: ");
                System.out.println("---------------------------------");
                System.out.println("Numero inicial de trapecios = " + trapeciosIniciales);
                System.out.println("Numero final de trapecios = " + trapecios);
                System.out.println("No. de procesos = " + calcTotales);
                System.out.println("Valor Real de la Integral = " + valorReal + " " + unidad);
                System.out.println("Valor calculado por trapecios = " + valorCalculado + " " + unidad);
                System.out.println("Error del problema = " + errorProblema);
                System.out.printf("Error del Método = %.14f\n", errorMetodo);
                break;
            }
            trapecios = trapecios * 2;
            limInf = limInfInicial;
        } while (calcTotales < numeroProcesos && errorMetodo > errorProblema);

        if ( calcTotales == numeroProcesos && errorMetodo > errorProblema ) {
            System.out.println("No se alcanzó la precisión deseada con el número máximo de procesos.");
        }
        sc.close();
    }
}