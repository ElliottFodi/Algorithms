Heap Sort
Complexity (n log n) This is n log n complexity because the heap will always 
have the largest value in the heap as the root, which is then moved to the 
back of the array. This is done for all n values and it takes log n to restore 
the heap.

Heap sort is a sort used on a heap. If a heap is not given the sort will not work. 
It utilizes that properties of a heap to sort the array. Given a max heap the sort 
switches the root with the last element in the array and decrements the array 
length. This is done so the heap does not cycle the max value back to the root. 
Heapify is then called on the root which restores the heap properties and the next 
largest value is now the root. This process is repeated recursively until the heap 
is empty and the array is sorted.

To run:

If in windows navigate into the src direcotry 
Compile the program using javac
	javac HeapSort.java
and execute like a normal java program
	java HeapSort

The prgroam will prompt for an array size, this is the amount of numbers you would like to sort.
The program will generate 4 test cases using the input array size and out put the results.

NOTE: the array size entered must be greater then 50 and has not been tested with array sizes 
over 500,000.