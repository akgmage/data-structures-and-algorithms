"""
A* Algorithm

Motivation - To approximate the shortest path in real-life situations, like- in maps, games where there can be many hindrances.

Unlike other traversal techniques which focus on the path to be taken, A* algorithm focuses on the distance to be travelled.
It is a combination of Uniform Cost Search(UCS) and Best First Search(BFS).

Explanation
A* algorithm is a best-first search algorithm in which the cost associated with a node is f(n) = g(n) + h(n), where g(n) is the cost of the path from the initial state to node n and h(n) is the heuristic estimate or the cost or a path from node n to a goal.
heuristic means guess or estimate.

Consider a square grid having many obstacles and we are given a starting cell and a target cell. We want to reach the target cell (if possible) from the starting cell as quickly as possible. 

Here g(n) is the distance between the current cell and the start cell. So we can say g(n) is the cost of the path from initial state to n. 
h(n) is a heuristic function that is used to estimate the cost of the cheapest path from n to the goal. So we can say h(n) is the cost from n to goal. 

So we can say f(n) is the cost of the cheapest path from initial state to goal passing through n.

pseudocode
1. Initialize the open list
2. Initialize the closed list
put the starting node on the open list (you can leave its f at zero)

3. while the open list is not empty
    a) find the node with the least f on the open list, call it "q"
    b) pop q off the open list
    c) generate q's 8 successors and set their parents to q
    d) for each successor
        i) if successor is the goal, stop search
    
        ii) else, compute both g and h for successor 
        successor.g = q.g + distance between successor and q
        successor.h = distance from goal to successor
        successor.f = successor.g + successor.h
        
        iii) if a node with the same position as successor is in the OPEN list which has a lower f than successor, skip this successor
        
        iv) if a node with the same position as successor is in the CLOSED list which has a lower f than successor, skip this successor
        otherwise, add the node to the open list
        
    e) push q on the closed list
    
For more information, visit: https://www.geeksforgeeks.org/a-search-algorithm/ or https://stackabuse.com/courses/graphs-in-python-theory-and-implementation/lessons/a-star-search-algorithm/
    
"""

from collections import deque


class Graph:
    # example of adjacency list (or rather map)
    # adjacency_list = {
    # 'A': [('B', 1), ('C', 3), ('D', 7)],
    # 'B': [('D', 5)],
    # 'C': [('D', 12)]
    # }

    def __init__(self, adjacency_list):
        self.adjacency_list = adjacency_list

    def get_neighbors(self, v):
        return self.adjacency_list[v]

    # heuristic function with equal values for all nodes
    def h(self, n):
        H = {"A": 1, "B": 1, "C": 1, "D": 1}

        return H[n]

    def a_star_algorithm(self, start_node, stop_node):
        # open_list is a list of nodes which have been visited, but who's neighbors
        # haven't all been inspected, starts off with the start node
        # closed_list is a list of nodes which have been visited
        # and who's neighbors have been inspected
        open_list = set([start_node])
        closed_list = set([])

        # g contains current distances from start_node to all other nodes
        # the default value (if it's not found in the map) is +infinity
        g = {}

        g[start_node] = 0

        # parents contains an adjacency map of all nodes
        parents = {}
        parents[start_node] = start_node

        while len(open_list) > 0:
            n = None

            # find a node with the lowest value of f() - evaluation function
            for v in open_list:
                if n == None or g[v] + self.h(v) < g[n] + self.h(n):
                    n = v

            if n == None:
                print("Path does not exist!")
                return None

            # if the current node is the stop_node
            # then we begin reconstructin the path from it to the start_node
            if n == stop_node:
                reconst_path = []

                while parents[n] != n:
                    reconst_path.append(n)
                    n = parents[n]

                reconst_path.append(start_node)

                reconst_path.reverse()

                print("Path found: {}".format(reconst_path))
                return reconst_path

            # for all neighbors of the current node do
            for m, weight in self.get_neighbors(n):
                # if the current node isn't in both open_list and closed_list
                # add it to open_list and note n as it's parent
                if m not in open_list and m not in closed_list:
                    open_list.add(m)
                    parents[m] = n
                    g[m] = g[n] + weight

                # otherwise, check if it's quicker to first visit n, then m
                # and if it is, update parent data and g data
                # and if the node was in the closed_list, move it to open_list
                else:
                    if g[m] > g[n] + weight:
                        g[m] = g[n] + weight
                        parents[m] = n

                        if m in closed_list:
                            closed_list.remove(m)
                            open_list.add(m)

            # remove n from the open_list, and add it to closed_list
            # because all of his neighbors were inspected
            open_list.remove(n)
            closed_list.add(n)

        print("Path does not exist!")
        return None


# Driver code

adjacency_list = {
    "A": [("B", 1), ("C", 3), ("D", 7)],
    "B": [("D", 5)],
    "C": [("D", 12)],
}

graph1 = Graph(adjacency_list)
graph1.a_star_algorithm("A", "D")

# Output:
# Path found: ['A', 'B', 'D']
# Explanation: The path with the lowest cost is A -> B -> D with a cost of 6.
