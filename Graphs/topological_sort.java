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

	Explanation:
	The provided code implements a topological sorting algorithm to find the order in which jobs can be executed given their dependencies. It uses a directed acyclic graph (DAG) representation to represent the jobs and their dependencies.

	Let's go through each part of the code in detail:

	1. `Dep` struct:
	- This is a simple struct that represents a dependency between two jobs.
	- `Prereq` field indicates the prerequisite job.
	- `Job` field indicates the job that depends on the prerequisite.

	2. `TopologicalSort` function:
	- This is the main function that performs the topological sorting of jobs.
	- It takes two input parameters: `jobs`, a list of job IDs, and `deps`, a list of dependencies.
	- It first creates a job graph using the `createJobGraph` function and then gets the ordered jobs using the `getOrderedJobs` function.

	3. `createJobGraph` function:
	- This function creates a job graph from the list of jobs and dependencies.
	- It creates a new instance of the `JobGraph` struct and iterates through the dependencies.
	- For each dependency, it adds the prerequisite job to the dependent job's list of prerequisites in the job graph.

	4. `getOrderedJobs` function:
	- This function performs a depth-first traversal of the job graph to get the ordered jobs.
	- It iterates through the nodes of the graph until all nodes have been visited.
	- For each node, it calls the `depthFirstTraverse` function to perform the depth-first traversal and get the ordered jobs.
	- If a cycle is detected in the graph during the traversal, it means that there is a circular dependency, and the function returns an empty list.

	5. `depthFirstTraverse` function:
	- This function performs the depth-first traversal of the graph starting from a given node.
	- It checks if the current node has been visited (i.e., it is not part of any cycle).
	- If the node is currently being visited (marked as `Visiting`), it means that there is a cycle, and the function returns `true`.
	- Otherwise, it marks the node as `Visiting`, recursively traverses through its prerequisites, and marks it as `Visited` after the traversal.
	- It appends the job to the `orderedJobs` list in the correct order.

	6. `JobGraph` struct:
	- This struct represents the job graph.
	- `Nodes` is a list of all the job nodes in the graph.
	- `Graph` is a map where the key is the job ID, and the value is a pointer to the corresponding `JobNode` in the graph.

	7. `NewJobGraph` function:
	- This function creates a new instance of the `JobGraph` struct and initializes its `Graph` field with an empty map.
	- It also adds individual job nodes to the `Nodes` list.

	8. `Addprereq`, `AddNode`, and `GetNode` functions:
	- These are helper functions to add prerequisites to a job, add a new job node to the graph, and get an existing job node, respectively.

	9. `JobNode` struct:
	- This struct represents a node in the job graph.
	- `Job` is the job ID.
	- `Prereqs` is a list of pointers to other job nodes that are prerequisites for the current job.
	- `Visited` and `Visiting` are boolean flags used during the depth-first traversal to track the traversal status of each node.

	Overall, the code implements the topological sorting algorithm using depth-first traversal to find the order in which jobs can be executed without violating their dependencies. It efficiently handles circular dependencies and returns the ordered jobs or an empty list if a circular dependency is detected.

	O(j + d) time | O(j + d) space - where j is the number of jobs and d is the number of dependencies
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Dep {
    int Prereq;
    int Job;

    public Dep(int Prereq, int Job) {
        this.Prereq = Prereq;
        this.Job = Job;
    }
}

class JobGraph {

    // Inner class representing a job node
    static class JobNode {
        int job; // Job ID
        List<JobNode> prereqs; // List of prerequisite job nodes
        boolean visited; // Flag to mark if the node has been visited
        boolean visiting; // Flag to mark if the node is currently being visited

        // Constructor to initialize a job node
        public JobNode(int job) {
            this.job = job;
            this.prereqs = new ArrayList<>();
            this.visited = false;
            this.visiting = false;
        }
    }

    List<JobNode> nodes; // List of all job nodes in the graph
    Map<Integer, JobNode> graph; // Map to store the job nodes by their IDs

    // Constructor to create a job graph from a list of jobs
    public JobGraph(List<Integer> jobs) {
        this.nodes = new ArrayList<>();
        this.graph = new HashMap<>();
        for (int job : jobs) {
            // Add each job as a node to the graph
            addNode(job);
        }
    }

    // Function to add a prerequisite to a job node
    public void addPrereq(int job, int prereq) {
        JobNode jobNode = getNode(job);
        JobNode prereqNode = getNode(prereq);
        // Add the prerequisite node to the list of prerequisites for the job node
        jobNode.prereqs.add(prereqNode);
    }

    // Function to add a new job node to the graph
    public void addNode(int job) {
        // Create a new job node and add it to the graph and nodes list
        JobNode node = new JobNode(job);
        graph.put(job, node);
        nodes.add(node);
    }

    // Function to get a job node from the graph by its ID
    public JobNode getNode(int job) {
        // If the node does not exist in the graph, create a new node and add it to the graph
        if (!graph.containsKey(job)) {
            addNode(job);
        }
        return graph.get(job);
    }
}

public class Main {

    // Function to perform topological sorting and return the ordered jobs
    public static List<Integer> TopologicalSort(List<Integer> jobs, List<Dep> deps) {
        // Create a job graph from the list of jobs and dependencies
        JobGraph graph = createJobGraph(jobs, deps);
        // Get the ordered jobs using depth-first traversal
        return getOrderedJobs(graph);
    }

    // Function to create a job graph from a list of jobs and dependencies
    public static JobGraph createJobGraph(List<Integer> jobs, List<Dep> deps) {
        // Initialize an empty graph
        JobGraph graph = new JobGraph(jobs);
        // Add each dependency as a prerequisite to the corresponding job node in the graph
        for (Dep dep : deps) {
            graph.addPrereq(dep.Job, dep.Prereq);
        }
        return graph;
    }

    // Function to perform depth-first traversal and get the ordered jobs
    public static List<Integer> getOrderedJobs(JobGraph graph) {
        List<Integer> orderedJobs = new ArrayList<>();
        List<JobGraph.JobNode> nodes = graph.nodes;

        // Continue the traversal until all nodes have been visited
        while (!nodes.isEmpty()) {
            // Get the last node from the list of nodes and remove it from the list
            JobGraph.JobNode node = nodes.remove(nodes.size() - 1);

            // Perform depth-first traversal starting from the current node
            if (!depthFirstTraverse(graph, node.job, orderedJobs)) {
                return new ArrayList<>(); // If a cycle is detected during traversal, return an empty list
            }
        }
        return orderedJobs;
    }

    // Function to perform depth-first traversal starting from a specific job node
    public static boolean depthFirstTraverse(JobGraph graph, int jobId, List<Integer> orderedJobs) {
        // Get the job node from the graph
        JobGraph.JobNode node = graph.getNode(jobId);

        // If the node has been visited, it means it is not part of any cycle, so return false
        if (node.visited) {
            return false;
        }

        // If the node is currently being visited, it means there is a cycle, so return true
        if (node.visiting) {
            return true;
        }

        // Mark the node as currently being visited
        node.visiting = true;

        // Recursively traverse through each prerequisite of the current node
        for (JobGraph.JobNode prereqNode : node.prereqs) {
            // If a cycle is detected during the traversal, return true
            if (depth
