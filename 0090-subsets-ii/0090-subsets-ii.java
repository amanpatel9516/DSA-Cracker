class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(0, nums, current, ans);

        return ans;
    }

    private void backtrack(int start,
                           int[] nums,
                           List<Integer> current,
                           List<List<Integer>> ans) {

                         ans.add(new ArrayList<>(current));

        // Try choosing every element from 'start'
        for (int i = start; i < nums.length; i++) {

            // Skip duplicates at the same recursion level
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Choose
            current.add(nums[i]);

            // Explore
            backtrack(i + 1, nums, current, ans);

            // Undo the choice (Backtrack)
            current.remove(current.size() - 1);
        }
    }
}
 