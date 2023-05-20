public class Graph {
    private int[] parents;

    public Graph(int n) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public int findX(int x) {
        if (parents[x] == x) {
            return x;
        } else {
            parents[x] = findX(parents[x]);
            return parents[x];
        }
    }

    public void union(int a, int b) {
        int rootA = findX(a);
        int rootB = findX(b);
        if (rootA != rootB) {
            parents[rootA] = rootB;
        }
    }
}