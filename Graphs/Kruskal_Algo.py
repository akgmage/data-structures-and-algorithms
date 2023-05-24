class UnionFind:
    def __init__(self, n):
        self.parent = list(range(n))
        self.rank = [0] * n

    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, x, y):
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


def kruskal(graph):
    edges = []
    for u in range(len(graph)):
        for v, weight in graph[u]:
            edges.append((weight, u, v))

    edges.sort()
    mst = []
    uf = UnionFind(len(graph))

    for weight, u, v in edges:
        if uf.find(u) != uf.find(v):
            uf.union(u, v)
            mst.append((u, v, weight))

    return mst


# Example usage:
graph = [
    [(1, 1), (2, 2)],           # Node 0
    [(0, 1), (2, 3), (3, 4)],   # Node 1
    [(0, 2), (1, 3), (3, 5)],   # Node 2
    [(1, 4), (2, 5)]            # Node 3
]

mst = kruskal(graph)
for u, v, weight in mst:
    print(f"Edge ({u}, {v}) with weight {weight}")
