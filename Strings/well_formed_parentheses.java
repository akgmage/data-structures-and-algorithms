/**

   Time Complexity: O(2^n * n), Space Complexity: O(n).

   Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

   Example 1:
   Input: n = 3
   Output: ["((()))","(()())","(())()","()(())","()()()"]


   Example 2:
   Input: n = 1
   Output: ["()"]


   Constraints:

      1 <= n <= 8


**/


class Solution {


    public List<String> generateParenthesis(int n) {

        ArrayList<String> validParenthesis = new ArrayList<String>();
	/**
           We need to generate every n pair valid parenthses.

           What we are going to do is try every possible combination
           if we have a 2 pair parenthes p: ????
           each question mark could be '(' or ')'.
           ex: ()() or (()) or ((()
           so we have a total of (2 ^ (2 * n)) combination.

           if we say that an open bracket '(' can be expressed as 0
           and a closed bracket ')' can be expressed 1.

           0000 -> ((((
           0001 -> ((()
           0010 -> (()(
           0011 -> (())
           0100 -> ()((
           0101 -> ()()
            .
            .
            .
            .
            .
           1111 -> ))))

        **/
        for (int i = 0; i < (1 << (2 * n)); ++i)
    	{
	    String aParenthesis = "";
	    for(int j = 0; j < 2 * n; ++j)
	    {
		if(((i >> j) & 1) == 1)
		{
		    aParenthesis += '(';
		}
		else
		    aParenthesis += ')';
	    }
    	    if(isValid(aParenthesis))
    		validParenthesis.add(aParenthesis);
    	}

    	return validParenthesis;
    }


    /**
        Function: isValid check if parenthesis is balanced or not.


        For each open bracket we find we pushed it to the stack.

        If We find a closed bracket we check the top of the stack
           if it is an open bracket that's mean we find a corrsponding closing bracket so, we removed it.

           else the top of the stack is a closed bracket that means there is no open bracket that matches that closed bracket,
           that's means the parenthesis is NOT valid or balanced so, we return false.


           At the end if we find that the stack is empty that's mean that each open breack has a  corrsponding closed bracket,
           so, we return true otherwise we return false.
    **/

    public boolean isValid(String s) {

        int n = s.length();
	Stack<Character> st = new Stack<Character>();

        for(int i = 0; i < n; ++i)
	{
            char ch = s.charAt(i);
	    if( ch == '(')
	    {
		st.push(ch);
	    }
	    else
	    {
	        if(!st.empty() && st.peek() == '(')
		    st.pop();
	        else
                    return false;
	    }
	}

	return st.empty();
    }
}
