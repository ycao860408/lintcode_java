public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer
     * @return: The median of the element inside the window at each moving
     */
    public List<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        int curMedian; 
        if (k > 1) {
            maxHeap.offer(nums[0]);
            for (int i = 1; i < k - 1; i++) {
                int x = maxHeap.peek();
                if (nums[i] < x) {
                    maxHeap.offer(nums[i]);
                } else {
                    minHeap.offer(nums[i]);
                }
            }
            curMedian = maxHeap.peek();
        } else {
            curMedian = 0;
        }
        for (int i = k - 1; i < nums.length; i++) {
            if (nums[i] <= curMedian) {
                maxHeap.offer(nums[i]);
            } else {
                minHeap.offer(nums[i]);
            }
            
            while (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            }
            while (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            curMedian = maxHeap.peek();
            res.add(curMedian);
            if (nums[i -k + 1] <= curMedian) {
                maxHeap.remove(nums[i - k + 1]);
            } else {
                minHeap.remove(nums[i - k + 1]);
            }
        }
        return res;
    }
}