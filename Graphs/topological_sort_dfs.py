"""
Implementation of Topological sort using DFS
According to Introduction to Algorithms, given a directed acyclic graph (DAG), 
a topological sort is a linear ordering of all vertices such that for any edge
(u, v), u comes before v. Another way to describe it is that when you put all
vertices horizontally on a line, all of the edges are pointing from left to right.

Time complexity O(Vertices + Edges)
"""

def main():
    adj_list = {
        5: [2, 0],
        4: [0, 1],
        3: [1],
        2: [3],
        1: [],
        0: []
    }

    dfs(adj_list, set(), [])



def dfs(adj_list, visited, stack):
    for vertex in range(6):
        if vertex in visited:
            continue
        dfs_visit(adj_list, visited, vertex, stack)

    print(stack[::-1])


def dfs_visit(adj_list, visited, node, stack):
    visited.add(node)

    for neighbor in adj_list[node]:
        if neighbor in visited:
            continue
        dfs_visit(adj_list, visited, neighbor, stack)

    stack.append(node)



if __name__ == "__main__":
    main()