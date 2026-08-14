class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int mincount = Integer.MAX_VALUE;

        while (right < nums.length){ 
            sum += nums[right];

        
            while (sum >= target) {
                mincount = Math.min(mincount, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }

        return mincount == Integer.MAX_VALUE ? 0 : mincount;
    }
}