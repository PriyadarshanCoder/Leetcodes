class Solution {
    public int findPairs(int[] nums, int k) {
      if (k < 0) return 0; // No valid pairs for negative k

        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Skip duplicates for the first number in the pair
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int target = nums[i] + k;

            // Binary search for target in the rest of the array
            if (binarySearch(nums, i + 1, n - 1, target)) {
                count++;
            }
        }

        return count;
    }

    // Standard binary search function
    private boolean binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}