public class ConnectingGraph3 {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    int father[] = null;
    int size;
    
    ConnectingGraph3(int n) {
        father = new int[n + 1];
        size = n; 
        for (int i = 1; i <= n; i++) {
            father[i] = i;
        }
    }
    
    private int find(int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }
    
    public void connect(int a, int b) {
        // write your code here
        int root_A = find(a);
        int root_B = find(b);
        if (root_A != root_B) {
            father[root_A] = root_B;
            size--;
        }
    }

    /**
     * @return: An integer
     */
    public int query() {
        // write your code here
        return size;
    }
}