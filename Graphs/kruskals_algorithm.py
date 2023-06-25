#Question: Implement Kruskal's algorithm in Python to find the minimum spanning tree of a given graph.
#Intuition:
# Kruskal's algorithm is a greedy algorithm that aims to find the minimum spanning tree (MST) of a connected, weighted graph.
# The MST is a subset of the graph's edges that connects all the vertices with the minimum total weight.
# The algorithm works by iteratively selecting the edges in ascending order of their weights, while ensuring that adding an edge to the growing MST does not create a cycle. 
#It uses a disjoint set data structure, typically implemented with the Union-Find algorithm, to efficiently keep track of the connected components and 
# detect cycles.

#Implementing Kruskal's algorithm with the help of a Union-Find data structure allows for efficient detection of cycles and union operations,
#resulting in a time complexity of O(E log E), where E is the number of edges in the graph.

# Initialize a Union-Find data structure to keep track of the connected components.
class UnionFind:
    def __init__(self, n):
        # Initialize the parent and rank lists
        self.parent = list(range(n))
        self.rank = [0] * n

    def find(self, x):
        # Find the root of the set to which x belongs
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])  # Path compression
        return self.parent[x]

    def union(self, x, y):
        # Perform the union of two sets
        root_x = self.find(x)
        root_y = self.find(y)

        if root_x != root_y:
            if self.rank[root_x] < self.rank[root_y]:
                self.parent[root_x] = root_y
            elif self.rank[root_x] > self.rank[root_y]:
                self.parent[root_y] = root_x
            else:
                self.parent[root_y] = root_x
                self.rank[root_x] += 1

# Define the Kruskal function
def kruskal(graph):
    edges = []
    for u in range(len(graph)):
        for v, weight in graph[u]:
            edges.append((weight, u, v))

    edges.sort()
   # Create an empty list to store the MST
    mst = []
    uf = UnionFind(len(graph))

    for weight, u, v in edges:
        if uf.find(u) != uf.find(v):
            uf.union(u, v)
            mst.append((u, v, weight))

    return mst

# Example usage: Create a list of all the edges in the graph, along with their weights.
graph = [
    [(1, 1), (2, 2)],           # Node 0
    [(0, 1), (2, 3), (3, 4)],   # Node 1
    [(0, 2), (1, 3), (3, 5)],   # Node 2
    [(1, 4), (2, 5)]            # Node 3
]
#Sort the edges in ascending order based on their weights.
mst = kruskal(graph)
for u, v, weight in mst:
    print(f"Edge ({u}, {v}) with weight {weight}")
