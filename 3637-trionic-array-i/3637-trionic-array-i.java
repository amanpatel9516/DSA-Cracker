class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;

        int i =0;
        while(i<n-1 && nums[i] < nums[i+1]){
            i++ ;
        }

      if(i==0 || i==n-1){
        return false;

      }
      //phase 2...

int p =i;
      while(i <n-1 && nums[i] > nums[i+1]){
        i++;
              }
              if(i==p || i==n-1){
                return false;
              }

              //phase 3........

              while(i <n-1 && nums[i] <nums[i+1]){
                i++;
              }

              return i==n-1;

    }
}