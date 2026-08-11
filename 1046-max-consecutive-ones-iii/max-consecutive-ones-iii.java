class Solution {
    public int longestOnes(int[] nums, int k) {
       int left=0;
       int right=0;
       int maxlen1=0;
       int zero=0;
       while(right<nums.length)
       {
         if(nums[right]==0) zero++;
       
       while(zero>k){
        if(nums[left]==0) zero--;
        
       left++;
       }
       maxlen1= Math.max(maxlen1,right-left+1);
       right++;
    }
    return maxlen1;
    }
}