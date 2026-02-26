class Solution {
public:
    int numSteps(string s) {
        
        int steps = 0;
        int carry = 0;

        // traverse from right to left (ignore first bit)
        for(int i = s.size() - 1; i > 0; i--) {

            int bit = (s[i] - '0') + carry;

            // odd
            if(bit == 1) {
                steps += 2;   // +1 then /2
                carry = 1;
            }
            // even
            else {
                steps += 1;   // only /2
            }
        }

        // if carry remains
        return steps + carry;
    }
};