public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if (n <= 0 && edges.length <=0) {
            return false;
        }
        if (edges.length != n - 1) {
            return false;
        }
        Map<Integer, Set<Integer>> graph = initGraph(n, edges);
        Set<Integer> set = new HashSet<>();
        Queue<Integer> que = new LinkedList<>();
        que.offer(0);
        set.add(0);
        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int nei : graph.get(cur)) {
                if (!set.contains(nei)) {
                    que.offer(nei);
                    set.add(nei);
                }
            }
        }
        return set.size() == n;
        
    }
    
    private Map<Integer, Set<Integer>> initGraph(int n, int[][]edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        return graph;
    }
}