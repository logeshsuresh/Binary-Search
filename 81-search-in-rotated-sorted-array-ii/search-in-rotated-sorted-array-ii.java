class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low) + (high - low) / 2;
            // if target is present, return true
            if (nums[mid] == target) return true;
            /* if (nums[mid] == nums[low] == nums[high]) -> try and eliminate low and high 
                                                            by incrementing low and decrementing high 
            */
            if (nums[mid] == nums[low] && nums[mid] == nums[high]) {
                low += 1;
                high -= 1;
                continue;
            }
            // check which part is sorted
            if (nums[low] <= nums[mid]) {
                // left part sorted
                if (nums[low] <= target && target <= nums[mid]) {
                    // target present in the sorted half 
                    high = mid;
                } else {
                    // target not present in sorted half -> eliminate this half
                    low = mid + 1;
                }
            } else {
                // right part sorted
                if (nums[mid] <= target && target <= nums[high]) {
                    // target present in the sorted half
                    low = mid;
                } else {
                    // target not present in sorted half -> eliminate this half
                    high = mid - 1;
                }
            }
        } 
        // target not found
        return false; 
    }
}