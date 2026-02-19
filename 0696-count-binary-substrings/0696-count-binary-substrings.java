class Solution {
    public int countBinarySubstrings(String s) {
        int ans = 0;
        int prevLen = 0;
        int currLen = 1;
        
        for (int i = 1; i < s.length(); i++) {
            // Check if current char matches the one before it
            if (s.charAt(i) == s.charAt(i - 1)) {
                currLen++;
            } else {
                // A transition occurred (e.g., '0' to '1' or '1' to '0').
                // Add the valid combinations from the PREVIOUS two groups.
                ans += Math.min(prevLen, currLen);
                
                // Shift the window
                prevLen = currLen;
                currLen = 1;
            }
        }
        
        // Add the combinations from the final two groups after the loop ends
        ans += Math.min(prevLen, currLen);
        
        return ans;
    }
}