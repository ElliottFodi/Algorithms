My Sort
Running Time: Complexity:  (n log n) Worst case (n^2)
It should be noted that this improvement is used to avoid the worst case but cannot 
completely prevent the random chance of the worst case happening. It does how every 
drastically improve the running time on a sorted list closer to (n log n).

My Sort is an improvement on Quick Sort. In traditional quick sort the pivot is selected 
as the first or last element for the list of numbers being sorted. If the list is a sorted 
list, this can cause Quick sort to give its worst case running time. By randomly selecting 
the pivot Quick sort’s running time can be improved when sorting an in order list. Its 
running time on a random list of numbers will be similar to normal Quick Sort. Aside from 
randomly choosing the pivot the rest of the algorithm will behave just as normal Quick Sort.

To run:

If in windows navigate into the src direcotry 
Compile the program using javac
	javac MySort.java
and execute like a normal java program
	java MySort

The prgroam will prompt for an array size, this is the amount of numbers you would like to sort.
The program will generate 4 test cases using the input array size and out put the results.

NOTE: the array size entered must be greater then 50 and has not been tested with array sizes 
over 500,000.