class Pair {
    int num, idx;
    Pair(int idx, int num) {
        this.num = num; 
        this.idx = idx;
    }
}
public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        int [] ans = new int[2];
        if (nums == null || nums.length < 2) {
            return ans;
        }
        target = Math.abs(target);
        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(i + 1, nums[i]);
        }
        Arrays.sort(pairs, new Comparator<Pair>(){
            public int compare(Pair o1, Pair o2) {
                return o1.num - o2.num;
            }
        });
        
        for (int r = 1, l =0; r < nums.length; r++) {
            while (l < r && pairs[r].num - pairs[l].num > target) {
                l++;
            }
            if (l < r && pairs[r].num - pairs[l] .num== target) {
                ans[0] = pairs[l].idx;
                ans[1] = pairs[r].idx;
                Arrays.sort(ans);
                return ans;
            }
        }
        return ans;
    }
}