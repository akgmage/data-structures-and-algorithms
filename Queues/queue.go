// Implement Queue Data Structure

package main

import "fmt"

type Queue []string

// IsEmpty func checks if the queue is empty
func (q *Queue) IsEmpty() bool{
	return len(*q) == 0
}

// EnQueue func enqueues a new value in the Queue
func (q *Queue) EnQueue(str string) {
	fmt.Printf("%s entered queue\n", str)
	*q = append(*q, str)
}
// DeQueue func dequeues "first in" as in FIFO, value in the Queue
func (q *Queue) DeQueue() (string, bool) {
	if q.IsEmpty() {
		return "", false
	} else {
		element := (*q)[0]
		*q = (*q)[1:]
		return element, true
	}
}

func main() {
	var queue Queue
	ele, msg := queue.DeQueue()
	if msg == true {
		fmt.Printf("%s", ele)
	} else {
		fmt.Printf("Nothing to delete!\n")
	}

	queue.EnQueue("Hello0")
	queue.EnQueue("Hello1")
	queue.EnQueue("Hello2")

	for len(queue) > 0 {
		ele, msg := queue.DeQueue()
		if msg == true {
			fmt.Printf("%s deleted from queue\n", ele)
		}
	}

}
