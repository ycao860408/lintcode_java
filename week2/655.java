public class Solution {
    /**
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        // write your code here
        int maxlen = Math.max(num1.length(), num2.length());
        int[] inum1 = convertInt(num1, maxlen);
        int[] inum2 = convertInt(num2, maxlen);
        StringBuffer sb = new StringBuffer();
        for ( int i = maxlen - 1; i >0; i--) {
            int temp = inum1[i] + inum2[i];
            sb.append(temp % 10);
            inum1[i - 1] += (temp / 10);
        }
        sb.append((inum1[0] + inum2[0]) % 10);
        if ((inum1[0] + inum2[0]) / 10 !=0) {
            sb.append((inum1[0] + inum2[0]) / 10);
        }
        return sb.reverse().toString();
        
        
    }
    
    private int[] convertInt(String num, int maxlen) {
        char[] chars = num.toCharArray();
        int[] res = new int[maxlen];
        for (int i = chars.length - 1; i >= 0 ; i--) {
           res[maxlen -1 -(chars.length -1-i)] = chars[i] -'0';
        }
        return res;
    }
}