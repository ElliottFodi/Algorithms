Merge Sort
Complexity: (n log n) This is always n log n because Merge sort splits the array 
into sub arrays based on the data size.

Merge Sort sorts a list of numbers by recursively splitting the list into smaller 
and smaller sub arrays, until a comparison can be made between two numbers. After 
the set of small sub arrays is sorted then two sub arrays are combining together. 
During this combining phase the sorted numbers in each sub array are compared and 
placed into a new array sorted. This process is repeated recursively till the 
entire array that was broken into sub arrays is recombined. Thus the list is 
sorted.  

To run:

If in windows navigate into the src direcotry 
Compile the program using javac
	javac MergeSort.java
and execute like a normal java program
	java MergeSort

The prgroam will prompt for an array size, this is the amount of numbers you would like to sort.
The program will generate 4 test cases using the input array size and out put the results.

NOTE: the array size entered must be greater then 50 and has not been tested with array sizes 
over 500,000.