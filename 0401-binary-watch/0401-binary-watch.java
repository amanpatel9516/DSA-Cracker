import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        
        // Iterate through the strict bounds of a real clock
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                
                // Integer.bitCount() returns the number of set bits (1s) in the binary representation
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    
                    // String.format is perfect for injecting leading zeros
                    // %d for hour (no leading zero), %02d for minute (pad with zero to length 2)
                    result.add(String.format("%d:%02d", h, m));
                }
            }
        }
        
        return result;
    }
}