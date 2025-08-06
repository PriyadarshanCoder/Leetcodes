class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, k, n);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int start, int k, int target) {
        if (current.size() == k) {
            if (target == 0) {
                result.add(new ArrayList<>(current)); // Valid combination
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (i > target) break; // Optimization: no point in going further
            current.add(i);                          // choose
            backtrack(result, current, i + 1, k, target - i); // explore
            current.remove(current.size() - 1);      // un-choose (backtrack)
        }
    }
}