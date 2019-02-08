public class Solution {
    /**
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return 0;
        }
        Arrays.sort(num);
        int last = 0;
        int res = 0;
        int count = 0;
        for (int i =0; i < num.length; i++) {
            if (i > 0  && num[i] == num[i-1]) {
                continue;
            }
            if (i == 0) {
                count = 1;
                last = num[i];
            } else {
                if (num[i] == last + 1) {
                    count++;
                } else {
                    count = 1;
                }
                last = num[i];
            }
            res = Math.max(res, count);
        }
        return res;
    }
}

// O(N)

public class Solution {
    /**
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return 0;
        }
        
        Set<Integer> set = new HashSet<>();
        
        for (int item : num) {
            set.add(item);
        }
        int res = 0;
        for (int item : num) {
            if (set.contains(item)) {
                set.remove(item);
                int l = item - 1;
                int r = item + 1;
                while (set.contains(l)) {
                    set.remove(l);
                    l--;
                }
                while (set.contains(r)) {
                    set.remove(r);
                    r++;
                }
                res = Math.max(res, r - l - 1);
            }
        }
        return res;
    }
}