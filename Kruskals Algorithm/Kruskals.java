import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Kruskals {

	public static void main(String[] args) {

		
		data passedData = getInput();
		int nodes = passedData.getNodes();
		int edges = passedData.getEdges();
		PriorityQueue<edge> edgePQ = passedData.getPQ();
		double time1 = System.nanoTime();

		results finalResults = Kruskals(edgePQ, edges, nodes);
		
		double time2 = System.nanoTime();
		ArrayList<edge> resultArrayList = finalResults.getEdgeArrayList();
		for( int i = 0; i < resultArrayList.size(); i++){
			System.out.println(resultArrayList.get(i).vertex1 +" "+ resultArrayList.get(i).vertex2);
		}
		
		System.out.println("Min Cost: " + finalResults.minCost);
		System.out.println("\ntime: " + ((time2 - time1)/.000001) + " Miliseconds");
		
	}
	
	// kruskals algorithm
	public static results Kruskals(PriorityQueue<edge> edgePriorityQueue, int numberOfEdges, int numberOfVerticies){
		int largestSetSize = 0;
		set[] sets = new set[numberOfVerticies];
		for( int i = 0; i < numberOfVerticies; i++){
			sets[i] = new set(i);
		}
		
		PriorityQueue<edge> edgePQ = edgePriorityQueue;
		ArrayList<edge> edgesUsed = new ArrayList<edge>();
		int minCost = 0;
		
		// loop over all edges and construct the final set
		for(int i = 0; i < numberOfEdges; i++){
			
			edge currentMinEdge = edgePQ.remove();
			int vertex1 = currentMinEdge.vertex1;
			int vertex2 = currentMinEdge.vertex2;
			int v1Parent = findParent(sets, vertex1);
			int v2Parent = findParent(sets, vertex2);
			if(v1Parent != v2Parent ){
				largestSetSize = union(sets, v1Parent, v2Parent);
				minCost += currentMinEdge.getWeight();
				edgesUsed.add(currentMinEdge);
			}
			v1Parent = findParent(sets, vertex1);
			v2Parent = findParent(sets, vertex2);
			
			if(largestSetSize == numberOfVerticies){
				break;
			}
		}
		results finalResults = new results(edgesUsed, minCost);
		return finalResults;
	}
	
	// edge class contains the vertices of an edge and its weight
	public static class edge implements Comparable<edge>{
		
		int vertex1 = 0;
		int vertex2 = 0;
		int weight = 0;
		
		public edge(int vertexOne, int vertexTwo, int weightOfEdge){
			this.vertex1 = vertexOne;
			this.vertex2 = vertexTwo;
			this.weight = weightOfEdge;
		}
		
		public int getVertex1(){
			return vertex1;
		}
		public int getVertex2(){
			return vertex2;
		}
		public int getWeight(){
			return weight;
		}
		
		//@Override
		public int compareTo(edge o) {
			edge compareEdge = (edge) o;
			return this.weight - compareEdge.weight;
			
		}
	}
	
	// set: union find function
	public static class set{
		int parent = 0;
		int name = 0; 
		int size = 1;
		
		public set(int nodeName){
			this.name = nodeName;
			this.parent = nodeName;
		}
		public void updateParent(int newParent){
			this.parent = newParent; 
		}
		public void updateSize(int newSize){
			this.size = newSize;
		}
		
	}
	
	// find: union find function
	public static int  findParent(set[] sets, int node){
		if(sets[node].parent == sets[node].name){
			return sets[node].name;
		}else{
			int result = findParent(sets, sets[node].parent); 
			sets[node].updateParent(result);
			return result ;
		}
	}
	
	//union: union find function
	public static int union(set[] sets, int nodeA, int nodeB){
		int aSize = sets[nodeA].size;
		int bSize = sets[nodeB].size;
		if (aSize > bSize){
			sets[nodeB].updateParent(sets[nodeA].name);
			sets[nodeA].updateSize(sets[nodeA].size + sets[nodeB].size);
			return sets[nodeA].size;
		}else if(bSize > aSize ){
			sets[nodeA].updateParent(sets[nodeB].name);
			sets[nodeB].updateSize(sets[nodeB].size + sets[nodeA].size); 
			return sets[nodeB].size;
		}else{
			sets[nodeB].updateParent(sets[nodeA].name);
			sets[nodeA].updateSize(sets[nodeA].size + sets[nodeB].size); 
			return sets[nodeA].size;
		}
		
	}
	
	// gets the input from standard input and formats it accordingly 
	public static data getInput(){
		 BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		 PriorityQueue<edge> edgePQ = new PriorityQueue<edge>();
		 String line = "";
		 int nodes = 0;
	     int edges = 0;
	     
	     try{
	    	 line = bReader.readLine();
	         String[] firstLine = line.split(" ");
	         nodes = Integer.parseInt(firstLine[0]);
	         edges = Integer.parseInt(firstLine[1]);
	         for( int i = 0; i < edges; i++){
	        	 line = bReader.readLine();
		         String[] lines = line.split(" ");
		         int[] linesParsed = new int[lines.length];
		         for(int j =0; j < lines.length; j++  ){
		        	 linesParsed[j] = Integer.parseInt(lines[j]);
		         }
	        	 edgePQ.add(new edge(linesParsed[0], linesParsed[1], linesParsed[2]));
	     	 }
	     }catch(IOException ioe){
	    	 
	     }
	     data returnedData = new data(edgePQ, nodes, edges);
	     
		return returnedData;
	}
	
	// class used to pass the resulting data from input function to main
	public static class data{
		PriorityQueue<edge> priorityQ;
		
		int numberOfNodes = 0;
		int numberOfEdges = 0;
		
		public data(PriorityQueue<edge> PQ, int nodes, int edges){
			this.priorityQ = PQ;
			this.numberOfNodes = nodes;
			this.numberOfEdges = edges;
		}
		
		public int getNodes(){
			return numberOfNodes;
		}
		public int getEdges(){
			return numberOfEdges;
		}
		public PriorityQueue<edge> getPQ(){
			return priorityQ;
		}
	}
	
	// class used to pass the resulting data from kruskals function to main
	public static class results{
		ArrayList<edge> resultList;
		int minCost = 0;
		
		public results(ArrayList<edge> resultArrayList, int minimumCost){
			this.resultList = resultArrayList;
			this.minCost = minimumCost;
		}
		
		public int getMinCost(){
			return minCost;
		}
		public ArrayList<edge> getEdgeArrayList(){
			return resultList;
		}
	}

}
