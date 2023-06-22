def riverSizes(matrix):
    # List to store the sizes of rivers
    sizes = []

    # Create a visited matrix to keep track of visited nodes
    visited = [[False for _ in range(len(matrix[0]))] for _ in range(len(matrix))]

    # Iterate over each cell in the matrix
    for i in range(len(matrix)):
        for j in range(len(matrix[i])):
            # If the cell has already been visited, continue to the next iteration
            if visited[i][j]:
                continue

            # Explore the river connected to the current cell and update sizes
            sizes = traverseNode(i, j, matrix, visited, sizes)

    return sizes


def traverseNode(i, j, matrix, visited, sizes):
    # Variable to track the size of the current river
    currentRiverSize = 0

    # Queue to store nodes that need to be visited
    nodesToExplore = [[i, j]]

    # Loop until there are no more nodes to explore
    while nodesToExplore:
        # Dequeue the first node from the queue and update the current position (i, j)
        currentNode = nodesToExplore.pop(0)
        i, j = currentNode[0], currentNode[1]

        # If the current node has already been visited, continue to the next iteration
        if visited[i][j]:
            continue

        # Mark the current node as visited
        visited[i][j] = True

        # If the current node is land (0), continue to the next iteration
        if matrix[i][j] == 0:
            continue

        # Increment the size of the current river
        currentRiverSize += 1

        # Get the unvisited neighboring nodes of the current node
        unvisitedNeighbors = getUnvisitedNeighbors(i, j, matrix, visited)

        # Add the unvisited neighbors to the nodesToExplore queue
        nodesToExplore.extend(unvisitedNeighbors)

    # If the current river size is greater than 0, append it to the sizes list
    if currentRiverSize > 0:
        sizes.append(currentRiverSize)

    return sizes


def getUnvisitedNeighbors(i, j, matrix, visited):
    # List to store unvisited neighboring nodes
    unvisitedNeighbors = []

    # Check the four neighboring cells (up, down, left, right) of the current cell
    # and add unvisited neighbors to the unvisitedNeighbors list

    # Up neighbor
    if i > 0 and not visited[i - 1][j]:
        unvisitedNeighbors.append([i - 1, j])

    # Down neighbor
    if i < len(matrix) - 1 and not visited[i + 1][j]:
        unvisitedNeighbors.append([i + 1, j])

    # Left neighbor
    if j > 0 and not visited[i][j - 1]:
        unvisitedNeighbors.append([i, j - 1])

    # Right neighbor
    if j < len(matrix[0]) - 1 and not visited[i][j + 1]:
        unvisitedNeighbors.append([i, j + 1])

    return unvisitedNeighbors
