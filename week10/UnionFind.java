public class UnionFind {
    private int[] father = null;
    
    public UnionFind(int n) {
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }
    
    public int find(int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }
    
    public void union(int x, int y) {
        int x_root = find(x);
        int y_root = find(y);
        if (x_root != y_root) {
            father[y_root] = x_root;
        }
    }
}