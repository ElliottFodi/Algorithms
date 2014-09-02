Quick Sort 
Complexity:  n log n Worst case n^2

Quick sort is an in place sorting algorithm that utilizes a pivot. The array is compared against 
the pivot and numbers less than the pivot are placed near the start of the array and numbers greater 
than the pivot are placed near the end of the array. After every number has been compared with the 
pivot, the pivot is then placed in the middle of these numbers. It should be noted at this time the 
pivot is now correctly sorted. The algorithm then calls itself recursively as long as the two sub 
arrays that were created are unsorted.

To run:

If in windows navigate into the src direcotry 
Compile the program using javac
	javac QuickSort.java
and execute like a normal java program
	java QuickSort

The prgroam will prompt for an array size, this is the amount of numbers you would like to sort.
The program will generate 4 test cases using the input array size and out put the results.

NOTE: the array size entered must be greater then 50 and has not been tested with array sizes 
over 500,000.
