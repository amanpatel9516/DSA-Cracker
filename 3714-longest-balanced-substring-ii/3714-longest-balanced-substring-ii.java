import java.util.*;

class Solution {
    public int longestBalanced(String s) {
        int ans = 0;
        ans = Math.max(ans, getMax1(s, 'a'));
        ans = Math.max(ans, getMax1(s, 'b'));
        ans = Math.max(ans, getMax1(s, 'c'));

        ans = Math.max(ans, getMax2(s, 'a', 'b'));
        ans = Math.max(ans, getMax2(s, 'a', 'c'));
        ans = Math.max(ans, getMax2(s, 'b', 'c'));

        ans = Math.max(ans, getMax3(s));
        return ans;
    }

    private int getMax1(String s, char c) {
        int max = 0, curr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) max = Math.max(max, ++curr);
            else curr = 0;
        }
        return max;
    }

    private int getMax2(String s, char c1, char c2) {
        int n = s.length();
        int[] map = new int[2 * n + 1];
        Arrays.fill(map, -2);
        int max = 0, L = 0;
        
        while (L < n) {
            char ch = s.charAt(L);
            if (ch != c1 && ch != c2) {
                L++;
                continue;
            }
            int R = L;
            while (R < n && (s.charAt(R) == c1 || s.charAt(R) == c2)) R++;

            map[n] = L - 1; // 0 diff is at offset n
            int count1 = 0, count2 = 0;
            
            for (int i = L; i < R; i++) {
                if (s.charAt(i) == c1) count1++;
                else count2++;
                
                int diff = count1 - count2;
                if (map[diff + n] != -2) {
                    max = Math.max(max, i - map[diff + n]);
                } else {
                    map[diff + n] = i;
                }
            }

            // Cleanup to maintain O(N)
            count1 = 0; count2 = 0;
            map[n] = -2;
            for (int i = L; i < R; i++) {
                if (s.charAt(i) == c1) count1++;
                else count2++;
                map[(count1 - count2) + n] = -2;
            }
            L = R;
        }
        return max;
    }

    private int getMax3(String s) {
        int n = s.length();
        Map<Long, Integer> map = new HashMap<>();
        
        long zeroKey = (100000L << 32) | 100000L;
        map.put(zeroKey, -1);
        int max = 0, count1 = 0, count2 = 0, count3 = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') count1++;
            else if (ch == 'b') count2++;
            else count3++;

            int diff1 = count1 - count2;
            int diff2 = count1 - count3;
            // Shift handles pairs elegantly to avoid custom Object overrides
            long key = ((long)(diff1 + 100000) << 32) | (diff2 + 100000);

            if (map.containsKey(key)) {
                max = Math.max(max, i - map.get(key));
            } else {
                map.put(key, i);
            }
        }
        return max;
    }
}