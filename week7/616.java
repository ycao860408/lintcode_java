public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        int degree[] = new int[numCourses];
        List[] graph = new ArrayList[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        Queue<Integer> que = new LinkedList<>();
        
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                que.offer(i);
            }
        }
        
        while (!que.isEmpty()) {
            int cur = que.poll();
            res.add(cur);
            int size = graph[cur].size();
            for (int i = 0; i < size; i++) {
                int nei = (int) graph[cur].get(i);
                degree[nei]--;
                if (degree[nei]== 0) {
                    que.offer(nei);
                }
            }
        }
        int[] result = null;
        if (res.size() == numCourses) {
            result = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                result[i] = (int)res.get(i);
            }
        } else {
            result = new int[0];
        }
        return result;
    }
}