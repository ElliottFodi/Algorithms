Transitive Closure
Complexity V^3
The run time is dependent on the number of vertices. Since this is a variation of the 
Floyd-Warshall algorithm, the complexity is the same.

This algorithm finds if a path exists from a node to all possible other nodes. This 
algorithm is a variation of the Floyd-Warshall algorithm. Again it increases the 
amount if nodes reachable by a value of K. As K increases more paths are discovered. 
If run n -1 times all paths to all nodes will be discovered. It should be noted that 
it does this with no cycles. This algorithm utilizes and adjacency matrix but the 
matrix is composed of 1 and 0. 1 if a path exists and 0 if a path does not exist. The 
matrices are the multiplied except the operators are changed again. In this algorithm 
multiplication is logical AND and sum is logical OR. The rest of the process is the 
same as the Floyd -Warshall algorithm. Since this algorithm uses logical operators 
the run time for this algorithm is less than the Floyde-Warshall algorithm. 

Input File
The program accepts a .txt file as the input. The format is as follows
The first line list 4 as the number of nodes and 5 as the number of edges
The following lines are edges, 0 being node 0 and 1 being 
node 1, forming edge 0-1. 

4 5
0 1
0 2
1 2
1 3
2 3

answer for first row : 1 1 1 1 

THE INPUT FILE SHOULD BE IN THE SAME DIRECTORY WORKING DIRECTORY
AS THER PROGRAM IS BREING RUN IN

To run:

If in windows navigate into the src direcotry 
Compile the program using javac
	javac TransitiveClosure.java
and execute like a normal java program
	java TransitiveClosure < input.txt

If the input file is not formated correctly the program will through an error.

NOTE: This program has been tested with 100 nodes and 4950 edges maximum. 