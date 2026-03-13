class Solution {
public:
    long long maxHeight(long long T, long long t) {
        long long val = (2 * T) / t;
        long long x = (sqrt(1 + 4 * val) - 1) / 2;
        return x;
    }

    bool can(long long T, int h, vector<int>& w) {
        long long total = 0;

        for (long long t : w) {
            total += maxHeight(T, t);
            if (total >= h) return true;
        }

        return false;
    }

    long long minNumberOfSeconds(int mountainHeight, vector<int>& workerTimes) {
        long long left = 0, right = 1e18;
        long long ans = right;

        while (left <= right) {
            long long mid = (left + right) / 2;

            if (can(mid, mountainHeight, workerTimes)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
};