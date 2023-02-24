
class Solution {
public:
    bool halvesAreAlike(string s) {
        set<char> X {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        int half = s.size() / 2;
        int c = 0, d = 0;
        for(int i = 0; i < half; i++){
            if(X.find(s[i]) != X.end())
                c++;
        }
        for(int i = half; i < s.size(); i++){
            if(X.find(s[i]) != X.end()){
                d++;
            }
        }
        return c == d;
    }
};