Compute the optimum solution for placing a word on a line that minimizes the amount 
of slack on each line. The sum of the squares of the slacks should be minimized.

The text can be visualized in the following manner. From i to j is some string of 
words, where i is the start of the string and j is the end of the string. If j 
starts with word one and increases to the last word, every placement combination 
of the words must be tested. There for as j increases the end of the text i 
iterates over all of the previous j values testing for a new optimum solution. 
The optimum solution for the placement of words is calculated and stored every 
time j is increased and these values are stored in an array. The Index of i at 
which the optimal solution for a given j is also stored. Once j and i have reached 
the end of the text the optimal configuration can be found by recursively back 
tracking through the stored optimal solutions.

Input: text to optimize, Length of a line in characters

FOR  j = 0 to (end of text)

	For i = 0 to j

		Compute the length of the current i to j string
		
		Compute the slack  and square it

		if the string exceeds the allotted line length set its slack 
		to infinity and store the value

		if i = 0 store only the slack value

		if i > 0 store the slack plus the previous calculated optimum 
		solution for i

	
	When the for loop for i terminates get then min of the stored solutions, 
	this is the optimum 	solution for the given j

	The corrisponding index for the optimal solution is the index in the 
	array, this must also be stored

	When the for loop for j terminates recursively back track through the 
	optimal solutions to find the optimal placement of the words.

	Max = total amount of words
	Start = the starting position returned by the stored Index value for Max.
	
	for start to Max 
		store the last line
	Max = start -1
	
	Print all of the stored string in order 
END

The process of finding the optimum solution goes as follows:
Find the optimum solution for 1 word on 1 line. Which is just placing that word 
on the line if it is within the line length. 

Find the optimum solution for 2 words. First calculate the slack for both the 
words on the same line if they will fit. Then calculate the solution for place 
the second word on the second line. The cost for this will be the slack of the 
second word on the second line as well as the cost of the slack of placing the 
first word on the first line. Essentially if word 2 does not need to be placed 
on line 2 the cost should increase since it is not optimal.

Let's assume that we placed a 3rd word on the first line but when we try to 
place a fourth word  it exceeds the line's length. The same process is taken. 
First calculate the slack for placing all the words on one line, this would be 
infinity since all of the words cannot fit on one line. Next subtract the first 
word   ( increment i ), what this does is take the first word and place it on 
the first line and the rest of the words are placed on the second line. The cost 
of this is the slack of the second line and the cost of the slack for placing the 
first word on the first line (this value is already computed and stored in the 
look up array). The following would keep moving words up to previous lines until 
only the new word is left on the final line. Out of all these combinations the 
optimum solution for this j value is found.

Recursive Expression:

minimum (slack^2) for i through j + the previous calculated solution for i - 1

Complexity:
O(n^2) due to the double for loops in the algorithm.

For the given Basic example the algorithm would produce the following results:
The assumption is that each word is the same length of 5 characters long 
including the space and the line length allotted is 15 characters. This will 
just fit 3 words on the first line.

i-j	Slack 		Slack 		Squared + opt	
0-0	10		100		Optimum solution
0-1	5		25		Optimum solution
1-1	10		100 + 100	
0-2	0		0		Optimum solution
1-2	5		25 + 100	
2-2	10		100 + 25	
0-3	Infinity	Infinity	
1-3	0		0 + 100	
2-3	5		25 + 25		Optimum solution
3-3	10		100 	




Running this example through the program would produce the follow output:

the1 the2
the3 the4


This is the optimal solution which minimizes the sum of squares. 

Sample Data:

Input example

15
the1 the2
the3 the4
the5 the6
the7

output

the1 the2
the3 the4
the5 the6 the7 

Input 2:

40
Call me Ishmael.
Some years ago,
never mind how long precisely,
having little or no money in my purse,
and nothing particular to interest me on shore,
I thought I
would sail about a little
and see the watery part of the world.

Output2:

Call me Ishmael. Some years ago, never 
mind how long precisely, having little 
or no money in my purse, and nothing 
particular to interest me on shore, 
I thought I would sail about a little 
and see the watery part of the world.



This output may differ slightly from the book as my algo takes the first 
minimum slack encountered. It is possible for there to be the same min value 
for a different word configuration. This can be seen if the algorithm is 
worked out for as low as 7 words.

Code to generate sample data:
Any text can be used as long as the line length is longer than the longest word.

This program accepts its input data in a formatted style which is: 
First line the line Length desired, the length should be given in characters.
Second the data which should be formatted with one space in-between words and 
words should not be split across lines.

The program accepts the data via standard input, so it can be typed in or piped 
in via the command line. 

Input File
The program accepts a .txt file as the input. The format is as follows
The first line list the maximum length of a line and the following lines are 
the text to be formated.

40
Call me Ishmael.
Some years ago,
never mind how long precisely,
having little or no money in my purse,
and nothing particular to interest me on shore,
I thought I
would sail about a little
and see the watery part of the world.

answer
Call me Ishmael. Some years ago, never 
mind how long precisely, having little 
or no money in my purse, and nothing 
particular to interest me on shore, 
I thought I would sail about a little 
and see the watery part of the world.


To run 

If in windows navigate into the src direcotry 
Compile the program using javac
	javac prettyPrinting.java
and execute like a normal java program
	java prettyPrinting < input.txt

If the input file is not formated correctly the program will through an error.



