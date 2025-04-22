import java.util.Scanner;

public class TareaD {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Pantalla de inicio
        System.out.println("\t        INSTITUTO TECNOLÓGICO NACIONAL DE MÉXICO");
        System.out.println("\t            Ing. En Sistemas Computacionales");
        System.out.println("\nZavala Arredondo Dahir Fernando");
        System.out.println("Metodo de los trapecios.");
        System.out.println("De 12:00 a 13:00");
        //preguntar datos del problema
        System.out.print("\nIngrese la pregunta: ");
        String pregunta = sc.nextLine();
		//valor real
        System.out.print("Ingrese el Valor real: ");
        Double VReal = sc.nextDouble();
        sc.nextLine();
        //unidad
        System.out.print("Ingrese la unidad: ");
        String unidad = sc.nextLine();
        //preguntar datos de la funcion
        System.out.print("Ingrese el limite inferior: ");
        double liminf = sc.nextDouble();
        System.out.print("Ingrese el limite superior: ");
        double limsup = sc.nextDouble();
        System.out.print("Ingrese el numero de trapezios inicial: ");
        int trapecios=sc.nextInt();
        System.out.print("Ingrese el error del problema: ");
        Double errorpro = sc.nextDouble();
        System.out.print("Ingrese el limite procesos: ");
        int procesoslim = sc.nextInt();



        
        //copiamos los valores iniciales
        double originala=liminf;
        double originalb=limsup;
        int originaln=trapecios;
        int calculostotales=0;
        do {
        	System.out.println("\t        INSTITUTO TECNOLÓGICO NACIONAL DE MÉXICO");
            System.out.println("\t            Ing. En Sistemas Computacionales");
            System.out.println("\nZavala Arredondo Dahir Fernando");
            System.out.println("Metodo numericos - integracion numerica.");
            System.out.println("Metodo de los trapecios.");
            System.out.println("De 12:00 a 13:00");
            System.out.println("\nPregunta: "+pregunta);
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.printf("%-3s | %-10s | %-10s | %-12s | %-12s | %-10s\n", 
                    "No.", "a", "a+h", "f(a)", "f(a+h)", "Area");
            System.out.println("----------------------------------------------------------------------------------------------------------");
            
            
            double h = (originalb - originala)/trapecios;
            double valorCalculado = 0;
            liminf = originala;
            for(int i = 0; i < trapecios; i++) {
                limsup = liminf + h;
                double fa = funcion(liminf);
                double fah = funcion(limsup);
                double area = (h/2) * (fah + fa); 
                System.out.printf("%-3s | %-10g | %-10g | %-12g | %-12g | %-10g\n", 
                        i+1, liminf, limsup, fa, fah, area);
                valorCalculado += area;
                liminf = limsup;
            }        
            calculostotales++;

            System.out.println("----------------------------------------------------------------------------------------------------------");

            double errorCalculado = Math.abs(VReal - valorCalculado);
            if(errorCalculado <= errorpro) {
                System.out.println("Numero inicial de trapecios= " + originaln);
                System.out.println("Numero final de trapecios= " + trapecios);
                System.out.println("No. de procesos= " + calculostotales);
                System.out.println("Valor Real de la Integral= " + VReal + " " + unidad);
                System.out.println("Error del problema= " + errorpro);
                System.out.println("Error del Método= " + errorCalculado);
                System.exit(0);
            }
            if(calculostotales == procesoslim) {
                System.out.println("No hay aproximacion");
                System.exit(0);
            }
            trapecios = trapecios * 2;
            liminf = originala;
        } while(true);
	}
	static double funcion(double valor){
		return 40 + ( 8 * Math.sqrt(valor));
	}
}