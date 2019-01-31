public class Solution {
    /**
     * @param target: the destination
     * @return: the minimum number of steps
     */
    public int reachNumber(int target) {
        long t = Math.abs(target);
        long n = (long) Math.ceil((-1.0 + Math.sqrt(1 + 8.0 * t)) / 2);

        long sum = n * (n + 1) / 2;
        long diff = sum - target;
        if (diff == 0) {
            return (int)n;
        } else if (diff % 2 == 0) {
            return (int)n;
        } else if ((diff + n + 1) % 2 == 0) {
            return (int)n + 1;
        } else {
            return (int)n + 2;
        }
    }
}