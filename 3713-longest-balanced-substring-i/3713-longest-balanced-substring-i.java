class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;

        // Iterate through every possible starting point
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            int distinctCount = 0;

            // Expand the substring from i to j
            for (int j = i; j < n; j++) {
                int charIdx = s.charAt(j) - 'a';
                if (freq[charIdx] == 0) {
                    distinctCount++;
                }
                freq[charIdx]++;

                // Check if this substring is balanced
                if (isValid(freq, distinctCount)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    private boolean isValid(int[] freq, int distinctCount) {
        if (distinctCount == 0) return false;
        
        int commonFreq = -1;
        for (int f : freq) {
            if (f > 0) {
                if (commonFreq == -1) {
                    commonFreq = f;
                } else if (f != commonFreq) {
                    return false;
                }
            }
        }
        return true;
    }
}