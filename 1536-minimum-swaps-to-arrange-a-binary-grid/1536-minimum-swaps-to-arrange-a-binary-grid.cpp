#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int minSwaps(vector<vector<int>>& grid) {
        int n = grid.size();
        vector<int> zeros(n, 0);
        
        // Step 1: Precompute the number of trailing zeros for each row
        for (int i = 0; i < n; i++) {
            int count = 0;
            // Traverse from right to left
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    count++;
                } else {
                    break; // Stop at the first '1' from the right
                }
            }
            zeros[i] = count;
        }
        
        int swaps = 0;
        
        // Step 2: Greedily place a valid row at each index i
        for (int i = 0; i < n; i++) {
            int targetZeros = n - 1 - i;
            int j = i;
            
            // Find the first row (at or below i) that meets the target
            while (j < n && zeros[j] < targetZeros) {
                j++;
            }
            
            // If no valid row is found, the grid cannot be arranged
            if (j == n) return -1;
            
            // Step 3: Bubble the valid row up to position i
            // We swap adjacent elements to simulate the row swaps
            while (j > i) {
                swap(zeros[j], zeros[j - 1]);
                swaps++;
                j--;
            }
        }
        
        return swaps;
    }
};