import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if (map1.equals(map2)) {
                return true;
            }

            char rightChar = s2.charAt(i);
            map2.put(rightChar, map2.getOrDefault(rightChar, 0) + 1);

            char leftChar = s2.charAt(i - s1.length());
            if (map2.get(leftChar) == 1) {
                map2.remove(leftChar);
            } else {
                map2.put(leftChar, map2.get(leftChar) - 1);
            }
        }

        return map1.equals(map2);
    }
}