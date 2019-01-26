/**
 * Definition for graph node.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */


public class Solution {
    /*
     * @param graph: a list of Undirected graph node
     * @param values: a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node: an Undirected graph node
     * @param target: An integer
     * @return: a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // write your code here
        Queue<UndirectedGraphNode> que = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        que.add(node);
        set.add(node);
        while (!que.isEmpty()) {
            UndirectedGraphNode cur = que.poll();
            if (values.get(cur) == target) {
                return cur;
            }
            for (UndirectedGraphNode nei : cur.neighbors) {
                if (!set.contains(nei)) {
                    que.offer(nei);
                    set.add(nei);
                }
            }
        }
        return null;
    }
}