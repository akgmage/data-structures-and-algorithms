from collections import defaultdict

class Graph:
    def __init__(self):
        self.graph = defaultdict(list)
    
    def insertEdge(self,v1,v2):
        self.graph[v1].append(v2)
    
    def dfsSub(self,v,visited):

        visited.add(v)
        print(v,end=" ")

        for neighbour in self.graph[v]:
            if neighbour not in visited:
                self.dfsSub(neighbour,visited)

    def dfs(self,v):

        visited = set()
        self.dfsSub(v,visited)

g=Graph()
g.insertEdge(1,2)
g.insertEdge(2,1)
g.insertEdge(3,4)
g.insertEdge(4,5)
g.insertEdge(5,6)
g.insertEdge(2,6)

g.dfs(2)
        
