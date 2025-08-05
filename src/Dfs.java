public class Dfs {
    String[] color;
    int[] parent;
    int[] begTime;
    int[] endTime;
    int time;
    int numVertex;
    int[][] adjMatrix;

    public Dfs(int numVertex) {
        this.numVertex = numVertex;
        adjMatrix = new int[numVertex][numVertex];
        color = new String[numVertex];
        parent = new int[numVertex];
        begTime = new int[numVertex];
        endTime = new int[numVertex];
    }

    public void doDFS(int[][] adj) {
        for (int u = 0; u < numVertex; u++) {
            color[u] = "WHITE";
            parent[u] = -1;
            begTime[u] = Integer.MAX_VALUE;
            endTime[u] = Integer.MAX_VALUE;
        }
        time = 0;
        for (int u = 0; u < numVertex; u++) {
            if (color[u].equals("WHITE")) {
                dfsVisit(u, adj);
            }
        }
    }

    private void dfsVisit(int u, int[][] adj) {
        color[u] = "GRAY";
        time = time + 1;
        begTime[u] = time;
        for (int v = 0; v < numVertex; v++) {
            if (adj[u][v] != 0 && color[v].equals("WHITE")) {
                parent[v] = u;
                dfsVisit(v, adj);
            }
        }
        color[u] = "BLACK";
        time = time + 1;
        endTime[u] = time;

        System.out.println("Vertex: " + u + "-> Color: " + color[u] + "-> BegTime: " + begTime[u] + "-> EndTime: " + endTime[u] + "-> Parent: " + parent[u] + "");
    }

}