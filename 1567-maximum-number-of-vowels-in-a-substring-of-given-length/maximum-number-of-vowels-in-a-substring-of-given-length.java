class Solution {
    public int maxVowels(String s, int k) {
        int maxVowels = 0;
        int currentVowels = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            if (isVowel(s.charAt(right))) {
                currentVowels++;
            }
                if (right - left + 1 > k) {
                if (isVowel(s.charAt(left))) {
                    currentVowels--;
                }
                left++; 
            }
            if (right - left + 1 == k) {
                maxVowels = Math.max(maxVowels, currentVowels);
            }
        }

        return maxVowels;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}