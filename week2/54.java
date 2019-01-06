public class Solution {
    /**
     * @param str: A string
     * @return: An integer
     */
    public int atoi(String str) {
        // write your code here
        if (str == null || str.isEmpty()) {
            return 0;
        }
        
        String step1 = str.trim();
        if (step1.isEmpty()) {
            return 0;
        }
        
        String sign = Character.toString(step1.charAt(0));
        
        String step2;
    
        if (sign.equals("-")) {
            step2 = step1.substring(1);
        } else if (sign.equals("+")) {
            sign = "";
            step2 = step1.substring(1);
        } else {
            sign = "";
            step2 = step1;
        }
        int i;
        for (i = 0; i < step2.length(); i++) {
            if (!Character.isDigit(step2.charAt(i))) {
                break;
            } else {
                continue;
            }
        }
        
        String step3;
        
        String temp = step2.substring(0, i);
        
        if (temp.length() > 10) {
                return sign.equals("-")? Integer.MIN_VALUE : Integer.MAX_VALUE;
        } else if (temp.isEmpty()) {
                return 0;
        }else {
            step3 = temp;
        }
        Long test = new Long (sign + step3);
        if (test.longValue() > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        
        if (test.longValue() < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        
        return (int) test.longValue();
        
    }
}