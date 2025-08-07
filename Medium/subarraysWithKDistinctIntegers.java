 public int subarraysWithKDistinct(int[] nums, int k) {
        return countAtMostK(nums, k) - countAtMostK(nums, k - 1);
    }

    private int countAtMostK(int[] nums, int k) {
        int left = 0, result = 0;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int noOfDistinctNumbers = 0; // number of distinct numbers in the window

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];

            // If this number is new in the window, increase the distinct count
            if (countMap.getOrDefault(num, 0) == 0) {
                noOfDistinctNumbers++;
            }

            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

            // Shrink the window if distinct count exceeds k
            while (noOfDistinctNumbers > k) {
                int leftNum = nums[left];
                countMap.put(leftNum, countMap.get(leftNum) - 1);
                if (countMap.get(leftNum) == 0) {
                    noOfDistinctNumbers--; // one distinct number removed
                }
                left++;
            }

            // Add the number of valid subarrays ending at 'right'
            result += right - left + 1;
        }

        return result;
