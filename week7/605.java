public class Solution {
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here
        Map<Integer, Set<Integer>> graph = buildGraph(seqs);
        Map<Integer, Integer> intDegree = buildDegree(seqs, graph);
        
        Queue<Integer> que = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        
        for (Integer key : intDegree.keySet()) {
            if (intDegree.get(key) == 0) {
                que.offer(key);
            }
        }
        
        while (que.size() == 1) {
            int cur = que.poll();
            /*
            if (cur < 1 || cur > org.length) {
                return false;
            }
            */
            result.add(cur);
            System.out.println(graph.containsKey(cur));
            System.out.println(cur);
           
            if (!graph.containsKey(cur)) {
                continue;
            }
            
            for (Integer nei : graph.get(cur)) {
                intDegree.put(nei, intDegree.get(nei) - 1);
                if (intDegree.get(nei) == 0) {
                    que.offer(nei);
                }
            }
        }
        
        if (result.size() != org.length){
            return false;
        }
    
        for (int i = 0; i < org.length; i++) {
            if (result.get(i) != org[i])
                return false;
        }
        
        return true;
        
    }
    
    private Map<Integer, Set<Integer>> buildGraph(int[][] seqs) {
        Map<Integer, Set<Integer>> res = new HashMap<>();
        for (int i = 0; i < seqs.length; i++) {
            for (int j = 0; j < seqs[i].length-1; j++) {
                if (!res.containsKey(seqs[i][j])) {
                    res.put(seqs[i][j], new HashSet<Integer>());
                    res.get(seqs[i][j]).add(seqs[i][j + 1]);
                } else {
                    res.get(seqs[i][j]).add(seqs[i][j + 1]);
                }
            }
        }
        return res;
    }
    
    private Map<Integer,Integer> buildDegree(int[][] seqs, Map<Integer, Set<Integer>> graph) {
        Map<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < seqs.length; i++) {
            for (int j = 0; j < seqs[i].length; j++) {
                res.put(seqs[i][j],0);
            }
        }
        for (Integer key : graph.keySet()) {
            for (Integer item : graph.get(key)) {
                res.put(item, res.get(item) + 1);
            }
        }
        return res;
    }
}