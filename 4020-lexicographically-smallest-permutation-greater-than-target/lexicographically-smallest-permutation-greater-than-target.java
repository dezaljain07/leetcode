class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int pivotIndex = -1;
        int pivotCharIndex = -1;

        int[] prefCount = new int[26];

        for (int i = 0; i < n; i++) {
            char t = target.charAt(i);

            for (int c = (t - 'a') + 1; c < 26; c++) {
                if (count[c] - prefCount[c] > 0) {
                    pivotIndex = i;
                    pivotCharIndex = c;
                    break;
                }
            }

            int tIdx = t - 'a';
            if (prefCount[tIdx] < count[tIdx]) {
                prefCount[tIdx]++;
            } else {
                break;
            }
        }

        if (pivotIndex == -1) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int[] usedCount = new int[26];

        for (int i = 0; i < pivotIndex; i++) {
            char t = target.charAt(i);
            sb.append(t);
            usedCount[t - 'a']++;
        }

        sb.append((char) ('a' + pivotCharIndex));
        usedCount[pivotCharIndex]++;

        for (int c = 0; c < 26; c++) {
            int rem = count[c] - usedCount[c];
            while (rem > 0) {
                sb.append((char) ('a' + c));
                rem--;
            }
        }

        return sb.toString();
    }
}