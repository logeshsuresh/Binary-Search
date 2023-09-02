class Solution {
    public int findMin(int[] nums) {
      int n = nums.length;
      int low = 0, high = n - 1;
      int minimumElement = Integer.MAX_VALUE;

      while (low <= high) {
          int mid = (low) + (high - low) / 2;
          // if there are duplicates & nums[low] == nums[mid] == nums[high]
          if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
              // check if this is the minimum & increment low and decrement high
              minimumElement = Math.min(nums[mid], minimumElement);
              low += 1;
              high -= 1;
              continue;
          }
          if (nums[low] <= nums[mid]) {
              // left part sorted, check the minimum element with nums[low] and eliminate
              minimumElement = Math.min(nums[low], minimumElement);
              low = mid + 1;
          } else {
              // right part sorted, check the minimum element with nums[mid] and eliminate
              minimumElement = Math.min(nums[mid], minimumElement);
              high = mid - 1;
          }
      }  

      return minimumElement;
    }
}