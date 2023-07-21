package main

func TwoColorable(edges [][]int) bool {
	colors := map[int]bool{
		0: true,
	}
	stack := []int{0}

	for len(stack) > 0 {
		var node int
		node, stack = stack[len(stack)-1], stack[:len(stack)-1]
		for _, connection := range edges[node] {
			if _, colorFound := colors[connection]; !colorFound {
				colors[connection] = !colors[node]
				stack = append(stack, connection)
			} else if colors[connection] == colors[node] {
				return false
			}
		}
	}
	return true
}
