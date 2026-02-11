import java.util.*;

class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            // Sets to track distinct numbers for the subarray starting at i
            Set<Integer> distinctEven = new HashSet<>();
            Set<Integer> distinctOdd = new HashSet<>();

            for (int j = i; j < n; j++) {
                int current = nums[j];
                
                if (current % 2 == 0) {
                    distinctEven.add(current);
                } else {
                    distinctOdd.add(current);
                }

                // Check if the counts of distinct numbers are equal
                if (distinctEven.size() == distinctOdd.size()) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }
}