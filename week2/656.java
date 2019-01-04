public class Solution {
    /**
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return product of num1 and num2
     */
    public String multiply(String num1, String num2) {
        // write your code here
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "";
        }
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int l1 = num1.length(), l2 = num2.length();
        int[] res = new int[l1 + l2];
        int[] inum1 = toIntArray(num1);
        int [] inum2 = toIntArray(num2);

        for (int i = 0; i < l2; i++) {
            for (int j = 0; j < l1; j++) {
                res[i + j] += inum1[j] * inum2[i];
                res[i + j + 1] += (res[i + j] / 10);
                res[i + j] = res[i + j] % 10;
            }
        }
        
        StringBuffer sb = new StringBuffer();
        if (res[l1+l2 - 1] != 0) {
            sb.append(res[l1+l2 -1]);
        }
        for (int i = l1 + l2 - 2; i >= 0; i--) {
            sb.append(res[i]);
        }
        return sb.toString();
    }
    
    private int[] toIntArray(String num) {
        StringBuffer sb = new StringBuffer(num);
        char[] chars = sb.reverse().toString().toCharArray();
        int[] res = new int[chars.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = chars[i] - '0';
        }
        return res;
    }
}