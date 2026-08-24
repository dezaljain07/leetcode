class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int minLen = n + 1;
        int[] deque = new int[n + 1];
        int head = 0, tail = 0;

        for (int i = 0; i <= n; i++) {
            while (tail > head && prefixSum[i] - prefixSum[deque[head]] >= k) {
                minLen = Math.min(minLen, i - deque[head]);
                head++;
            }
            while (tail > head && prefixSum[i] <= prefixSum[deque[tail - 1]]) {
                tail--;
            }
            deque[tail++] = i;
        }

        return minLen <= n ? minLen : -1;
    }
}