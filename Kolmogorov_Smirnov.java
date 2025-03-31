public class Kolmogorov_Smirnov{

    public static void main(String[] args){

        //PROVISIONAL: declarar matriz con datos:
        double[] DatosUi = {0.0619, 0.0824, 0.0856, 0.0994, 0.125, 0.1294, 0.1487, 0.1573, 0.1599, 0.1627, 
            0.1658, 0.1676, 0.24, 0.2594, 0.2661, 0.2737, 0.274, 0.3109, 0.3263, 0.3276,
            0.3321, 0.3358, 0.3492, 0.3629, 0.3632, 0.3867, 0.3899, 0.3975, 0.4103,
            0.416, 0.44, 0.4522, 0.4802, 0.4875, 0.4916, 0.4927, 0.5319, 0.5645,
            0.5697, 0.6355, 0.6776, 0.6831, 0.6963, 0.7215, 0.7564, 0.7604,
            0.7652, 0.7821, 0.7901, 0.8017, 0.8049, 0.8086, 0.8097,
            0.8135, 0.8413, 0.8767, 0.8972, 0.9297, 0.9476,
            0.9563, 0.9609, 0.9862, 0.9909, 0.9928};

        //Utilizar matriz con datos para determinar i/N y Di

        double iN[] = new double[DatosUi.length];
        double Di[] = new double[DatosUi.length];

        //Impresion del encabezado de la tabla
        System.out.println("-------------------------------------------------");
        System.out.printf("|%-10s |%-10s |%-10s |%-10s |%n", "i", "Ui", "i/N", "Di");
        System.out.println("-------------------------------------------------");

        //rellenar matrices iN y Di
        double d=0;
        double nSig=0.05;
        double DN_a=0;
        for (int i=0; i<DatosUi.length; i++){
            d=i;
            iN[i]=(d+1)/DatosUi.length;
            Di[i]=Math.abs(DatosUi[i] - iN[i]);


            //Imprimir matrices
            System.out.printf("|%-10s |", i+1);
            System.out.printf("%-10.5f |", DatosUi[i]);
            System.out.printf("%-10.5f |", iN[i]);
            System.out.printf("%-10.5f |", Di[i]);
            System.out.println();
            System.out.println("-------------------------------------------------");
        }

        //Encontrar valor Di mas alto y su ubicacion en la matriz
        double DiMax=Di[0];
        int indice=0;
        for (int i=0; i<Di.length; i++){
            if (Di[i]>DiMax){
                DiMax=Di[i];
                indice=i;
            }
        }

        //Imprimir valores asociados con DiMax
        System.out.println("-------------------------------------------------");
        System.out.printf("|%-10s |%-10s |%-10s |%-10s |%n", "i", "Ui", "i/N", "Di");
        System.out.println("-------------------------------------------------");
        System.out.printf("|%-10s |", (indice+1));
        System.out.printf("%-10.5f |", DatosUi[indice]);
        System.out.printf("%-10.5f |", iN[indice]);
        System.out.printf("%-10.5f |", Di[indice]);
        System.out.println();
        System.out.println("-------------------------------------------------");

        //PRUEBA DE BONDAD DE AJUSTE(Determinar DN_a, y si D < DN,a se acepta H0, en caso contrario se rechaza)
        if (DatosUi.length>30 && nSig == 0.05)
        DN_a=1.36/Math.sqrt(DatosUi.length);
        else if(DatosUi.length>30 && nSig == 0.10)
        DN_a=1.22/Math.sqrt(DatosUi.length);
        else if(DatosUi.length>30 && nSig == 0.01)
        DN_a=1.63/Math.sqrt(DatosUi.length);

        //Impresion de datos mostrando DN_a y DiMax
        System.out.println("\nD = "+Di[indice]+"          D"+DatosUi.length+","+(nSig*100)+" = "+DN_a);
        if (Di[indice]>DN_a)
            System.out.println("D > D"+DatosUi.length+","+(nSig*100));
        else
            System.out.println("D < D"+DatosUi.length+","+(nSig*100));
        
            System.out.println("-------------------------------------------------");

        //Impresion de conclusion
        if(Di[indice]<DN_a)
            System.out.println("Se acepta H0, lo que significa que los numeros estan distribuidos uniformemente.");
        else 
            System.out.println("Se rechaza H0, lo que significa que los numeros no estan distribuidos uniformemente.");
    }
}