class Node {
    constructor(x, y) {
        this.x = x;
        this.y = y;
        this.g = 0; // Cost from start node to this node
        this.h = 0; // Heuristic cost from this node to target node
        this.f = 0; // Total cost (g + h)
        this.parent = null; // Parent node in the path
    }
}

function euclideanDistance(node1, node2) {
    const dx = node2.x - node1.x;
    const dy = node2.y - node1.y;
    return Math.sqrt(dx * dx + dy * dy);
}

function aStar(start, target, grid) {
    const openList = [start];
    const closedList = [];

    while (openList.length > 0) {
        let currentNode = openList[0];
        let currentIndex = 0;

        for (let i = 1; i < openList.length; i++) {
            if (openList[i].f < currentNode.f) {
                currentNode = openList[i];
                currentIndex = i;
            }
        }

        openList.splice(currentIndex, 1);
        closedList.push(currentNode);

        if (currentNode === target) {
            const path = [];
            let current = currentNode;
            while (current !== null) {
                path.unshift(current);
                current = current.parent;
            }
            return path;
        }

        const neighbors = getNeighbors(currentNode, grid);
        for (let neighbor of neighbors) {
            if (closedList.some(node => node === neighbor)) {
                continue;
            }

            const tentativeG = currentNode.g + euclideanDistance(currentNode, neighbor);
            let newPath = false;

            if (!openList.some(node => node === neighbor)) {
                openList.push(neighbor);
                newPath = true;
            } else if (tentativeG < neighbor.g) {
                newPath = true;
            }

            if (newPath) {
                neighbor.parent = currentNode;
                neighbor.g = tentativeG;
                neighbor.h = euclideanDistance(neighbor, target);
                neighbor.f = neighbor.g + neighbor.h;
            }
        }
    }

    return []; // No path found
}

function getNeighbors(node, grid) {
    const neighbors = [];
    const x = node.x;
    const y = node.y;

    if (x > 0) neighbors.push(grid[x - 1][y]);
    if (x < grid.length - 1) neighbors.push(grid[x + 1][y]);
    if (y > 0) neighbors.push(grid[x][y - 1]);
    if (y < grid[0].length - 1) neighbors.push(grid[x][y + 1]);

    return neighbors;
}

// Example usage
const grid = [
    [new Node(0, 0), new Node(1, 0), new Node(2, 0)],
    [new Node(0, 1), new Node(1, 1), new Node(2, 1)],
    [new Node(0, 2), new Node(1, 2), new Node(2, 2)]
];

const startNode = grid[0][0];
const targetNode = grid[2][2];

const path = aStar(startNode, targetNode, grid);
console.log(path);
