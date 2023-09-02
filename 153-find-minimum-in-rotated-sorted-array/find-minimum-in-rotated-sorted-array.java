class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int minimumElement = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low) + (high - low) / 2;
            // check for sorted half
            if (nums[low] <= nums[mid]) {
                // left part is sorted, hence nums[low] is the minimum here
                minimumElement = Math.min(nums[low], minimumElement);
                low = mid + 1;
            } else {
                // right part is sorted, hence nums[mid] is my minimum
                minimumElement = Math.min(nums[mid], minimumElement);
                high = mid - 1;
            }
        }

        return minimumElement;
    }
}