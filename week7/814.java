/**
 * Definition for graph node.
 * class GraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph: a list of Undirected graph node
     * @param A: nodeA
     * @param B: nodeB
     * @return:  the length of the shortest path
     */
    public int shortestPath(List<UndirectedGraphNode> graph, UndirectedGraphNode A, UndirectedGraphNode B) {
        // Write your code here
        int res = 0; 
        Queue<UndirectedGraphNode> que = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        que.offer(A);
        set.add(A);
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode cur = que.poll();
                if (cur == B) {
                    return res;
                }
                for (UndirectedGraphNode nei : cur.neighbors) {
                    if (!set.contains(nei)) {
                        set.add(nei);
                        que.offer(nei);
                    }
                }
            }
            res++;
        }
        return -1;
    }
}