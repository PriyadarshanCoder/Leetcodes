import java.util.PriorityQueue;
import java.util.Collections;

class MedianFinder {
    private PriorityQueue<Integer> leftMaxHeap;   // smaller half (max-heap)
    private PriorityQueue<Integer> rightMinHeap;  // larger half (min-heap)

    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightMinHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // Step 1: always push to max-heap
        leftMaxHeap.offer(num);

        // Step 2: balance → move max from left to right
        rightMinHeap.offer(leftMaxHeap.poll());

        // Step 3: ensure left has >= right
        if (leftMaxHeap.size() < rightMinHeap.size()) {
            leftMaxHeap.offer(rightMinHeap.poll());
        }
    }
    
    public double findMedian() {
        if (leftMaxHeap.size() == rightMinHeap.size()) {
            // even count → average of two
            return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
        } else {
            // odd count → max-heap top
            return leftMaxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
