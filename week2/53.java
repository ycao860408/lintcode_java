public class Solution {
    /*
     * @param s: A string
     * @return: A string
     */
    public String reverseWords(String s) {
        // write your code here
        if(s.length() == 0 || s == null){
            return " ";
        }
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for(int i = array.length - 1; i >= 0; i--){
            if(!array[i].equals("")) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                
                sb.append(array[i]);
            }
        }
        return sb.toString();
    }
}