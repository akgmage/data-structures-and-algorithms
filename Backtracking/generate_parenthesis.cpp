// AUTHOR : SAGAR WADHWA
// PRO-TIP : DO THIS ON PEN AND PAPER, RECURSION CAN'T BE EXPLAIEND VIA COMMENTS.
/*
Generate parenthesis problem on leetcode : https://leetcode.com/problems/generate-parentheses/description/

Problem Statement : Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]

Approach : The approach used here is that since we are given "n" pairs of brackets, that means initially we will be having "n" number
of opening brackets as well as "n" number of closing brackets. Here, we can use recursion and backtracking to find out all the
different possible solution as the question has asked us to generate valid parenthesis. While making recursion calls, we will be keeping
an output string which will be storing the pattern of brakcets which has been formed till now, another two variables will be storing
the number of opening and the number of closing brackets we are left with. Also pass a vector of string which will be storing our all
the possible combinations of the string.

Here the base case will be the condition when all the opening and the closing brackets are finished. In this case just push the answer
generated from the output string in the vector of string named answer.

Another condition that can be here is that at a moment we are left with more number of opening brackets than the number of closing brackets.
In this case we will have to first insert the opening bracket and then again make a recursive call but this time the number of opening
brackets will decrease by one.

If the number of closing brackets are greater than the number of opening brackets, then we will have to add the closing brackets in
the string, so this time add a closing bracket and then make a recursive call but the number of closing brackets will be decreased by one

Observation that you can get from the recursive tree
Whenever we have count of open brackets equal to the count of close brackets, we have only one choice - that is to use '('. Because, all the brackets till now have been balanced. And we can not start a new sequence with ')'.
Whenever, count of close bracket is 0, we can only use '('.
Whenever, count of open bracket is 0, we can only use ')'.
And for all the remaining cases, we have both the choices.
We get an answer, when count of open == 0 and count of close == 0.

Time complexity: O(2^(2n) * n)
We are generating all possible strings of length 2n. At each character, we have two choices: choosing ( or ), which means there are a total
of 2^(2n) unique strings.

For each string of length 2n, we need to iterate through each character to verify it is a valid combination of parentheses, which
takes an average of O(n)

Space complexity: O(2^(2n) * n)
*/
class Solution
{
public:
    void solve(string output, int numberOfOpeningBrackets, int numberOfClosingBrackets, vector<string> &answer)
    {
        // base case
        if (numberOfOpeningBrackets == 0 && numberOfClosingBrackets == 0)
        {
            answer.push_back(output);
            return;
        }

        // include opening bracket
        if (numberOfOpeningBrackets > 0)
        {

            output.push_back('(');
            solve(output, numberOfOpeningBrackets - 1, numberOfClosingBrackets, answer);

            // backtrack
            output.pop_back();
        }

        // include closing bracket
        if (numberOfClosingBrackets > numberOfOpeningBrackets)
        {

            output.push_back(')');
            solve(output, numberOfOpeningBrackets, numberOfClosingBrackets - 1, answer);

            // backtrack, by removing the added character and try out other path
            output.pop_back();
        }
    }
    vector<string> generateParenthesis(int n)
    {
        vector<string> answer;
        // initially the number of opening and the closing brackets will be equals to n
        //  while finding the solution we will try out all the possible combinations in which
        //  the parenthesis can be added.
        int numberOfOpeningBrackets = n;
        int numberOfClosingBrackets = n;

        // output string which will denote the answer which is being formed in recurison
        string output = "";
        solve(output, numberOfOpeningBrackets, numberOfClosingBrackets, answer);
        return answer;
    }
};