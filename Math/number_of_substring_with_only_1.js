// Program Author : TheCodeVenturer[Niraj Modi]
/*
    Program Definition : Number of Substrings With Only 1s in Javascript
        Description : We are required to find no.of substrings with only 1's is possible
    
    Approach:
        BruteForce : 
            we can create a nested loop to find each substring from each each 1's positions. Which will require O(n^2) complexity for worst Cases.
        Optimal Approach:
            Using Mathematical Formula
                No.of Substrings = n*(n+1)/2    n <- size of string
                we are only required to find substrings which only consists of 1

            now for this we will apply this formula for all group of ones so that total no.of substrings can be generated
            [Note: for each group of use the formula and add the result to 2nd variable sol and set count to zero for next group of ones]
    Complexity:
		The time complexity of this solution is O(n) because i will parent and nested folder will together run for n times only. 
		The space complexity is O(1),we are not using any Auxiliary Spaces.
    Sample input/outputs:
		Example 1:
		Input: "0110111"
		Output: 9

		Example 2:
		Input: "101"
		Output: 2

		Example 3:
		Input: "1111111"
		Output: 28
 */
const mod = 1e9+7 // For handling the overflow of integer
var numSub = function(s) {
    var sol=0;                  //Solution variable which will be return finally
    for(let i=0;i<s.length;){    // iterating for each index
        let count=0;            
        while(s[i]=='1'){       // finding size of each group
            count++
            i++
        }
        if(count==0)            //if count is 1 means the current element was 0
            i++                 //updating i here as parent loop is not doing any update on the iterative variable
        sol = (sol + count*(count+1)/2)%mod         // Applying the formula for 1's of size counr and adding it sol and storing remainder to handle overflow
    }
    return sol  //Finally return Solution
};


s="0110111"
console.log(numSub(s))