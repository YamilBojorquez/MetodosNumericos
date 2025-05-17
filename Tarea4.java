import java.util.Scanner;

public class Tarea4 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t\t\t        INSTITUTO TECNOLÓGICO NACIONAL DE MÉXICO");
        System.out.println("\t\t\t            Ing. En Sistemas Computacionales");
        System.out.println("\nBojórquez Chávez Yamil Santiago.");
        System.out.println("Métodos Numéricos - Integración Numérica.");
        System.out.println("Método Reglas de Simpson.");
        System.out.println("Horario de 9:00 a 10:00 horas.");

        System.out.print("\nPregunta del Problema: ");
        String pregunta = sc.nextLine();
        System.out.print("Valor real: ");
        double Vreal = sc.nextDouble();
        System.out.print("Limite inferior: ");
        double a = sc.nextDouble();
        System.out.print("Limite superior: ");
        double b = sc.nextDouble();
        sc.nextLine();
        System.out.print("Unidad: ");
        String unidad = sc.nextLine();

        int n;
        do {
            System.out.println("\n\n\n\t\tMétodo Reglas de Simpson");
            System.out.println("* Regla 1 n=2.");
            System.out.println("* Regla 2 n=3.");
            System.out.println("* Regla 3 n>2 y n=par.");
            System.out.println("* Regla 4 n>3, n=impar y n= *3.");
            System.out.println("* F I N. n=0");
            System.out.print("\nCual es el número de Divisiones: ");
            n = sc.nextInt();

            if (n == 2) {
                System.out.println("\n\n\n\t\t\t          Simpson de 1/3 formula simple");
                System.out.println("\t\t\t        Instituto Tecnológico de Culiacán");
                System.out.println("\t\t\t                 Ing. en Sistemas");
                System.out.println("\nBojórquez Chávez Yamil Santiago");
                System.out.println("Integración Numérica - Método de Simpson");
                System.out.println("De 9:00 a 10:00 horas");
                System.out.println("\nPregunta: " + pregunta);

                double h= (b-a)/n;
                double fa= (0.03*Math.pow(a, 2)) + 1.5;
                double x1= a+h;
                double fx1= (0.03*Math.pow(x1, 2)) + 1.5;
                double fb= (0.03*Math.pow(b, 2)) + 1.5;
                double Vcalc= ((1*h)/3)*( fa+(4*fx1)+fb );
                double Error= Math.abs(Vreal-Vcalc);

                System.out.println("-----------------------------------------------------");
                System.out.printf("| %-3s | %9s | %9s | %6s | %10s |\n", "Pxy", "x", "f(x)", "Factor", "Area");
                System.out.println("-----------------------------------------------------");
                System.out.printf("| %-3d | %9.5f | %9.5f | %-6d | %10.5f |\n", 1, a, fa, 1, 1*fa);
                System.out.printf("| %-3d | %9.5f | %9.5f | %-6d | %10.5f |\n", 2, x1, fx1, 4, 4*fx1);
                System.out.printf("| %-3d | %9.5f | %9.5f | %-6d | %10.5f |\n", 3, b, fb, 1, 1*fb);
                System.out.println("-----------------------------------------------------");
                System.out.println("No. de Divisiones = " + n);
                System.out.printf("Valor Real de la Integral = %.5f %s\n", Vreal, unidad);
                System.out.printf("Valor por el Método       = %.5f %s\n", Vcalc, unidad);
                System.out.printf("Error del Método          = %.5f %s\n", Error, unidad);

            } else if (n == 3) {
                System.out.println("\n\n\n\t\t\t          Simpson de 3/8 formula simple");
                System.out.println("\t\t\t        Instituto Tecnológico de Culiacán");
                System.out.println("\t\t\t                 Ing. en Sistemas");
                System.out.println("\nBojórquez Chávez Yamil Santiago");
                System.out.println("Integración Numérica - Método de Simpson");
                System.out.println("De 9:00 a 10:00 horas");
                System.out.println("\nPregunta: " + pregunta);

                double h= (b-a)/n;
                double fa= (0.03*Math.pow(a, 2)) + 1.5;
                double x1= a+(1*h);
                double x2= a+(2*h);
                double fx1= (0.03*Math.pow(x1, 2)) + 1.5;
                double fx2= (0.03*Math.pow(x2, 2)) + 1.5;
                double fb= (0.03*Math.pow(b, 2)) + 1.5;
                double Vcalc= ((3*h)/8)*( fa+(3*fx1)+(3*fx2)+fb );
                double Error= Math.abs(Vreal-Vcalc);
                
                System.out.println("-----------------------------------------------------");
                System.out.printf("| %-3s | %9s | %9s | %6s | %10s |\n", "Pxy", "x", "f(x)", "Factor", "Area");
                System.out.println("-----------------------------------------------------");
                System.out.printf("| %-3d | %9.5f | %9.5f | %-6d | %10.5f |\n", 1, a, fa, 1, 1 * fa);
                System.out.printf("| %-3d | %9.5f | %9.5f | %-6d | %10.5f |\n", 2, x1, fx1, 3, 3 * fx1);
                System.out.printf("| %-3d | %9.5f | %9.5f | %-6d | %10.5f |\n", 3, x2, fx2, 3, 3 * fx2);
                System.out.printf("| %-3d | %9.5f | %9.5f | %-6d | %10.5f |\n", 4, b, fb, 1, 1 * fb);
                System.out.println("-----------------------------------------------------");
                System.out.println("No. de Divisiones = " + n);
                System.out.printf("Valor Real de la Integral = %.5f %s\n", Vreal, unidad);
                System.out.printf("Valor por el Método       = %.5f %s\n", Vcalc, unidad);
                System.out.printf("Error del Método          = %.5f %s\n", Error, unidad);

            } else if (n>2 && n%2==0) {
                System.out.println("\n\n\n\t\t\t         Simpson de 1/3 formula compleja");
                System.out.println("\t\t\t        Instituto Tecnológico de Culiacán");
                System.out.println("\t\t\t                 Ing. en Sistemas");
                System.out.println("\nBojórquez Chávez Yamil Santiago");
                System.out.println("Integración Numérica - Método de Simpson");
                System.out.println("De 9:00 a 10:00 horas");
                System.out.println("\nPregunta: " + pregunta);
                System.out.println("-----------------------------------------------------");
                System.out.printf("| %-3s | %9s | %9s | %6s | %10s |\n", "Pxy", "x", "f(x)", "Factor", "Area");
                System.out.println("-----------------------------------------------------");
                
                double Vcalc = 0;
                double h= (b-a)/n;
                double ca= a;
                double cb= b;

                for (int x = 1; x <= n+1; x++) {
                    if (x == 1) {
                        double factor=1;
                        double pto=ca;
                        double fpto=(0.03*Math.pow(pto, 2)) + 1.5;
                        double valor= factor*fpto;
                        Vcalc= Vcalc + valor;
                        System.out.printf("| %-3s | %9.5f | %9.5f | %6.0f | %10.5f |\n", x, pto, fpto, factor, valor);
                    }
                    if (x == n+1) {
                        double factor=1;
                        double pto=cb;
                        double fpto=(0.03*Math.pow(pto, 2)) + 1.5;
                        double valor= factor*fpto;
                        Vcalc= Vcalc + valor;
                        System.out.printf("| %-3s | %9.5f | %9.5f | %6.0f | %10.5f |\n", x, pto, fpto, factor, valor);
                    }
                    if (x > 1 && x < n+1) {
                        double Pos=x-1;
                        double Res=(x%2);
                        if (Res == 0) {
                            double factor=4;
                            double pto=ca + (Pos*h);
                            double fpto=(0.03*Math.pow(pto, 2)) + 1.5;
                            double valor= factor*fpto;
                            Vcalc= Vcalc + valor;
                        System.out.printf("| %-3s | %9.5f | %9.5f | %6.0f | %10.5f |\n", x, pto, fpto, factor, valor);
                        } else {
                            double factor=2;
                            double pto=ca + (Pos*h);
                            double fpto=(0.03*Math.pow(pto, 2)) + 1.5;
                            double valor= factor*fpto;
                            Vcalc= Vcalc + valor;
                        System.out.printf("| %-3s | %9.5f | %9.5f | %6.0f | %10.5f |\n", x, pto, fpto, factor, valor);
                        }
                    }
                }

                Vcalc= (1*h/3)*Vcalc;
                double Error= Math.abs(Vreal - Vcalc);
                System.out.println("-----------------------------------------------------");
                System.out.println("No. de Divisiones = " + n);
                System.out.printf("Valor Real de la Integral = %.5f %s\n", Vreal, unidad);
                System.out.printf("Valor por el Método       = %.5f %s\n", Vcalc, unidad);
                System.out.printf("Error del Método          = %.5f %s\n", Error, unidad);

            } else if (n>3 && n%2!=0 && n%3==0) {
                System.out.println("\n\n\n\t\t\t         Simpson de 3/8 formula compleja");
                System.out.println("\t\t\t        Instituto Tecnológico de Culiacán");
                System.out.println("\t\t\t                 Ing. en Sistemas");
                System.out.println("\nBojórquez Chávez Yamil Santiago");
                System.out.println("Integración Numérica - Método de Simpson");
                System.out.println("De 9:00 a 10:00 horas");
                System.out.println("\nPregunta: " + pregunta);
                System.out.println("-----------------------------------------------------");
                System.out.printf("| %-3s | %9s | %9s | %6s | %10s |\n", "Pxy", "x", "f(x)", "Factor", "Area");
                System.out.println("-----------------------------------------------------");

                double Vcalc=0;
                double h= (b-a)/n;
                double ca= a;
                double cb= b;

                for (int xx = 1; xx <= n+1; xx++) {
                    if (xx == 1) {
                        double factor=1;
                        double pto=ca;
                        double fpto=(0.03*Math.pow(pto, 2)) + 1.5;
                        double valor= factor*fpto;
                        Vcalc= Vcalc + valor;
                        System.out.printf("| %-3s | %9.5f | %9.5f | %6.0f | %10.5f |\n", xx, pto, fpto, factor, valor);
                    }
                    if (xx == n+1) {
                        double factor=1;
                        double pto=cb;
                        double fpto=(0.03*Math.pow(pto, 2)) + 1.5;
                        double valor= factor*fpto;
                        Vcalc= Vcalc + valor;
                        System.out.printf("| %-3s | %9.5f | %9.5f | %6.0f | %10.5f |\n", xx, pto, fpto, factor, valor);
                    }
                    if (xx > 1 && xx < n+1) {
                        double Pos=xx-1;
                        double Res=((xx-1) %3 );
                        if (Res == 0) {
                            double factor=2;
                            double pto=ca + (Pos*h);
                            double fpto=(0.03*Math.pow(pto, 2)) + 1.5;
                            double valor= factor*fpto;
                            Vcalc= Vcalc + valor;
                        System.out.printf("| %-3s | %9.5f | %9.5f | %6.0f | %10.5f |\n", xx, pto, fpto, factor, valor);
                        } else {
                            double factor=3;
                            double pto=ca + (Pos*h);
                            double fpto=(0.03*Math.pow(pto, 2)) + 1.5;
                            double valor= factor*fpto;
                            Vcalc= Vcalc + valor;
                        System.out.printf("| %-3s | %9.5f | %9.5f | %6.0f | %10.5f |\n", xx, pto, fpto, factor, valor);
                        }
                    }
                }

                Vcalc= (3*h/8)*Vcalc;
                double Error= Math.abs(Vreal - Vcalc);
                System.out.println("-----------------------------------------------------");
                System.out.println("No. de Divisiones = " + n);
                System.out.printf("Valor Real de la Integral = %.5f %s\n", Vreal, unidad);
                System.out.printf("Valor por el Método       = %.5f %s\n", Vcalc, unidad);
                System.out.printf("Error del Método          = %.5f %s\n", Error, unidad);
            } else if (n != 0){
                System.out.println("Simpson no aplica para este número de divisiones");
            }

        } while (n != 0);

        sc.close();
    }
}