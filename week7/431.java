/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    /*
     * @param nodes: a array of Undirected graph node
     * @return: a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        // write your code here
        Set<UndirectedGraphNode> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        
        for (UndirectedGraphNode node : nodes) {
            if (!set.contains(node)) {
                bfs(node, res, set);
            }
        }
        return res;
    }
    
    private void bfs(UndirectedGraphNode node, List<List<Integer>> res, Set<UndirectedGraphNode> set){
        List<Integer> comp = new ArrayList<>();
        Queue<UndirectedGraphNode> que = new LinkedList<>();
        que.offer(node);
        set.add(node);
        while (!que.isEmpty()) {
            UndirectedGraphNode cur = que.poll();
            comp.add(cur.label);
            for (UndirectedGraphNode nei : cur.neighbors) {
                if (!set.contains(nei)) {
                    que.offer(nei);
                    set.add(nei);
                }
            }
        }
        Collections.sort(comp);
        res.add(comp);
    }
}