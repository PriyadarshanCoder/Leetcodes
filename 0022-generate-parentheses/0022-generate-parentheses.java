class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

     
    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // If the current string length reaches max*2, add to result
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        
        // If we can still add '(', add it and recurse
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        
        // If we can add ')', add it and recurse
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}