# Graphs Dijkstras Implementation
# Program Author : Tyler Le

# Dijkstra's algorithm is a graph search algorithm 
# that solves the single-source shortest path problem 
# for a graph with non-negative edge weights

def dijkstra(graph, start):
    # Create a dictionary to store the shortest distances to each node
    shortest_distances = {node: float('inf') for node in graph}
    shortest_distances[start] = 0
    
    # Create a set to store nodes that have been processed
    processed_nodes = set()
    
    # Create a priority queue to store nodes and their distances
    queue = [(start, 0)]
    
    while queue:
        # Get the node with the smallest distance from the start node
        current_node, current_distance = min(queue, key=lambda x: x[1])
        queue.remove((current_node, current_distance))
        
        # If we've already processed this node, skip it   
        if current_node in processed_nodes:
            continue
        
        # Mark this node as processed
        processed_nodes.add(current_node)
        
        # Update the shortest distances to all neighboring nodes
        for neighbor, weight in graph[current_node].items():
            distance = current_distance + weight
            if distance < shortest_distances[neighbor]:
                shortest_distances[neighbor] = distance
                queue.append((neighbor, distance))
    
    return shortest_distances

# Example usage
graph = {
    'A': {'B': 5, 'C': 1},
    'B': {'A': 5, 'C': 2, 'D': 1},
    'C': {'A': 1, 'B': 2, 'D': 4},
    'D': {'B': 1, 'C': 4}
}

start_node = 'A'
distances = dijkstra(graph, start_node)

print(distances)
