class Solution {
    public int longestOnes(int[] nums, int k) {
            int left = 0;
        int maxLength = 0;
        int zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {
            // If current number is 0, increment zeroCount
            if (nums[right] == 0) {
                zeroCount++;
            }

            // Shrink window from the left if zeroCount > k
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Update maxLength
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}