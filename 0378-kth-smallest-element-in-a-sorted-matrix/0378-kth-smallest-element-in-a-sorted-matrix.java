class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        // Binary search on value range
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessEqual(matrix, mid);

            if (count < k) {
                low = mid + 1; // kth is bigger
            } else {
                high = mid; // kth is smaller or equal
            }
        }
        return low; // or high, both converge
    }

    // Counts how many numbers ≤ mid
    private int countLessEqual(int[][] matrix, int mid) {
        int n = matrix.length;
        int count = 0;
        int row = n - 1, col = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= mid) {
                count += row + 1;
                col++;
            } else {
                row--;
            }
        }
        return count;
    }
}
