case-specific sorting of strings (GFG)
Given a string S consisting of only uppercase and lowercase characters. The task is to sort uppercase and lowercase letters separately such that if the ith place in the original string had an Uppercase character then it should not have a lowercase character after being sorted and vice versa.

Example 1:

Input:
N = 12
S = defRTSersUXI
Output: deeIRSfrsTUX
Explanation: Sorted form of given string
with the same case of character as that
in original string is deeIRSfrsTUX
Example 2:

Input:
N = 6
S = srbDKi
Output: birDKs
Explanation: Sorted form of given string
with the same case of character
result in output as birDKs.
Your Task:
You only need to complete the function caseSort, that takes a string str and the length of the string n and returns sorted string.

Explanation: In this problem, we  create three strings based on the given string.One for storing the capital letters named as caps string (string caps=""), second for small letters (string small="") and finally the third string (string ans="") which would store the final result.
We will sort the strings in order to maintain  alphabetical order.
Then we traverse the given string using  x (pointer) ,  i and j pointers for the caps and small strings. j pointer is used to traverse the string caps while i used to traverse the string small.
x pointer is used to iterate through the given string as a whole and for each capital  letter found we will insert the the letter from string caps into the string ans.
Similarly, for each small letter, we will insert it from the string small into the ans string.
Finally we return the ans string.

CODE:

class Solution
{
    public:
    //Function to perform case-specific sorting of strings.
    string caseSort(string str, int n)
    {
        string small="", caps = "",ans="";
        for(auto x:str){
            if(isupper(x)){
                caps+=x;
            }
            else{
                small+=x;
            }
        }
        sort(caps.begin(),caps.end());
        sort(small.begin(),small.end());
        int i=0,j=0;
        for(auto x:str){
            if(isupper(x)){
                ans+=caps[j];
                j++;
            }
            else{
                ans+=small[i];
                i++;
            }
        }
        return ans;
        // your code here
    }
};
