// AUTHOR : SAGAR WADHWA
// PRO-TIP : DO THIS ON PEN AND PAPER, RECURSION CAN'T BE EXPLAIEND VIA COMMENTS.
class Solution {
public:
    void solve(string output, int numberOfOpeningBrackets, int numberOfClosingBrackets, vector<string> &answer){
        //base case
        if(numberOfOpeningBrackets == 0 && numberOfClosingBrackets == 0){
            answer.push_back(output);
            return;
        }

        //include opening bracket
        if(numberOfOpeningBrackets>0){

            output.push_back('(');
            solve(output, numberOfOpeningBrackets-1, numberOfClosingBrackets, answer);

            //backtrack
            output.pop_back();
        }

        //include closing bracket
        if(numberOfClosingBrackets > numberOfOpeningBrackets){

            output.push_back(')');
            solve(output, numberOfOpeningBrackets, numberOfClosingBrackets-1, answer);

            //backtrack, by removing the added character and try out other path
            output.pop_back();
        }
    }
    vector<string> generateParenthesis(int n) {
        vector<string> answer;
        //initially the number of opening and the closing brackets will be equals to n
        // while finding the solution we will try out all the possible combinations in which
        // the parenthesis can be added.
        int numberOfOpeningBrackets = n;
        int numberOfClosingBrackets = n;

        //output string which will denote the answer which is being formed in recurison
        string output = "";
        solve(output, numberOfOpeningBrackets, numberOfClosingBrackets, answer);
        return answer;
    }   
};