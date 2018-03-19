import java.util.Scanner;

public class Sudoku1 {

	static int tam = 9;

	public static void main(String[] args) {
                //Francis yo no tenia idea de como hacerla he usado una y la he comentado entera
		// mostrar el tiempo aquí  ***********************************
		int[][] matriz = new int[tam][tam];
		int[][] resuelta = { { 5,3,4,6,7,8,9,1,2}, {6,7,2,1,9,5,3,4,8 }, { 1,9,8,3,4,2,5,6,7}, {8,5,9,7,6,1,4,2,3},
				{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};

		System.out.println("Sudoku");
		sorteo(matriz);

		System.out.println(" ");

		/*System.out.println("Matriz Resuelta");
		showresuelta(resuelta);*/

		// inicia la funcion que indica que  inicia la matriz
		rellena(matriz, resuelta);

	}

	// sor
	public static void sorteo(int[][] matriz) {

		matriz[0][0]=5;matriz[0][1]=3;matriz[0][4]=7;
		matriz[1][0]=6;matriz[1][3]=1;matriz[1][4]=9;matriz[1][5]=5;
		matriz[2][1]=9;matriz[2][2]=8;matriz[2][7]=6;
	        
		matriz[3][0]=8;matriz[3][4]=6;matriz[3][8]=6;
		matriz[4][0]=4;matriz[4][3]=8;matriz[4][5]=3;matriz[4][8]=1;
		matriz[5][0]=7;matriz[5][4]=2;matriz[5][8]=6;
	        
		matriz[6][1]=6;matriz[6][6]=2;matriz[6][7]=8;
		matriz[7][3]=4;matriz[7][4]=1;matriz[7][5]=9;matriz[7][8]=5;
		matriz[8][4]=8;matriz[8][7]=7;matriz[8][8]=9;
					
		
		

		show(matriz);
                //muestra la matriz
	}

	// Esta función hace aparte el dibujo de la matriz
	public static void show(int[][] matriz) {

		System.out.println( "  0 1 2 3 4 5 6 7 8");
        System.out.println();
        
        for (int l=0;l<9;l++) {
            System.out.print(l + " ");
            for (int c=0;c<9;c++) {
                
                System.out.print(matriz[l][c] + "|");
            }
            System.out.println();
		}
	}

	// rellenar la matriz
	public static void renellarmatriz(int[][] matriz, int[][] resuelta) {
		Scanner p = new Scanner(System.in);

		System.out.println("Digita una linea");
		int x = p.nextInt();
		if (x > 9) {
			checar(x, matriz, resuelta);

		}

		System.out.println("Digite a coluna");
		int y = p.nextInt();
		if (y > 9 || y < 0) {
			System.out.println("columna inexistente");
			rellenar(matriz, resuelta); // numero novo
		}

		System.out.println("Digite o valor");
		int valor = p.nextInt();

		// VERIFICAR SE EXISTE numero y la posicion
		if (matriz[x][y] == 0) {

			matriz[x][y] = valor;
			System.out.println("Valor añadido com exito! ");

			show(matriz); // mostrar a matriz toda vez que adicionar um
			rellenar(matriz, resuelta); // numero nuevo

		} else {
			System.out.println("ya existe valor en esta posicion");
			show(matriz);
			rellenar(matriz, resuelta);

		}

	} // termino metodo de rellenar

	// decidimos si salimos del juego
	public static void checar(int x, int[][] matriz, int[][] resuelta) {
		Scanner p = new Scanner(System.in);

		switch (x) {

		case 10:
			System.out.println("Quieres salir del juego? Si es asi pulsa '0'.");
			int resposta = p.nextInt();

			if (resposta == 0) {
				System.exit(0);
				// salir del juego
				// Muestra tiempo AQUI ***********************************
			} else {
				System.out.println("Vamos continuar el juego.");

			}
			break;
		case 11:
			System.out.println("Vamos a comprobar");
			terminado(matriz, resuelta);
			break;
		default:
			System.out.println("Numero valido. 10 - SALIR, 11- Comprobar, o continuar el juego");
			rellenar(matriz, resuelta);

		}

	}

	public static boolean terminado(int[][] matriz, int[][] resuelta) {

		// verifica si la matriz esta resuelta
		boolean resultado = true;

		for (int f = 0; f < matriz.length; f++) {
			for (int c = 0; c < matriz.length; c++) {
				if (matriz[f][c] == 0) {
					resultado = false;
					System.out.println("Matriz esta completa");
					show(matriz);
					resuelta(matriz, resuelta);
				} else {

				}
			}

		}
		System.out.println("Matriz Completa. Vamos verificar los datos");

		verificador(matriz, resuelta);
		return resultado;

	}

	// Verificar si esta resuelta 
	public static void verificador(int[][] matriz, int[][] resuelta) {
		Scanner s = new Scanner(System.in);

		int error = 0;
		int acierto = 0;
		int restante = 6;

		for (int i = 0; i < tam; i++) {
			for (int c = 0; i < matriz.length; c++) {
				// System.out.println("matriz" + matriz[i][c]);
				// System.out.println("resuelta" + resuelta[i][c]);
				if (matriz[i][c] == resuelta[i][c]) {
					acierto++;
					System.out.println(" matriz" + "[" + i + "]" + "[" + c + "]" + "resuelta" + "[" + i + "]" + "[" + c
							+ "]" + "numero " + matriz[i][c]);

					if (acierto == restante) {
						System.out.println("Felicidades has acabado el juego.");
						System.out.println("Si quieres jugar de nuevo 'S'. ");
						char nuevo = s.next().charAt(0);
						if (nuevo == 'S' || nuevo == 's') {
							show(matriz);
							rellenar(matriz,resuelta);
						}
					}

				} else {

					error++;
				}

			}
		}
		//numero de fallos y aciertos
		int totaldeintentos = acierto+error; 
		trocaValores(matriz, resulelta);
		System.out.print("Total de intentos=" + totaldeintentos +"intentos erroneos=" + error + "intentos correctos=" + acierto);

	}

	public static void showresuelta(int[][] resuelta) {

		System.out.println( "  0 1 2 3 4 5 6 7 8");
        System.out.println();
        
        for (int l=0;l<9;l++) {
            System.out.print(l + " ");
            for (int c=0;c<9;c++) {
                
                System.out.print(resuelta[l][c] + "|");
            }
            System.out.println();
		}
	}

	public static void trocaValores(int[][] matriz, int[][] resuelta) {
		Scanner s = new Scanner(System.in);

		int numero = 0;
		int x = 0;
		int y = 0;

		System.out.println("Escriba qué línea tiene que agregar el valor");
		x = s.nextInt();
		if (x > 9) {
			checar(x, matriz, resuelta);

		}
		System.out.println("Escriba a que columna pertenece el valor");
		y = s.nextInt();
                // tienes que escribir a que columna pertenece el valor
		System.out.println("Introduzca el número para añadir al juego");
		// numero diferente de cero por que la matriz será rellenada con
		// cero

		if (numero != 0) {
			// numero diferente de cero se almacena y rellena
			matriz[x][y] = numero;
			show(matriz); // muestra la matriz
			resuelta(matriz, resuelta); // numero nuevo

		}

	}

} // fin de main