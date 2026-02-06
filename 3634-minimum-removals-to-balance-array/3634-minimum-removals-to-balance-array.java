import java.util.Arrays;

class Solution {
    public int minRemoval(int[] nums, int k) {
        // 1. Sort the array.
        // This allows us to treat the "kept" elements as a contiguous window.
        // Time Complexity: O(N log N)
        Arrays.sort(nums);
        
        int n = nums.length;
        int left = 0;
        int maxKept = 0;
        
        // 2. Sliding Window
        // 'right' iterates through the array, treating nums[right] as the current MAXIMUM.
        // 'left' points to the current MINIMUM of the window.
        for (int right = 0; right < n; right++) {
            
            // Condition: max > min * k
            // If the window is invalid, we shrink it from the left until it becomes valid.
            // IMPORTANT: Cast to (long) to prevent integer overflow (10^9 * 10^5 > 2^31).
            while (left < right && (long)nums[right] > (long)nums[left] * k) {
                left++;
            }
            
            // Update the maximum size of a valid window found so far.
            // (right - left + 1) is the number of elements in the current valid window.
            maxKept = Math.max(maxKept, right - left + 1);
        }
        
        // 3. The answer is the total elements minus the ones we decided to keep.
        return n - maxKept;
    }
}