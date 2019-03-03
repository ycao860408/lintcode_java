class Point{
    int sum, i, j;
    Point(int sum, int i, int j) {
        this.sum = sum; 
        this.i = i;
        this.j = j;
    }
}

class PointComparator implements Comparator<Point> {
    public int compare(Point a, Point b) {
        return a.sum - b.sum;
    }
}
public class Solution {
    /**
     * @param A: an integer arrays sorted in ascending order
     * @param B: an integer arrays sorted in ascending order
     * @param k: An integer
     * @return: An integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // write your code here
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return 0;
        }
        if (k > A.length * B.length) {
            return 0;
        }
        int lenA = A.length, lenB = B.length;
        PriorityQueue<Point> que = new PriorityQueue<>(new PointComparator());
        Set<Integer> set = new HashSet<>();
        que.offer(new Point(A[0]+B[0],0,0));
        set.add(0 * lenA + 0);
       
        for (int p = 1; p < k ; p++) {
            Point cur = que.poll();
            int i = cur.i, j = cur.j;
            if (j + 1 < B.length && !set.contains((j + 1) * lenA + i)) {
                que.offer(new Point(A[i] + B[j + 1], i, j + 1));
                set.add((j + 1) * lenA + i);
            }
            if (i + 1 < A.length && !set.contains(j * lenA + i + 1)) {
                que.offer(new Point(A[i + 1] + B[j], i + 1, j));
                set.add(j * lenA + i + 1);
            }
        }
        
        return que.poll().sum;
    }
}