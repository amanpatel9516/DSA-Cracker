class Solution {
    public boolean hasAlternatingBits(int n) {
       
        long val = (long) n ^ (n >> 1);
        
         
        return (val & (val + 1)) == 0;
    }
}