class Solution {
    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;

        // must start at (0,0) with 0
        if (grid[0][0] != 0) return false;

        return isValid(grid, 0, 0, n, 0);
    }

    private boolean isValid(int[][] grid, int r, int c, int n, int step) {
        // out of bounds
        if (r < 0 || c < 0 || r >= n || c >= n) return false;

        // wrong number
        if (grid[r][c] != step) return false;

        // last step reached
        if (step == n * n - 1) return true;

        int next = step + 1;

        // try all 8 knight moves (no inline checks)
        boolean ans1 = isValid(grid, r - 2, c + 1, n, next);
        boolean ans2 = isValid(grid, r - 2, c - 1, n, next);
        boolean ans3 = isValid(grid, r - 1, c + 2, n, next);
        boolean ans4 = isValid(grid, r - 1, c - 2, n, next);
        boolean ans5 = isValid(grid, r + 1, c + 2, n, next);
        boolean ans6 = isValid(grid, r + 1, c - 2, n, next);
        boolean ans7 = isValid(grid, r + 2, c + 1, n, next);
        boolean ans8 = isValid(grid, r + 2, c - 1, n, next);

        return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8;
    }
}
