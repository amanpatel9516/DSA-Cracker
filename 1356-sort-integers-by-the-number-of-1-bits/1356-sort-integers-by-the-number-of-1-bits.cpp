class Solution {
public:
    vector<int> sortByBits(vector<int>& arr) {
        
        sort(arr.begin(), arr.end(), [](int a, int b) {
            
            int bitsA = __builtin_popcount(a);
            int bitsB = __builtin_popcount(b);

            // primary condition
            if(bitsA == bitsB)
                return a < b;

            // secondary condition
            return bitsA < bitsB;
        });

        return arr;
    }
}
;