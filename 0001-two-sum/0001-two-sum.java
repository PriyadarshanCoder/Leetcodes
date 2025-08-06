class Solution {
    public int[] twoSum(int[] nums, int target) {
         // Create a map to store numbers and their indices
        HashMap<Integer, Integer> map = new HashMap<>();

        // Go through each number in the array
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            int difference = target - number;

            // Check if the map already has the number we need
            if (map.containsKey(difference)) {
                // Found the pair, return their indices
                return new int[] { map.get(difference), i };
            }

            // Store this number with its index
            map.put(number, i);
        }
         return new int[] {};
    }
}