/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        Map<DirectedGraphNode, Integer> map = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode nei : node.neighbors) {
                if (map.containsKey(nei)) {
                    map.put(nei, map.get(nei) + 1);
                } else {
                    map.put(nei,1);
                }
            }
        }
        
        
        Queue<DirectedGraphNode> que = new LinkedList<>();
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                que.offer(node); 
            }
        }
        
        while (!que.isEmpty()) {
            DirectedGraphNode cur = que.poll();
            res.add(cur);
            
            for (DirectedGraphNode nei : cur.neighbors) {
                map.put(nei, map.get(nei) - 1);
                if (map.get(nei) == 0) {
                    que.add(nei);
                }
            }
        }
        
        return res;
    }
}