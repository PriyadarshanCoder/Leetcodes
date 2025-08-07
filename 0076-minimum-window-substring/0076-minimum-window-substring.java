class Solution {
    public String minWindow(String s, String t) {
      if (s.length() < t.length()) return "";

        // Map to store the frequency of characters in t
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        int matchedCount = 0;
        Map<Character, Integer> windowMap = new HashMap<>();

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            if (targetMap.containsKey(rightChar) && 
                windowMap.get(rightChar).intValue() <= targetMap.get(rightChar).intValue()) {
                matchedCount++;
            }

            // Try to shrink the window
            while (matchedCount == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if (targetMap.containsKey(leftChar) && 
                    windowMap.get(leftChar).intValue() < targetMap.get(leftChar).intValue()) {
                    matchedCount--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
}
}