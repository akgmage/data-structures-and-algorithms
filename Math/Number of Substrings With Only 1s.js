/*
  PROBLEM STATEMENT:
  
  Given a binary string s, return the number of substrings with all characters 1's. Since the answer may be too large, return it modulo 109 + 7.
  
  EXAMPLE 1:
      Input: s = "0110111"
      Output: 9
      Explanation: There are 9 substring in total with only 1's characters.
      "1" -> 5 times.
      "11" -> 3 times.
      "111" -> 1 time.
  EXAMPLE 2:
      Input: s = "101"
      Output: 2
      Explanation: Substring "1" is shown 2 times in s.
      
  CONSTRAINT:
      Constraints:
      1 <= s.length <= 105
      s[i] is either '0' or '1'.
*/

/* Explaination

 The function begins by initializing two variables - "count" and "answer" - to 0. 
 "count" will be used to keep track of the current number of consecutive 1's in the string,
 while "answer" will eventually store the final answer.

The constant "mod" is defined to be 10^9+7, which will be used to take modulo of the answer
at each step, in order to prevent overflow.

The function then iterates through the input string using a for loop.
For each character in the string, it checks if it is a 1 or a 0. If it is a 1,
the "count" variable is incremented by 1. If it is a 0, the "count" variable is reset to 0.

At each step of the loop, the value of "count" is added to "answer" and then taken modulo "mod".
This is done to count the number of substrings with all 1's and prevent overflow of the result.

After the loop has finished, the final value of "answer" is returned as the solution to the problem.


*/


var numSub = function(s) {
  // count stores the current number of consecutive 1's
  var count=0;
  // answer storese the final answer to be returned
  var answer=0;
  // we mod the sum at each step so that they don't overflow
  const mod=1000000007;
  // iterate the entire string
  for(let i=0;i<s.length;i++){
      // if we find 1, we update the count=count+1 
      // if we find 0, we update the count=0
      count=s.charAt(i)=="1"?count+1:0;
      // we add the value of count to the answer (adding number of substring at each step)
      answer=(answer+count)%mod;
  }
  // return the final answer.
  return answer;
};


/* Time and Space complexity

The time complexity of this code is O(n),
where n is the length of the input string s. This is because we iterate through the entire string once,
and each operation inside the loop takes O(1) time.

The space complexity of this code is O(1),
because we only use a fixed amount of extra space to store the variables count, answer, mod, and i.
We do not use any additional space that depends on the length of the input string.








*/
