public class Solution {
    /*
     * @param envelopes: a number of envelopes with widths and heights
     * @return: the maximum number of envelopes
     */
    public int maxEnvelopes(int[][] envelopes) {
        // write your code here
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }
        int n = envelopes.length;
        Arrays.sort(envelopes, Comparator.comparing(a->a[0]));
        int[] num = new int[n + 1];
        num[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (fit(i,j, envelopes)){
                    num[i] = Math.max(num[i], num[j] + 1);
                }
            }
        }
        
        int ans = 0; 
        for (int i = 0; i <= n; i++) {
            ans = Math.max(ans, num[i]);
        }
        return ans;
    }
    
    private boolean fit(int i, int j, int[][] envelopes) {
        if (j == 0)
            return true;
        return envelopes[i-1][0] > envelopes[j-1][0] && envelopes[i-1][1] > envelopes[j-1][1];
    }
}

// passed by using the binary tree. 
public class Solution {
    /**
     * @param envelopes a number of envelopes with widths and heights
     * @return the maximum number of envelopes
     */
    public int maxEnvelopes(int[][] envelopes) {
        // Write your code here
        if(envelopes == null || envelopes.length == 0 
            || envelopes[0] == null || envelopes[0].length != 2)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
            } 
        });
        int dp[] = new int[envelopes.length];
        int len = 0;
        for(int[] envelope : envelopes){
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            System.out.println(index);
                if(index < 0)
                    index = -index - 1;
            System.out.println(index);
            dp[index] = envelope[1];
            if (index == len)
                len++;
        }
        return len;
    }
}