class Solution {
    public int searchInsert(int[] nums, int target) {

        int n = nums.length;
        int low = 0, high = n - 1;
        int insertPosition = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                insertPosition = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        } 

        return insertPosition;
    }
}