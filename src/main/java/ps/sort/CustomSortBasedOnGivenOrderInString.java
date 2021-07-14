package ps.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * order and str are strings composed of lowercase letters. In order, no letter occurs more than once.
 * <p>
 * order was sorted in some custom order previously.
 * We want to permute the characters of str so that they match the order that order was sorted.
 * More specifically, if x occurs before y in order, then x should occur before y in the returned string.
 */

/**
 * Input:
 * order = "cba"
 * str = "abcd"
 * Output: "cbad"
 */

public class CustomSortBasedOnGivenOrderInString {
    public static void main(String[] args) {
        String order = "cba";
        String str = "abcd";
        CustomSortBasedOnGivenOrderInString customSortBasedOnGivenOrderInString = new CustomSortBasedOnGivenOrderInString();
        String out = customSortBasedOnGivenOrderInString.customSortString(order, str);
        String out1 = customSortBasedOnGivenOrderInString.customSortString1(order, str);

    }

    public String customSortString(String order, String str) {
        int charCount[] = new int[26];

        for (char c : str.toCharArray()) {
            charCount[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (charCount[c - 'a'] > 0) {
                sb.append(c);
                charCount[c - 'a']--;
            }
        }

        for (int i = 0; i < charCount.length; i++) {
            while (charCount[i] > 0) {
                sb.append((char) (i + 'a'));
                charCount[i]--;
            }
        }
        return sb.toString();
    }

    public String customSortString1(String order, String str) {
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for (char c : order.toCharArray()) {
            if (map.containsKey(c)) {
                while (map.get(c) > 0) {
                    sb.append(c);
                    map.put(c, map.get(c) - 1);
                }
                map.remove(c);
            }
        }

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            int c = e.getValue();
            while (c > 0) {
                sb.append(e.getKey());
                c--;
            }
        }

        return sb.toString();
    }
}
