class Solution {
    public int maxScore(int[] cardPoints, int k) {
          int n = cardPoints.length;

        int leftSum = 0;
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }

        int maxScore = leftSum;
        int rightSum = 0;

        // Start taking cards from the right one by one and reduce from left
        for (int i = 1; i <= k; i++) {
            leftSum -= cardPoints[k - i];        // remove last element from left side
            rightSum += cardPoints[n - i];       // add from the right end
            int currentScore = leftSum + rightSum;
            maxScore = Math.max(maxScore, currentScore);
        }

        return maxScore;
    }
}