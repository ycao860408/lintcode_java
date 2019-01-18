// one trip
public class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = 0, pl = 0, pr = nums.length - 1;
        while (i <= pr) {
            if (nums[i] == 0) {
                swape(nums, i, pl);
                i++;
                pl++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swape(nums, i, pr);
                pr--;
            }
        }
    }
    
    private void swape(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// two trips

public class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        partitionArray(nums, 1);
        partitionArray(nums, 2);
    }
    
    private void partitionArray(int [] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        int i = 0, j = nums.length - 1;
        
        while (i <= j) {
            while (i <= j && nums[i] < k ) {
                i++;
            }
            while (i <= j && nums[j] >= k) {
                j--;
            }
            
            if (i <= j) {
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j--] = temp;
            }
        }
    }
}