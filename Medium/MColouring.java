import java.util.*;

class Solution {
    boolean graphColoring(int V, int[][] edges, int m) {
        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] color = new int[V]; // 0 = uncolored
        return solve(0, adj, color, V, m);
    }

    private boolean solve(int node, List<List<Integer>> adj, int[] color, int V, int m) {
        if (node == V) return true; // all vertices colored

        // try all colors
        for (int c = 1; c <= m; c++) {
            if (isSafe(node, adj, color, c)) {
                color[node] = c;
                if (solve(node + 1, adj, color, V, m)) return true;
                color[node] = 0; // backtrack
            }
        }
        return false; // no valid color found
    }

    private boolean isSafe(int node, List<List<Integer>> adj, int[] color, int c) {
        for (int nei : adj.get(node)) {
            if (color[nei] == c) return false;
        }
        return true;
    }
}
