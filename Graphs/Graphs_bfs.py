from collections import defaultdict

class Graph:
    def __init__(self):
        self.graph = defaultdict(list)

    def insertEdge(self,v1,v2):
        self.graph[v1].append(v2)

    def subBfs(self,visited,queue):
        while(queue):
            v=queue.pop(0)
            visited.add(v)
            print(v,end=" ")
            
            for neighbour in self.graph[v]:
                if neighbour not in visited:
                    queue.append(neighbour)
                    visited.add(neighbour)
        
    def bfs(self,v):
        visited=set()
        queue=[v]
        self.subBfs(visited,queue)

g=Graph()
g.insertEdge(1,2)
g.insertEdge(2,1)
g.insertEdge(2,3)
g.insertEdge(3,4)
g.insertEdge(4,5)
g.insertEdge(5,6)
g.insertEdge(2,6)

g.bfs(1)
