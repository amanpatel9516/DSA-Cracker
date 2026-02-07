 
class Solution {
    public int minimumDeletions(String s) {
        // 'bCount' tracks the number of 'b' characters we have encountered so far.
        // These are potential "problematic" characters if an 'a' appears later.
        int bCount = 0;
        
        // 'minDeletions' tracks the minimum removals needed to balance the string processed so far.
        int minDeletions = 0;
        
        // Iterate through each character of the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == 'b') {
                // If we see a 'b', it doesn't cause a conflict immediately.
                // We just increment our count of 'b's.
                bCount++;
            } else {
                // If we see an 'a', we have a potential conflict with previous 'b's.
                // We have two choices to fix the "ba" pattern:
                // 1. Delete this 'a' (cost: minDeletions + 1)
                // 2. Keep this 'a' and delete all previous 'b's (cost: bCount)
                // logic: minDeletions = min(minDeletions + 1, bCount)
                if (bCount > 0) {
                     minDeletions++;
                     bCount--; 
                     // Wait, the DP transition simplifies:
                     // We effectively "pair" this 'a' with a previous 'b' and discard one.
                     // But strictly speaking, the simplified Greedy logic is:
                     // minDeletions = Math.min(minDeletions + 1, bCount);
                }
            }
        }
        
        // Let's rewrite the loop logic slightly to match the standard DP form for clarity
        // The above logic inside the loop was a "Stack" based variation. 
        // Here is the cleaner DP state transition version:
        
        int dp = 0; // min deletions so far
        int b = 0;  // count of 'b's so far
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                b++;
                // If it's a 'b', min deletions doesn't change, but 'b' count goes up.
            } else {
                // If it's an 'a', we take the MIN of:
                // 1. Deleting this 'a' (current dp + 1)
                // 2. Keeping this 'a' (which means deleting all previous 'b's)
                dp = Math.min(dp + 1, b);
            }
        }
        
        return dp;
    }
}