import javax.swing.JOptionPane;

public class Main {

	static boolean carrega(int vetor[]) {
		// Popula o array colection
		for (int i = 0; i < vetor.length; i++) {
			String input = JOptionPane.showInputDialog("Digite os números da coleção.");
			vetor[i] = Integer.parseInt(input);
		}
		return true;
	}

	static void mostrar(int vetor[]) {
		System.out.println("-------------------------------------------------------");
		for (int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
			if (i == (vetor.length - 1)) {
				System.out.print("\n");
			}
		}
		System.out.println("-------------------------------------------------------");
	}

	static boolean inverter(int vetor[], boolean populated) {
		if (populated) {
			int range = vetor.length;

			// Determina o valor onde o laço deve parar
			int invertRange;
			if (range % 2 == 0) {
				invertRange = range / 2;
			} else {
				invertRange = (range - 1) / 2;
			}
			// Inverte as posições do Array
			for (int i = 0; i < (invertRange); i++) {
				int aux = vetor[i];
				vetor[i] = vetor[range - 1 - i];
				vetor[range - 1 - i] = aux;
			}
			return true;
		} else {
			System.out.println("Necessário popular o array antes de inverte-lo.");
			return false;
		}

	}

	static boolean ordenarBolha(int vetor[], boolean populated) {
		if (populated) {
			int range = vetor.length;
			for (int i = 0; i < range; i++) {
				for (int j = 0; j < range - 1; j++) {
					if (vetor[j] > vetor[j + 1]) {
						int aux = vetor[j];
						vetor[j] = vetor[j + 1];
						vetor[j + 1] = aux;
					}
				}
			}
			return true;
		} else {
			System.out.println("Necessário popular o array antes de contar os ímpares.");
			return false;
		}

	}

	static int contarPrimos(int vetor[]) {

		int prime = 0;
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] == 2) {
				prime += 1;
			} else {
				int aux = vetor[i] - 1;
				boolean primeBoolean = true;
				while (aux >= 2) {
					if ((vetor[i] % aux) == 0) {
						primeBoolean = false;
					}
					aux -= 1;
				}

				if (primeBoolean) {
					prime += 1;
				}
			}
		}
		return prime;
	}

	static int somarImpares(int vetor[]) {
		int odd = 0;
		for (int i = 0; i < vetor.length; i++) {
			if ((vetor[i] % 2) != 0) {
				odd += 1;
			}
		}
		return odd;
	}

	static boolean detonar(int vetor[], boolean populated) {

		if (populated) {
			// Despopula o array colection
			for (int i = 0; i < vetor.length; i++) {
				vetor[i] = 0;
			}
			System.out.println("Array resetado.");
		} else {
			System.out.println("Necessário popular o array.");
		}
		return false;

	}

	static int menor(int vetor[]) {
		int smaller = 0;
		for (int i = 0; i < vetor.length; i++) {
			if (i == 0) {
				smaller = vetor[i];
			} else if (vetor[i] < smaller) {
				smaller = vetor[i];
			}
		}
		return smaller;
	}

	static int fatorial(int smaller) {
		int fatSmaller = 1;
		for (int i = smaller; i > 0; i--) {
			fatSmaller *= i;
		}
		return fatSmaller;
	}

	public static void main(String[] args) {
		/*
		 * MENU: 1.POPULAR 2.MOSTRAR 3.INVERTER 4.ORDENAR CRESCENTE 5.CONTAR PRIMOS
		 * 6.SOMATORIO IMPARES 7.DETONAR 8.FATORIAL DO MENOR 9.VAZAR
		 */

		int[] collection = new int[10];
		boolean populated = false;
		int option = 0;
		String input;

		// Mostra um menu até que o usuário decida parar o programa
		do {
			input = JOptionPane.showInputDialog("Escolha uma ação:" + "\n1: POPULAR" + "\n2: MOSTRAR" + "\n3: INVERTER"
					+ "\n4: ORDENAR CRESCENTE" + "\n5: CONTAR PRIMOS" + "\n6: SOMATÓRIO ÍMPARES" + "\n7: DETONAR"
					+ "\n8: FATORIAL DO MENOR" + "\n9: Encerrar");

			option = Integer.parseInt(input);

			switch (option) {
			case 1:
				populated = carrega(collection);
				break;
			case 2:
				if (populated) {
					mostrar(collection);
				} else {
					System.out.println("Necessário popular o array antes de mostra-lo.");
				}
				break;
			case 3:
				if (inverter(collection, populated)) {
					System.out.println("Array invertido.");
				} else {
					System.out.println("Falha ao inverter o array.");
				}
				break;
			case 4:
				if (ordenarBolha(collection, populated)) {
					System.out.println("Array ordenado.");
				} else {
					System.out.println("Falha ao ordenar o array.");
				}
				break;
			case 5:
				if (populated) {
					System.out.println(
							"A quantidade de números primos contidos no array é de: " + contarPrimos(collection));
				} else {
					System.out.println("Necessário popular o array antes de contar os ímpares.");
				}
				break;
			case 6:
				if (populated) {
					System.out.println(
							"A quantidade de números ímpares contidos no array é de: " + somarImpares(collection));
				} else {
					System.out.println("Necessário popular o array antes de contar os ímpares.");
				}
				break;
			case 7:
				populated = detonar(collection, populated);
				break;
			case 8:
				if (populated) {
					int smaller = menor(collection);
					System.out.println(
							"O menor número do array é " + smaller + " \nO seu fatorial é: " + fatorial(smaller));
				} else {
					System.out.println("Necessário popular o array antes.");
				}
				break;
			}

		} while (option != 9);

	}

}