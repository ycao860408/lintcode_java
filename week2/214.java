public class Solution {
    /**
     * @param A: An integer
     * @return: a float number
     */
    public float maxOfArray(float[] A) {
        // write your code here
        float res = Float.NEGATIVE_INFINITY;
        
        for (float item : A) {
            res = Math.max(res,item);
        }
        return res;
    }
}