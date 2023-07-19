/*
  You're given a list of arbitrary jobs that need to be completed; these jobs
  are represented by distinct integers. You're also given a list of dependencies. A
  dependency is represented as a pair of jobs where the first job is a
  prerequisite of the second one. In other words, the second job depends on the
  first one; it can only be completed once the first job is completed.

  Write a function that takes in a list of jobs and a list of dependencies and
  returns a list containing a valid order in which the given jobs can be
  completed. If no such order exists, the function should return an empty array.

  Sample INput:
  jobs: [1, 2, 3, 4]
  deps:  = [[1, 2], [1, 3], [3, 2], [4, 2], [4, 3]]
  Output: [1, 4, 3, 2] or [4, 1, 3, 2]
*/
package main

type Dep struct {
	Prereq int
	Job    int
}

// TopologicalSort performs topological sorting of jobs given their dependencies.
func TopologicalSort(jobs []int, deps []Dep) []int {
	// Create a job graph from the list of jobs and dependencies.
	jobGraph := createJobGraph(jobs, deps)

	// Get the ordered jobs using depth-first traversal.
	return getOrderedJobs(jobGraph)
}

// createJobGraph creates a job graph from the list of jobs and dependencies.
func createJobGraph(jobs []int, deps []Dep) *JobGraph {
	graph := NewJobGraph(jobs)
	for _, dep := range deps {
		// Add each dependency as a prerequisite to the corresponding job node in the graph.
		graph.Addprereq(dep.Job, dep.Prereq)
	}
	return graph
}

// getOrderedJobs performs a depth-first traversal of the job graph to get the ordered jobs.
func getOrderedJobs(graph *JobGraph) []int {
	orderedJobs := []int{}
	nodes := graph.Nodes

	// Continue the traversal until all nodes have been visited.
	for len(nodes) != 0 {
		// Get the last node from the list of nodes and remove it from the list.
		node := nodes[len(nodes)-1]
		nodes = nodes[:len(nodes)-1]

		// Perform depth-first traversal starting from the current node.
		// If a cycle is detected, return an empty list.
		containsCycle := depthFirstTraverse(node, &orderedJobs)
		if containsCycle {
			return []int{}
		}
	}
	return orderedJobs
}

// depthFirstTraverse performs depth-first traversal starting from the given node.
// It returns true if a cycle is detected, otherwise, it returns false.
func depthFirstTraverse(node *JobNode, orderedJobs *[]int) bool {
	// If the node has been visited, it means it is not part of any cycle, so return false.
	if node.Visited {
		return false
	}
	// If the node is currently being visited it means there is a cycle, so return true.
	if node.Visiting {
		return true
	}

	// Mark the node as currently being visited.
	node.Visiting = true

	// Recursively traverse through each prerequisite of the current node.
	for _, prereqNode := range node.Prereqs {
		// If a cycle is detected during the traversal, return true.
		containsCycle := depthFirstTraverse(prereqNode, orderedJobs)
		if containsCycle {
			return true
		}
	}

	// Mark the node as visited and no longer being visited.
	node.Visited = true
	node.Visiting = false

	// Append the job to the orderedJobs list in the correct order.
	*orderedJobs = append(*orderedJobs, node.Job)

	// Return false, as no cycle was detected during the traversal.
	return false
}

// JobGraph represents the job graph.
type JobGraph struct {
	Nodes []*JobNode
	Graph map[int]*JobNode
}

// NewJobGraph creates a new instance of the JobGraph and initializes its Graph field.
func NewJobGraph(jobs []int) *JobGraph {
	g := &JobGraph{
		Graph: map[int]*JobNode{},
	}
	for _, job := range jobs {
		// Add individual job nodes to the Nodes list.
		g.AddNode(job)
	}
	return g
}

// Addprereq adds a prerequisite to a job in the job graph.
func (g *JobGraph) Addprereq(job, prereq int) {
	jobNode := g.GetNode(job)
	prereqNode := g.GetNode(prereq)
	// Add the prerequisite node to the list of prerequisites for the job node.
	jobNode.Prereqs = append(jobNode.Prereqs, prereqNode)
}

// AddNode adds a new job node to the job graph.
func (g *JobGraph) AddNode(job int) {
	// Create a new job node and add it to the graph and nodes list.
	g.Graph[job] = &JobNode{Job: job}
	g.Nodes = append(g.Nodes, g.Graph[job])
}

// GetNode gets an existing job node from the job graph.
func (g *JobGraph) GetNode(job int) *JobNode {
	// If the node does not exist in the graph, create a new node and add it to the graph.
	if _, found := g.Graph[job]; !found {
		g.AddNode(job)
	}
	return g.Graph[job]
}

// JobNode represents a node in the job graph.
type JobNode struct {
	Job      int
	Prereqs  []*JobNode
	Visited  bool
	Visiting bool
}
