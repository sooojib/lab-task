import java.util.List;

// Separate Main class
public class Main {
    public static void main(String[] args) {
        try {
            List<Integer> dfsOrder = DFSFromFile.dfsTraversal("adjacency_matrix.txt");
            System.out.println("DFS Traversal: " + dfsOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}