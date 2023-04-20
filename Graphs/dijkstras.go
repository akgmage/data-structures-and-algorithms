
package main
// priorityQueue is a heap-based priority queue of items
type priorityQueue []*item

// item represents an item in the priority queue
type item struct {
    value    string  // value of the item
    priority int     // priority of the item (i.e., its distance from the start vertex)
}

// Len returns the number of items in the priority queue
func (pq priorityQueue) Len() int {
    return len(pq)
}

// Less returns true if item i has higher priority than item j
func (pq priorityQueue) Less(i, j int) bool {
    return pq[i].priority < pq[j].priority
}

// Swap swaps the positions of items i and j in the priority queue
func (pq priorityQueue) Swap(i, j int) {
    pq[i], pq[j] = pq[j], pq[i]
}

// Push adds an item to the priority queue
func (pq *priorityQueue) Push(x interface{}) {
    item := x.(*item)
    *pq = append(*pq, item)
}

// Pop removes the item with the highest priority from the priority queue and returns it
func (pq *priorityQueue) Pop() interface{} {
    old := *pq
    n := len(old)
    item := old[n-1]
    *pq = old[0 : n-1]
    return item
}