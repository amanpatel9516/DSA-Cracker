class Solution {
public:
    int minOperations(vector<int>& nums) {
        stack<int> st;
        int ops = 0;

        for (int x : nums) {
            while (!st.empty() && st.top() > x)
                st.pop();

            if (x == 0) continue;

            if (st.empty() || st.top() < x) {
                ops++;
                st.push(x);
            }
        }
        return ops;
    }
};
