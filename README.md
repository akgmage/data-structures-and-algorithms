<a href="https://flutter.dev/">
  <h1 align="center">
    <picture>
      <source media="(prefers-color-scheme: dark)" srcset="https://raw.githubusercontent.com/akgmage/go-web/master/templates/assets/DSA.png">
      <img alt="Data Structures & Algorithms" src="https://raw.githubusercontent.com/akgmage/go-web/master/templates/assets/DSA.png">
    </picture>
  </h1>
</a>

# Implementation of well known Data Structures and Algorithms

Contributions are welcome!
You can join the fun by following our [contributing guide](https://github.com/akgmage/data-structures-and-algorithms/blob/main/CONTRIBUTING.md).

# Table of contents

- [Intro](https://github.com/akgmage/data-structures-and-algorithms#intro)
  - [Time complexity](https://github.com/akgmage/data-structures-and-algorithms#time-complexity)
  - [Calculation Rules](https://github.com/akgmage/data-structures-and-algorithms#calculation-rules)
  - [Loops](https://github.com/akgmage/data-structures-and-algorithms#loops)
  - [Order of Magnitude](https://github.com/akgmage/data-structures-and-algorithms#order-of-magnitude)
  - [Phases](https://github.com/akgmage/data-structures-and-algorithms#phases)
  - [Several Variables](https://github.com/akgmage/data-structures-and-algorithms#several-variables)
  - [Recursion](https://github.com/akgmage/data-structures-and-algorithms#recursion)
  - [Complexity classes](https://github.com/akgmage/data-structures-and-algorithms#complexity-classes)
  - [Estimating efficiency](https://github.com/akgmage/data-structures-and-algorithms#estimating-efficiency)
- [Data structures](https://github.com/akgmage/data-structures-and-algorithms#data-structures)
- [Sorting](https://github.com/akgmage/data-structures-and-algorithms#sorting)
  - [Well Known Sorting Algorithms](https://github.com/akgmage/data-structures-and-algorithms#well-known-sorting-algorithms)
- [Binary Search](https://github.com/akgmage/data-structures-and-algorithms#binary-search)
  - [Method 1](https://github.com/akgmage/data-structures-and-algorithms#method-1)
  - [Example](https://github.com/akgmage/data-structures-and-algorithms#example)
  - [Method 2](https://github.com/akgmage/data-structures-and-algorithms#method-2)
- [Greedy algorithms](https://github.com/akgmage/data-structures-and-algorithms#greedy-algorithms)
  - [Coin problem](https://github.com/akgmage/data-structures-and-algorithms#coin-problem)
  - [General case](https://github.com/akgmage/data-structures-and-algorithms#general-case)
- [Dynamic programming](https://github.com/akgmage/data-structures-and-algorithms#dynamic-programming)
  - [Coin problem](https://github.com/akgmage/data-structures-and-algorithms#coin-problem-1)
  - [Using memoization](https://github.com/akgmage/data-structures-and-algorithms#using-memoization)
- [Amortized analysis](https://github.com/akgmage/data-structures-and-algorithms#amortized-analysis)
- [Pattern 1: Two Pointers](https://github.com/akgmage/data-structures-and-algorithms#pattern-1-two-pointers)
  - [Practice problems for two pointers](https://github.com/akgmage/data-structures-and-algorithms#practice-problems-for-two-pointers)
- [Pattern 2: Fast and Slow Pointers](https://github.com/akgmage/data-structures-and-algorithms#pattern-2-fast-and-slow-pointers)
  - [Practice problems for fast and slow pointers](https://github.com/akgmage/data-structures-and-algorithms#practice-problems-for-fast-and-slow-pointers)
- [Pattern 3: Sliding Window](https://github.com/akgmage/data-structures-and-algorithms#pattern-3-sliding-window)
  - [Practice problems for sliding window](https://github.com/akgmage/data-structures-and-algorithms#practice-problems-for-sliding-window)
- [Pattern 4: Merge Interval](https://github.com/akgmage/data-structures-and-algorithms#pattern-4-merge-interval)
  - [Practice problems for merge intervals](https://github.com/akgmage/data-structures-and-algorithms#practice-problems-for-merge-intervals)
- [Pattern 5: In-place Reversal of a Linked List](https://github.com/akgmage/data-structures-and-algorithms#pattern-5-in-place-reversal-of-a-linked-list)
  - [Practice problems for in-place reversal of a linked list](https://github.com/akgmage/data-structures-and-algorithms#practice-problems-for-in-place-reversal-of-a-linked-list)
- [Pattern 6: Two Heaps](https://github.com/akgmage/data-structures-and-algorithms#pattern-6-two-heaps)
  - [Practice problems for two heaps](https://github.com/akgmage/data-structures-and-algorithms#practice-problems-for-two-heaps)
- [Pattern 7: K-way Merge](https://github.com/akgmage/data-structures-and-algorithms#pattern-7-k-way-merge)
  - [Practice problems for k-way Merge](https://github.com/akgmage/data-structures-and-algorithms#practice-problems-for-k-way-merge)
- [Pattern 8: Top K Elements](https://github.com/akgmage/data-structures-and-algorithms#pattern-8-top-k-elements)
  - [Practice problems for Top K Elements](https://github.com/akgmage/data-structures-and-algorithms#practice-problems-for-top-k-elements)

# Intro

The design of algorithms consists of problem solving and mathematical
thinking. Skills for analyzing problems and solving them creatively are needed.
An algorithm for solving a problem has to be both correct and efficient, and the
core of the problem is often about inventing an efficient algorithm.

# Time complexity

The efficiency of algorithms is important. Usually, it is easy to design an algorithm that solves the problem slowly, but the real challenge is to invent a fast algorithm. The time complexity of an algorithm estimates how much time the algorithm will use for some input. The idea is to represent the efficiency as a function whose parameter is the size of the input. By calculating the time complexity, we can find out whether the algorithm is fast enough without implementing it.

## Calculation rules

The time complexity of an algorithm is denoted `O(...)` where the three dots represent some function. Usually, the variable n denotes the input size. For example, if the input is an array of numbers, n will be the size of the array, and if the input is a string, n will be the length of the string.

## Loops

A common reason why an algorithm is slow is that it contains many loops that go through the input. The more nested loops the algorithm contains, the slower it is. If there are k nested loops, the time complexity is O(n^k).

For example, the time complexity of the following code is O(n):

```cpp
for (int i = 1; i <= n; i++) {
  // code
}
```

And the time complexity of the following code is O(n^2):

```cpp
for (int i = 1; i <= n; i++) {
  for (int j = 1; j <= n; j++) {
    // code
  }
}
```

## Order of magnitude

A time complexity does not tell us the exact number of times the code inside a loop is executed, but it only shows the order of magnitude. In the following examples, the code inside the loop is executed 3n, n + 5 and [n / 2] times, but the time complexity of each code is O(n).

```cpp
for (int i = 1; i <= 3*n; i++) {
  // code
}
```

```cpp
for (int i = 1; i <= n+5; i++) {
  // code
}
```

```cpp
for (int i = 1; i <= n; i += 2) {
// code
}
```

As another example, the time complexity of the following code is O(n^2):

```cpp
for (int i = 1; i <= n; i++) {
  for (int j = i+1; j <= n; j++) {
    // code
  }
}
```

## Phases

If the algorithm consists of consecutive phases, the total time complexity is the largest time complexity of a single phase. The reason for this is that the slowest phase is usually the bottleneck of the code. For example, the following code consists of three phases with time complexities O(n), O(n^2) and O(n). Thus, the total time complexity is O(n^2).

```cpp
for (int i = 1; i <= n; i++) {
  // code
}
for (int i = 1; i <= n; i++) {
  for (int j = 1; j <= n; j++) {
    // code
  }
}
for (int i = 1; i <= n; i++) {
// code
}
```

## Several variables

Sometimes the time complexity depends on several factors. In this case, the time complexity formula contains several variables. For example, the time complexity of the following code is O(nm):

```cpp
for (int i = 1; i <= n; i++) {
  for (int j = 1; j <= m; j++) {
    // code
  }
}
```

## Recursion

The time complexity of a recursive function depends on the number of times the function is called and the time complexity of a single call. The total time complexity is the product of these values.  
For example, consider the following function:

```cpp
void f(int n) {
  if (n == 1) return;
  f(n-1);
}
```

The call f(n) causes n function calls, and the time complexity of each call is O(1).
Thus, the total time complexity is O(n).

As another example, consider the following function:

```cpp
void g(int n) {
  if (n == 1) return;
  g(n-1);
  g(n-1);
}
```

In this case each function call generates two other calls, except for n = 1. Let us see what happens when g is called with parameter n. The following table shows the function calls produced by this single call:

function call number of calls  
g(n)&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; 1  
g(n - 1)&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp; 2  
g(n - 2)&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp; 4  
.... &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;  
g(1) &emsp;&emsp;&emsp;&emsp;&emsp;&emsp; 2^(n - 1)

Based on this, the time complexity is
1 + 2 + 4 + ... + 2^(n - 1) = 2^(n - 1) = O(2^n).

# Complexity classes

The following list contains common time complexities of algorithms:

O(1) : The running time of a constant-time algorithm does not depend on the input size. A typical constant-time algorithm is a direct formula that calculates the answer.

O(logn) : A logarithmic algorithm often halves the input size at each step. The running time of such an algorithm is logarithmic, because log base 2 n equals the number of times n must be divided by 2 to get 1.

O(√n) : A square root algorithm is slower than O(logn) but faster than O(n). A special property of square roots is that √n = n / √n , so the square root √n lies, in some sense, in the middle of the input.

O(n) : A linear algorithm goes through the input a constant number of times. This is often the best possible time complexity, because it is usually necessary to access each input element at least once before reporting the answer.

O(nlogn) : This time complexity often indicates that the algorithm sorts the input, because the time complexity of efficient sorting algorithms is O(nlogn). Another possibility is that the algorithm uses a data structure where each operation takes O(logn) time.

O(n^2) : A quadratic algorithm often contains two nested loops. It is possible to go through all pairs of the input elements in O(n^2) time.

O(n^3) : A cubic algorithm often contains three nested loops. It is possible to go through all triplets of the input elements in O(n^3) time.

O(2^n) : This time complexity often indicates that the algorithm iterates through all subsets of the input elements. For example, the subsets of {1,2,3} are Φ, {1}, {2}, {3}, {1,2}, {1,3}, {2,3} and {1,2,3}.

O(n!) : This time complexity often indicates that the algorithm iterates through all permutations of the input elements. For example, the permutations of {1,2,3} are (1,2,3), (1,3,2), (2,1,3 , (2,3,1), (3,1,2) and (3,2,1).

An algorithm is polynomial if its time complexity is at most O(n^k) where k is a constant. All the above time complexities except O(2^n) and O(n!) are polynomial.  
In practice, the constant k is usually small, and therefore a polynomial time complexity roughly means that the algorithm is efficient. Still, there are many important problems for which no polynomial algorithm is known, i.e., nobody knows how to solve them efficiently. NP-hard problems are an important set of problems, for which no polynomial algorithm is known.

# Estimating efficiency

By calculating the time complexity of an algorithm, it is possible to check, before implementing the algorithm, that it is efficient enough for the problem. The starting point for estimations is the fact that a modern computer can perform some hundreds of millions of operations in a second. For example, assume that the time limit for a problem is one second and the input size is n = 10 ^ 5. If the time complexity is O(n^2), the algorithm will perform about (10 ^ 5) ^ 2 = 10 ^ 10 operations. This should take at least some tens of seconds, so the algorithm seems to be too slow for solving the problem.

On the other hand, given the input size, we can try to guess the required time complexity of the algorithm that solves the problem. The following table contains some useful estimates assuming a time limit of one second.  
input size required time complexity  
n <= 10&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;O(n!)  
n <= 20&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; O(2 ^ n)  
n <= 500&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp; O(n ^ 3)  
n <= 5000&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; O(n ^ 2)  
n <= 106&emsp;&emsp;&emsp;&emsp;&emsp; O(nlogn) or O(n)  
n is large&emsp;&emsp;&emsp;&emsp;&emsp; O(1) or O(logn)

For example, if the input size is n = 10 ^ 5, it is probably expected that the time complexity of the algorithm is O(n) or O(nlogn). This information makes it easier to design the algorithm, because it rules out approaches that would yield an algorithm with a worse time complexity. Still, it is important to remember that a time complexity is only an estimate of efficiency, because it hides the constant factors. For example, an algorithm that runs in O(n) time may perform n/2 or 5n operations. This has an important effect on the actual running time of the algorithm.

# Data structures

A data structure is a way to store data in the memory of a computer. It is
important to choose an appropriate data structure for a problem, because each
data structure has its own advantages and disadvantages. The crucial question
is: which operations are efficient in the chosen data structure?

- `Dynamic arrays` : A dynamic array is an array whose size can be changed during the execution of the program.
- `Set structures` : A set is a data structure that maintains a collection of elements. The basic operations of sets are element insertion, search and removal.
- `Map structures` : A map is a generalized array that consists of key-value-pairs. While the keys in an ordinary array are always the consecutive integers 0,1,...,n-1, where n is the size of the array, the keys in a map can be of any data type and they do not have to be consecutive values.
- `Deque` : A deque is a dynamic array whose size can be efficiently changed at both ends of the array. Like a vector, a deque provides the functions push_back and pop_back, but it also includes the functions push_front and pop_front which are not available in a vector.
- `Stack` : A stack is a data structure that provides two O(1) time operations: adding an element to the top, and removing an element from the top. It is only possible to access the top element of a stack.
- `Queue` : A queue also provides two O(1) time operations: adding an element to the end of the queue, and removing the first element in the queue. It is only possible to access the first and last element of a queue.
- `Priority queue` : A priority queue maintains a set of elements. The supported operations are insertion and, depending on the type of the queue, retrieval and removal of either the minimum or maximum element. Insertion and removal take O(logn) time, and retrieval takes O(1) time. While an ordered set efficiently supports all the operations of a priority queue, the benefit of using a priority queue is that it has smaller constant factors. A priority queue is usually implemented using a heap structure that is much simpler than a balanced binary tree used in an ordered set.

# Sorting

Sorting is a fundamental algorithm design problem. Many efficient algorithms
use sorting as a subroutine, because it is often easier to process data if the
elements are in a sorted order.
For example, the problem ”does an array contain two equal elements?” is easy
to solve using sorting. If the array contains two equal elements, they will be next
to each other after sorting, so it is easy to find them. Also, the problem ”what is
the most frequent element in an array?” can be solved similarly.
There are many algorithms for sorting, and they are also good examples of
how to apply different algorithm design techniques. The efficient general sorting
algorithms work in O(nlogn) time, and many algorithms that use sorting as a
subroutine also have this time complexity.

```js
heights = [6, 5, 4, 5, 2, 3];
heights.sort();
Output: [2, 3, 4, 5, 5, 6];
```

Even though languages have built-in sorting method, sorting is a great example of how there may be many ways to think about the same problem, some perhaps better than others. Understanding sorting is a traditional first step towards mastery of algorithms and computer science.

### Well known sorting algorithms

- Bubble Sort [Go](https://github.com/akgmage/data-structures-and-algorithms/blob/main/sorting/bubble_sort.go) [C++](https://github.com/akgmage/data-structures-and-algorithms/blob/main/sorting/bubble_sort.cpp) [Java](https://github.com/akgmage/data-structures-and-algorithms/blob/main/sorting/bubble_sort.java) [Javascript](https://github.com/akgmage/data-structures-and-algorithms/blob/main/sorting/bubble_sort.js) [Python](https://github.com/akgmage/data-structures-and-algorithms/blob/main/sorting/bubble_sort.py)
- Insertion Sort [Go](https://github.com/akgmage/data-structures-and-algorithms/blob/main/sorting/insertion_sort.go) [C++](https://github.com/akgmage/data-structures-and-algorithms/blob/main/sorting/insertion_sort.cpp) [Java](https://github.com/akgmage/data-structures-and-algorithms/blob/main/sorting/insertion_sort.java) [Javascript](https://github.com/akgmage/data-structures-and-algorithms/blob/main/sorting/insertion_sort.js) [Python](https://github.com/akgmage/data-structures-and-algorithms/blob/main/sorting/insertion_sort.py)
- Selection Sort [Go](https://github.com/akgmage/data-structures-and-algorithms/blob/main/sorting/selection_sort.go) [C++](https://github.com/akgmage/data-structures-and-algorithms/blob/main/sorting/selection_sort.cpp) [Java](https://github.com/akgmage/data-structures-and-algorithms/blob/main/sorting/selection_sort.java) [Javascript](https://github.com/akgmage/data-structures-and-algorithms/blob/main/sorting/selection_sort.js) [Python](https://github.com/akgmage/data-structures-and-algorithms/blob/main/sorting/selection_sort.py)
- Merge Sort [Go](https://github.com/akgmage/data-structures-and-algorithms/blob/main/sorting/merge_sort.go) [C++](https://github.com/akgmage/data-structures-and-algorithms/blob/main/sorting/merge_sort.cpp) [Java](https://github.com/akgmage/data-structures-and-algorithms/blob/main/sorting/merge_sort.java) [Javascript](https://github.com/akgmage/data-structures-and-algorithms/blob/main/sorting/merge_sort.js) [Python](https://github.com/akgmage/data-structures-and-algorithms/blob/main/sorting/merge_sort.py)
- Quick Sort [C++](https://github.com/akgmage/data-structures-and-algorithms/blob/main/sorting/quick_sort.cpp) [Java](https://github.com/akgmage/data-structures-and-algorithms/blob/main/sorting/quick_sort.java)

# Binary Search

A general method for searching for an element in an array is to use a for loop
that iterates through the elements of the array. For example, the following code
searches for an element x in an array:

```cpp
for (int i = 0; i < n; i++) {
  if (array[i] == x) {
    // x found at index i
  }
}
```

The time complexity of this approach is O(n), because in the worst case, it
is necessary to check all elements of the array. If the order of the elements is
arbitrary, this is also the best possible approach, because there is no additional
information available where in the array we should search for the element x.
However, if the array is sorted, the situation is different. In this case it is
possible to perform the search much faster, because the order of the elements in
the array guides the search. The following binary search algorithm efficiently
searches for an element in a sorted array in O(logn) time.

## Method 1

The usual way to implement binary search resembles looking for a word in a
dictionary. The search maintains an active region in the array, which initially
contains all array elements. Then, a number of steps is performed, each of which
halves the size of the region.
At each step, the search checks the middle element of the active region. If
the middle element is the target element, the search terminates. Otherwise, the
search recursively continues to the left or right half of the region, depending on
the value of the middle element.
The above idea can be implemented as follows:

```cpp
int a = 0, b = n-1;
while (a <= b) {
  int k = (a+b)/2;
  if (array[k] == x) {
    // x found at index k
  }
  if (array[k] > x) b = k-1;
  else a = k+1;
}
```

## Example

[Go](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Binary%20Search/binary_search_iterative.go) [Python](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Binary%20Search/binary_search.py)

## Method 2

An alternative method to implement binary search is based on an efficient way to
iterate through the elements of the array. The idea is to make jumps and slow
the speed when we get closer to the target element.
The search goes through the array from left to right, and the initial jump
length is n/2. At each step, the jump length will be halved: first n/4, then n/8,
n/16, etc., until finally the length is 1. After the jumps, either the target element
has been found or we know that it does not appear in the array.
The following code implements the above idea:

```cpp
int k = 0;
for (int b = n/2; b >= 1; b /= 2) {
  while (k+b < n && array[k+b] <= x) k += b;
}
if (array[k] == x) {
  // x found at index k
}
```

During the search, the variable b contains the current jump length. The
time complexity of the algorithm is O(logn), because the code in the while loop is
performed at most twice for each jump length.

# Greedy algorithms

A greedy algorithm constructs a solution to the problem by always making a
choice that looks the best at the moment. A greedy algorithm never takes back
its choices, but directly constructs the final solution. For this reason, greedy
algorithms are usually very efficient.
The difficulty in designing greedy algorithms is to find a greedy strategy that
always produces an optimal solution to the problem. The locally optimal choices
in a greedy algorithm should also be globally optimal. It is often difficult to argue
that a greedy algorithm works.

## Coin problem

As a first example, we consider a problem where we are given a set of coins and
our task is to form a sum of money n using the coins. The values of the coins are
coins = `{c1, c2,..., ck}`, and each coin can be used as many times we want. What
is the minimum number of coins needed?
For example, if the coins are the euro coins (in cents)
`{1,2,5,10,20,50,100,200}`
and `n = 520`, we need at least four coins. The optimal solution is to select coins
`200 + 200 + 100 + 20` whose sum is `520`.

A simple greedy algorithm to the problem always selects the largest possible coin,
until the required sum of money has been constructed. This algorithm works in
the example case, because we first select two `200` cent coins, then one `100` cent
coin and finally one `20` cent coin. But does this algorithm always work?
It turns out that if the coins are the euro coins, the greedy algorithm always
works, i.e., it always produces a solution with the fewest possible number of coins.
The correctness of the algorithm can be shown as follows:
First, each coin `1, 5, 10, 50 and 100` appears at most once in an optimal
solution, because if the solution would contain two such coins, we could replace them by one coin and obtain a better solution. For example, if the solution would
contain coins `5 + 5`, we could replace them by coin 10.
In the same way, coins 2 and 20 appear at most twice in an optimal solution,
because we could replace coins `2 + 2 + 2` by coins `5 + 1` and coins `20 + 20 + 20` by
coins 50 + 10. Moreover, an optimal solution cannot contain coins `2 + 2 + 1` or
`20 + 20 + 10`, because we could replace them by coins 5 and 50.
Using these observations, we can show for each coin x that it is not possible
to optimally construct a sum x or any larger sum by only using coins that are
smaller than x. For example, `if x = 100`, the largest optimal sum using the smaller
coins is `50 + 20 + 20 + 5 + 2 + 2 = 99`. Thus, the greedy algorithm that always selects
the largest coin produces the optimal solution.
This example shows that it can be difficult to argue that a greedy algorithm
works, even if the algorithm itself is simple.

## General case

In the general case, the coin set can contain any coins and the greedy algorithm
does not necessarily produce an optimal solution.
We can prove that a greedy algorithm does not work by showing a counterexample
where the algorithm gives a wrong answer. In this problem we can easily
find a counterexample: if the coins are `{1,3,4}` and the target sum is `6`, the greedy
algorithm produces the solution 4 + 1 + 1 while the optimal solution is `3 + 3`.
It is not known if the general coin problem can be solved using any greedy
algorithm.

# Dynamic programming

Dynamic programming is a technique that combines the correctness of complete
search and the efficiency of greedy algorithms. Dynamic programming can
be applied if the problem can be divided into overlapping subproblems that can
be solved independently.

There are two uses for dynamic programming:

- Finding an optimal solution: We want to find a solution that is as large as possible or as small as possible.
- Counting the number of solutions: We want to calculate the total number of possible solutions.

## Coin problem

We first focus on a problem that we have already seen in Greedy Algorithm Given a set
of coin values coins = `{c1, c2,..., ck}` and a target sum of money n, our task is to
form the sum n using as few coins as possible.
We solved the problem using a greedy algorithm that always
chooses the largest possible coin. The greedy algorithm works, for example, when
the coins are the euro coins, but in the general case the greedy algorithm does
not necessarily produce an optimal solution.
Now is time to solve the problem efficiently using dynamic programming, so
that the algorithm works for any coin set. The dynamic programming algorithm
is based on a recursive function that goes through all possibilities how to form
the sum, like a brute force algorithm. However, the dynamic programming
algorithm is efficient because it uses memoization and calculates the answer to
each subproblem only once.

The idea in dynamic programming is to formulate the problem recursively so
that the solution to the problem can be calculated from solutions to smaller
subproblems. In the coin problem, a natural recursive problem is as follows: what
is the smallest number of coins required to form a sum x?
Let solve(x) denote the minimum number of coins required for a sum x.
The values of the function depend on the values of the coins. For example, if
`coins = {1,3,4}`, the first values of the function are as follows:

```solve(0) = 0
solve(1) = 1
solve(2) = 2
solve(3) = 1
solve(4) = 1
solve(5) = 2
solve(6) = 2
solve(7) = 2
solve(8) = 2
solve(9) = 3
solve(10) = 3
```

For example, `solve(10) = 3`, because at least 3 coins are needed to form the
sum `10`. The optimal solution is `3 + 3 + 4 = 10`.
The essential property of solve is that its values can be recursively calculated
from its smaller values. The idea is to focus on the first coin that we choose for
the sum. For example, in the above scenario, the first coin can be either `1, 3
or 4`. If we first choose coin `1`, the remaining task is to form the sum 9 using
the minimum number of coins, which is a subproblem of the original problem.
Of course, the same applies to coins` 3 and 4`.

Thus, we can use the following recursive formula to calculate the minimum number of coins:  
solve(x) = min(solve(x - 1) + 1,  
solve(x - 3) + 1,  
solve(x - 4) + 1).

The base case of the recursion is solve(0) Æ 0, because no coins are needed to form an empty sum. For example,  
solve(10) = solve(7) + 1 = solve(4) + 2 = solve(0) + 3 = 3.

Now we are ready to give a general recursive function that calculates the minimum number of coins needed to form a sum x:
solve(x) = Infinity if x < 0  
solve(x) = 0 if x == 0  
solve(x) = min(c --> coins) ==> solve(x - c) + 1, if x > 0

Once a recursive function that solves the problem has been found, we can
directly implement a solution, (the constant INF denotes infinity):

```cpp
int solve(int x) {
  if (x < 0) return INF;
  if (x == 0) return 0;
  int best = INF;
  for (auto c : coins) {
    best = min(best, solve(x-c)+1);
  }
  return best;
}
```

Still, this function is not efficient, because there may be an exponential number of ways to construct the sum. However, next we will see how to make the function efficient using a technique called memoization.

## Using memoization

The idea of dynamic programming is to use memoization to efficiently calculate values of a recursive function. This means that the values of the function are stored in an array after calculating them. For each parameter, the value of the function is calculated recursively only once, and after this, the value can be
directly retrieved from the array.

In this problem, we use arrays

```cpp
bool ready[N];
int value[N];
```

where `ready[x]` indicates whether the value of `solve(x)` has been calculated,
and if it is, `value[x]` contains this value. The constant `N` has been chosen so that all required values fit in the arrays.  
Now the function can be efficiently implemented as follows:

```cpp
int solve(int x) {
  if (x < 0) return INF;
  if (x == 0) return 0;
  if (ready[x]) return value[x];
  int best = INF;
  for (auto c : coins) {
    best = min(best, solve(x-c)+1);
  }
  value[x] = best;
  ready[x] = true;
  return best;
}
```

# Amortized analysis

The time complexity of an algorithm is often easy to analyze just by examining the structure of the algorithm: what loops does the algorithm contain and how many times the loops are performed. However, sometimes a straightforward analysis does not give a true picture of the efficiency of the algorithm.
Amortized analysis can be used to analyze algorithms that contain operations whose time complexity varies. The idea is to estimate the total time used to all such operations during the execution of the algorithm, instead of focusing on individual operations.

# Pattern 1: Two Pointers

As the name suggests, the two pointers pattern uses two pointers to iterate over an array or list until the conditions of the problem are satisfied. This is useful because it allows us to keep track of the values of two different indexes in a single iteration. Whenever there’s a requirement to find two data elements in an array that satisfy a certain condition, the two pointers pattern should be the first strategy to come to mind.

The pointers can be used to iterate the data structure in one or both directions, depending on the problem statement. For example, to identify whether a string is a palindrome, we can use one pointer to iterate the string from the beginning and the other to iterate it from the end. At each step, we can compare the values of the two pointers and see if they meet the palindrome properties.

## Practice problems for two pointers

- Two sum [Go](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Hash%20Table/two_sum.go) [C++](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Hash%20Table/two_sum.cpp) [Java](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Hash%20Table/two_sum.java) [Python](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Hash%20Table/two_sum.py) [Javascript](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Hash%20Table/two_sum.js)

- Three Number Sum [Go](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Arrays/triplet_sum.go) [Java](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Arrays/triplet_sum.java) [C++](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Arrays/triplet_sum.cpp) [Python](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Arrays/triplet_sum.py) [Javascript](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Arrays/triplet_sum.js)

- Valid Pallindrome [Go](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Strings/is_pallindrome.go) [Javascript](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Strings/is_%20palindrome.js) [C++](https://github.com/akgmage/data-structures-and-algorithms/tree/main/Strings/is_palindrome.cpp) [Python](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Strings/is_pallindrome.py) [Java](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Strings/is_pallindrome.java)

- Reverse Word in a String [Go](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Strings/reverse_word_in_a_string.go) [Javascript](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Strings/reverse_words_in_a_string.js)

- Valid Pallindrome II [Go](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Strings/valid_pallindrome2.go) [C++](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Strings/valid_pallindrome2.cpp)

# Pattern 2: Fast and Slow Pointers

The fast and slow pointer technique (also known as the tortoise and hare algorithm) uses two pointers to determine traits about directional data structures. This can be an array, singly-linked list, or a graph.

Similar to the two pointers pattern, the fast and slow pointers pattern uses two pointers to traverse an iterable data structure at different speeds. It’s usually used to identify distinguishable features of directional data structures, such as a linked list or an array.

The pointers can be used to traverse the array or list in either direction, however, one moves faster than the other. Generally, the slow pointer moves forward by a factor of one, and the fast pointer moves by a factor of two in each step. However, the speed can be adjusted according to the problem statement.

Unlike the two pointers approach, which is concerned with data values, the fast and slow pointers approach is used to determine data structure traits using indices in arrays or node pointers in linked lists. The approach is commonly used to detect cycles in the given data structure, so it’s also known as Floyd’s cycle detection algorithm.

The key idea is that the pointers start at the same location, but they move forward at different speeds. If there is a cycle, the two are bound to meet at some point in the traversal. To understand the concept, think of two runners on a track. While they start from the same point, they have different running speeds. If the race track is a circle, the faster runner will overtake the slower one after completing a lap. On the other hand, if the track is straight, the faster runner will end the race before the slower one, hence never meeting on the track again. The fast and slow pointers pattern uses the same intuition.

## Practice problems for fast and slow pointers

- Linked List cycle detection [C++](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Fast%20and%20Slow%20Pointers/linked_floyds_cycle_detection.cpp)
- Find middle of Linked List [C++](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Fast%20and%20Slow%20Pointers/linked_list_compute_midpoint.cpp) [Python](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Fast%20and%20Slow%20Pointers/linked_list_find_middle.py)
- Happy Number [Go](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Fast%20and%20Slow%20Pointers/happy_number.go)
- Pallindrome Linked List [C++](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Linked%20List/linked_list_pallindrome.cpp)
- Remove Kth node from end [Go](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Linked%20List/linked_list_kth_from_end.go) [C++](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Linked%20List/linked_list_remove_nth_node_from_end.cpp) [Python](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Linked%20List/remove_kth_node_from_end.py)
- Linked List Sort List [C++](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Linked%20List/liniked_list_sort_list.cpp)

# Pattern 3: Sliding Window

The Sliding window is a problem-solving technique of data structure and algorithm for problems that apply arrays or lists. These problems are painless to solve using a brute force approach in O(n²) or O(n³). However, the Sliding window technique can reduce the time complexity to O(n).

The sliding window pattern is a computational method aimed at reducing the use of nested loops in an algorithm. It’s a variation of the two pointers pattern, where the pointers can be used to set window bounds.

A window is a sublist formed over a part of an iterable data structure. It can be used to slide over the data in chunks corresponding to the window size. The sliding window pattern allows us to process the data in segments instead of the entire list. The segment or window size can be set according to the problem’s requirements. For example, if we have to find three consecutive integers with the largest sum in an array, we can set the window size to 3. This will allow us to process the data three elements at a time.

Why is this method more efficient? It isn’t if, for each window, we iterate over all the elements of the window because that gives us the same O(kn) time complexity.

Instead, what if we focused on the element entering the window and the one leaving it? For example, after calculating the sum of the first three elements, we move the window one step forward, subtract the element that is no longer in the window from the sum, and add the new element that has entered it. Next we check if the new sum is greater than the first. If it is, we update the max sum found so far. Now, each time we move the window forward, we perform at most four operations, reducing the time complexity to O(4n), that is, O(n).

## Practice problems for sliding window

- Find Maximum in Sliding Window [Java](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Sliding%20Window/sliding_window_max.java) [Javascript](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Sliding%20Window/sliding_window_max.js) [Python](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Sliding%20Window/sliding_window_max.py)
- Minimum Window Subsequence
- Repeated DNA Sequences
- Minimum Window Substring
- Longest Substring without Repeating Characters [Go](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Sliding%20Window/longest_substring_without_repeating_characters.go)

# Pattern 4: Merge Interval

The merge intervals pattern deals with problems involving overlapping intervals. Each interval is represented by a start and an end time. For example, an interval of [10,20] seconds means that the interval starts at 10 seconds and ends at 20seconds, such that both 10 and time 20 are included in the interval.

The most common problems solved using this pattern are scheduling problems.

The key to understanding this pattern and exploiting its power lies in understanding how any two intervals may overlap.

Many problems in the real world use the merge intervals pattern. Let’s look at some examples.

- Display busy schedule: Display the busy hours of a user to other users without revealing the individual meeting slots in a calendar.

- Schedule a new meeting: Add a new meeting to the tentative meeting schedule of a user in such a way that no two meetings overlap each other.

- Task scheduling in operating systems (OS): Schedule tasks for the OS based on task priority and the free slots in the machine’s processing schedule.

## Practice problems for merge intervals

- Merge Intervals
- Insert Interval
- Interval List Intersections
- Employee Free Time
- Meeting Rooms

# Pattern 5: In-place Reversal of a Linked List

The in-place reversal of a linked list pattern allows us to reverse a linked list without any additional memory, using only the given nodes.

Many problems require a reversal of a set of nodes in a linked list without using additional memory. In such cases, using the in-place reversal pattern is the simplest solution. Instead of making a new linked list with reversed links, we can do it in place, without using additional memory.

How can we achieve an in-place reversal of nodes? We iterate in a linked list and keep track of the current node, the next node, and the previous node simultaneously. Keeping track of the nodes allows us to easily change the links between them and make them point to a different node than before.

When solving such problems, the naive approach of iterating the linked list using nested loops takes O(n²) time. However, using the in-place reversal pattern, the time complexity is O(n)
time, since we use a single loop to iterate the linked list.

Similarly, for space complexity: the naive approach requires the use of additional memory—if a linked list contains thousands of nodes, we’d need to allocate a lot of additional memory resources to solve the problem. However, the in-place reversal of a linked pattern will use only O(1) space.

## Practice problems for in-place reversal of a linked list

- Reverse Linked List [C++](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Linked%20List/linked_list_reverse.cpp)
- Reverse Nodes in k-group
- Reorder List
- Swapping Nodes in a Linked List
- Swapping Nodes in Pairs [C++](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Linked%20List/linked_list_swap_nodes_in_pair.cpp)
- Reverse Nodes in Even Length Groups

# Pattern 6: Two Heaps

As the name suggests, the two heaps pattern uses either two min-heaps, two max-heaps, or a min-heap and a max-heap simultaneously to solve the problem.

Given that there are n elements in a heap, it takes O(log n) time to insert an element in it, O(log n) time to remove an element from it, and O(1) time to access the element at the root of the heap. The root stores the smallest element in the case of a min-heap and the largest element in a max-heap.

In some problems, we’re given a set of data such that it can be divided into two parts. We can either use the first part to find the smallest element using the min-heap and the second part to find the largest element using the max-heap, or we can do the reverse and use the first part to find the largest element using the max-heap and the second part to find the smallest element using the min-heap.

There might be cases where we need to find the two largest numbers from two different data sets. We’ll use two max-heaps to store two different data sets in that case. In other cases, we might need to find the two smallest numbers from two different data sets, and then we would use two min-heaps.

Many problems in the real world use the two heaps pattern. Let’s look at some examples.

- Video streaming: During a user session, there is often a possibility that packet drops and buffering might occur. We want to record the median number of buffering events that might occur in a particular session, which could then be used to improve the user experience.

- Netflix: As part of a demographic study, we’re interested in the median age of our viewers. We want to implement a functionality whereby the median age can be updated efficiently whenever a new user signs up for video streaming.

## Practice problems for two heaps

- Maximize Capital
- Find Median from a data stream
- Schedule Tasks on minimum machines

# Pattern 7: K-way Merge

The k-way merge pattern helps to solve problems involving a list of sorted arrays.

Here is what the pattern looks like:

1. Insert the first element of each array in a min-heap.
2. Next, remove the smallest element from the heap and add it to the merged array.
3. Keep track of which array each element comes from.
4. Then, insert the next element of the same array into the heap.
5. Repeat steps 2 to 4 to fill the merged array in sorted order.

Many problems in the real world use the k-way merge pattern. Let’s look at some examples.

- Merge tweets in twitter feed: Sometimes we need to implement a module that adds a user’s Tweets into an already populated Twitter feed in chronological order.

- Used in external sorting procedures: When an algorithm is processing huge amounts of data, it needs to repeatedly fetch it from external storage because RAM capacity is fixed. To overcome the speed limitation of external storage, k-way merges are used in external sorting. Let’s consider a case where we need to perform six merges. A binary merge requires three merge passes while a 6-way merge only requires one pass. K-way merge reduces the number of accesses to external storage, which in turn greatly improves performance when dealing with large amounts of data.

## Practice problems for k-way Merge

- Merge Sorted Array
- Kth smallest number in M sorted list
- Find K pairs with smallest sums
- Merge K sorted lists
- Kth Smallest element in a sorted matrix
- Median of two sorted arrays

# Pattern 8: Top K Elements

The top K elements pattern helps find some specific k number of elements from the given data with optimum time complexity. Many problems ask us to find the top, the smallest, or the most/least frequent k elements in an unsorted list of elements. To solve such problems, sorting the list takes O(nlog(n)) time, then finding the k elements takes O(k) time. However, the top k elements pattern can allow us to solve the problem using O(n logk) time without sorting the list first.

Which data structure can we use to solve such problems? The best data structure to keep track of the smallest or largest k elements is heap. With this pattern, we either use a max-heap or a min-heap to find the smallest or largest k elements, respectively.

For example, let’s look at how this pattern takes steps to solve the problem of finding the top k largest elements (using min-heap) or top k smallest elements (using max-heap):
Insert the first k elements from the given set of elements to the min-heap or max-heap.

Iterate through the rest of the elements.

For min-heap, if you find the larger element, remove the top (smallest number) of the min-heap and insert the new larger element.
For max-heap, if you find the smaller element, remove the top (largest number) of the max-heap and insert the new smaller element.
Iterating the complete list takes O(n) time, and the heap takes O(logk) time for insertion. However, we get the O(1) access to the k elements using the heap.

Many problems in the real world use the top K elements pattern. Let’s look at some examples.

- Uber: Select at least the n nearest drivers within the user’s vicinity, avoiding the drivers that are too far away.

- Stocks: Given the set of IDs of brokers, determine the top K broker’s performance with the frequently repeated IDs in the given data set.

## Practice problems for Top K Elements

- Kth largest element in a stream
- Reorganize string
- K closest point to origin
- Top K frequent element
- Kth largest element in an array
- Kth smallest element in an BST
