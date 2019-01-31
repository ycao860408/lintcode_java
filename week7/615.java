public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        List[] edges = new ArrayList[numCourses];
        int [] degree = new int[numCourses];
        for (int i  = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i< prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                que.offer(i);
            }
        }
        
        int count = 0;
        
        while (!que.isEmpty()) {
            int curCourse = que.poll();;
            count++;
            int size = edges[curCourse].size();
            for (int i = 0; i < size; i++) {
                int nei = (int)edges[curCourse].get(i);
                degree[nei]--;
                if (degree[nei] == 0) {
                    que.offer(nei);
                }
            }
        }
        return count == numCourses;
    }
}