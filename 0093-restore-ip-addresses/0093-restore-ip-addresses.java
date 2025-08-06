class Solution {
    public List<String> restoreIpAddresses(String s) {
      List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
    
    // Helper function to do backtracking
    private void backtrack(String s, int start, List<String> segments, List<String> result) {
        // If we have 4 segments and used all characters in s
        if (segments.size() == 4) {
            if (start == s.length()) {
                // Join segments with '.' and add to result
                result.add(String.join(".", segments));
            }
            return;
        }
        
        // Try segments of length 1, 2, or 3
        for (int len = 1; len <= 3; len++) {
            // Avoid going beyond the string length
            if (start + len > s.length()) break;
            
            String segment = s.substring(start, start + len);
            
            // Check if segment is valid
            if (isValid(segment)) {
                segments.add(segment);
                backtrack(s, start + len, segments, result);
                segments.remove(segments.size() - 1);  // backtrack
            }
        }
    }
    
    // Check if a segment is a valid IP segment
    private boolean isValid(String segment) {
        // Leading zero is invalid unless segment is exactly "0"
        if (segment.length() > 1 && segment.startsWith("0")) return false;
        
        int val = Integer.parseInt(segment);
        return val >= 0 && val <= 255;
    }
}