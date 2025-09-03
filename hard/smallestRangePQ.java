import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        // Min-heap: [value, listIndex, elementIndex]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        int max = Integer.MIN_VALUE;
        
        // Step 1: Push first element of each list into heap
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            minHeap.offer(new int[]{val, i, 0});
            max = Math.max(max, val);
        }
        
        int start = 0, end = Integer.MAX_VALUE;
        
        // Step 2: Process heap
        while (minHeap.size() == nums.size()) {
            int[] curr = minHeap.poll();
            int minVal = curr[0];
            
            // Update best range
            if (max - minVal < end - start) {
                start = minVal;
                end = max;
            }
            
            // Move to next element in the same list
            int listIndex = curr[1];
            int elemIndex = curr[2];
            
            if (elemIndex + 1 < nums.get(listIndex).size()) {
                int nextVal = nums.get(listIndex).get(elemIndex + 1);
                minHeap.offer(new int[]{nextVal, listIndex, elemIndex + 1});
                max = Math.max(max, nextVal);
            }
        }
        
        return new int[]{start, end};
    }
}
