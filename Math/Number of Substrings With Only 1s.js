
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
