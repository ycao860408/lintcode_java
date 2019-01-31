/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    /*
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> que = new LinkedList<>();
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        //Set<UndirectedGraphNode> set = new HashSet<>();
        que.add(node);
        //set.add(node);
        map.put(node, res);
        
        while (!que.isEmpty()) {
            UndirectedGraphNode cur = que.poll();
            UndirectedGraphNode copy = map.get(cur);
            
            for (UndirectedGraphNode nei : cur.neighbors) {
                if (!map.containsKey(nei)) {
                    map.put(nei, new UndirectedGraphNode(nei.label));
                    que.offer(nei);
                }
                copy.neighbors.add(map.get(nei));
                
            }
        }
        return res;
    }
}