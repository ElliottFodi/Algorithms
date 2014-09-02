import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstras {

	public static void main(String[] args) {

		int numberOfNodes = 8;
		int source = 0;
		vertex[] graph = getInput();
		numberOfNodes = graph.length;
		source = graph[0].getName();
		double time1 = System.nanoTime();

		int[] distance = DijkstrasShortestPath(graph, source, numberOfNodes);
		
		double time2 = System.nanoTime();

		for (int i = 0; i < distance.length; i++) {
			System.out.print(distance[i] + " ");
		}

		System.out.println("time: " + ((time2 - time1) / .000001)
				+ " Miliseconds");
	}

	// Dijkstra's algorithm function
	public static int[] DijkstrasShortestPath(vertex[] graph, int sourceNode, int numberOfNodes) {
		int infinity = Integer.MAX_VALUE;
		int[] distance = new int[numberOfNodes];
		PriorityQueue<vertex> unCompleteNodes = new PriorityQueue<vertex>();
		vertex currentVertex = graph[sourceNode];

		for (int i = 0; i < distance.length; i++) {
			distance[i] = infinity;
			graph[i].setCurrentBestDistanceToThisNode(infinity);
			if (i == sourceNode) {
				// distance to the source vertex is 0.
				graph[i].setCurrentBestDistanceToThisNode(0);
				distance[currentVertex.getName()] = 0;
			}
			// add each node to the priority queue
			unCompleteNodes.add(graph[i]);
		}

		// remove the source vertex from the priority queue
		unCompleteNodes.remove();

		// while there are nodes in the priority queue loop
		while (unCompleteNodes.isEmpty() != true) {
			ArrayList<Integer> adjNodes = currentVertex.getAdjNodes();
			int adjNodeIndex = 0;
			for (int i = 0; i < adjNodes.size(); i++) {
				adjNodeIndex = adjNodes.get(i);

				if (distance[adjNodeIndex] == infinity) {
					distance[adjNodeIndex] = currentVertex
							.getWeightOfAdjacentNode(adjNodeIndex)
							+ distance[currentVertex.getName()];
					// update distance in priority queue
					unCompleteNodes.remove(graph[adjNodeIndex]);
					graph[adjNodeIndex]
							.setCurrentBestDistanceToThisNode(distance[adjNodeIndex]);
					unCompleteNodes.add(graph[adjNodeIndex]);

				} else if (currentVertex.getWeightOfAdjacentNode(adjNodeIndex)
						+ distance[currentVertex.getName()] < distance[adjNodeIndex]) {
					distance[adjNodeIndex] = currentVertex
							.getWeightOfAdjacentNode(adjNodeIndex)
							+ distance[currentVertex.getName()];
					// update distance in priority queue
					unCompleteNodes.remove(graph[adjNodeIndex]);
					graph[adjNodeIndex]
							.setCurrentBestDistanceToThisNode(distance[adjNodeIndex]);
					unCompleteNodes.add(graph[adjNodeIndex]);
				}
			}

			// remove the node with the smallest distance, this is now complete
			// and becomes the source node
			adjNodes.clear();
			currentVertex = unCompleteNodes.remove();
		}
		return distance;
	}

	// class vertex represents a vertex and contains all of its adjacent nodes
	public static class vertex implements Comparable<vertex> {
		int vertexName = -1;
		int NumberOfEdges = 0;
		int discoveredFromNode = -1;
		int currentBestDistanceToThisNode = -1;

		ArrayList<Integer> adjacentNodes = new ArrayList<Integer>();
		ArrayList<Integer> adjacentNodesWeights = new ArrayList<Integer>();

		public vertex(int name) {
			this.vertexName = name;
		}

		public void addNode(int node, int weight) {
			this.adjacentNodes.add(node);
			this.adjacentNodesWeights.add(weight);
			this.NumberOfEdges++;
		}

		public int getWeightOfAdjacentNode(int node) {
			int index = adjacentNodes.indexOf(node);
			return adjacentNodesWeights.get(index);
		}

		public ArrayList<Integer> getAdjNodes() {
			return adjacentNodes;
		}

		public int getName() {
			return vertexName;
		}

		public int getCurrentBestDistanceToThisNode() {
			return currentBestDistanceToThisNode;
		}

		public void setCurrentBestDistanceToThisNode(
				int newCurrentBestDistanceToThisNode) {
			this.currentBestDistanceToThisNode = newCurrentBestDistanceToThisNode;
		}

		// @Override
		public int compareTo(vertex o) {
			vertex compareVertex = (vertex) o;
			return this.currentBestDistanceToThisNode
					- compareVertex.currentBestDistanceToThisNode;

		}
	}

	// gets the graph from standard input and formats it as required by the algorithm function
	public static vertex[] getInput() {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

		String line = "";
		int nodes = 0;
		int edges = 0;
		try {
			line = bReader.readLine();
			String[] firstLine = line.split(" ");
			nodes = Integer.parseInt(firstLine[0]);
			edges = Integer.parseInt(firstLine[1]);
			System.out.println("\nNodes: " + nodes + " Edges: " + edges);
		} catch (IOException ioe) {

		}

		vertex[] graph = new vertex[nodes];
		for (int i = 0; i < nodes; i++) {
			graph[i] = new vertex(i);
		}

		try {

			for (int i = 0; i < edges; i++) {
				line = bReader.readLine();
				String[] lines = line.split(" ");
				int[] linesParsed = new int[lines.length];
				for (int j = 0; j < lines.length; j++) {
					linesParsed[j] = Integer.parseInt(lines[j]);
				}

				graph[linesParsed[0]].addNode(linesParsed[1], linesParsed[2]);
			}

		} catch (IOException ioe) {
			System.out.println("IO error");
			System.exit(1);
		}

		for (int i = 0; i < graph.length; i++) {
			System.out.println(graph[i].vertexName + " "
					+ graph[i].NumberOfEdges);
		}

		return graph;
	}

}
