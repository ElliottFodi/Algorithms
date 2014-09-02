import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class FloydWarshalls {

	public static void main(String[] args) {

		int[][] original = getInput();
		int[][] result = original;
		int nodes = original.length;
		double time1 = System.nanoTime();

		// call floyd-warshalls algorithm
		for (int i = 0; i < nodes - 1; i++) {
			result = floydwarshalls(original, result, nodes);
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

	// floyd warshall's algorithm
	public static int[][] floydwarshalls(int[][] originalAdjacencyMatrix, int[][] newAdjacencyMatrix, int numberOfNodes) {
		int[][] shortestPathMatrix = new int[numberOfNodes][numberOfNodes];
		int[] rowOfOldMatrix = new int[numberOfNodes];
		PriorityQueue<Integer> min = new PriorityQueue<Integer>();

		for (int i = 0; i < numberOfNodes; i++) {

			for (int j = 0; j < numberOfNodes; j++) {
				rowOfOldMatrix[j] = originalAdjacencyMatrix[i][j];
			}

			for (int j = 0; j < numberOfNodes; j++) {
				for (int k = 0; k < numberOfNodes; k++) {
					if (newAdjacencyMatrix[k][j] == Integer.MAX_VALUE
							|| rowOfOldMatrix[k] == Integer.MAX_VALUE) {
						min.add(Integer.MAX_VALUE);
					} else {
						min.add(newAdjacencyMatrix[k][j] + rowOfOldMatrix[k]);
					}
				}
				shortestPathMatrix[i][j] = min.remove();
				min.clear();
			}
		}

		return shortestPathMatrix;
	}

	// function to get and format input for floyd-warshall algorithm
	public static int[][] getInput() {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		int[][] adjacencyMatrix;
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
		adjacencyMatrix = new int[nodes][nodes];
		for (int i = 0; i < nodes; i++) {
			for (int j = 0; j < nodes; j++) {
				adjacencyMatrix[i][j] = Integer.MAX_VALUE;
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
				adjacencyMatrix[linesParsed[0]][linesParsed[1]] = linesParsed[2];
			}
			for (int i = 0; i < nodes; i++) {
				adjacencyMatrix[i][i] = 0;
			}

		} catch (IOException ioe) {

		}
		return adjacencyMatrix;
	}

}
