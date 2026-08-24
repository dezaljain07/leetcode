class Solution {
    public int longestPalindrome(String s) {
        int[] counts = new int[128];
        for (char c : s.toCharArray()) {
            counts[c]++;
        }

        int length = 0;
        for (int count : counts) {
            length += (count / 2) * 2;
            if (length % 2 == 0 && count % 2 == 1) {
                length++;
            }
        }

        return length;
    }
}