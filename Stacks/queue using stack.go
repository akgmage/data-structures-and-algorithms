// Queue using stack
package main

import "fmt"

// Queue represents a queue data structure using two stacks.
type Queue struct {
	enqueueStack []int // Stack for enqueue operations
	dequeueStack []int // Stack for dequeue operations
}

// Enqueue adds an element to the back of the queue.
func (q *Queue) Enqueue(value int) {
	q.enqueueStack = append(q.enqueueStack, value)
}

// Dequeue removes and returns the front element of the queue.
func (q *Queue) Dequeue() int {
	// If the dequeue stack is empty, transfer elements from the enqueue stack
	if len(q.dequeueStack) == 0 {
		for len(q.enqueueStack) > 0 {
			// Pop an element from the enqueue stack and push it onto the dequeue stack
			element := q.enqueueStack[len(q.enqueueStack)-1]
			q.enqueueStack = q.enqueueStack[:len(q.enqueueStack)-1]
			q.dequeueStack = append(q.dequeueStack, element)
		}
	}

	// If the dequeue stack is still empty, the queue is empty
	if len(q.dequeueStack) == 0 {
		panic("Queue is empty")
	}

	// Pop and return the front element from the dequeue stack
	element := q.dequeueStack[len(q.dequeueStack)-1]
	q.dequeueStack = q.dequeueStack[:len(q.dequeueStack)-1]
	return element
}

func main() {
	queue := Queue{}

	// Enqueue elements
	queue.Enqueue(1)
	queue.Enqueue(2)
	queue.Enqueue(3)

	// Dequeue elements
	fmt.Println(queue.Dequeue()) // Output: 1
	fmt.Println(queue.Dequeue()) // Output: 2

	// Enqueue more elements
	queue.Enqueue(4)
	queue.Enqueue(5)

	// Dequeue the remaining elements
	fmt.Println(queue.Dequeue()) // Output: 3
	fmt.Println(queue.Dequeue()) // Output: 4
	fmt.Println(queue.Dequeue()) // Output: 5
}
