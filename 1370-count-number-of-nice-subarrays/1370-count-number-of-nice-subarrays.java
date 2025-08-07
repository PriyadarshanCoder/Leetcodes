class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
          // Convert to binary array: 1 if odd, 0 if even
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % 2;
        }

        // HashMap to store frequency of prefix sums
        HashMap<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1); // Base case for subarrays that start at index 0

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            // Check if there is a prefix with sum = current_sum - k
            count += prefixCount.getOrDefault(sum - k, 0);

            // Update the map with the current prefix sum
            prefixCount.put(sum, prefixCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}