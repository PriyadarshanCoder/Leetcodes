public class MinimumSwaps {

    public static int minSwaps(int[] arr, int k) {
        int n = arr.length;

        // Step 1: Count elements ≤ k
        int count = 0;
        for (int value : arr) {
            if (value <= k) {
                count++;
            }
        }

        // Step 2: Count bad elements in the initial window of size 'count'
        int bad = 0;
        for (int i = 0; i < count; i++) {
            if (arr[i] > k) {
                bad++;
            }
        }

        // Step 3: Slide the window and compute minimum swaps (i.e., minimum bad count)
        int minSwaps = bad;
        for (int i = 0, j = count; j < n; i++, j++) {
            if (arr[i] > k) {
                bad--;  // element going out is bad
            }
            if (arr[j] > k) {
                bad++;  // element coming in is bad
            }
            minSwaps = Math.min(minSwaps, bad);
        }

        return minSwaps;
    }

    // Sample usage
    public static void main(String[] args) {
        int[] arr1 = {2, 1, 5, 6, 3};
        int k1 = 3;
        System.out.println(minSwaps(arr1, k1));  // Output: 1

        int[] arr2 = {2, 7, 9, 5, 8, 7, 4};
        int k2 = 6;
        System.out.println(minSwaps(arr2, k2));  // Output: 2

        int[] arr3 = {2, 4, 5, 3, 6, 1, 8};
        int k3 = 6;
        System.out.println(minSwaps(arr3, k3));  // Output: 0
    }
}
