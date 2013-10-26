## Evernote Programming Challenges
https://evernotechallenge.interviewstreet.com/challenges/dashboard/#problems

### Circular Buffer

Implement a circular buffer of size N. Allow the caller to append, remove and list the contents of the buffer. Implement the buffer to achieve maximum performance for each of the operations.

The new items are appended to the end and the order is retained i.e elements are placed in increasing order of their insertion time. When the number of elements in the list elements exceeds the defined size, the older elements are overwritten.
 
There are four types of commands.
 
"A"  n -  Append the following n lines to the buffer. If the buffer is full they replace the older entries.
"R"  n -  Remove first n elements of the buffer. These n elements are the ones that were added earliest among the current elements.
"L"   - List the elements of buffer in order of their inserting time.
"Q"  - Quit.  
 
Your task is to execute commands on circular buffer.
 
Input format :
 
First line of input contains N ,  the size of the buffer.
A n  - append the following n lines to the buffer.
R n - remove first n elements of the buffer.
L - list the buffer.
Q - Quit.
 
Output format :
 
Whenever  L command appears in the input, print the elements of buffer in order of their inserting time. Element that was added first should appear first. 
 
Sample Input :
 
10
A 3
Fee
Fi
Fo
A 1
Fum
R 2
L
Q
 
Sample Output :
 
Fo
Fum
 
Constraint :
 
0 <= N <= 10000
Number of removing elements will <= number of elements presents in circular buffer.
total number of commands <= 50000.
total number of characters in input <= 20000000.

### Top Four

Given an unordered list of N elements, write a function to find the top four elements of the given list. Make sure your function runs in linear time O(N).
 
Input format :
 
First line of input contains N , number of elements in list.
Next N line , each contains a element.
 
Output format :
 
Print the top four elements of list.
 
Sample input :
 
8
6930886
-1692777
4636915
7747793
-4238335
9885386
9760492
6516649
 
Sample ouput :
 
9885386
9760492
7747793
6930886
 
Constraint :
 
N < 1000000.
all numbers will fit  in 32-bit integer.

### Frequent Terms

Frequency Counting of Words / Top N words in a document.
 
Given N terms, your task is to find the k most frequent terms from given N terms.
 
Input format :
 
First line of input contains N, denoting the number of terms to add.
In each of the next N lines, each contains a term.
Next line contains k, most frequent terms.
 
Output format :
 
Print the k most frequent terms in descending order of their frequency. If two terms have same frequency print them in lexicographical order.
 
Sample input :
 
14
Fee
Fi
Fo
Fum
Fee
Fo
Fee 
Fee
Fo
Fi
Fi
Fo
Fum
Fee
3
 
Sample output :
 
Fee
Fo
Fi
 
Constraint :
0 < N < 300000 
0 < term length < 25.