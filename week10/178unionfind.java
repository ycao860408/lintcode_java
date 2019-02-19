public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    int[] father = null;
    private int find(int x) {
        if (x == father[x]) {
            return x;
        }
        return father[x] = find(father[x]);
    }
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if (n == 0) return false;
        if (edges.length != n-1) {
            return false;
        }
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        for (int[] item : edges) {
            int start = item[0];
            int end = item[1];
            int root_s = find(start);
            int root_e = find(end);
            if (root_s == root_e) {
                return false;
            }
            father[root_s] = root_e;
        }
        return true;
    }
}

// graph's three requirement: 
// 1. no circle.
// 2. n - 1 edges
// 3. n nodes
// any two of the three can lead to a valid tree. Here we use find to test whether two node are connected when an edge is going to connect them. 
// here any connected items are within a set. 