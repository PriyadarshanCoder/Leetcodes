class Solution {
    public String getPermutation(int n, int k) {
            // Method to return the k-th permutation of numbers from 1 to n
        List<Integer> numbers = new ArrayList<>();  // List of available numbers (1 to n)
        int[] factorial = new int[n + 1];           // Array to store factorial values from 0! to n!
        StringBuilder sb = new StringBuilder();     // StringBuilder to efficiently build the result

        factorial[0] = 1;                           // Initialize 0! = 1
        for (int i = 1; i <= n; i++) {
            numbers.add(i);                         // Add numbers 1 through n to the list
            factorial[i] = factorial[i - 1] * i;    // Compute and store i! = (i-1)! * i
        }

        k--;  // Convert k to 0-based index (since our logic assumes 0-indexed permutations)

        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];       // Determine index of current digit
            sb.append(numbers.get(index));          // Add selected digit to the result
            numbers.remove(index);                  // Remove used digit from the list
            k %= factorial[n - i];                  // Reduce k for the next position
        }

        return sb.toString();  // Return the final permutation as a string
    }
}