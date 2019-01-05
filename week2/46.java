public class Solution {
    /*
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        int len = nums.size();
        Collections.sort(nums, new newComparator());
        int candidate = nums.get(0).intValue();
        int count = 0;
        for (Integer item : nums) {
            if (item.intValue() != candidate) {
                if (count > len / 2) {
                    break;
                } else {
                    count = 0;
                    candidate = item.intValue();
                }
                
            }
            count++;
        }
        return candidate;
    }
    
    private class newComparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return a.intValue() - b.intValue();
        }
    }
}