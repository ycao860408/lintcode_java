public class Solution extends GuessGame {
    /**
     * @param n an integer
     * @return the number you guess
     */
    public int guessNumber(int n) {
        // Write your code here
        int left = 1, right = n;
        
        while ( left + 1 < right) {
            int mid = left + (right - left ) / 2;
            if (guess(mid) == 0) {
                return mid;
            }
            
            if (guess(mid)  0) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if (guess(right)  == 0) {
            return right;
        } else {
            return left;
        }
    }    
}