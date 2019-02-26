public class Solution {
    /**
     * @param L: an integer
     * @param R: an integer
     * @return: the count of numbers in the range [L, R] having a prime number of set bits in their binary representation
     */
    public int countPrimeSetBits(int L, int R) {
    	int res = 0;
    	for (int i = L ; i <= R; i++) {
    	    int bitSum = getBitSum(i);
    	    System.out.println(bitSum);
    	    if (isPrime(bitSum)) {
    	        res++;
    	    }
    	}
    	return res;
	}
	private int getBitSum(int i) {
	    int res = 0;
	    while (i != 0) {
	        int bit = i % 2;
	        i/= 2;
	        res+=bit;
	    }
	    return res;
	}
	
	private boolean isPrime(int n) {
	    if (n <= 1) {
	        return false;
	    }
	    for (int i = 2; i < n ; i++) {
	        if (i > n / i) {
	            break;
	        }
	        if (n % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
}