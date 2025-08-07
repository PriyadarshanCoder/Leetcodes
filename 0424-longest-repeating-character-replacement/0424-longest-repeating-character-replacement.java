class Solution {
    public int characterReplacement(String s, int k) {
         int[] freq = new int[26]; // To store frequency of each character in the window
        int left = 0;
        int maxFreq = 0;
        int maxWindowSize = 0;

        for (int right = 0; right < s.length(); right++) {
            // Update frequency of current character
            freq[s.charAt(right) - 'A']++;

            // Update maxFreq: the highest frequency of any character in the window
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            int windowSize = right - left + 1;

            // If more than k characters need replacement, shrink the window
            if (windowSize - maxFreq > k) {
                freq[s.charAt(left) - 'A']--; // Remove left character from window
                left++;
                windowSize = right - left + 1; // Recalculate window size
            }

            // Update the max window size found so far
            maxWindowSize = Math.max(maxWindowSize, windowSize);
        }

        return maxWindowSize;
    }
}