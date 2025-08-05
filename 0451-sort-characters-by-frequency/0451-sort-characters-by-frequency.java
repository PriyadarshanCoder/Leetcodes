class Solution {
    public String frequencySort(String s) {
         Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Create buckets: index = frequency, value = list of characters
        List<Character>[] buckets = new List[s.length() + 1];
        for (char c : freqMap.keySet()) {
            int freq = freqMap.get(c);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(c);
        }

        // Step 3: Build the result from highest frequency to lowest
        StringBuilder result = new StringBuilder();
        for (int freq = buckets.length - 1; freq >= 0; freq--) {
            if (buckets[freq] != null) {
                for (char c : buckets[freq]) {
                    for (int i = 0; i < freq; i++) {
                        result.append(c);
                    }
                }
            }
        }

        return result.toString();
    }
}