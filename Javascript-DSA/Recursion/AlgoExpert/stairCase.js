//! https://www.algoexpert.io/questions/Staircase%20Traversal

//? using sliding window O(n) time | O(n) space  

function stairCaseTraversal(height, maxSteps) {
    let currentNumberOfWays = 0;
    const waysToTop = [1];

    for(currentHeight = 1; currentHeight < height + 1; currentHeight++) {
        const startOfWindow = currentHeight - maxSteps - 1;
        const endOfWindow = currentHeight - 1;
        if(startOfWindow >= 0) currentNumberOfWays -= waysToTop[startOfWindow];
        currentNumberOfWays += waysToTop[endOfWindow]
        waysToTop.push(currentNumberOfWays);
    }
    return waysToTop[height];
}

//? O(n * k) time | O(n) space
function stairCaseTraversal(height, maxSteps) {
    const waysToTop = new Array(height + 1).fill(0);
    waysToTop[0] = 1;
    waysToTop[1] = 1;

    for(let currentHeight = 2; currentHeight < height + 1; currentHeight++) {
        let step = 1;
        while(step <= maxSteps && step <= currentHeight) {
            waysToTop[currentHeight] = waysToTop[currentHeight] + waysToTop[currentHeight - 1];
            step++;
        }
    }
    return waysToTop[height];
}

//! O(n*k) time | O(n) space - where n is the height of the staircase and k is the number of allowed steps.
//todo using Dynamic Programming

function stairCaseTraversal(height, maxSteps) {
    return numberOfWaysToTop(height, maxSteps, {0: 1, 1: 1});
}

function numberOfWaysToTop(height, maxSteps, memoize) {
    if(height in memoize) {
        return memoize[height];
    }
    let numberOfWays = 0;
    for(let step = 1; step < Math.min(height, maxSteps) + 1; step++) {
        numberOfWays += numberOfWaysToTop(height - step, maxSteps, memoize)
    }
    memoize[height] = numberOfWays;

    return numberOfWays;
}

//! O(k^n) time | O(n) space - where n is the height of the staircase and k is the number of allowed steps.
function stairCaseTraversal(height, maxSteps) {
    return numberOfWaysToTop(height, maxSteps);
}

function numberOfWaysToTop(height, maxSteps) {
    if(height <= 1) return 1;

    let numberOfWays = 0;
    for(let step = 1; step < Math.min(height, maxSteps) + 1; step++) {
        numberOfWays += numberOfWaysToTop(height - step, maxSteps);
    }
    return numberOfWays;
}

console.log(stairCaseTraversal(4, 2));