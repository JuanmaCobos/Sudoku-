import java.util.Scanner;

public class Sudoku1 {

	static int tam = 9;

	public static void main(String[] args) {

		// mostrar el tiempo aquí  ***********************************
		int[][] matriz = new int[tam][tam];
		int[][] resuelta = { { 5,3,4,6,7,8,9,1,2}, {6,7,2,1,9,5,3,4,8 }, { 1,9,8,3,4,2,5,6,7}, {8,5,9,7,6,1,4,2,3},
				{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};

		System.out.println("Matriz para resolver");
		sorteo(matriz);

		System.out.println(" ");

		/*System.out.println("Matriz Resuelta");
		showresuelta(resuelta);*/

		// inicia la funcion que indica que  inicia la matriz
		rellenarmatriz(matriz, resuelta);

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
			System.out.println("coluna inexistente");
			preenche(matriz, resuelta); // numero novo
		}

		System.out.println("Digite o valor");
		int valor = p.nextInt();

		// VERIFICAR SE EXISTE O NUMERO NA POSICAO
		if (matriz[x][y] == 0) {

			matriz[x][y] = valor;
			System.out.println("Valor adicionado com sucesso! ");

			show(matriz); // mostrar a matriz toda vez que adicionar um
			preenche(matriz, resolvida); // numero novo

		} else {
			System.out.println("Ja existe valor nesta posicao");
			show(matriz);
			preenche(matriz, resuelta);

		}

	} // termino do metodo preenche

	// pelo numero da linha decidir sair ou chegar jogo
	public static void checar(int x, int[][] matriz, int[][] resolvida) {
		Scanner p = new Scanner(System.in);

		switch (x) {

		case 10:
			System.out.println("Voce deseja realmente sair do jogo? Se sim digite '0'.");
			int resposta = p.nextInt();

			if (resposta == 0) {
				System.exit(0);
				// saiu do jogo
				// MOSTRAR O TEMPO AQUI ***********************************
			} else {
				System.out.println("Vamos continuar o jogo entao.");

			}
			break;
		case 11:
			System.out.println("Vamos analisar seu jogo");
			terminado(matriz, resolvida);
			break;
		default:
			System.out.println("NÃºmero invalido. 10 - SAIR, 11- Checar, ou continue o jogo");
			preenche(matriz, resolvida);

		}

	}

	public static boolean terminado(int[][] matriz, int[][] resolvida) {

		// VERIFICAR SE A MATRIZ ESTA COMPLETA
		boolean resultado = true;

		for (int f = 0; f < matriz.length; f++) {
			for (int c = 0; c < matriz.length; c++) {
				if (matriz[f][c] == 0) {
					resultado = false;
					System.out.println("Matriz nao completa");
					show(matriz);
					preenche(matriz, resolvida);
				} else {

				}
			}

		}
		System.out.println("Matriz Completa. Vamos verificar os dados");

		verificador(matriz, resolvida);
		return resultado;

	}

	// VERIFICAR SE A MATRIZ E IGUAL A RESOLVIDA
	public static void verificador(int[][] matriz, int[][] resolvida) {
		Scanner s = new Scanner(System.in);

		int erro = 0;
		int certo = 0;
		int restante = 6;

		for (int i = 0; i < tam; i++) {
			for (int c = 0; i < matriz.length; c++) {
				// System.out.println("matriz" + matriz[i][c]);
				// System.out.println("resolvida" + resolvida[i][c]);
				if (matriz[i][c] == resolvida[i][c]) {
					certo++;
					System.out.println(" matriz" + "[" + i + "]" + "[" + c + "]" + "resolvida" + "[" + i + "]" + "[" + c
							+ "]" + "numero " + matriz[i][c]);

					if (certo == restante) {
						System.out.println("PARABÉNS! Você concluiu o jogo.");
						System.out.println("Se deseja jogar novamente digite 'S'. ");
						char novo = s.next().charAt(0);
						if (novo == 'S' || novo == 's') {
							show(matriz);
							preenche(matriz, resolvida);
						}
					}

				} else {

					erro++;
				}

			}
		}
		
		int totaldeintentos = certo+erro; 
		trocaValores(matriz, resolvida);
		System.out.print("Total de intentos=" + totaldeintentos +"Chutes errado=" + erro + "intentos correctos=" + certo);

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

	public static void trocaValores(int[][] matriz, int[][] resolvida) {
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
			preenche(matriz, resolvida); // numero nuevo

		}

	}

} // fin de main