Kruskal's Algorithm 
Running Time: e log e
The run time is dependent on the number of edges

This algorithm finds the minimum cost to span the graph. It does this by 
identifying the minimum cost edges. The algorithm starts with a sorted list 
of all the edges in the graph (sorted by least cost to max cost). Each edge 
is then examined, this is where the algorithm utilizes Union Find. both 
nodes to compose an edge are added to a set. For every edge after the nodes 
are examined and if they belong to the same set then the edge is discarded. 
If the nodes are from different sets, the new node is added to the set. Union 
find is used to connect disjoint sets all of which are a part of the same 
graph. This process is repeated until the set is equal to the amount of nodes 
in the graph.

Input File
The program accepts a .txt file as the input. The format is as follows
The first line list 7 as the number of nodes and 12 as the number of edges
The following lines are edges with there wight, 0 being node 0 and 1 being 
node 1. Forming edge 0-1 with a weight on 3.

7 12
0 1 3
1 3 8
3 5 1
4 5 2
2 4 3
0 2 2
2 1 1
4 3 3
4 6 8
3 6 5
2 6 6
1 6 7

answer min cost : 14

THE INPUT FILE SHOULD BE IN THE SAME DIRECTORY WORKING DIRECTORY
AS THER PROGRAM IS BREING RUN IN

To run:

If in windows navigate into the src direcotry 
Compile the program using javac
	javac Kruskals.java
and execute like a normal java program
	java Kruskals < input.txt

If the input file is not formated correctly the program will through an error.

NOTE: This program has been tested with 100 nodes and 4950 edges maximum.