public class PruebaDeLasSeries {
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
        int n = (int) Math.round(Math.sqrt(N/5.0)); // Declaramos n para usarlo en fórmulas posteriores

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
        
        int[] celda = new int [(int) Math.pow(n, 2)]; // Declaramos un arreglo que para contar los pares dentro de cada celda
        for (int k = 0; k < N; k++) {
            int i = celdaEnX[k];
            int j = celdaEnY[k];

            int posicionCelda = (i - 1) * n + (j - 1); // Calculamos en qué celda está nuestro par
            celda[posicionCelda]++; // Contamos la celda
        }

        // Calculamos Xo ^2
        double [] vectorXoCuadrada = new double[celda.length]; // Declaramos un vector para aplicarle la formula a cada valor del vector celda 
        double xoCuadrada = 0;
        for (int i = 0; i < celda.length; i++) {
            vectorXoCuadrada[i] = Math.pow(celda[i]-Eij, 2) / Eij;
            xoCuadrada += vectorXoCuadrada[i]; // Sumamos cada valor del vector XoCuadrada para obtener el resultado
        }


        double [][] tablaChi ={        // Tabla chi cuadrada
            {1,3.841},   {2,5.991},	  {3,7.815},   {4,9.488},	{5,11.070}, 
            {6,12.592},	 {7,14.067},  {8,15.507},  {9,16.919},	{10,18.307}, 
            {11,19.675}, {12,21.026}, {13,22.362}, {14,23.685}, {15,24.996},
            {16,26.296}, {17,27.587}, {18,28.869}, {19,30.144}, {20,31.410},	
            {21,32.671}, {22,33.924}, {23,35.172}, {24,36.415}, {25,37.652},
            {26,38.885}, {27,40.113}, {28,41.337}, {29,42.557}, {30,43.773},
            {31,44.985}, {32,46.194}, {33,47.400}, {34,48.602}, {35,49.802},
            {40,55.758}, {50,67.500}, {60,79.1},   {100,124.3}
        };

        double gl = Math.pow(n, 2) - 1; // gl = grados de libertad

        double valorAComparar = 0;      // Aqui obtendremos el valor de la tabla chi cuadrada que vamos a comparar con el valor que calculamos en nuestro código
        for (int i = 0; i < tablaChi.length; i++) {
            if (tablaChi[i][0] == gl) {
                valorAComparar = tablaChi[i][1];
                break;
            }
        }
        
        // Comparamos nuestra Chi calculada con la Chi de la tabla
        System.out.println("¿ " + xoCuadrada + " > " + valorAComparar + " ?");
        if (xoCuadrada > valorAComparar) {
            System.out.println("Si. Rechazamos la hipótesis nula, puesto que existen diferencias significativas.");
        } else {
            System.out.println("No. No rechazamos la hipótesis nula, puesto que no hay diferencias significativas.");
        }
    }
}