class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // HashMap to store prefix sum and its frequency
        HashMap<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1); // Base case: prefix sum 0 has occurred once
        
        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            // Check if (currentSum - goal) has occurred before
            if (prefixCount.containsKey(currentSum - goal)) {
                count += prefixCount.get(currentSum - goal);
            }

            // Update prefix sum frequency
            prefixCount.put(currentSum, prefixCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}