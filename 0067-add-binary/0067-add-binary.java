class Solution {
    public String addBinary(String a, String b) {
        // StringBuilder is crucial here! Using String concatenation (+) is O(N^2)
        StringBuilder result = new StringBuilder();
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        // Process from right to left
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            
            if (i >= 0) {
                // 'charAt' gives the char. Subtracting '0' gets the int value.
                sum += a.charAt(i) - '0';
                i--;
            }
            
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            
            // Append the remainder (0 or 1)
            result.append(sum % 2);
            
            // Calculate the new carry for the next column
            carry = sum / 2;
        }
        
        // Reverse the StringBuilder and convert to String
        return result.reverse().toString();
    }
}