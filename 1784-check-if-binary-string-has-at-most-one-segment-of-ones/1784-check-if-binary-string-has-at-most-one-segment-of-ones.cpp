class Solution {
public:
    bool checkOnesSegment(string s) {
        
        bool zeroFound = false;
        
        for(char c : s)
        {
            if(c == '0')
                zeroFound = true;
            
            if(c == '1' && zeroFound)
                return false;
        }
        
        return true;
    }
};