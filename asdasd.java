public class asdasd {
    public static void main(String [] args) {
        double[] datosUi = { // Estos son los datos Ui que usaremos para formar pares
            0.2594, 0.2661, 0.2737, 0.2740, 0.3109, 0.3263, 0.3276, 0.3321, 0.3358,
            0.3492, 0.3629, 0.3632, 0.3867, 0.3899, 0.3975, 0.4103, 0.4160, 0.4400,
            0.4522, 0.4802, 0.8049, 0.8086, 0.8097, 0.8135, 0.8413, 0.8767, 0.8972,
            0.9297, 0.9476, 0.9563, 0.9609, 0.9862, 0.9909, 0.9928, 0.4875, 0.4916,
            0.4927, 0.5319, 0.5645, 0.0619, 0.0824, 0.0856, 0.0994, 0.1250, 0.1294,
            0.1487, 0.1573, 0.1599, 0.1627, 0.1658, 0.1676, 0.2400, 0.5697, 0.6355,
            0.6776, 0.6831, 0.6963, 0.7215, 0.7564, 0.7604, 0.7652, 0.7821, 0.7901, 0.8017
        };

        int N = datosUi.length; // Declaramos N para usarlo en fórmulas posteriores, siendo N el tamaño de la muestra
        //int n = (int) Math.round(Math.sqrt(N/5.0)); // Declaramos n para usarlo en fórmulas posteriores
        int n = 5;

        // Formar los datos Ui+1 para tener los datos en pares
        double[] datosUi2 = new double[N];
        for (int i = 0; i < N-1; i++) {
            datosUi2[i] = datosUi[i+1]; 
        }
        datosUi2[N-1] = datosUi[0]; // El último dato se empareja con el primero para que no queden pares solos y tener la misma cantidad de pares que de número de datos

        double Eij = N / Math.pow(n, 2); // Calculamos Eij para fórmulas posteriores
        

        // Procedemos a calcular Oij (cantidad de pares por celda)
        int[] celdaEnX = new int [N]; 
        int[] celdaEnY = new int [N];
        for (int i = 0; i < N; i++) {
            celdaEnX[i] = (int) Math.floor(datosUi[i] * n) + 1; // Encontramos en qué celda de X se encuentra el primer dato del par
            celdaEnY[i] = (int) Math.floor(datosUi2[i] * n) + 1;// Encontramos en qué celda de Y se encuentra el segundo dato del par
        }
        
        int[] celda = {
            2,3,3,2,2,
            4,5,2,1,4,
            2,3,2,1,3,
            1,2,2,2,3,
            3,3,2,4,3
        };

        // Calculamos Xo ^2
        double [] vectorXoCuadrada = new double[celda.length];
        double xoCuadrada = 0;
        for (int i = 0; i < celda.length; i++) {
            vectorXoCuadrada[i] = Math.pow(celda[i]-Eij, 2) / Eij;
            xoCuadrada += vectorXoCuadrada[i];
        }

        System.out.println(xoCuadrada);
        System.out.println(xoCuadrada);

    }
}