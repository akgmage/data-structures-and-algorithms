#include <stdio.h>
#include <limits.h>

#define N 4 // Number of workers and tasks

void hungarianAlgorithm(int costMatrix[N][N]);

int main() {
    int costMatrix[N][N] = {
        {9, 2, 7, 8},
        {6, 4, 3, 7},
        {5, 8, 1, 8},
        {7, 6, 9, 4}
    };

    hungarianAlgorithm(costMatrix);

    return 0;
}

void hungarianAlgorithm(int costMatrix[N][N]) {
    int i, j;
    int numWorkers = N, numTasks = N;

    int minCost, minCostIdx;
    int rowCover[N] = {0};
    int colCover[N] = {0};
    int assignment[N][2] = {0}; // Stores the assignment

    // Step 1: Subtract the smallest value in each row from all elements in that row
    for (i = 0; i < numWorkers; i++) {
        minCost = INT_MAX;
        for (j = 0; j < numTasks; j++) {
            if (costMatrix[i][j] < minCost) {
                minCost = costMatrix[i][j];
            }
        }
        for (j = 0; j < numTasks; j++) {
            costMatrix[i][j] -= minCost;
        }
    }

    // Step 2: Find a zero in the cost matrix and mark the row and column
    for (i = 0; i < numWorkers; i++) {
        for (j = 0; j < numTasks; j++) {
            if (costMatrix[i][j] == 0 && !rowCover[i] && !colCover[j]) {
                assignment[i][0] = i;
                assignment[i][1] = j;
                rowCover[i] = 1;
                colCover[j] = 1;
            }
        }
    }

    // Step 3: Check if all rows are covered
    int rowCoveredCount = 0;
    for (i = 0; i < numWorkers; i++) {
        rowCoveredCount += rowCover[i];
    }

    if (rowCoveredCount == numWorkers) {
        // All rows are covered, we have the optimal assignment
        printf("Optimal Assignment:\n");
        for (i = 0; i < numWorkers; i++) {
            printf("Worker %d -> Task %d\n", assignment[i][0] + 1, assignment[i][1] + 1);
        }
        return;
    } else {
        // Proceed to step 4
    }
    
    // Step 4: Find the minimum uncovered value (minCost) in the cost matrix
    minCost = INT_MAX;
    for (i = 0; i < numWorkers; i++) {
        for (j = 0; j < numTasks; j++) {
            if (!rowCover[i] && !colCover[j] && costMatrix[i][j] < minCost) {
                minCost = costMatrix[i][j];
            }
        }
    }

    // Step 5: Subtract minCost from all uncovered elements and add it to all elements at the intersection of covering lines
    for (i = 0; i < numWorkers; i++) {
        for (j = 0; j < numTasks; j++) {
            if (!rowCover[i] && !colCover[j]) {
                costMatrix[i][j] -= minCost;
            } else if (rowCover[i] && colCover[j]) {
                costMatrix[i][j] += minCost;
            }
        }
    }

    // Continue to step 3
    hungarianAlgorithm(costMatrix);
}
