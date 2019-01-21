public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        if (height == null || height.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i <= height.length; i++) {
            int cur = (i == height.length) ? -1: height[i];
            while (!stack.isEmpty() && height[stack.peek()] >= cur) {
                int h = height[stack.pop()];
                int w = stack.isEmpty()? i: (i - stack.peek() - 1);
                ans = Math.max(ans, h * w);
            }
            stack.push(i);
        }
        return ans;
    }
}