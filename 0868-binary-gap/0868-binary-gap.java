class Solution {
    public int binaryGap(int n) {
        int maxGap = 0;
        int lastPos = -1; // Sentinel value for "no '1' seen yet"
        int currentPos = 0;
        
        // Process the number bit by bit
        while (n > 0) {
            // Check if the least significant bit (LSB) is 1
            if ((n & 1) == 1) {
                // If lastPos isn't -1, we have a valid adjacent pair
                if (lastPos != -1) {
                    maxGap = Math.max(maxGap, currentPos - lastPos);
                }
                // Record the position of this '1'
                lastPos = currentPos;
            }
            
            // Unsigned right shift (though standard >> is fine here since n is positive)
            n >>= 1;
            currentPos++;
        }
        
        return maxGap;
    }
}