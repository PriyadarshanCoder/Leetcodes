class Solution {
    public int lengthOfLongestSubstring(String s) {
         HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            if (map.containsKey(current)) {
                // Move left pointer to the right of last occurrence if needed
                left = Math.max(left, map.get(current) + 1);
            }

            map.put(current, right); // Update last seen index
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
