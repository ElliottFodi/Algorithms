import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TransitiveClosure {

	public static void main(String[] args) {

		boolean[][] original = getInput();
		boolean[][] result = original;
		int nodes = original.length;
		System.out.println(nodes);

		double time1 = System.nanoTime();
		
		for (int i = 0; i < nodes - 1; i++) {
			result = transitiveClosure(original, result, nodes);
		}
		
		double time2 = System.nanoTime();

		for (int i = 0; i < nodes; i++) {
			for (int j = 0; j < nodes; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("\ntime: " + ((time2 - time1) / .000001)
				+ " Miliseconds");
	}

	// transitive closure function
	public static boolean[][] transitiveClosure(boolean[][] originalAdjacencyMatrix, boolean[][] newAdjacencyMatrix, int numberOfNodes) {
		boolean[][] shortestPathMatrix = new boolean[numberOfNodes][numberOfNodes];
		boolean[] rowOfOriginalMatrix = new boolean[numberOfNodes];

		for (int i = 0; i < numberOfNodes; i++) {

			for (int j = 0; j < numberOfNodes; j++) {
				rowOfOriginalMatrix[j] = originalAdjacencyMatrix[i][j];
			}

			for (int j = 0; j < numberOfNodes; j++) {
				boolean result = false;
				for (int k = 0; k < numberOfNodes; k++) {

					if ((newAdjacencyMatrix[k][j] && rowOfOriginalMatrix[k]) == true) {
						result = true;
						break;
					}
				}

				shortestPathMatrix[i][j] = result;
				result = false;
			}
		}

		return shortestPathMatrix;
	}

	// gets input from standard input and formats it for transitive closure function
	public static boolean[][] getInput() {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] adjacencyMatrix;
		String line = "";
		int nodes = 0;
		int edges = 0;

		try {
			line = bReader.readLine();
			String[] firstLine = line.split(" ");
			nodes = Integer.parseInt(firstLine[0]);
			edges = Integer.parseInt(firstLine[1]);
		} catch (IOException ioe) {

		}
		adjacencyMatrix = new boolean[nodes][nodes];
		for (int i = 0; i < nodes; i++) {
			for (int j = 0; j < nodes; j++) {
				adjacencyMatrix[i][j] = false;
			}
		}
		try {
			for (int i = 0; i < edges; i++) {
				line = bReader.readLine();
				String[] lines = line.split(" ");
				int[] linesParsed = new int[lines.length];
				for (int j = 0; j < lines.length; j++) {
					linesParsed[j] = Integer.parseInt(lines[j]);
				}

				adjacencyMatrix[linesParsed[0]][linesParsed[1]] = true;
			}
			for (int i = 0; i < nodes; i++) {
				adjacencyMatrix[i][i] = true;
			}

		} catch (IOException ioe) {

		}
		return adjacencyMatrix;
	}

}
