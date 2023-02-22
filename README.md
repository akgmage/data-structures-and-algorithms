<a href="https://flutter.dev/">
  <h1 align="center">
    <picture>
      <source media="(prefers-color-scheme: dark)" srcset="https://raw.githubusercontent.com/akgmage/go-web/master/templates/assets/DSA.png">
      <img alt="Data Structures & Algorithms" src="https://raw.githubusercontent.com/akgmage/go-web/master/templates/assets/DSA.png">
    </picture>
  </h1>
</a>

# Implementation of well known Data Structures and Algorithms

🌈 Everyone is welcome!
You can join the fun by following our [contributing](https://github.com/akgmage/data-structures-and-algorithms/blob/main/CONTRIBUTING.md) guide.

# Pattern 1: Two Pointers

As the name suggests, the two pointers pattern uses two pointers to iterate over an array or list until the conditions of the problem are satisfied. This is useful because it allows us to keep track of the values of two different indexes in a single iteration. Whenever there’s a requirement to find two data elements in an array that satisfy a certain condition, the two pointers pattern should be the first strategy to come to mind.

The pointers can be used to iterate the data structure in one or both directions, depending on the problem statement. For example, to identify whether a string is a palindrome, we can use one pointer to iterate the string from the beginning and the other to iterate it from the end. At each step, we can compare the values of the two pointers and see if they meet the palindrome properties.

## Practice problems for two pointers

- Two sum [Go](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Hash%20Table/two_sum.go) [C++](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Hash%20Table/two_sum.cpp) [Java](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Hash%20Table/two_sum.java) [Python](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Hash%20Table/two_sum.py)

- Three Number Sum [Go](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Arrays/triplet_sum.go) [Java](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Arrays/triplet_sum.java) [C++](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Arrays/triplet_sum.cpp) [Python](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Arrays/triplet_sum.py) [Javascript](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Arrays/triplet_sum.js)

- Valid Pallindrome [Go](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Strings/is_pallindrome.go) [Javascript](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Strings/is_%20palindrome.js)

- Reverse Word in a String [Go](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Strings/reverse_word_in_a_string.go) [Javascript](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Strings/reverse_word_in_a_string.js)

- Valid Pallindrome II [Go](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Strings/valid_pallindrome2.go) [C++](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Strings/valid_pallindrome2.cpp)

# Pattern 2: Fast and Slow Pointers

The fast and slow pointer technique (also known as the tortoise and hare algorithm) uses two pointers to determine traits about directional data structures. This can be an array, singly-linked list, or a graph.

Similar to the two pointers pattern, the fast and slow pointers pattern uses two pointers to traverse an iterable data structure at different speeds. It’s usually used to identify distinguishable features of directional data structures, such as a linked list or an array.

The pointers can be used to traverse the array or list in either direction, however, one moves faster than the other. Generally, the slow pointer moves forward by a factor of one, and the fast pointer moves by a factor of two in each step. However, the speed can be adjusted according to the problem statement.

Unlike the two pointers approach, which is concerned with data values, the fast and slow pointers approach is used to determine data structure traits using indices in arrays or node pointers in linked lists. The approach is commonly used to detect cycles in the given data structure, so it’s also known as Floyd’s cycle detection algorithm.

The key idea is that the pointers start at the same location, but they move forward at different speeds. If there is a cycle, the two are bound to meet at some point in the traversal. To understand the concept, think of two runners on a track. While they start from the same point, they have different running speeds. If the race track is a circle, the faster runner will overtake the slower one after completing a lap. On the other hand, if the track is straight, the faster runner will end the race before the slower one, hence never meeting on the track again. The fast and slow pointers pattern uses the same intuition.

## Practice problems for fast and slow pointers

- Linked List cycle detection [C++](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Linked%20List/linked_floyds_cycle_detection.cpp)
- Find middle of Linked List [C++](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Linked%20List/linked_list_compute_midpoint.cpp)
- Happy Nuumber [Go](https://github.com/akgmage/data-structures-and-algorithms/tree/main/Fast%20and%20Slow%20Pointers)
- Pallindrome Linked List
- Remove Kth node from end [C++](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Linked%20List/linked_list_remove_nth_node_from_end.cpp)
- Linked List Sort List [C++](https://github.com/akgmage/data-structures-and-algorithms/blob/main/Linked%20List/liniked_list_sort_list.cpp)
