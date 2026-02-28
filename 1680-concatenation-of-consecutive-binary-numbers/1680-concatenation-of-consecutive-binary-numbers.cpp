class Solution {
public:
    int concatenatedBinary(int n) {
        
        const long long MOD = 1e9 + 7;
        long long ans = 0;
        int bitLength = 0;

        for(int i = 1; i <= n; i++) {

            // increase bit length when i is power of 2
            if((i & (i - 1)) == 0)
                bitLength++;

            ans = ((ans << bitLength) + i) % MOD;
        }

        return (int)ans;
    }
};