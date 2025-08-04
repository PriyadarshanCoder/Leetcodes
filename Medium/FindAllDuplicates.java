class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // Map number to index (1-based to 0-based)

            if (nums[index] < 0) {
                result.add(Math.abs(nums[i])); // Already visited, duplicate found
            } else {
                nums[index] = -nums[index]; // Mark as visited by negating
            }
        }

        return result;
    }
}
