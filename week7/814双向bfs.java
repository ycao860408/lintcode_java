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
        if (A == B) {
            return 0;
        }
        Queue <UndirectedGraphNode> queA = new LinkedList<>();
        Queue <UndirectedGraphNode> queB = new LinkedList<>();
        Set<UndirectedGraphNode> setA = new HashSet<>();
        Set<UndirectedGraphNode> setB = new HashSet<>();
        
        queA.offer(A);
        setA.add(A);
        queB.offer(B);
        setB.add(B);
        
        int res = 0;
        
        while (!queA.isEmpty() && !queB.isEmpty()) {
            res++;
            int n = queA.size();
            for (int i = 0; i < n; i++) {
                UndirectedGraphNode curA = queA.poll();
                for (UndirectedGraphNode nei : curA.neighbors) {
                    if (setB.contains(nei)) {
                        return res;
                    }
                    
                    if (!setA.contains(nei)) {
                        queA.offer(nei);
                        setA.add(nei);
                    }
                }
            }
            res++;
            n = queB.size();
            for (int i = 0; i < n; i++) {
                UndirectedGraphNode curB = queB.poll();
                for (UndirectedGraphNode nei: curB.neighbors) {
                    if(setA.contains(nei)) {
                        return res;
                    }
                    if (!setB.contains(nei)) {
                        queB.offer(nei);
                        setB.add(nei);
                    }
                }
            }
        }
        return -1;
    }
}


// Optimized one to prefer the simple one !
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
        if (A == B) {
            return 0;
        }
        Queue <UndirectedGraphNode> queA = new LinkedList<>();
        Queue <UndirectedGraphNode> queB = new LinkedList<>();
        Set<UndirectedGraphNode> setA = new HashSet<>();
        Set<UndirectedGraphNode> setB = new HashSet<>();
        
        queA.offer(A);
        setA.add(A);
        queB.offer(B);
        setB.add(B);
        Queue<UndirectedGraphNode> queCur = null;
        Set<UndirectedGraphNode> setCur = null, setOp = null;
        int res = 0;
        
        while (!queA.isEmpty() && !queB.isEmpty()) {
            res++;
            int n = queA.size();
            int m = queB.size();

            if (n <= m) {
                queCur = queA;
                setCur = setA;
                setOp = setB;
            } else {
                queCur = queB;
                setCur = setB;
                setOp = setA;
            }
            int size = Math.min(m,n);
            
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode cur = queCur.poll();
                for (UndirectedGraphNode nei : cur.neighbors) {
                    if (setOp.contains(nei)) {
                        return res;
                    }
                    
                    if (!setOp.contains(nei)) {
                        queCur.offer(nei);
                        setCur.add(nei);
                    }
                }
            }
        }
        return -1;
    }
}