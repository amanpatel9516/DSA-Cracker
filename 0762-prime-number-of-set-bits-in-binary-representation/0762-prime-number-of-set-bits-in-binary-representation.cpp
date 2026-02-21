class Solution {
public:
    
    bool isPrime(int x) {
        return (x == 2 || x == 3 || x == 5 || x == 7 ||
                x == 11 || x == 13 || x == 17 || x == 19);
    }
    
    int countPrimeSetBits(int left, int right) {
        int ans = 0;

        for(int num = left; num <= right; num++) {
            
            // builtin popcount = count set bits
            int bits = __builtin_popcount(num);

            if(isPrime(bits))
                ans++;
        }

        return ans;
    }
};