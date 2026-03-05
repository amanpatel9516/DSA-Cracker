class Solution {
public:
    int minOperations(string s) {
        
        int changeStart0 = 0;
        int changeStart1 = 0;

        for(int i = 0; i < s.size(); i++){
            
            // Pattern: 010101...
            if(i % 2 == 0){
                if(s[i] != '0') changeStart0++;
            } else {
                if(s[i] != '1') changeStart0++;
            }

            // Pattern: 101010...
            if(i % 2 == 0){
                if(s[i] != '1') changeStart1++;
            } else {
                if(s[i] != '0') changeStart1++;
            }
        }

        return min(changeStart0, changeStart1);
    }
};