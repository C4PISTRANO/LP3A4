
// ALGORITMO BANQUEIRO EXERCICIO
import java.util.Scanner;

public class BankerAlgorithm {
	private int numProcesses; // número de processos
	private int numResources; // número de recursos
	private int[][] allocation; // matriz de alocação
	private int[][] max; // matriz de máxima necessidade
	private int[] available; // vetor de recursos disponíveis
	private boolean[] isSafe; // vetor que indica se um processo é seguro

	public void initializeValues() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o número de processos: ");
		numProcesses = scanner.nextInt();
		System.out.print("Digite o número de recursos: ");
		numResources = scanner.nextInt();
		allocation = new int[numProcesses][numResources];
		max = new int[numProcesses][numResources];
		available = new int[numResources];
		isSafe = new boolean[numProcesses];
		System.out.println("Digite a matriz de alocação:");
		readMatrix(scanner, allocation);
		System.out.println("Digite a matriz de máxima necessidade:");
		readMatrix(scanner, max);
		System.out.println("Digite o vetor de recursos disponíveis:");
		readVector(scanner, available);
	}

	public void calculateNeed(int[][] need) {
		for (int i = 0; i < numProcesses; i++) {
			for (int j = 0; j < numResources; j++) {
				need[i][j] = max[i][j] - allocation[i][j];
			}
		}
	}

	public void execute() {
		int[][] need = new int[numProcesses][numResources];
		calculateNeed(need);
		int[] work = available.clone();
		int count = 0;
		while (count < numProcesses) {
			boolean found = false;
			for (int i = 0; i < numProcesses; i++) {
				if (!isSafe[i]) {
					boolean canExecute = true;
					for (int j = 0; j < numResources; j++) {
						if (need[i][j] > work[j]) {
							canExecute = false;
							break;
						}
					}
					if (canExecute) {
						isSafe[i] = true;
						found = true;
						count++;
						for (int j = 0; j < numResources; j++) {
							work[j] += allocation[i][j];
						}
					}
				}
			}
			if (!found) {
				break;
			}
		}
		if (count < numProcesses) {
			System.out.println("O sistema está inseguro!");
		} else {
			System.out.println("O sistema está seguro!");
		}
	}

	public void readMatrix(Scanner scanner, int[][] matrix) {
		for (int i = 0; i < numProcesses; i++) {
			for (int j = 0; j < numResources; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
	}

	public void readVector(Scanner scanner, int[] vector) {
		for (int i = 0; i < numResources; i++) {
			vector[i] = scanner.nextInt();
		}
	}

	public static void main(String[] args) {
		BankerAlgorithm banker = new BankerAlgorithm();
		banker.initializeValues();
		banker.execute();
	}
}
