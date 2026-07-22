class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        if (nums.length == 1) {
            List<Integer> singleList = new ArrayList<>();
            singleList.add(nums[0]);
            res.add(singleList);
            return new ArrayList<>(res);
        }

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int[] remainingNums = new int[nums.length - 1];
            int index = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    remainingNums[index] = nums[j];
                    index++;
                }
            }
            
            List<List<Integer>> perms = permuteUnique(remainingNums);
            for (List<Integer> p : perms) {
                p.add(n);
            }
            
            res.addAll(perms);
        }
        
        return new ArrayList<>(res);    
    }
}