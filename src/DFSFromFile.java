import java.io.*;
import java.util.*;

class DFSFromFile {

    static void dfs(int node, int[][] adj, boolean[] vis, List<Integer> result) {
        vis[node] = true;
        result.add(node);
        for (int j = 0; j < adj[node].length; j++) {
            if (adj[node][j] == 1 && !vis[j]) {
                dfs(j, adj, vis, result);
            }
        }
    }

    static List<Integer> dfsTraversal(String filename) throws Exception {
        // Read adjacency matrix from file
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        List<String[]> lines = new ArrayList<>();

        // Skip header
        br.readLine();

        while ((line = br.readLine()) != null) {
            lines.add(line.split("\t"));
        }

        int n = lines.size();
        int[][] adj = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                adj[i][j-1] = Integer.parseInt(lines.get(i)[j]);
            }
        }

        boolean[] vis = new boolean[n];
        List<Integer> dfsOrder = new ArrayList<>();

        dfs(0, adj, vis, dfsOrder); // Start DFS from node 0 (A)

        return dfsOrder;
    }
}


