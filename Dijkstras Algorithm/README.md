Dijkstra's Algorithm
Complexity:  (|V|)^2 
The run time is determined by the amount of nodes.

This algorithm finds the minimum distance from one node (source node) to all other 
nodes in the graph. It starts by examining all nodes directly connected to the source 
node and recording their distances/weights from the source node. The distances/weights 
are kept in table (min distance to a given node) Once all nodes have been examined 
the min distance in the distance table it found. The path to this node is considered 
complete and it becomes the source node to be examined. The process is repeated 
updating the distance table for all adjacent nodes. If a new path to an existing node 
is found with a better distance, the distance table is updates again. This process 
is repeated until every node in the graph has been examined . Nodes that are not 
connected to the graph or are unreachable in a directed graph will have a distance 
of infinity. 

Input File
The program accepts a .txt file as the input. The format is as follows
The first line list 8 as the number of nodes and 14 as the number of edges
The following lines are edges with there wight, 0 being node 0 and 1 being 
node 1. Forming edge 0-1 with a weight on 20.

8 14
0 1 20
0 3 80
0 6 90
1 5 10 
2 5 50
2 7 20
2 3 10
3 2 10
3 6 20
4 1 50
4 6 30
5 2 10
5 3 40 
6 0 20

answer 20 40 50 infin 30 70 60

THE INPUT FILE SHOULD BE IN THE SAME DIRECTORY WORKING DIRECTORY
AS THER PROGRAM IS BREING RUN IN

To run:

If in windows navigate into the src direcotry 
Compile the program using javac
	javac Dijkstras.java
and execute like a normal java program
	java Dijkstras < input.txt

If the input file is not formated correctly the program will through an error.

NOTE: This program has been tested with 100 nodes and 4950 edges maximum. 
