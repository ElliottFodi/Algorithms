Floyd-Warshall's Algorithm
Complexity:  V^3
The run time is dependent on the amount of vertices. Since the algorithm works 
with adjacency matrixes.  

This algorithm finds a shortest paths for all pairs (all pairs shortest path). 
It stars with finding the shortest path to each adjacent node. It then increases 
the amount of nodes search able by a value of K. As K increase it can find a 
minimum path to K nodes away. This is accomplished using adjacency matrixes. An 
adjacency matrix is constructed for the entire graph. This matrix multiplication 
is then performed except the operators are changed. Addition is used instead of 
multiplication and Minis used instead of Sum. This finds the minimum cost to a 
given node. This results in m * m == m^2. The process is then repeated K times. 
The only difference is the original matrix is multiplied by the result of the 
previous multiplication. m * m^2 == m^3. This is repeated n -1 times to find a 
pairs shortest paths.

Input File
The program accepts a .txt file as the input. The format is as follows
The first line list 4 as the number of nodes and 5 as the number of edges
The following lines are edges with there wight, 0 being node 0 and 1 being 
node 1. Forming edge 0-1 with a weight on 2.

4 5
0 1 2
0 2 5
1 2 1
1 3 8
2 3 4

answer for first row : 0 2 3 9

THE INPUT FILE SHOULD BE IN THE SAME DIRECTORY WORKING DIRECTORY
AS THER PROGRAM IS BREING RUN IN

To run:

If in windows navigate into the src direcotry 
Compile the program using javac
	javac FloydWarshalls.java
and execute like a normal java program
	java FloydWarshalls< input.txt

If the input file is not formated correctly the program will through an error.

NOTE: This program has been tested with 100 nodes and 4950 edges maximum. 