class Solution {
public:
    long long minimumCost(vector<int>& nums, int k, int dist) {
        // Base cost is always nums[0]
        long long base = nums[0];
        int n = nums.size();
        
        // We need to pick k-2 additional elements from the window (i, i+dist]
        int target = k - 2;
        
        // Edge Case: If k=2, we don't pick any additional neighbors.
        // We just need the minimum pivot nums[i] (1 <= i < n).
        if (target == 0) {
            int minVal = INT_MAX;
            for (int i = 1; i < n; i++) minVal = min(minVal, nums[i]);
            return base + minVal;
        }

        // Data Structures for Sliding Window
        // L stores the smallest 'target' elements, R stores the rest.
        multiset<int> L, R;
        long long sumL = 0;

        // Helper: Add value to window
        auto add = [&](int val) {
            L.insert(val);
            sumL += val;
            // If L grows too large, move the largest element to R
            if (L.size() > target) {
                auto it = prev(L.end()); // Largest in L
                sumL -= *it;
                R.insert(*it);
                L.erase(it);
            }
        };

        // Helper: Remove value from window
        auto remove = [&](int val) {
            auto it = L.find(val);
            if (it != L.end()) {
                // Element is in L: Remove it and refill L from R
                sumL -= *it;
                L.erase(it);
                if (!R.empty()) {
                    auto minR = R.begin(); // Smallest in R
                    sumL += *minR;
                    L.insert(*minR);
                    R.erase(minR);
                }
            } else {
                // Element is in R: Just remove it
                it = R.find(val);
                if (it != R.end()) {
                    R.erase(it);
                }
            }
        };

        // 1. Initialize Window for pivot i=1
        // The valid window for neighbors is indices [2, 1 + dist]
        for (int j = 2; j <= min(n - 1, 1 + dist); j++) {
            add(nums[j]);
        }

        long long minTotalCost = LLONG_MAX;

        // 2. Slide the pivot 'i' from 1 to n
        // Max valid i is determined by needing at least (k-2) elements after it.
        // However, the window constraints handle validity naturally.
        for (int i = 1; i <= n - k + 1; i++) {
            // If we have enough elements to form a valid set
            if (L.size() == target) {
                long long currentCost = base + nums[i] + sumL;
                minTotalCost = min(minTotalCost, currentCost);
            }

            // Prepare for next iteration (i becomes i+1)
            
            // 1. The element at 'i+1' is currently in the neighbor pool.
            // It will become the NEW pivot, so remove it from the pool.
            if (i + 1 < n) {
                remove(nums[i + 1]);
            }

            // 2. The window slides right, encompassing 'i + 1 + dist'.
            // Add this new element to the pool.
            if (i + 1 + dist < n) {
                add(nums[i + 1 + dist]);
            }
        }

        return minTotalCost;
    }
};