public class Solution {
    /*
     * @param nums: a list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        int len = nums.size();
        Collections.sort(nums, new newComparator());
        
        for (Integer item: nums) {
            System.out.println(item.intValue() + " " + len);
        }
        
        
        int candidate = nums.get(0).intValue();
        int count = 0;
        for (Integer item : nums) {
            System.out.println(count);
            if (item.intValue() != candidate) {
                
                if (count > len / 3) {
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