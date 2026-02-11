import java.util.*;

class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        // tree[v] stores the min and max values in the segment to help find zeros
        // However, for this problem, we can use a simpler approach:
        // A Segment Tree where each node stores the minimum and maximum prefix sum.
        int[] treeMin = new int[4 * n];
        int[] treeMax = new int[4 * n];
        int[] lazy = new int[4 * n];
        
        int[] lastPos = new int[100001];
        Arrays.fill(lastPos, -1);
        
        int maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            int prev = lastPos[val];
            int delta = (val % 2 == 0) ? 1 : -1;
            
            // Range update: add delta to all start positions L in [prev + 1, i]
            update(1, 0, n - 1, prev + 1, i, delta, treeMin, treeMax, lazy);
            lastPos[val] = i;
            
            // Find the leftmost index L such that the value in the segment tree is 0
            int leftmostZero = findLeftmostZero(1, 0, n - 1, 0, i, treeMin, treeMax, lazy);
            
            if (leftmostZero != -1) {
                maxLen = Math.max(maxLen, i - leftmostZero + 1);
            }
        }
        
        return maxLen;
    }

    private void pushDown(int v, int[] treeMin, int[] treeMax, int[] lazy) {
        if (lazy[v] != 0) {
            lazy[2 * v] += lazy[v];
            treeMin[2 * v] += lazy[v];
            treeMax[2 * v] += lazy[v];
            lazy[2 * v + 1] += lazy[v];
            treeMin[2 * v + 1] += lazy[v];
            treeMax[2 * v + 1] += lazy[v];
            lazy[v] = 0;
        }
    }

    private void update(int v, int tl, int tr, int l, int r, int add, int[] treeMin, int[] treeMax, int[] lazy) {
        if (l > r) return;
        if (l == tl && r == tr) {
            lazy[v] += add;
            treeMin[v] += add;
            treeMax[v] += add;
        } else {
            pushDown(v, treeMin, treeMax, lazy);
            int tm = (tl + tr) / 2;
            update(2 * v, tl, tm, l, Math.min(r, tm), add, treeMin, treeMax, lazy);
            update(2 * v + 1, tm + 1, tr, Math.max(l, tm + 1), r, add, treeMin, treeMax, lazy);
            treeMin[v] = Math.min(treeMin[2 * v], treeMin[2 * v + 1]);
            treeMax[v] = Math.max(treeMax[2 * v], treeMax[2 * v + 1]);
        }
    }

    private int findLeftmostZero(int v, int tl, int tr, int l, int r, int[] treeMin, int[] treeMax, int[] lazy) {
        if (l > r || treeMin[v] > 0 || treeMax[v] < 0) return -1;
        if (tl == tr) return tl;
        
        pushDown(v, treeMin, treeMax, lazy);
        int tm = (tl + tr) / 2;
        
        // Try the left child first to get the "longest" subarray
        int res = findLeftmostZero(2 * v, tl, tm, l, Math.min(r, tm), treeMin, treeMax, lazy);
        if (res == -1) {
            res = findLeftmostZero(2 * v + 1, tm + 1, tr, Math.max(l, tm + 1), r, treeMin, treeMax, lazy);
        }
        return res;
    }
}