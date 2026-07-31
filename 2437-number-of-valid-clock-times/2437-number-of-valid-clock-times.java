class Solution {
    public int countTime(String time) {

        char h1 = time.charAt(0);
        char h2 = time.charAt(1);

        char m1 = time.charAt(3);
        char m2 = time.charAt(4);

        int h = 1;
        int m = 1;

        if (h1 == '?' && h2 == '?') {
            h = 24;
        } else if (h1 == '?' && h2 != '?') {
            h = h2 <= '3' ? 3 : 2;
        } else if (h1 != '?' && h2 == '?') {
            h = h1 == '2' ? 4 : 10;
        }

        if (m1 == '?' && m2 == '?') {
            m = 60;
        } else if (m1 == '?' && m2 != '?') {
            m = 6;
        } else if (m1 != '?' && m2 == '?') {
            m = 10;
        }

        return h * m;
    }
}