class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low) + (high - low) / 2;
            if (nums[mid] == target) return mid;
            if (nums[low] <= nums[mid]) {
                // left half is sorted
                if (target >= nums[low] && target <= nums[mid]) {
                    // element found in left half
                    high = mid;
                } else {
                    low = mid + 1;
                } 
            } else {
                // right half is sorted
                if (target >= nums[mid] && target <= nums[high]) {
                    // element found in right half
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}